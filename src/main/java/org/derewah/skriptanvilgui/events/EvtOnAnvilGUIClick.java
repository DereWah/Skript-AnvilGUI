package org.derewah.skriptanvilgui.events;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.util.SimpleEvent;
import ch.njol.skript.registrations.EventValues;
import ch.njol.skript.util.Getter;
import org.bukkit.entity.Player;
import org.derewah.skriptanvilgui.anvilgui.Anvil;
import org.derewah.skriptanvilgui.events.Anvil.BridgeAnvilClick;

public class EvtOnAnvilGUIClick {

    static{
        Skript.registerEvent("On AnvilGUI Click", SimpleEvent.class, BridgeAnvilClick.class, "anvil gui click");
        EventValues.registerEventValue(BridgeAnvilClick.class, String.class, new Getter<String, BridgeAnvilClick>() {
            @Override
            public String get(BridgeAnvilClick bridgeAnvilClick) {
                return bridgeAnvilClick.getAnvilState().getText();
            }
        }, EventValues.TIME_NOW);
        EventValues.registerEventValue(BridgeAnvilClick.class, Player.class, new Getter<Player, BridgeAnvilClick>() {
            @Override
            public Player get(BridgeAnvilClick bridgeAnvilClick) {
                return bridgeAnvilClick.getAnvilState().getPlayer();
            }
        }, EventValues.TIME_NOW);
        EventValues.registerEventValue(BridgeAnvilClick.class, Integer.class, new Getter<Integer, BridgeAnvilClick>() {
            @Override
            public Integer get(BridgeAnvilClick bridgeAnvilClick) {
                return bridgeAnvilClick.getAnvilSlot();
            }
        }, EventValues.TIME_NOW);
        EventValues.registerEventValue(BridgeAnvilClick.class, Anvil.class, new Getter<Anvil, BridgeAnvilClick>() {
            @Override
            public Anvil get(BridgeAnvilClick bridgeAnvilClick) {
                return bridgeAnvilClick.getAnvil();
            }
        }, EventValues.TIME_NOW);
    }

}
