package database;

import database.dao.OwnerDAO;
import database.dao.VehicleDAO;
import database.dao.VehicleModelDAO;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        OwnerDAO ownerDAO = new OwnerDAO();
        VehicleModelDAO modelDAO = new VehicleModelDAO();
        VehicleDAO vehicleDAO = new VehicleDAO();

        ownerDAO.createOwner(scanner);
        modelDAO.createVehicleModel(scanner);
        vehicleDAO.createVehicle(scanner);

        ownerDAO.closeConnection();
        vehicleDAO.closeConnection();
        modelDAO.closeConnection();
    }
}
