package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.ReceiveEnergyConsumptionDTO;
import ro.tuc.ds2020.entities.Device;
import ro.tuc.ds2020.entities.EnergyConsumption;

public class EnergyConsumptionBuilder {

    private EnergyConsumptionBuilder(){

    }

    public static EnergyConsumption toEntity(ReceiveEnergyConsumptionDTO receiveEnergyConsumptionDTO, Device device){
        return new EnergyConsumption(receiveEnergyConsumptionDTO.getTimestamp(),
                (int) receiveEnergyConsumptionDTO.getMeasurementValue(), device);
    }

}
