/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author DELL
 */
public class Room {
    private int roomId;
    private String title;
    private String description;
    private int area;
    private int cost;
    private int status;
    private LocalDate dateCreated;
    private String note;
    private String locationId;
    private String roomTypeId;
    private String accountId; 
    private String firstImage;
    private List<Image> listImages; 

    public Room(int roomId, String title, String description, int area, int cost, int status, LocalDate dateCreated, String note, String locationId, String roomTypeId, String accountId, String firstImage) {
        this.roomId = roomId;
        this.title = title;
        this.description = description;
        this.area = area;
        this.cost = cost;
        this.status = status;
        this.dateCreated = dateCreated;
        this.note = note;
        this.locationId = locationId;
        this.roomTypeId = roomTypeId;
        this.accountId = accountId;
        this.firstImage = firstImage;
    }
    
    
        
    public Room(int roomId, String title, String description, int area, int cost, int status, LocalDate dateCreated, String note, String locationId, String roomTypeId, String accountId) {
        this.roomId = roomId;
        this.title = title;
        this.description = description;
        this.area = area;
        this.cost = cost;
        this.status = status;
        this.dateCreated = dateCreated;
        this.note = note;
        this.locationId = locationId;
        this.roomTypeId = roomTypeId;
        this.accountId = accountId;
    }

    public Room(int roomId, String title, String description, int area, int cost, int status, LocalDate dateCreated, String note, String locationId, String roomTypeId, String accountId, List<Image> listImages) {
        this.roomId = roomId;
        this.title = title;
        this.description = description;
        this.area = area;
        this.cost = cost;
        this.status = status;
        this.dateCreated = dateCreated;
        this.note = note;
        this.locationId = locationId;
        this.roomTypeId = roomTypeId;
        this.accountId = accountId;
        this.listImages = listImages;
    }
    
    
    

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public List<Image> getListImages() {
        return listImages;
    }

    public void setListImages(List<Image> listImages) {
        this.listImages = listImages;
    }

    public String getFirstImage() {
        return firstImage;
    }

    public void setFirstImage(String firstImage) {
        this.firstImage = firstImage;
    }

    @Override
    public String toString() {
        return "Room{" + "roomId=" + roomId + ", title=" + title + ", description=" + description + ", area=" + area + ", cost=" + cost + ", status=" + status + ", dateCreated=" + dateCreated + ", note=" + note + ", locationId=" + locationId + ", roomTypeId=" + roomTypeId + ", accountId=" + accountId + ", firstImage=" + firstImage + ", listImages=" + listImages + '}';
    }
 
    
    
    
    
    
    
    
}