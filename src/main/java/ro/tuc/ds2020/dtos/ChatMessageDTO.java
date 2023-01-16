package ro.tuc.ds2020.dtos;

public class ChatMessageDTO {

    private String senderID;
    private String senderFullName;
    private String receiverID;
    private String messageBody;

    public ChatMessageDTO(){

    }

    public ChatMessageDTO(String senderID, String senderFullName, String receiverID, String messageBody) {
        this.senderID = senderID;
        this.senderFullName = senderFullName;
        this.receiverID = receiverID;
        this.messageBody = messageBody;
    }

    public String getSenderID() {
        return senderID;
    }

    public void setSenderID(String senderID) {
        this.senderID = senderID;
    }

    public String getSenderFullName() {
        return senderFullName;
    }

    public void setSenderFullName(String senderFullName) {
        this.senderFullName = senderFullName;
    }

    public String getReceiverID() {
        return receiverID;
    }

    public void setReceiverID(String receiverID) {
        this.receiverID = receiverID;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }
}
