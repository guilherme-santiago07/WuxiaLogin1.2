package me.dev.santiago.commands;

import me.dev.santiago.login.Login;
import me.dev.santiago.login.LoginAPI;
import me.dev.santiago.utils.TitleAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class LogoutCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player))
            return false;
        Player player = ((Player) sender).getPlayer();
        Login login = LoginAPI.getLogin(player);

        if(!login.isLogged())
            return false;

        login.logout();
        player.sendMessage("&6Você foi deslogado!");
        new PlayerQuitEvent(player, "");
        new PlayerJoinEvent(player, "");
        player.sendMessage("§6Por favor, faça login!");
        TitleAPI.sendTitle(player, 20, 20,20, "§6Logue-se!", "§6/login <senha>");

        return false;
    }
}
