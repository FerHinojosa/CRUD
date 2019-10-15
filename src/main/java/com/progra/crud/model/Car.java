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

/**
 * Implements DB Manager.
 *
 * @author Fernando Hinojosa on 10/12/2019.
 * @version v1.0
 */
public class Car {
    private int yearModel;
    private String make;
    private String model;
    private int speed;

    /**
     * Constructor of the class Car.
     * @param make of the car.
     * @param model of the car.
     * @param yearModel of the car.
     * @param speed of the car.
     */
    public Car(String make, String model,int yearModel, int speed) {
        this.yearModel = yearModel;
        this.make = make;
        this.model = model;
        this.speed = speed;
    }

    /**
     * Gets the year model.
     * @return the year model.
     */
    public int getYearModel() {
        return yearModel;
    }

    /**
     * Get model.
     * @return the model of the car.
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets model.
     * @param model of the car.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Sets year model.
     * @param yearModel of the car.
     */
    public void setYearModel(int yearModel) {
        this.yearModel = yearModel;
    }

    /**
     * Gets make of the car.
     * @return string with the make.
     */
    public String getMake() {
        return make;
    }

    /**
     * Sets make of the car.
     * @param make the car.
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * Gets speed of the car.
     * @return int with the speed of the car.
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Sets speed of the car.
     * @param speed of the car.
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
