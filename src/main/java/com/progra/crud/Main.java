/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.progra.crud;

import com.progra.crud.model.DBManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

/**
 * Implements main classes.
 *
 * @author Fernando Hinojosa Sanchez 10/09/2019.
 * @version 1.0
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) throws SQLException {
        SpringApplication.run(Main.class, args);
        /*DBManager dbManager = new DBManager();


        dbManager.remove(1);
        boolean remove = dbManager.remove(4);
        System.out.println(remove);
        dbManager.selectAll();
        System.out.println("//////////");
        dbManager.update(2,"Audi","Explorer",1998,100);*/
    }
}
