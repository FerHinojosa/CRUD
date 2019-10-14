/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.progra.crud.model;

import com.progra.crud.db.QueryManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implements DB Manager.
 *
 * @author Fernando Hinojosa on 10/03/2019.
 * @version v1.0
 */
public class DBManager {
    private QueryManager queryManager;
    public DBManager(){
        queryManager = new QueryManager();
        queryManager.createTable();
    }

    public String add (String make,String model,int yearModel,int speed){
        String registrar = queryManager.insert(make,model,yearModel,speed);
        return registrar;
    }
    public int remove (int id) throws SQLException {
        int registrar = queryManager.delete(id);
        return registrar;
    }
    public List<Car> selectAll () throws SQLException {
        return queryManager.selecAll();
    }
    public Car select (int id) throws SQLException {
        return queryManager.select(id);
    }
    /*public void update (int ID,String make,String model,int yearModel,int speed) throws SQLException {
        queryManager.update(ID,make,model,yearModel,speed);
    }*/
}
