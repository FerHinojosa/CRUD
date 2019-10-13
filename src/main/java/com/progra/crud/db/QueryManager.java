package com.progra.crud.db;

import com.progra.crud.model.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QueryManager {
    private Connection connection;
    private Statement statement;
    public QueryManager() {
        connection = DBConnection.getInstance().getConnection();
    }

    public void createTable (){
        String createSql = "CREATE TABLE IF NOT EXISTS CarStorage " +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " make varchar(50)," +
                " model varchar(50)," +
                " year integer, " +
                " speed integer)";
        try {
            statement = connection.createStatement();
            statement.executeUpdate(createSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean insert (String make,String model,int yearModel,int speed) {
        boolean registrar = false;
        String sql = "INSERT INTO CarStorage (make,model,year,speed)" + "VALUES (?,?,?,?)";
        try (PreparedStatement state = connection.prepareStatement(sql)) {
            state.setString(1,make);
            state.setString(2,model);
            state.setInt(3,yearModel);
            state.setInt(4,speed);
            state.executeUpdate();
            registrar = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrar;
    }
    public boolean delete (int id){
        boolean registrar = false;
        String sql = "DELETE FROM CarStorage WHERE ID = ?";
        try (PreparedStatement state = connection.prepareStatement(sql)) {
            state.setInt(1,id);
            state.executeUpdate();
            registrar = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrar;
    }
    public void select (int id){
        String sql = "SELECT * FROM CarStorage WHERE ID = ?";
        try (PreparedStatement state = connection.prepareStatement(sql)) {
            state.setInt(1,id);
            ResultSet resultSet = state.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") +  "\t" +
                        resultSet.getString("make") + "\t" +
                        resultSet.getString("model") + "\t" +
                        resultSet.getInt("year") + "\t" +
                        resultSet.getInt("speed"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void selecAll(){
        String sql = "SELECT * FROM CarStorage";
        try (PreparedStatement state = connection.prepareStatement(sql);
             ResultSet resultSet = state.executeQuery();) {
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") +  "\t" +
                        resultSet.getString("make") + "\t" +
                        resultSet.getString("model") + "\t" +
                        resultSet.getInt("year") + "\t" +
                        resultSet.getInt("speed"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update (int id,String make,String model,int yearModel,int speed) {
        String sql = "UPDATE CarStorage SET make = ?, model = ?, year = ?, speed = ? WHERE id = ?;";
        try (PreparedStatement state = connection.prepareStatement(sql)) {
            state.setString(1,make);
            state.setString(2,model);
            state.setInt(3,yearModel);
            state.setInt(4,speed);
            state.setInt(5,id);
            state.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
