package database.dao;

import database.dto.OwnerDTO;
import database.dto.VehicleModelDTO;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

public class VehicleModelDAO {

    private EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("cars");

    private EntityManager entityManager = entityManagerFactory.createEntityManager();


    private EntityTransaction tx = entityManager.getTransaction();

    public void createVehicleModel(Scanner scanner) {
        System.out.println("Enter model's name:");
        String modelName = scanner.next();
        tx.begin();
        VehicleModelDTO vehicleModelDTO = new VehicleModelDTO(modelName);
        entityManager.persist(vehicleModelDTO);
        tx.commit();
    }

    public VehicleModelDTO findModelByName(String name){
        TypedQuery<VehicleModelDTO> query1 = entityManager.createNamedQuery("modelByName", VehicleModelDTO.class);
        query1.setParameter("byName", name);
        List<VehicleModelDTO> models = query1.getResultList();
        VehicleModelDTO model = models.get(0);
        return model;
    }

    public void closeConnection(){
        entityManager.close();
        entityManagerFactory.close();
        System.exit(0);
    }
}
