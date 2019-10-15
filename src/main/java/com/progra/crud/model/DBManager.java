/**
 * Copyright (c) 2019 Jalasoft.
 * <p>
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.progra.crud.model;

import com.progra.crud.db.QueryManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Implements DB Manager.
 *
 * @author Fernando Hinojosa on 10/12/2019.
 * @version v1.0
 */
public class DBManager {
    private QueryManager queryManager;

    /**
     * Creates the connection with the Query, and create the table.
     */
    public DBManager() {
        queryManager = new QueryManager();
        queryManager.createTable();
    }

    /**
     * Add record in the data base.
     * @param make of the car.
     * @param model of the car.
     * @param yearModel of the car.
     * @param speed of the car.
     * @return String with the message about what happend with the object.
     */
    public String add(String make, String model, int yearModel, int speed) {
        String registrar = queryManager.insert(make, model, yearModel, speed);
        return registrar;
    }

    /**
     * Delete record in the data base.
     * @param id of the car.
     * @return numbers of record deleted.
     */
    public int remove(int id) {
        int registrar = 0;
        try {
            registrar = queryManager.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return registrar;
    }

    /**
     * Display all record of the data base.
     * @return List with all records has in the database.
     */
    public List<Car> selectAll() {
        List<Car> carList = new ArrayList<Car>();
        try {
            carList = queryManager.selecAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return carList;
    }

    /**
     * Display an specific record of the data base.
     * @param id of the car.
     * @return object with the information.
     */
    public Car select(int id) {
        Car car = null;
        try {
            car = queryManager.select(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return car;
    }

    /**
     * Modify any record of the data base.
     * @param ID of the car.
     * @param make of the car.
     * @param model of the car.
     * @param yearModel of the car.
     * @param speed of the car.
     * @return object modified.
     */
    public Car update(int ID, String make, String model, int yearModel, int speed) {
        Car car = null;
        try {
            car = queryManager.update(ID, make, model, yearModel, speed);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return car;
    }
}
