package ro.tuc.ds2020.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
public class Device {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-binary")
    private UUID id;

    @Column(name = "description")
    private String description;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "max_h_energy_consumption", nullable = false)
    private int maxHEnergyConsumption;

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
    private Set<EnergyConsumption> energyConsumptionSet;

    public Device(){

    }

    public Device(String description, String address, int maxHEnergyConsumption, User user){
        this.description = description;
        this.address = address;
        this.maxHEnergyConsumption = maxHEnergyConsumption;
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMaxHEnergyConsumption() {
        return maxHEnergyConsumption;
    }

    public void setMaxHEnergyConsumption(int maxHEnergyConsumption) {
        this.maxHEnergyConsumption = maxHEnergyConsumption;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
