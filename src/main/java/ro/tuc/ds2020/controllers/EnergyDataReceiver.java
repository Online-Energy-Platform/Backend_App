package ro.tuc.ds2020.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import ro.tuc.ds2020.dtos.NotificationDTO;
import ro.tuc.ds2020.dtos.ReceiveEnergyConsumptionDTO;
import ro.tuc.ds2020.services.DeviceService;
import ro.tuc.ds2020.services.EnergyConsumptionService;

@Component
public class EnergyDataReceiver {

    // atribut in care pastram tuplele primite din coada, si facem suma valorilor primite pe ore/minute:
    private ReceiveEnergyConsumptionDTO receivedEnergyValue;

    // pentru apelarea insert-ului valorilor in baza de date:
    private final EnergyConsumptionService energyConsumptionService;

    // pentru preluarea valorii de maxim a device-ului din baza de date:
    private final DeviceService deviceService;

    // pentru transmitere mesaje prin websocket:
    private final SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    public EnergyDataReceiver(EnergyConsumptionService energyConsumptionService,
                              SimpMessagingTemplate simpMessagingTemplate,
                              DeviceService deviceService) {
        this.energyConsumptionService = energyConsumptionService;
        this.simpMessagingTemplate = simpMessagingTemplate;
        this.deviceService = deviceService;
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule()); // pentru a putea converti localdatetime in json;
        return new Jackson2JsonMessageConverter(objectMapper);
    }

    // VARIANTA CARE MERGE DIN 10 IN 10 MINUTE SI CALCULEAZA SUMA PE ORE:
    /*
    @RabbitListener(queues = "${spring.rabbitmq.template.default-receive-queue}")
    public void listen(ReceiveEnergyConsumptionDTO receiveEnergyConsumptionDTO){
        // printare tupla primita din coada:
        System.err.println(receiveEnergyConsumptionDTO.toString());

        // daca este prima valoare scoasa din coada, initializam atributul clasei cu ce am primit:
        if(receivedEnergyValue == null){
            receivedEnergyValue = receiveEnergyConsumptionDTO;
        }
        else{
            //altfel, ne declaram o variabila in care punem suma valorilor masurate pana in acest moment:
            double receivedValue = receivedEnergyValue.getMeasurementValue();
            boolean equalDevices = receivedEnergyValue.getDeviceId().toString()
                    .equals(receiveEnergyConsumptionDTO.getDeviceId().toString());
            boolean equalHours = receivedEnergyValue.getTimestamp().getHour()
                    == receiveEnergyConsumptionDTO.getTimestamp().getHour();
            boolean equalDate = receivedEnergyValue.getTimestamp().getDayOfMonth()
                    == receiveEnergyConsumptionDTO.getTimestamp().getDayOfMonth()
                    && receivedEnergyValue.getTimestamp().getMonth()
                    == receiveEnergyConsumptionDTO.getTimestamp().getMonth()
                    && receivedEnergyValue.getTimestamp().getYear()
                    == receiveEnergyConsumptionDTO.getTimestamp().getYear();
            // daca tupla primita este pentru acelasi device ca tupla anterioara, procesam valoare primita:
            if(equalDevices){
                // daca ora pentru care e transmisa valoarea curenta este egala cu cea anterioara
                if(equalDate && equalHours){
                    // aduna valoarea curenta la cea anterioara:
                    receivedValue += receiveEnergyConsumptionDTO.getMeasurementValue();
                }
                else{
                    // apeleaza metoda din service de adaugare in db:
                    energyConsumptionService.insert(receivedEnergyValue);

                    int maxValue = deviceService.getDevice(receivedEnergyValue.getDeviceId()).getMaxHEnergyConsumption();
                    if(receivedEnergyValue.getMeasurementValue() > maxValue){
                        NotificationDTO notificationDTO = new NotificationDTO(receivedEnergyValue.getTimestamp(),
                                receivedEnergyValue.getMeasurementValue(), maxValue, receivedEnergyValue.getDeviceId().toString());
                        simpMessagingTemplate.convertAndSend("/energyConsumptionSimulation/message", notificationDTO);
                    }
                    System.err.println("Valoare pentru device-ul " + receivedEnergyValue.getDeviceId() + " la ora "
                            + receivedEnergyValue.getTimestamp().getHour() + "este "
                            + receivedEnergyValue.getMeasurementValue());
                    // reinitializeaza valoarea dto-ului din clasa:
                    receivedValue = receiveEnergyConsumptionDTO.getMeasurementValue();
                }
                //setare valori finale:
                receivedEnergyValue.setMeasurementValue(receivedValue);
                receivedEnergyValue.setTimestamp(receiveEnergyConsumptionDTO.getTimestamp());
            }
        }
    }*/

    // VARIANTA CARE MERGE DIN 10 IN 10 SECUNDE SI CALCULEAZA SUMA PE MINUT (PENTRU TESTARE):
    @RabbitListener(queues = "${spring.rabbitmq.template.default-receive-queue}")
    public void listen(ReceiveEnergyConsumptionDTO receiveEnergyConsumptionDTO){
        System.err.println(receiveEnergyConsumptionDTO.toString());

        if(receivedEnergyValue == null){
            receivedEnergyValue = receiveEnergyConsumptionDTO;
        }
        else{
            double receivedValue = receivedEnergyValue.getMeasurementValue();

            boolean equalDevices = receivedEnergyValue.getDeviceId().toString()
                    .equals(receiveEnergyConsumptionDTO.getDeviceId().toString());
            boolean equalHours = receivedEnergyValue.getTimestamp().getHour()
                    == receiveEnergyConsumptionDTO.getTimestamp().getHour();
            boolean equalMinutes = receivedEnergyValue.getTimestamp().getMinute()
                    == receiveEnergyConsumptionDTO.getTimestamp().getMinute();
            boolean equalDate = receivedEnergyValue.getTimestamp().getDayOfMonth()
                    == receiveEnergyConsumptionDTO.getTimestamp().getDayOfMonth()
                    && receivedEnergyValue.getTimestamp().getMonth()
                    == receiveEnergyConsumptionDTO.getTimestamp().getMonth()
                    && receivedEnergyValue.getTimestamp().getYear()
                    == receiveEnergyConsumptionDTO.getTimestamp().getYear();
            System.err.println("Date: " + equalDate + "; Hour: " + equalHours + "; Minutes: " + equalMinutes);
            if(equalDevices){
                if(equalDate && equalHours && equalMinutes){
                    receivedValue += receiveEnergyConsumptionDTO.getMeasurementValue();
                }
                else{
                    energyConsumptionService.insert(receivedEnergyValue);

                    int maxValue = deviceService.getDevice(receivedEnergyValue.getDeviceId()).getMaxHEnergyConsumption();
                    if(receivedEnergyValue.getMeasurementValue() > maxValue){
                        NotificationDTO notificationDTO = new NotificationDTO(receivedEnergyValue.getTimestamp(),
                                receivedEnergyValue.getMeasurementValue(), maxValue, receivedEnergyValue.getDeviceId().toString());
                        simpMessagingTemplate.convertAndSend("/energyConsumptionSimulation/message", notificationDTO);
                    }
                    System.err.println("Valoare pentru device-ul " + receivedEnergyValue.getDeviceId() + " la minutul "
                            + receivedEnergyValue.getTimestamp().getMinute() + " este "
                            + receivedEnergyValue.getMeasurementValue());

                    receivedValue = receiveEnergyConsumptionDTO.getMeasurementValue();
                }
                receivedEnergyValue.setMeasurementValue(receivedValue);
                receivedEnergyValue.setTimestamp(receiveEnergyConsumptionDTO.getTimestamp());
            }
        }
    }

}
