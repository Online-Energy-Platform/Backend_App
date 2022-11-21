package ro.tuc.ds2020.dtos;

import java.util.Objects;
import java.util.UUID;

public class InsertEnergyConsumptionDTO {

    private UUID id;
    private int year;
    private int month;
    private int day;
    private int energyValue;
    private UUID deviceID;

    public InsertEnergyConsumptionDTO(){

    }

    public InsertEnergyConsumptionDTO(UUID id, int year, int month, int day, int energyValue, UUID deviceID){
        this.id = id;
        this.year = year;
        this.month = month;
        this.day = day;
        this.energyValue = energyValue;
        this.deviceID = deviceID;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public UUID getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(UUID deviceID) {
        this.deviceID = deviceID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsertEnergyConsumptionDTO energyDTO = (InsertEnergyConsumptionDTO) o;
        return Objects.equals(year, energyDTO.year) &&
                Objects.equals(month, energyDTO.month) &&
                Objects.equals(day, energyDTO.day) &&
                Objects.equals(energyValue, energyDTO.energyValue) &&
                Objects.equals(deviceID, energyDTO.deviceID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day, energyValue, deviceID);
    }

}
