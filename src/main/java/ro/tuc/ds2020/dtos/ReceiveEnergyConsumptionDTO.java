package ro.tuc.ds2020.dtos;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class ReceiveEnergyConsumptionDTO {

    private LocalDateTime timestamp;
    private UUID deviceId;
    private double measurementValue;

    public ReceiveEnergyConsumptionDTO() {
    }

    public ReceiveEnergyConsumptionDTO(LocalDateTime timestamp, UUID deviceId, double measurementValue) {
        this.timestamp = timestamp;
        this.deviceId = deviceId;
        this.measurementValue = measurementValue;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public UUID getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(UUID deviceId) {
        this.deviceId = deviceId;
    }

    public double getMeasurementValue() {
        return measurementValue;
    }

    public void setMeasurementValue(double measurementValue) {
        this.measurementValue = measurementValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReceiveEnergyConsumptionDTO that = (ReceiveEnergyConsumptionDTO) o;
        return measurementValue == that.measurementValue &&
                Objects.equals(timestamp, that.timestamp) &&
                Objects.equals(deviceId, that.deviceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, deviceId, measurementValue);
    }

    @Override
    public String toString() {
        return "MeasurementDTO{" +
                "timestamp=" + timestamp +
                ", deviceId=" + deviceId +
                ", measurementValue=" + measurementValue +
                '}';
    }

}
