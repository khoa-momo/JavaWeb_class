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
public class Image {
    private int imageId;
    private String imageLink;

    public Image(int imageId, String imageLink) {
        this.imageId = imageId;
        this.imageLink = imageLink;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    @Override
    public String toString() {
        return "Image{" + "imageId=" + imageId + ", imageLink=" + imageLink + '}';
    }
     
    
}
