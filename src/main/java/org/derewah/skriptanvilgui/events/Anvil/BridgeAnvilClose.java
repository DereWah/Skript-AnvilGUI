package org.derewah.skriptanvilgui.events.Anvil;

import net.wesjd.anvilgui.AnvilGUI;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.derewah.skriptanvilgui.anvilgui.Anvil;

public class BridgeAnvilClose extends Event {
    private static final HandlerList handlers = new HandlerList();

    private final AnvilGUI.StateSnapshot state;
    private final Anvil anvil;


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

}
