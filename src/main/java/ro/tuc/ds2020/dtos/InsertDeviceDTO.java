package ro.tuc.ds2020.dtos;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class InsertDeviceDTO {

    @NotNull
    String description;
    @NotNull
    String address;
    @NotNull
    int maxHEnergyConsumption;

    public InsertDeviceDTO(){

    }

    public InsertDeviceDTO(String description, String address, int maxHEnergyConsumption){
        this.description = description;
        this.address = address;
        this.maxHEnergyConsumption = maxHEnergyConsumption;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsertDeviceDTO insertDeviceDTO = (InsertDeviceDTO) o;
        return Objects.equals(description, insertDeviceDTO.description) &&
                Objects.equals(address, insertDeviceDTO.address) &&
                Objects.equals(maxHEnergyConsumption, insertDeviceDTO.maxHEnergyConsumption);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, address, maxHEnergyConsumption);
    }

}
