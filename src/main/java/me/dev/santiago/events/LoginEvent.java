package me.dev.santiago.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class LoginEvent extends Event {

    private final Player loggedPlayer;
    private static final HandlerList HANDLERS = new HandlerList();

    public LoginEvent(Player player){
        this.loggedPlayer = player;
    }

    public Player getLoggedPlayer() {
        return loggedPlayer;
    }


    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    @Override
    public HandlerList getHandlers() {
        return null;
    }



}
