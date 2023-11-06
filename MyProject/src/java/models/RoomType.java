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
public class RoomType {
    private int roomTypeId;
    private int roomTypeName; 

    public RoomType(int roomTypeId, int roomTypeName) {
        this.roomTypeId = roomTypeId;
        this.roomTypeName = roomTypeName;
    }

    public int getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(int roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public int getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(int roomTypeName) {
        this.roomTypeName = roomTypeName;
    }
    
    
}
