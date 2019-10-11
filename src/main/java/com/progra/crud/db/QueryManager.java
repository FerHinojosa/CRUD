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

    public boolean insert (String checksum, String path) throws SQLException {
        statement = connection.createStatement();
        statement.execute("create table if not exists(check varchar(20), path varchar(20)");
        String sql = "INSERT INTO FileStorage (checksum,path)" + "VALUES (?,?)";
        boolean query = false;
        try (PreparedStatement state = connection.prepareStatement(sql)) {
            state.setString(1,checksum);
            state.setString(2,path);
            query = state.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
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
