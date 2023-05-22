package org.derewah.skriptanvilgui.expressions;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;
import org.derewah.skriptanvilgui.anvilgui.Anvil;


public class ExprNewAnvilGUI extends SimpleExpression<Anvil> {

    static {
        Skript.registerExpression(ExprNewAnvilGUI.class, Anvil.class, ExpressionType.SIMPLE,
                "[a] new anvil gui",
                "[a] new anvil gui (named|with title) %string% with default text %string%"
                );
    }


    private Expression<String> exprTitle;
    private Expression<String> exprText;
    private boolean prebuild = false;

    public boolean init(Expression<?>[] expression, int matchedPattern, Kleenean isDelayed, ParseResult parseResult) {
        if(matchedPattern == 1){
            prebuild = true;
            exprTitle = (Expression<String>) expression[0];
            exprText = (Expression<String>) expression[1];
        }
        return true;
    }

    @Override
    protected Anvil[] get(Event event){
        Anvil anvil = new Anvil();
        if(prebuild){
            anvil.setTitle(exprTitle.getSingle(event));
            anvil.setText(exprText.getSingle(event));
        }
        return new Anvil[]{anvil};
    }


    @Override
    public boolean isSingle(){
        return true;
    }

    @Override
    public Class<? extends Anvil> getReturnType(){
        return Anvil.class;
    }


    @Override
    public String toString(Event event, boolean debug){
        return "new anvil gui";
    }

}
