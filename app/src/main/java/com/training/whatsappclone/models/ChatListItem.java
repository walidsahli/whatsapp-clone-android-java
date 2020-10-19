package com.training.whatsappclone.models;

import java.util.Date;

public class ChatListItem {
    private String id;
    private String [] persons;
    private String lastMessageTime;
    private String lastMessage;

    public ChatListItem(String id, String[] persons, String lastMessageTime, String lastMessage) {
        this.id = id;
        this.persons = persons;
        this.lastMessageTime = lastMessageTime;
        this.lastMessage = lastMessage;
    }
    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[] getPersons() {
        return persons;
    }

    public void setPersons(String[] persons) {
        this.persons = persons;
    }

    public String getLastMessageTime() {
        return lastMessageTime;
    }

    public void setLastMessageTime(String lastMessageTime) {
        this.lastMessageTime = lastMessageTime;
    }
}
