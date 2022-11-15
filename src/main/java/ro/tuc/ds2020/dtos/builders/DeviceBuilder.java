package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.DeviceDTO;
import ro.tuc.ds2020.entities.Device;

public class DeviceBuilder {

    private DeviceBuilder() {
    }

    public static DeviceDTO toDeviceDTO(Device device) {
        return new DeviceDTO(device.getId(), device.getName(), device.getDescription(), device.getAddress(), device.getMaxHourlyConsumption());
    }

    public static Device toDeviceEntity(DeviceDTO deviceDTO) {
        return new Device(deviceDTO.getName(),
                deviceDTO.getDescription(),
                deviceDTO.getAddress(),
                deviceDTO.getMaxHourlyConsumption());
    }
}