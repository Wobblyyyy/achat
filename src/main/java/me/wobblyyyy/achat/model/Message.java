package me.wobblyyyy.achat.model;

public class Message {
    private MessageType type;
    private String timestamp;
    private String contents;
    private String senderUsername;
    private String senderId;

    public MessageType getType() {
        return type;
    }

    public Message setType(MessageType type) {
        this.type = type;
        return this;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public Message setTimestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public String getContents() {
        return contents;
    }

    public Message setContents(String contents) {
        this.contents = contents;
        return this;
    }

    public String getSenderUsername() {
        return senderUsername;
    }

    public Message setSenderUsername(String senderUsername) {
        this.senderUsername = senderUsername;
        return this;
    }

    public String getSenderId() {
        return senderId;
    }

    public Message setSenderId(String senderId) {
        this.senderId = senderId;
        return this;
    }

    public enum MessageType {
        USER_JOIN,
        USER_LEAVE,
        USER_MESSAGE,
        SYSTEM_MESSAGE
    }
}
