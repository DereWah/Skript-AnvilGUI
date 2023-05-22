package org.derewah.skriptanvilgui.expressions;

import ch.njol.skript.classes.Changer.ChangeMode;
import ch.njol.skript.expressions.base.SimplePropertyExpression;
import ch.njol.util.coll.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import org.derewah.skriptanvilgui.anvilgui.Anvil;


public class ExprAnvilGUIItemLeft extends SimplePropertyExpression<Anvil, ItemStack> {

    static {
        register(ExprAnvilGUIItemLeft.class, ItemStack.class, "left (slot|item)", "anvil");
    }

    @Override
    public ItemStack convert(Anvil anvil) {
        return anvil.getItemLeft();
    }

    @Override
    public Class<?>[] acceptChange(final ChangeMode mode){
        if(mode == ChangeMode.SET){
            return CollectionUtils.array(ItemStack.class);
        }
        return null;
    }

    @Override
    public void change(Event event, Object[] delta, ChangeMode mode) {
        getExpr().getSingle(event).setItemLeft((ItemStack) delta[0]);

    }

    @Override
    public Class<? extends ItemStack> getReturnType() {
        return ItemStack.class;
    }

    @Override
    protected String getPropertyName() {
        return "left item";
    }
}