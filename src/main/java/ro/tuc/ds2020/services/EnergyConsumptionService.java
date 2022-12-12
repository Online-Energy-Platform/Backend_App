package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.dtos.ReceiveEnergyConsumptionDTO;
import ro.tuc.ds2020.dtos.ViewEnergyConsumptionDTO;
import ro.tuc.ds2020.dtos.builders.EnergyConsumptionBuilder;
import ro.tuc.ds2020.entities.Device;
import ro.tuc.ds2020.entities.EnergyConsumption;
import ro.tuc.ds2020.repositories.DeviceRepository;
import ro.tuc.ds2020.repositories.EnergyConsumptionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EnergyConsumptionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private final EnergyConsumptionRepository energyConsumptionRepository;
    private final DeviceRepository deviceRepository;

    @Autowired
    public EnergyConsumptionService(EnergyConsumptionRepository energyConsumptionRepository, DeviceRepository deviceRepository){
        this.energyConsumptionRepository = energyConsumptionRepository;
        this.deviceRepository = deviceRepository;
    }

    public List<ViewEnergyConsumptionDTO> getConsumptionsByDeviceAndDate(UUID deviceId) {
        List<EnergyConsumption> energyConsumptionList = energyConsumptionRepository.getEnergyConsumptionByDeviceId(deviceId);
        List<ViewEnergyConsumptionDTO> viewEnergyConsumptionDTOList = new ArrayList<>();
        for (EnergyConsumption energyConsumption: energyConsumptionList){
            viewEnergyConsumptionDTOList.add(new ViewEnergyConsumptionDTO(energyConsumption.getTimestamp(), energyConsumption.getEnergyValue()));
        }
        return viewEnergyConsumptionDTOList;
    }

    public UUID insert(ReceiveEnergyConsumptionDTO receiveEnergyConsumptionDTO) {
        // search for device:
        Optional<Device> device = deviceRepository.findById(receiveEnergyConsumptionDTO.getDeviceId());
        System.err.println("S-a gasit device-ul: " + device.isPresent());
        EnergyConsumption energyConsumption;
        if(device.isPresent()){
            energyConsumption = EnergyConsumptionBuilder.toEntity(receiveEnergyConsumptionDTO, device.get());
        }
        else{
            throw new ResourceNotFoundException(Device.class.getSimpleName()
                    + " with id: " + receiveEnergyConsumptionDTO.getDeviceId());
        }
        energyConsumptionRepository.save(energyConsumption);
        return energyConsumption.getId();
    }
}
