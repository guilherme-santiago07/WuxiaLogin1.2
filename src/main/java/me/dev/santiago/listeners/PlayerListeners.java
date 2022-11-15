package me.dev.santiago.listeners;

import me.dev.santiago.WuxiaLogin;
import me.dev.santiago.database.Database;
import me.dev.santiago.database.MySQL;
import me.dev.santiago.events.LoginEvent;
import me.dev.santiago.events.LogoutEvent;
import me.dev.santiago.login.Login;
import me.dev.santiago.login.LoginAPI;
import me.dev.santiago.utils.TitleAPI;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListeners implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        Player p = e.getPlayer();
        Bukkit.getPluginManager().callEvent(new LogoutEvent(p));
    }

    @EventHandler
    public void onLogin(LoginEvent e){
        Player p = e.getLoggedPlayer();
        LoginAPI.setLogin(p, new Login(WuxiaLogin.getDatabase().getPassword()));
        TitleAPI.sendTitle(p, 20, 40, 20,"§6Logado com sucesso!", "§6Bem vindo ao servidor!" );
        p.sendMessage("§6Logado com sucesso!");
        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BELL, 100, 10);
    }

    @EventHandler
    public void onLogout(LogoutEvent e){
        Player p = e.getLogoutPlayer();
        Login login = LoginAPI.getLogin(p);
        MySQL database = WuxiaLogin.getDatabase();
        if(database.getPassword(p) == null){
            database.insertPassword(p, login);
            return;
        }
        database.updatePassword(p, login);
    }




}
