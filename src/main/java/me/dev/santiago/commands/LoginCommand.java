package me.dev.santiago.commands;

import me.dev.santiago.WuxiaLogin;
import me.dev.santiago.database.MySQL;
import me.dev.santiago.events.LoginEvent;
import me.dev.santiago.login.Login;
import me.dev.santiago.login.LoginAPI;
import me.dev.santiago.utils.TitleAPI;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;

public class LoginCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player))
            return false;

        String password = args[0];
        Player p = (Player)sender;
        Login login = LoginAPI.getLogin(p);

        if(args.length > 1){
            p.sendMessage("§6Use /login <senha> !");
            return false;
        }

        if(login.isLogged()) {
            p.sendMessage(" §6Você já está logado");
            return false;
        }

        if(!password.equals(login.getPassword())){
            p.sendMessage("§cSenha errada, tente novamente!");
            return false;
        }

        Bukkit.getPluginManager().callEvent(new LoginEvent(p));
        return true;
    }
}
