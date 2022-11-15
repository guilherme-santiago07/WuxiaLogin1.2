package me.dev.santiago.database;

import me.dev.santiago.login.Login;
import org.bukkit.entity.Player;

import java.sql.*;

public class MySQL extends Database{


    public MySQL(String user, String password) {
        super(user, password);
    }

    public void insertPassword(Player player, Login login){
        setConnection(connect());
        String query = "INSERT INTO 'login'('id','password') VALUES (?,?);";
        String id = player.getUniqueId().toString();
        try(PreparedStatement stm = getConnection().prepareStatement(query)){
            stm.setString(1, id);
            stm.setString(2, login.getPassword());
            stm.executeUpdate();
            closeConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updatePassword(Player player, Login login){
        setConnection(connect());
        String query = "UPDATE 'login' SET 'password' = ? WHERE 'id' = ?;";
        String id = player.getUniqueId().toString();
        try(PreparedStatement stm = getConnection().prepareStatement(query)){
            stm.setString(1, login.getPassword());
            stm.setString(2, id);
            stm.executeUpdate();
            closeConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public String getPassword(Player player){
        setConnection(connect());
        String query = "SELECT 'password' FROM 'login' WHERE 'id' = ?;";
        try(Statement stm = getConnection().createStatement()){
            ResultSet rs = stm.executeQuery(query);
            if (rs.next()){
                return  rs.getString("password");
            }
            closeConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void createTable(){
        setConnection(connect());
        String query = "CREATE TABLE IF NOT EXISTS category(id VARCHAR(32),password VARCHAR(16));";
        try(Statement stm = getConnection().createStatement()){
            stm.execute(query);
            closeConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Connection connect() {
        return super.connect();
    }

    @Override
    public void closeConnection() {
        super.closeConnection();
    }

}
