package database.dao;

import database.dto.OwnerDTO;
import database.dto.VehicleDTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class OwnerDAO {
    private EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("cars");

    private EntityManager entityManager = entityManagerFactory.createEntityManager();


    private EntityTransaction tx = entityManager.getTransaction();

    private VehicleDAO vehicleDAO;

    public void createOwner(Scanner scanner) {
        System.out.println("Enter owner's name:");
        String firstName = scanner.next();
        System.out.println("Enter owner's surname:");
        String lastName = scanner.next();
        System.out.println("Enter owner's birth date (in format yyyy-MM-dd):");
        String birthDate = scanner.next();
        tx.begin();
        OwnerDTO newOwner = new OwnerDTO(firstName, lastName, birthDate);
        entityManager.persist(newOwner);
        tx.commit();
    }

    public void changeOwnerName(Scanner scanner){
        System.out.println("Enter owner's id:");
        Long id =  scanner.nextLong();
        System.out.println("Enter new owner's name:");
        String newName = scanner.next();
        tx.begin();
        OwnerDTO ownerDTO = findOwnerById(id);
        ownerDTO.setFirstName(newName);
        entityManager.persist(ownerDTO);
        tx.commit();
    }

    private OwnerDTO findOwnerById(Long id){
        OwnerDTO ownerDTO = entityManager.find(OwnerDTO.class, id);
        return ownerDTO;
    }

    public void showOwnerDetails(Long id){
        OwnerDTO ownerDTO = findOwnerById(id);
        System.out.println("Owner's name: " + ownerDTO.getFirstName());
        System.out.println("Owner's surname: " + ownerDTO.getLastName());
        System.out.println("Owner's birth date: " + ownerDTO.getBirthDate());
    }

    public void showAllOwnerCars(Long ownerId){
        OwnerDTO owner = findOwnerById(ownerId);
        List<VehicleDTO> vehicles = owner.getVehicles();
        int count = 0;
        for (VehicleDTO veh:vehicles) {
            count++;
            System.out.println("-----------------------");
            System.out.println(count + ".");
            System.out.println(veh);
        }
    }

    public void addNewVehicle(Long ownerId, Long vehicleId){
        tx.begin();
        OwnerDTO owner = findOwnerById(ownerId);
        owner.addVehicle(vehicleDAO.findVehicleById(vehicleId));
        entityManager.persist(owner);
        tx.commit();
    }


    public void closeConnection(){
        entityManager.close();
        entityManagerFactory.close();
        System.exit(0);
    }
}
