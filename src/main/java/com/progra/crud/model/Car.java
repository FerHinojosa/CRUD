package com.progra.crud.model;

public class Car {
    private int yearModel;
    private String make;
    private String model;
    private int speed;

    public int getYearModel() {
        return yearModel;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYearModel(int yearModel) {
        this.yearModel = yearModel;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
