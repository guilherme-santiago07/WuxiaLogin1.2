package me.dev.santiago;

import me.dev.santiago.commands.ChangepassCommand;
import me.dev.santiago.commands.LoginCommand;
import me.dev.santiago.commands.LogoutCommand;
import me.dev.santiago.commands.RegisterCommand;
import me.dev.santiago.database.Database;
import me.dev.santiago.database.MySQL;
import me.dev.santiago.listeners.PlayerListeners;
import me.dev.santiago.login.Login;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class WuxiaLogin extends JavaPlugin {
    private static Database database;

    @Override
    public void onEnable() {
        registerCommands();
        registerEvents();
        databaseConnection();
        WuxiaLogin.database = databaseConnection();
        loadConfig();
    }

    @Override
    public void onDisable() {
    }

    public void registerEvents(){
        Bukkit.getPluginManager().registerEvents(new PlayerListeners(), this);
    }

    public void registerCommands(){
        getCommand("Login").setExecutor(new LoginCommand());
        getCommand("Registrar").setExecutor(new RegisterCommand());
        getCommand("trocarsenha").setExecutor(new ChangepassCommand());
        getCommand("Logoff").setExecutor(new LogoutCommand());
    }
    public void loadConfig(){
        getConfig().options().copyDefaults(false);
        saveDefaultConfig();
    }

    public Database databaseConnection(){
        MySQL mySQL = new MySQL(getString("Sql.user"), getString("Sql.password"));
        mySQL.setDatabase(getString("Sql.database"));
        mySQL.setHost(getString("Sql.host"));
        mySQL.setPort(getString("Sql.port"));
        mySQL.setType("jdbc:mysql://");
        mySQL.createTable();
        return mySQL;
    }

    public String getString(String path){
        return getConfig().getString(path);
    }

    public static MySQL getDatabase() {
        return (MySQL) database;
    }

    }


