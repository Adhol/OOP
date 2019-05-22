package com.adhol.study.oop.motordepot;

import java.util.Arrays;
import java.util.Collections;

public class Vehicle {
    private boolean isBroken;
    private String name;
    private int averageSpeedKmPerHour;
    private int vehicleReliability; //надежность автомобиля от 1 до 99

    public Vehicle(String name, int averageSpeedKmPerHour, int vehicleReliability) {
        this.name = name;
        if (averageSpeedKmPerHour <= 0) {
            this.averageSpeedKmPerHour = 50;
        } else {
            this.averageSpeedKmPerHour = averageSpeedKmPerHour;
        }
        if (vehicleReliability <= 0 | vehicleReliability >= 100) {
            this.vehicleReliability = 50;
        } else {
            this.vehicleReliability = vehicleReliability;
        }
        this.isBroken = false;
    }

    public int getAverageSpeedKmPerHour() {
        return averageSpeedKmPerHour;
    }

    public String getName() {
        return name;
    }

    public boolean isBroken() {
        return isBroken;
    }

    //Рассчитывает вероятность поломки во время рейса в зависимости от надежности автомобиля

    public void calculateChanceOfBreakageDuringRoute() {

        Integer[] a = new Integer[100];

        for (int i = 0; i < a.length - vehicleReliability; i++) {
            a[i] = 1;
        }

        Collections.shuffle(Arrays.asList(a));

        for(int i = 0; i < a.length; i++) {
            if (a[i] == null) {
                a[i] = 0;
            }
        }

        int r = (int) (Math.random() * 100);

        if (a[r] == 0) {
           isBroken = true;
        }
    }
}
