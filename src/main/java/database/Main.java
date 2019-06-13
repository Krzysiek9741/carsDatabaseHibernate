package database;

import database.dao.OwnerDAO;
import database.dao.VehicleDAO;
import database.dao.VehicleModelDAO;

import java.util.Scanner;

public class Main {

    OwnerDAO ownerDAO = new OwnerDAO();
    VehicleModelDAO modelDAO = new VehicleModelDAO();
    VehicleDAO vehicleDAO = new VehicleDAO();

    public static void main(String[] args) {
        Main main = new Main();
        main.runApp(args);
    }

    public void runApp(String[] args) {

        boolean finish = false;
        try (Scanner scanner = new Scanner(System.in)) {
            while (!finish) {
                System.out.println("|------------------------------------|");
                System.out.println("|                MENU                |");
                System.out.println("|------------------------------------|");
                System.out.println("|    OPTIONS:                        |");
                System.out.println("|         1. Create a new owner      |");
                System.out.println("|         2. Create a new car        |");
                System.out.println("|         3. Create a new car model  |");
                System.out.println("|         4. Add car to owner        |");
                System.out.println("|         5. Remove car from owner   |");
                System.out.println("|         6. Delete car              |");
                System.out.println("|         7. Show all owner's cars   |");
                System.out.println("|         8. Exit                    |");
                System.out.println("|------------------------------------|");
                int digit = scanner.nextInt();
                switch (digit) {
                    case 1:
                        ownerDAO.createOwner(scanner);
                        break;
                    case 2:
                        vehicleDAO.createVehicle(scanner, modelDAO);
                        break;
                    case 3:
                        modelDAO.createVehicleModel(scanner);
                        break;
                    case 4:
                        ownerDAO.addNewVehicle(scanner);
                        break;
                    case 5:

                    case 6:

                    case 7:
                        ownerDAO.showAllOwnerCars(scanner);
                        break;
                    case 8:
                        finish = true;
                        ownerDAO.closeConnection();
                        modelDAO.closeConnection();
                        vehicleDAO.closeConnection();
                        break;
                }
            }
        }

    }
}
