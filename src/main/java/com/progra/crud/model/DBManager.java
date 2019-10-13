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

    public boolean add (String make,String model,int yearModel,int speed) throws SQLException {
        boolean registrar = queryManager.insert(make,model,yearModel,speed);
        return registrar;
    }
    public boolean remove (int id) throws SQLException {
        boolean registrar = queryManager.delete(id);
        return registrar;
    }
    public void selectAll () throws SQLException {
        queryManager.selecAll();
    }
    public void select (int id) throws SQLException {
        queryManager.select(id);
    }
    public void update (int ID,String make,String model,int yearModel,int speed) throws SQLException {
        queryManager.update(ID,make,model,yearModel,speed);
    }
}
