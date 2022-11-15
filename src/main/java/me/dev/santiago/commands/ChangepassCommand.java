package me.dev.santiago.commands;

import me.dev.santiago.login.Login;
import me.dev.santiago.login.LoginAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChangepassCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player))
            return false;

        Player p = (Player) sender;
        Login login = LoginAPI.getLogin(p);
        String lastPassword = login.getPassword();

        if (!login.isLogged()) {
            p.sendMessage("§cVocê precisa estar logado para isso!");
            return false;
        }

        if (args.length < 2) {
            p.sendMessage("§cUse /trocarsenha <senhaantiga> <senhanova>");
            return false;
        }

        if (!args[0].equals(lastPassword)) {
            p.sendMessage("§cSenha antiga incorreta, insira novamente");
            return false;
        }

        if (args[1].equals(lastPassword)) {
            p.sendMessage("§cSua senha nova não pode ser igual a antiga!");
            return false;
        }

        if(args[1].length() < 4) {
            p.sendMessage("§cSenha muito curta!");
            return false;
        }

        login.setPassword(args[1]);
        p.sendMessage("§6Senha alterada com sucesso!");

        return false;
    }

}
