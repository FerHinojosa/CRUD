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

    public void add (String make,String model,int yearModel,int speed) throws SQLException {
        queryManager.insert(make,model,yearModel,speed);
    }
}
