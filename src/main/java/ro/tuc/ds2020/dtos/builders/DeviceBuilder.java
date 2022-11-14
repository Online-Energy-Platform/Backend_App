package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.DeviceDTO;
import ro.tuc.ds2020.dtos.EditDeviceDTO;
import ro.tuc.ds2020.dtos.InsertDeviceDTO;
import ro.tuc.ds2020.entities.Device;
import ro.tuc.ds2020.entities.User;

import java.util.UUID;

public class DeviceBuilder {

    public DeviceBuilder(){

    }

    public static DeviceDTO toDeviceDTO(Device device){
        UUID userID = null;
        if(device.getUser() != null){
            userID = device.getUser().getId();
        }
        return new DeviceDTO(device.getId(), device.getDescription(), device.getAddress(), device.getMaxHEnergyConsumption(), userID);
    }

    public static Device toEntity(InsertDeviceDTO insertDeviceDTO){
        return new Device(insertDeviceDTO.getDescription(), insertDeviceDTO.getAddress(), insertDeviceDTO.getMaxHEnergyConsumption(), null);
    }

    public static Device editDeviceDTOToEntity(EditDeviceDTO editDeviceDTO, User user, Device device){
        String description = editDeviceDTO.getDescription();
        String address = editDeviceDTO.getAddress();
        int maxHEnergyConsumption = editDeviceDTO.getMaxHEnergyConsumption();
        if(description != null){
            device.setDescription(description);
        }
        if(address != null){
            device.setAddress(address);
        }
        if(maxHEnergyConsumption != 0){
            device.setMaxHEnergyConsumption(maxHEnergyConsumption);
        }
        if(user != null){
            device.setUser(user);
        }
        return device;
    }

    public static EditDeviceDTO toEditDeviceDTO(Device editedDevice) {
        return new EditDeviceDTO(editedDevice.getDescription(), editedDevice.getAddress(), editedDevice.getMaxHEnergyConsumption(), editedDevice.getUser().getId());
    }
}
