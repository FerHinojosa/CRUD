/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.progra.crud.controller;


import com.progra.crud.model.DBManager;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;

/**
 * Implements main classes.
 *
 * @author Fernando Hinojosa Sanchez 10/09/2019.
 * @version 1.0
 */
@RestController
@RequestMapping("/api/v1.0/")
public class ManagerController {

    @PostMapping("/car")
    public void insert(@RequestParam(value = "make", defaultValue = "") String make,
                       @RequestParam(value = "model", defaultValue = "") String model,
                       @RequestParam(value = "year", defaultValue = "") int year,
                       @RequestParam(value = "speed", defaultValue = "") int speed) throws SQLException {
        DBManager dbManager = new DBManager();
        boolean test = dbManager.add(make,model,year,speed);
        System.out.println(test);
    }
    @DeleteMapping("/car")
    public void delete(@RequestParam(value = "id", defaultValue = "") int id) throws SQLException{
        DBManager dbManager = new DBManager();
        boolean test = dbManager.remove(id);
        System.out.println(test);
    }
    @GetMapping("/car/{id}")
    public void select(@PathVariable Integer id) throws SQLException{
        DBManager dbManager = new DBManager();
        dbManager.select(id);
    }
    @GetMapping("/car")
    public void selectAll() throws SQLException{
        DBManager dbManager = new DBManager();
        dbManager.selectAll();
    }
    @PutMapping("/car")
    public void update(@RequestParam(value = "id", defaultValue = "") int id,
                       @RequestParam(value = "make", defaultValue = "") String make,
                       @RequestParam(value = "model", defaultValue = "") String model,
                       @RequestParam(value = "year", defaultValue = "") int year,
                       @RequestParam(value = "speed", defaultValue = "") int speed) throws SQLException {
        DBManager dbManager = new DBManager();
        dbManager.update(id,make, model, year, speed);
    }
}
