package me.dev.santiago.commands;

import me.dev.santiago.WuxiaLogin;
import me.dev.santiago.database.MySQL;
import me.dev.santiago.login.Login;
import me.dev.santiago.login.LoginAPI;
import me.dev.santiago.utils.TitleAPI;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;

public class RegisterCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player))
            return false;

        final Player player = (Player) sender;
        final Login login = LoginAPI.getLogin(player);


        if (login.getPassword() != null) {
            player.sendMessage("§cVocê ja está registrado!");
            return false;
        }

        if (args.length != 2) {
            player.sendMessage("§cUso incorreto, use: /registrar <senha> <senha>.");
            return false;
        }

        final String firstPassword = args[0];
        final String confirmPassword = args[1];

        if(firstPassword.length() < 4) {
            player.sendMessage("§cSenha muito curta!");
            return false;
        }

        if (!(firstPassword.equals(confirmPassword))){
            player.sendMessage("§cAs senhas estão diferentes");
            return false;
        }

        login.register(firstPassword);
        TitleAPI.sendTitle(player, 20, 40, 20,"§6Registrado com sucesso!",
                "§6Bem vindo ao servidor!" );
        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BELL, 100, 10);
        player.sendMessage("§6Você foi registrado com sucesso");
        login.login();

        return true;
    }
}
