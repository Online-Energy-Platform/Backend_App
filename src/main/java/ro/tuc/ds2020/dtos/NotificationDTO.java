package ro.tuc.ds2020.dtos;

import java.time.LocalDateTime;

public class NotificationDTO {

    private String messageBody;
    private String deviceId;

    public NotificationDTO(){

    }

    public NotificationDTO(LocalDateTime timestamp, double measurements, int maxValue, String deviceId){
        this.messageBody = "Notificare: in data de " + timestamp.getDayOfMonth() + "-" + timestamp.getMonth() +
                "-" + timestamp.getYear() +", pe parcursul orei " + timestamp.getHour() + ":00, consumul de energie" +
                " pentru device-ul cu id: " + deviceId + " a depasit limita maxima de " + maxValue +
                ", avand valoarea de " + measurements;
        this.deviceId = deviceId;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
