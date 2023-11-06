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
public class Blog {
    private int blogId;
    private String blogName;
    private String blogDes;
    private String createdDate;

    public Blog(int blogId, String blogName, String blogDes, String createdDate) {
        this.blogId = blogId;
        this.blogName = blogName;
        this.blogDes = blogDes;
        this.createdDate = createdDate;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getBlogDes() {
        return blogDes;
    }

    public void setBlogDes(String blogDes) {
        this.blogDes = blogDes;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "BlogDAO{" + "blogId=" + blogId + ", blogName=" + blogName + ", blogDes=" + blogDes + ", createdDate=" + createdDate + '}';
    }
    
}
