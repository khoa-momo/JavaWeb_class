/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author DELL
 */
public class Room {
    private int id;
    private String title;
    private String status;
    private String roomType;
    private String square;

    public Room() {
    }

    public Room(int id, String title, String status, String roomType, String square) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.roomType = roomType;
        this.square = square;
    }

    public Room(String roomType) {
        this.roomType = roomType;
    } 
    
    
    public Room(int id, String title, String status, String roomType) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.roomType = roomType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getSquare() {
        return square;
    }

    public void setSquare(String square) {
        this.square = square;
    }
    
    
}
