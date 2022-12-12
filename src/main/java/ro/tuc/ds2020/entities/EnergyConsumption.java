package ro.tuc.ds2020.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class EnergyConsumption implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp;

    @Column(name = "energy_value", nullable = false)
    private int energyValue;

    @ManyToOne()
    @JoinColumn(name = "device_id", nullable = false)
    private Device device;

    public EnergyConsumption(){

    }

    public EnergyConsumption(LocalDateTime timestamp, int energyValue, Device device){
        this.timestamp = timestamp;
        this.energyValue = energyValue;
        this.device = device;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getEnergyValue() {
        return energyValue;
    }

    public void setEnergyValue(int energyValue) {
        this.energyValue = energyValue;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
}
