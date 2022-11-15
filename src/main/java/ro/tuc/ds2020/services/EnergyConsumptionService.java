package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.dtos.ViewEnergyConsumptionDTO;
import ro.tuc.ds2020.entities.EnergyConsumption;
import ro.tuc.ds2020.repositories.EnergyConsumptionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EnergyConsumptionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private final EnergyConsumptionRepository energyConsumptionRepository;

    @Autowired
    public EnergyConsumptionService(EnergyConsumptionRepository energyConsumptionRepository){
        this.energyConsumptionRepository = energyConsumptionRepository;
    }


    public List<ViewEnergyConsumptionDTO> getConsumptionsByDeviceAndDate(UUID deviceId) {
        List<EnergyConsumption> energyConsumptionList = energyConsumptionRepository.getEnergyConsumptionByDeviceId(deviceId);
        List<ViewEnergyConsumptionDTO> viewEnergyConsumptionDTOList = new ArrayList<>();
        for (EnergyConsumption energyConsumption: energyConsumptionList){
            viewEnergyConsumptionDTOList.add(new ViewEnergyConsumptionDTO(energyConsumption.getTimestamp(), energyConsumption.getEnergyValue()));
        }
        return viewEnergyConsumptionDTOList;
    }
}
