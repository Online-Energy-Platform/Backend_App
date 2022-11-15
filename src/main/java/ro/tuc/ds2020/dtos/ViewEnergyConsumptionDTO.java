package ro.tuc.ds2020.dtos;

import java.time.LocalDateTime;
import java.util.Objects;

public class ViewEnergyConsumptionDTO {

    private LocalDateTime timestamp;
    private int energyValue;

    public ViewEnergyConsumptionDTO(){

    }

    public ViewEnergyConsumptionDTO(LocalDateTime timestamp, int energyValue){
        this.timestamp = timestamp;
        this.energyValue = energyValue;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViewEnergyConsumptionDTO energyDTO = (ViewEnergyConsumptionDTO) o;
        return Objects.equals(timestamp, energyDTO.timestamp) &&
                Objects.equals(energyValue, energyDTO.energyValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, energyValue);
    }

}
