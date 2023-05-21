package org.derewah.skriptanvilgui.anvilgui;

import net.wesjd.anvilgui.AnvilGUI;
import org.bukkit.Bukkit;
import org.derewah.skriptanvilgui.SkriptAnvilGUI;
import org.derewah.skriptanvilgui.events.Anvil.BridgeAnvilClick;
import org.derewah.skriptanvilgui.events.Anvil.BridgeAnvilClose;

import java.util.Arrays;

public class Anvil {


    private final AnvilGUI.Builder builder;
    private String title;
    private String text;


    public Anvil(){
        this.builder = new AnvilGUI.Builder();
        this.text = "Input Text";
        this.title = "Anvil Title";
        builder.text(this.text);
        builder.title(this.title);
        builder.plugin(SkriptAnvilGUI.getInstance());
        builder.onClick((slot, stateSnapshot) -> {
            return Arrays.asList(AnvilGUI.ResponseAction.run(() ->
                    Bukkit.getPluginManager().callEvent(new BridgeAnvilClick(slot, stateSnapshot, this))));
        });
        builder.onClose(stateSnapshot -> {
            Bukkit.getPluginManager().callEvent(new BridgeAnvilClose(stateSnapshot, this));});
    }

    public void setText(String text){
        this.text = text;
        this.builder.text(text);
    }

    public String getText(){
        return this.text;
    }

    public void setTitle(String title){
        this.title = title;
        this.builder.title(title);
    }

    public String getTitle(){
        return this.title;
    }

    public AnvilGUI.Builder getBuilder(){
        return this.builder;
    }


}
