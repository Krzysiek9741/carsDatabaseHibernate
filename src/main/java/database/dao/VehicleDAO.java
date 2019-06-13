package database.dao;

import database.dto.OwnerDTO;
import database.dto.VehicleDTO;
import database.dto.VehicleModelDTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Scanner;

public class VehicleDAO {

    private EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("cars");

    private EntityManager entityManager = entityManagerFactory.createEntityManager();


    private EntityTransaction tx = entityManager.getTransaction();


    public void createVehicle(Scanner scanner, VehicleModelDAO modelDAO) {
        System.out.println("Enter model's name:");
        String modelName = scanner.next();
        VehicleModelDTO model = modelDAO.findModelByName(modelName);
        System.out.println("Enter vehicle's color:");
        String color = scanner.next();
        System.out.println("Enter vehicle's production year:");
        int productionYear = scanner.nextInt();
        System.out.println("Enter vehicle's registration number:");
        String registrationNumber = scanner.next();
        tx.begin();
        VehicleDTO vehicle = new VehicleDTO(model, productionYear, color, registrationNumber);
        entityManager.persist(vehicle);
        tx.commit();
    }

    public VehicleDTO findVehicleById(Long vehicleId){
        VehicleDTO vehicle = entityManager.find(VehicleDTO.class, vehicleId);

        return vehicle;
    }

    public void closeConnection(){
        entityManager.close();
        entityManagerFactory.close();
        System.exit(0);
    }
}
