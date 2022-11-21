package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.InsertEnergyConsumptionDTO;
import ro.tuc.ds2020.dtos.ViewEnergyConsumptionDTO;
import ro.tuc.ds2020.services.EnergyConsumptionService;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/energy")
public class EnergyConsumptionController {

    private final EnergyConsumptionService energyConsumptionService;

    @Autowired
    public EnergyConsumptionController(EnergyConsumptionService energyConsumptionService){
        this.energyConsumptionService = energyConsumptionService;
    }

    @GetMapping("/{deviceId}")
    public ResponseEntity<List<ViewEnergyConsumptionDTO>> getDeviceEnergyConsumptionForDate(@PathVariable("deviceId") UUID deviceId){
        System.err.println("S-a pornit request-ul!");
        List<ViewEnergyConsumptionDTO> viewEnergyConsumptionDTOList = energyConsumptionService.getConsumptionsByDeviceAndDate(deviceId);
        return new ResponseEntity<>(viewEnergyConsumptionDTOList, HttpStatus.OK);
    }

//    @PostMapping()
//    public ResponseEntity<UUID> insertTuple(@RequestBody InsertEnergyConsumptionDTO insertEnergyConsumptionDTO){
//        UUID tupleID = energyConsumptionService.insert(insertEnergyConsumptionDTO);
//        return new ResponseEntity<>(tupleID, HttpStatus.CREATED);
//    }

}
