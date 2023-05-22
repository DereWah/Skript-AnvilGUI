package org.derewah.skriptanvilgui.events.Anvil;

import net.wesjd.anvilgui.AnvilGUI;
import org.bukkit.Bukkit;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.derewah.skriptanvilgui.SkriptAnvilGUI;
import org.derewah.skriptanvilgui.anvilgui.Anvil;

public class BridgeAnvilClose extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();

    private final AnvilGUI.StateSnapshot state;
    private final Anvil anvil;

    private boolean cancelled = false;


    public BridgeAnvilClose(AnvilGUI.StateSnapshot state, Anvil anvil) {
        this.state = state;
        this.anvil = anvil;
    }

    public AnvilGUI.StateSnapshot getAnvilState(){
        return state;
    }

    public Anvil getAnvil(){
        return this.anvil;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        if(b){
            Bukkit.getScheduler().runTaskLater(SkriptAnvilGUI.getInstance(), () -> anvil.getBuilder().open(state.getPlayer()), 1);

            cancelled = false;
        }
    }
}
