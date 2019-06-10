package database.dto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vehicle_model")
@NamedQuery(name = "modelByName", query = "FROM VehicleModelDTO WHERE name = :byName")
public class VehicleModelDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vehicleModelId;
    @Column(name = "model_name")
    private String name;
    @OneToMany(
            mappedBy = "vehicle_model",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<VehicleDTO> vehicles = new ArrayList<>();

    public VehicleModelDTO() {
    }

    public VehicleModelDTO(String name) {
        this.name = name;
    }

    public Long getVehicleModelId() {
        return vehicleModelId;
    }

    public void setVehicleModelId(Long vehicleModelId) {
        this.vehicleModelId = vehicleModelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<VehicleDTO> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehicleDTO> vehicles) {
        this.vehicles = vehicles;
    }

    public void addVehicle(VehicleDTO vehicle){
        vehicles.add(vehicle);
        vehicle.setVehicle_model(this);
    }

    public void removeVehicle(VehicleDTO vehicle){
        vehicles.remove(vehicle);
        vehicle.setVehicle_model(null);
    }
}
