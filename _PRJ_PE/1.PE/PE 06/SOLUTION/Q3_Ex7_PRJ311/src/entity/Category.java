/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Tuan Anh
 */
public class Category {
    private int categoryID;
    private int blogID;
    private String categoryName;
    private String dateCreated;
    private boolean activated;

    public Category() {
    }

    public Category(int categoryID, int blogID, String categoryName, String dateCreated, boolean activated) {
        this.categoryID = categoryID;
        this.blogID = blogID;
        this.categoryName = categoryName;
        this.dateCreated = dateCreated;
        this.activated = activated;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getBlogID() {
        return blogID;
    }

    public void setBlogID(int blogID) {
        this.blogID = blogID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }
    
}
