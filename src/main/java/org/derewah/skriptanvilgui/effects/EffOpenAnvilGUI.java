package org.derewah.skriptanvilgui.effects;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.util.AsyncEffect;
import ch.njol.util.Kleenean;
import net.wesjd.anvilgui.AnvilGUI;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.derewah.skriptanvilgui.anvilgui.Anvil;

public class EffOpenAnvilGUI extends Effect {
    static{
        Skript.registerEffect(EffOpenAnvilGUI.class,
                "open anvilgui %anvil% to %players%");
    }

    private Expression<Anvil> exprAnvil;
    private Expression<Player> exprPlayer;


    @Override
    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int matchedPattern, Kleenean isDelayed, ParseResult parseResult){
        exprAnvil = (Expression<Anvil>) expressions[0];
        exprPlayer = (Expression<Player>) expressions[1];
        return true;
    }

    @Override
    protected void execute(Event event) {
        Anvil anvil = exprAnvil.getSingle(event);
        Player player = exprPlayer.getSingle(event);
        anvil.getBuilder().open(player);
    }

    @Override
    public String toString(Event event, boolean b) {
        return null;
    }
}
