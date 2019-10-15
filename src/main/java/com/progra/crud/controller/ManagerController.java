/**
 * Copyright (c) 2019 Jalasoft.
 * <p>
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

import java.util.List;

/**
 * Implements controller classes.
 *
 * @author Fernando Hinojosa Sanchez 10/09/2019.
 * @version 1.0
 */
@RestController
@RequestMapping("/api/v1.0/")
public class ManagerController {
    private DBManager dbManager;

    /** This method saves object into database.
     * @param make of the car.
     * @param model of the car.
     * @param year of fabrication.
     * @param speed of the car.
     * @return String with the message about what happend with the object.
     */
    @PostMapping("/car")
    public String insert(@RequestParam(value = "make", defaultValue = "") String make,
                         @RequestParam(value = "model", defaultValue = "") String model,
                         @RequestParam(value = "year", defaultValue = "") int year,
                         @RequestParam(value = "speed", defaultValue = "") int speed) {
        dbManager = new DBManager();
        String test= "Registry incomplete, please try again";
        try {
            test = dbManager.add(make, model, year, speed);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return test;
    }

    /** This method deletes record.
     * @param id to delete record.
     * @return numbers of record deleted.
     */
    @DeleteMapping("/car")
    public ResponseEntity delete(@RequestParam(value = "id", defaultValue = "") int id) {
        dbManager = new DBManager();
        try {
            int result = dbManager.remove(id);
            if (result > 0) {
                return new ResponseEntity("Record deleted successfully", HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity("Invalid ID, please introduce valid ID", HttpStatus.BAD_REQUEST);
    }

    /**
     * This method displays object data into form for the given id.
     * @param id to the displays.
     * @return object with the information.
     */
    @GetMapping("/car/{id}")
    public ResponseEntity<Car> select(@PathVariable Integer id) {
        dbManager = new DBManager();
        Car result = dbManager.select(id);
        try {
            if (result == null) {
                return new ResponseEntity<Car>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Car>(result, HttpStatus.OK);
    }

    /**
     * Return all records in the database.
     * @return List with all records has in the database.
     */
    @GetMapping("/car")
    public List<Car> selectAll() {
        dbManager = new DBManager();
        List<Car> carList = null;
        try {
            carList = dbManager.selectAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return carList;
    }

    /**
     * Change any parameter of the object.
     * @param id to the car.
     * @param make to the car.
     * @param model to the car.
     * @param year to the car.
     * @param speed to the car.
     * @return object modified.
     */
    @PutMapping("/car")
    public ResponseEntity<Car> update(@RequestParam(value = "id", defaultValue = "") int id,
                                      @RequestParam(value = "make", defaultValue = "") String make,
                                      @RequestParam(value = "model", defaultValue = "") String model,
                                      @RequestParam(value = "year", defaultValue = "") int year,
                                      @RequestParam(value = "speed", defaultValue = "") int speed) {
        dbManager = new DBManager();
        Car result = dbManager.update(id, make, model, year, speed);
        try {
            if (result == null) {
                return new ResponseEntity<Car>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Car>(result, HttpStatus.OK);
    }
}
