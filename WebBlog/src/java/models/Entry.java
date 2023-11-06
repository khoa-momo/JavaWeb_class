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
public class Entry {
    private int entryId;
    private int blogId;
    private int categoryId;
    private String title;
    private String entryContent;
    private String dateCreated;
    private String dateModified;

    public Entry() {
    } 
    
    public Entry(int entryId, int blogId, int categoryId, String title, String entryContent, String dateCreated, String dateModified) {
        this.entryId = entryId;
        this.blogId = blogId;
        this.categoryId = categoryId;
        this.title = title;
        this.entryContent = entryContent;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
    }

    public int getEntryId() {
        return entryId;
    }

    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEntryContent() {
        return entryContent;
    }

    public void setEntryContent(String entryContent) {
        this.entryContent = entryContent;
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
        return "Entry{" + "entryId=" + entryId + ", blogId=" + blogId + ", categoryId=" + categoryId + ", title=" + title + ", entryContent=" + entryContent + ", dateCreated=" + dateCreated + ", dateModified=" + dateModified + '}';
    }

    
}
