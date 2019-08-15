package com.ucar.training.entity;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Message {
    private String time;
    private String content;
    private String author;
    private String id;

    public Message(){

    }
    public Message(String content, String author) {
        this.content = content;
        this.author = author;
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        time = sdf.format(date);
        id = UUID.randomUUID().toString();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getId() { return id; }

    public void setId(String id){
        this.id = id;
    }

}
