package com.adhol.study.oop.motordepot;

import java.util.Arrays;
import java.util.Collections;

public class Driver {
    private String name;
    private int drivingSkill; // опыт водителя от 1 до 99
    private boolean isSuspendedFromWork;

    public Driver(String name, int drivingSkill) {
        this.name = name;
        if (drivingSkill <= 0 | drivingSkill >= 100) {
            this.drivingSkill = 50;
        } else {
            this.drivingSkill = drivingSkill;
        }
        this.isSuspendedFromWork = false;
    }

    public boolean makeNoteAboutVehicleStatus(Vehicle vehicle) {
        if (vehicle.isBroken()) {
            System.out.println("Vehicle " + vehicle.getName() + " is broken");
            makeRequestForRepair(vehicle);
        } else {
            System.out.println("Vehicle " + vehicle.getName() + " is fine");
        }
        return vehicle.isBroken();
    }

    public void makeNoteAboutRouteStatus(Route route) {
        System.out.println("Route is done");
        route.setDone(true);
    }

    public void makeRequestForRepair(Vehicle vehicle) {
        System.out.println("Vehicle " + vehicle.getName() + " needs repair");
    }

    public String getName() {
        return name;
    }

    public boolean isSuspendedFromWork() {
        return isSuspendedFromWork;
    }

    public void setSuspendedFromWork(boolean suspendedFromWork) {
        isSuspendedFromWork = suspendedFromWork;
    }

    //Рассчитывает вероятность получения штрафа во время рейса в зависимости от отпыта вождения водителя

    public boolean calculateChanceOfTrafficOffenceDuringRoute() {

        boolean b = false;

        Integer[] arr = new Integer[100];

        for (int i = 0; i <= drivingSkill; i++) {
            arr[i] = 1;
        }

        Collections.shuffle(Arrays.asList(arr));

        for(int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                arr[i] = 0;
            }
        }

        int r = (int) (Math.random() * 100);

        if (arr[r] == 0) {

            b = true;
            System.out.println("Driver " + name + " fined for traffic offense");
        }

        return b;
    }
}
