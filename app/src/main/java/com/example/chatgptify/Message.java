package com.example.chatgptify;

public class Message {
    public static String SENT_BY_ME = "ME";
    public static String SENT_BY_BOT = "BOT";

    String message;
    String sender;

    public Message(String message, String sender) {
        this.message = message;
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
