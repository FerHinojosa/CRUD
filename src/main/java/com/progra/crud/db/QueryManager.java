/**
 * Copyright (c) 2019 Jalasoft.
 * <p>
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.progra.crud.db;

import com.progra.crud.model.Car;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implements DB Manager.
 *
 * @author Fernando Hinojosa on 10/12/2019.
 * @version v1.0
 */
public class QueryManager {
    private Connection connection;
    private Statement statement;

    /**
     * Create the connection with the DB.
     */
    public QueryManager() {
        connection = DBConnection.getInstance().getConnection();
    }

    /**
     * Create table in the data base.
     */
    public void createTable() {
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

    /**
     * Insert record in the data base.
     * @param make of the car.
     * @param model of the car.
     * @param yearModel of the car.
     * @param speed of the car.
     * @return String with the message about what happend with the object.
     */
    public String insert(String make, String model, int yearModel, int speed) {
        String registrar = "Registry incomplete, please try again";
        String sql = "INSERT INTO CarStorage (make,model,year,speed)" + "VALUES (?,?,?,?)";
        try (PreparedStatement state = connection.prepareStatement(sql)) {
            state.setString(1, make);
            state.setString(2, model);
            state.setInt(3, yearModel);
            state.setInt(4, speed);
            state.executeUpdate();
            registrar = "Succesfull registry!";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrar;
    }

    /**
     *  Delete record of the data base.
     * @param id of the car.
     * @return numbers of record deleted.
     */
    public int delete(int id) {
        int deletedRow = 0;
        String sql = "DELETE FROM CarStorage WHERE ID = ?";
        try (PreparedStatement state = connection.prepareStatement(sql)) {
            state.setInt(1, id);
            deletedRow = state.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deletedRow;
    }

    /**
     * Display specified record of the data base.
     * @param id of the car.
     * @return object with the information.
     */
    public Car select(int id) {
        String sql = "SELECT * FROM CarStorage WHERE ID = ?";
        Car carResult = null;
        try (PreparedStatement state = connection.prepareStatement(sql)) {
            state.setInt(1, id);
            ResultSet resultSet = state.executeQuery();
            while (resultSet.next()) {
                resultSet.getInt("id");
                String make = resultSet.getString("make");
                String model = resultSet.getString("model");
                int year = resultSet.getInt("year");
                int speed = resultSet.getInt("speed");
                carResult = new Car(make, model, year, speed);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carResult;
    }

    /**
     * Display all records of the data base.
     * @return List with all records has in the database.
     */
    public List<Car> selecAll() {
        String sql = "SELECT * FROM CarStorage";
        List<Car> carList = new ArrayList<Car>();
        try (PreparedStatement state = connection.prepareStatement(sql);
             ResultSet resultSet = state.executeQuery();) {
            while (resultSet.next()) {
                String make = resultSet.getString("make");
                String model = resultSet.getString("model");
                int year = resultSet.getInt("year");
                int speed = resultSet.getInt("speed");
                Car carResult = new Car(make, model, year, speed);
                carList.add(carResult);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carList;
    }

    /**
     * Modify record of the data base.
     * @param id of the car.
     * @param make of the car.
     * @param model of the car.
     * @param yearModel of the car.
     * @param speed of the car.
     * @return object modified.
     */
    public Car update(int id, String make, String model, int yearModel, int speed) {
        String sql = "UPDATE CarStorage SET make = ?, model = ?, year = ?, speed = ? WHERE id = ?;";
        Car carResult = null;
        try (PreparedStatement state = connection.prepareStatement(sql)) {
            state.setString(1, make);
            state.setString(2, model);
            state.setInt(3, yearModel);
            state.setInt(4, speed);
            state.setInt(5, id);
            state.executeUpdate();
            carResult = new Car(make, model, yearModel, speed);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carResult;
    }
}
