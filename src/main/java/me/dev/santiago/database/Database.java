package me.dev.santiago.database;

import me.dev.santiago.WuxiaLogin;
import org.bukkit.configuration.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private String port;
    private String database;
    private String host;
    private String user;
    private String password;
    private String type;
    private final String url = type + host + ":" + port + "/" + database;

    private Connection connection;

    public Database(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public Connection connect(){
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void closeConnection(){
        try {
            connect().close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
