package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.dtos.DeviceDTO;
import ro.tuc.ds2020.dtos.EditDeviceDTO;
import ro.tuc.ds2020.dtos.InsertDeviceDTO;
import ro.tuc.ds2020.dtos.builders.DeviceBuilder;
import ro.tuc.ds2020.entities.Device;
import ro.tuc.ds2020.entities.User;
import ro.tuc.ds2020.repositories.DeviceRepository;
import ro.tuc.ds2020.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DeviceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeviceService.class);
    private final DeviceRepository deviceRepository;
    private final UserRepository userRepository;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository, UserRepository userRepository){
        this.deviceRepository = deviceRepository;
        this.userRepository = userRepository;
    }


    public List<DeviceDTO> findDevices() {
        List<Device> deviceList = deviceRepository.findAll();
        LOGGER.info("S-au returnat " + deviceList.size() + " devices!");
        List<DeviceDTO> deviceDTOList = new ArrayList<>();
        for(Device device: deviceList){
            deviceDTOList.add(DeviceBuilder.toDeviceDTO(device));
        }
        return deviceDTOList;
    }

    public DeviceDTO getDevice(UUID id) {
        Optional<Device> device = deviceRepository.findById(id);
        if(!device.isPresent()){
            throw new ResourceNotFoundException(Device.class.getSimpleName() + " with id: " + id);
        }
        return DeviceBuilder.toDeviceDTO(device.get());
    }

    public UUID insert(InsertDeviceDTO insertDeviceDTO) {
        Device device = DeviceBuilder.toEntity(insertDeviceDTO);
        deviceRepository.save(device);
        return device.getId();
    }

    public EditDeviceDTO editDevice(UUID id, EditDeviceDTO editDeviceDTO) {
        Optional<Device> device = deviceRepository.findById(id);
        if(!device.isPresent()){
            throw new ResourceNotFoundException(Device.class.getSimpleName() + " with id: " + id);
        }

        Device editedDevice;
        if(editDeviceDTO.getUserId() == null){
            editedDevice = DeviceBuilder.editDeviceDTOToEntity(editDeviceDTO, null, device.get());
        }
        else{
            Optional<User> user = userRepository.findById(editDeviceDTO.getUserId());
            if(!user.isPresent()){
                throw new ResourceNotFoundException(User.class.getSimpleName() + " with id: " + editDeviceDTO.getUserId());
            }
            editedDevice = DeviceBuilder.editDeviceDTOToEntity(editDeviceDTO, user.get(), device.get());
        }

        deviceRepository.save(editedDevice);
        return DeviceBuilder.toEditDeviceDTO(editedDevice);
    }

    public UUID deleteDevice(UUID id) {
        Optional<Device> device = deviceRepository.findById(id);
        if(!device.isPresent()){
            throw new ResourceNotFoundException(Device.class.getSimpleName() + " with id: " + id);
        }
        deviceRepository.deleteById(id);
        return id;
    }
}
