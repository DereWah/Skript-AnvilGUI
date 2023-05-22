package org.derewah.skriptanvilgui.events;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.util.SimpleEvent;
import ch.njol.skript.registrations.EventValues;
import ch.njol.skript.util.Getter;
import org.bukkit.entity.Player;
import org.derewah.skriptanvilgui.anvilgui.Anvil;
import org.derewah.skriptanvilgui.events.Anvil.BridgeAnvilClose;

public class EvtOnAnvilGUIClose {

    static{
        Skript.registerEvent("On AnvilGUI Close", SimpleEvent.class, BridgeAnvilClose.class, "anvil gui close");
        EventValues.registerEventValue(BridgeAnvilClose.class, String.class, new Getter<String, BridgeAnvilClose>() {
            @Override
            public String get(BridgeAnvilClose bridgeAnvilClose) {
                return bridgeAnvilClose.getAnvilState().getText();
            }
        }, EventValues.TIME_NOW);
        EventValues.registerEventValue(BridgeAnvilClose.class, Player.class, new Getter<Player, BridgeAnvilClose>() {
            @Override
            public Player get(BridgeAnvilClose bridgeAnvilClose) {
                return bridgeAnvilClose.getAnvilState().getPlayer();
            }
        }, EventValues.TIME_NOW);
        EventValues.registerEventValue(BridgeAnvilClose.class, Anvil.class, new Getter<Anvil, BridgeAnvilClose>() {
            @Override
            public Anvil get(BridgeAnvilClose bridgeAnvilClose) {
                return bridgeAnvilClose.getAnvil();
            }
        }, EventValues.TIME_NOW);
    }

}
