package com.progra.crud.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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
    public void insert (String make,String model,int yearModel,int speed) {
        String sql = "INSERT INTO CarStorage (make,model,year,speed)" + "VALUES (?,?,?,?)";
        try (PreparedStatement state = connection.prepareStatement(sql)) {
            state.setString(1,make);
            state.setString(2,model);
            state.setInt(3,yearModel);
            state.setInt(4,speed);
            state.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*public void create() {
        try {
            statement = connection.createStatement();
            String sql = "CREATE TABLE COMPANY " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " NAME           TEXT    NOT NULL, " +
                    " AGE            INT     NOT NULL, " +
                    " ADDRESS        CHAR(50), " +
                    " SALARY         REAL)";
            statement.execute(sql);
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }*/
}
