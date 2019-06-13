package database.dto;

import javax.persistence.*;

@Entity
@Table(name = "Vehicle")
public class VehicleDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicle_id")
    private Long vehicleId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Owner_id")
    private OwnerDTO owner;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_model_id")
    private VehicleModelDTO vehicle_model;
    @Column(name = "production_year")
    private int productionYear;
    @Column(name = "color")
    private String color;
    @Column(name = "weight")
    private int weight;
    @Column(name = "registration_number")
    private String reistrationNumber;

    public VehicleDTO() {
    }

    public VehicleDTO(VehicleModelDTO vehicle_model, int productionYear, String color, String reistrationNumber) {
        this.vehicle_model = vehicle_model;
        this.productionYear = productionYear;
        this.color = color;
        this.reistrationNumber = reistrationNumber;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public OwnerDTO getOwner() {
        return owner;
    }

    public void setOwner(OwnerDTO owner) {
        //OwnerDTO oldOwner = this.owner;
        this.owner = owner;
    }

    public VehicleModelDTO getVehicle_model() {
        return vehicle_model;
    }

    public void setVehicle_model(VehicleModelDTO vehicle_model) {
        this.vehicle_model = vehicle_model;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getReistrationNumber() {
        return reistrationNumber;
    }

    public void setReistrationNumber(String reistrationNumber) {
        this.reistrationNumber = reistrationNumber;
    }

    @Override
    public String toString() {
        return  "Model: " + vehicle_model +
                "\nProduction year: " + productionYear +
                "\nColor: " + color +
                "\nRegistration number: " + reistrationNumber;
    }
}
