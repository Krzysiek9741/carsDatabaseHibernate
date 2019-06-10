package database.dto;

import javax.persistence.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "owner")
public class OwnerDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "owner_id")
    private Long ownerId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birth_date")
    private Date birthDate;
    @OneToMany(
            mappedBy = "owner",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<VehicleDTO> vehicles = new ArrayList<>();

    public OwnerDTO() {
    }

    public OwnerDTO(String firstName, String lastName, String birthDate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = java.sql.Date.valueOf(birthDate);    // new SimpleDateFormat("yyyy-MM-dd").parse(birthDate);
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<VehicleDTO> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehicleDTO> vehicles) {
        this.vehicles = vehicles;
    }

    public void addVehicle(VehicleDTO vehicle){
        vehicles.add(vehicle);
        vehicle.setOwner(this);
    }

    public void removeVehicle(VehicleDTO vehicle){
        vehicles.remove(vehicle);
        vehicle.setOwner(null);
    }
}
