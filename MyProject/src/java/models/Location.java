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
public class Location {
    private int locationId;
    private String provinceName;
    private String districtName;
    private String streetName;

    public Location(int locationId, String provinceName, String districtName, String streetName) {
        this.locationId = locationId;
        this.provinceName = provinceName;
        this.districtName = districtName;
        this.streetName = streetName;
    }

    public Location(String provinceName) {
        this.provinceName = provinceName;
    }
      
    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    @Override
    public String toString() {
        return "Location{" + "locationId=" + locationId + ", provinceName=" + provinceName + ", districtName=" + districtName + ", streetName=" + streetName + '}';
    }
     
}  