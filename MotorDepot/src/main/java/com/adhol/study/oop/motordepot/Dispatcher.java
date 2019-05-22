package com.adhol.study.oop.motordepot;

public class Dispatcher {

    private String name;

    public Dispatcher(String name) {
        this.name = name;
    }

    public void assignDriverToRoute(Driver driver, Vehicle vehicle, Route route) {

        double hoursToDone = route.getLengthKm() / vehicle.getAverageSpeedKmPerHour();

        if (driver.isSuspendedFromWork()) {
            System.out.println("Route is impossible, because driver " + driver.getName() + " is suspended to work");
        } else if (vehicle.isBroken()) {
            System.out.println("Route is impossible, because vehicle " + vehicle.getName() + " is broken");
        } else {
            System.out.println("Driver " + driver.getName() + " is fine");
            System.out.println("Vehicle " + vehicle.getName() + " is fine");
            System.out.println("Route starts, hours for done: " + hoursToDone);
            vehicle.calculateChanceOfBreakageDuringRoute();
            driver.makeNoteAboutRouteStatus(route);
            if (driver.calculateChanceOfTrafficOffenceDuringRoute()) {
                suspendDriverForWork(driver);
            }
            driver.makeNoteAboutVehicleStatus(vehicle);
        }
    }

    public void suspendDriverForWork(Driver driver) {
        System.out.println(driver.getName() + " is suspended to work");
        driver.setSuspendedFromWork(true);
    }

    public void allowDriverForWork(Driver driver) {
        System.out.println(driver.getName() + " is allowed to work");
        driver.setSuspendedFromWork(false);
    }
}
