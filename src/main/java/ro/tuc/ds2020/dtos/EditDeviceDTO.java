package ro.tuc.ds2020.dtos;

import java.util.Objects;
import java.util.UUID;

public class EditDeviceDTO {

    String description;
    String address;
    int maxHEnergyConsumption;
    UUID userId;

    public EditDeviceDTO(){

    }

    public EditDeviceDTO(String description, String address, int maxHEnergyConsumption, UUID userId){
        this.description = description;
        this.address = address;
        this.maxHEnergyConsumption = maxHEnergyConsumption;
        this.userId = userId;
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

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceDTO deviceDTO = (DeviceDTO) o;
        return Objects.equals(description, deviceDTO.description) &&
                Objects.equals(address, deviceDTO.address) &&
                Objects.equals(maxHEnergyConsumption, deviceDTO.maxHEnergyConsumption) &&
                Objects.equals(userId, deviceDTO.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, address, maxHEnergyConsumption, userId);
    }

}
