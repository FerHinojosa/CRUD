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


import com.progra.crud.model.Car;
import com.progra.crud.model.DBManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.util.List;

/**
 * Implements main classes.
 *
 * @author Fernando Hinojosa Sanchez 10/09/2019.
 * @version 1.0
 */
@RestController
@RequestMapping("/api/v1.0/")
public class ManagerController {
    private DBManager dbManager;
    @PostMapping("/car")
    public String insert(@RequestParam(value = "make", defaultValue = "") String make,
                         @RequestParam(value = "model", defaultValue = "") String model,
                         @RequestParam(value = "year", defaultValue = "") int year,
                         @RequestParam(value = "speed", defaultValue = "") int speed) throws SQLException {
        String test = dbManager.add(make,model,year,speed);
        return test;
    }
    @DeleteMapping("/car")
    public ResponseEntity delete(@RequestParam(value = "id", defaultValue = "") int id) throws SQLException{
        dbManager = new DBManager();
        int result = dbManager.remove(id);
        if (result > 0){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/car/{id}")
    public ResponseEntity<Car> select(@PathVariable Integer id) throws SQLException{
        dbManager = new DBManager();
        Car result = dbManager.select(id);
        if (result == null){
            return new ResponseEntity<Car>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Car>(result, HttpStatus.OK);
    }
    @GetMapping("/car")
    public List<Car> selectAll() throws SQLException{
        dbManager = new DBManager();
        List<Car> carList = dbManager.selectAll();
        return carList;
    }
    /*@PutMapping("/car")
    public void update(@RequestParam(value = "id", defaultValue = "") int id,
                       @RequestParam(value = "make", defaultValue = "") String make,
                       @RequestParam(value = "model", defaultValue = "") String model,
                       @RequestParam(value = "year", defaultValue = "") int year,
                       @RequestParam(value = "speed", defaultValue = "") int speed) throws SQLException {
        dbManager.update(id,make, model, year, speed);
    }*/
}
