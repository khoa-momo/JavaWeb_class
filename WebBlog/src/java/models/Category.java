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
public class Category {
    private int categoryId;
    private int blogId;
    private String categoryName;
    private String dateCreated;
    private String dateModified;

    public Category() {
    }

    public Category(int categoryId, int blogId, String categoryName, String dateCreated, String dateModified) {
        this.categoryId = categoryId;
        this.blogId = blogId;
        this.categoryName = categoryName;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
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

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    @Override
    public String toString() {
        return "Category{" + "categoryId=" + categoryId + ", blogId=" + blogId + ", categoryName=" + categoryName + ", dateCreated=" + dateCreated + ", dateModified=" + dateModified + '}';
    }
    
    
}
