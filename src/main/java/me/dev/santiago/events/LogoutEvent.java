package me.dev.santiago.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class LogoutEvent  extends Event {

        private final Player logoutPlayer;
        private static final HandlerList HANDLERS = new HandlerList();

        public LogoutEvent(Player player){
            this.logoutPlayer = player;
        }

        public Player getLogoutPlayer() {
            return logoutPlayer;
        }


        public static HandlerList getHandlerList() {
            return HANDLERS;
        }

        @Override
        public HandlerList getHandlers() {
            return null;
        }
}
