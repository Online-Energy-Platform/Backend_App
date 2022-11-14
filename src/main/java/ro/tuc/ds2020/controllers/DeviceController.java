package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.DeviceDTO;
import ro.tuc.ds2020.dtos.EditDeviceDTO;
import ro.tuc.ds2020.dtos.InsertDeviceDTO;
import ro.tuc.ds2020.services.DeviceService;

import java.util.List;
import java.util.UUID;


@RestController
@CrossOrigin
@RequestMapping("/device")
public class DeviceController {

    private final DeviceService deviceService;

    @Autowired
    public DeviceController(DeviceService deviceService){
        this.deviceService = deviceService;
    }

    @GetMapping()
    public ResponseEntity<List<DeviceDTO>> getDevices() {
        List<DeviceDTO> deviceDTOList = deviceService.findDevices();
        return new ResponseEntity<>(deviceDTOList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeviceDTO> getDevice(@PathVariable("id") UUID id){
        DeviceDTO deviceDTO = deviceService.getDevice(id);
        return new ResponseEntity<>(deviceDTO, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<UUID> insertDevice(@RequestBody InsertDeviceDTO insertDeviceDTO){
        UUID deviceID = deviceService.insert(insertDeviceDTO);
        return new ResponseEntity<>(deviceID, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EditDeviceDTO> updateDevice(@PathVariable("id") UUID id, @RequestBody EditDeviceDTO editDeviceDTO){
        EditDeviceDTO editedDeviceDTO = deviceService.editDevice(id, editDeviceDTO);
        return new ResponseEntity<>(editedDeviceDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UUID> deleteDevice(@PathVariable("id") UUID id){
        UUID deletedDeviceId = deviceService.deleteDevice(id);
        return new ResponseEntity<>(deletedDeviceId, HttpStatus.OK);
    }
}
