/**
 * Задача на взаимодействие между классами. Разработать систему «Автобаза».
 * Диспетчер распределяет заявки на Рейсы между Водителями и назначает для этого Автомобиль.
 * Водитель может сделать заявку на ремонт.
 * Диспетчер может отстранить Водителя от работы.
 * Водитель делает отметку о выполнении Рейса и состоянии Автомобиля.
 */

import java.util.ArrayList;
import java.util.List;

public class MotorDepot {
    public static void main(String[] args) {
        List<Driver> listOfDrivers = new ArrayList<>();
        List<Vehicle> listOfVehicle = new ArrayList<>();

        listOfDrivers.add(new Driver("John Doe", 70));
        listOfDrivers.add(new Driver("Mary Jane", 60));
        listOfDrivers.add(new Driver("John Snow", 90));
        listOfDrivers.add(new Driver("Keyser Soze", 80));

        listOfVehicle.add(new Vehicle("Mack", 90, 10));
        listOfVehicle.add(new Vehicle("Kenworth", 75, 15));
        listOfVehicle.add(new Vehicle("Volvo", 110, 5));
        listOfVehicle.add(new Vehicle("Peterbilt", 85, 7));
        listOfVehicle.add(new Vehicle("Kamaz", 60, 30));
        listOfVehicle.add(new Vehicle("Maz", 65, 35));

        Dispatcher dispatcher = new Dispatcher("Paul Gray");

        dispatcher.assignDriverToRoute(listOfDrivers.get(0), listOfVehicle.get(0), new Route(2700));
        System.out.println();
        dispatcher.assignDriverToRoute(listOfDrivers.get(1), listOfVehicle.get(1), new Route(1300));
        System.out.println();
        dispatcher.assignDriverToRoute(listOfDrivers.get(2), listOfVehicle.get(2), new Route(1500));
        System.out.println();
        dispatcher.assignDriverToRoute(listOfDrivers.get(3), listOfVehicle.get(3), new Route(3000));
        System.out.println();
        dispatcher.assignDriverToRoute(listOfDrivers.get(0), listOfVehicle.get(4), new Route(2100));
        System.out.println();
        dispatcher.assignDriverToRoute(listOfDrivers.get(1), listOfVehicle.get(5), new Route(1500));
        System.out.println();
        dispatcher.assignDriverToRoute(listOfDrivers.get(2), listOfVehicle.get(0), new Route(3500));
        System.out.println();
        dispatcher.assignDriverToRoute(listOfDrivers.get(3), listOfVehicle.get(1), new Route(900));
        System.out.println();
        dispatcher.assignDriverToRoute(listOfDrivers.get(0), listOfVehicle.get(2), new Route(400));
        System.out.println();
        dispatcher.assignDriverToRoute(listOfDrivers.get(1), listOfVehicle.get(3), new Route(3100));
        System.out.println();
        dispatcher.assignDriverToRoute(listOfDrivers.get(2), listOfVehicle.get(4), new Route(1800));
        System.out.println();
        dispatcher.assignDriverToRoute(listOfDrivers.get(3), listOfVehicle.get(5), new Route(1500));
        System.out.println();

    }
}
