package me.dev.santiago.login;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class LoginAPI {
    private static HashMap<Player, Login> loginHashMap = new HashMap<>();

    public static void setLogin(Player player, Login login){
        loginHashMap.put(player, login);
    }

    public static Login getLogin(Player player){
        return loginHashMap.get(player);
    }


}
