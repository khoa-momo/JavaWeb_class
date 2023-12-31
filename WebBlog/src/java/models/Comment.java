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
public class Comment {
    private int commentId;
    private int entryId;
    private int authorID;
    private String commentContent;
    private String dateCreated;
    private String dateModified;

    public Comment() {
    }

    public Comment(int commentId, int entryId, int authorID, String commentContent, String dateCreated, String dateModified) {
        this.commentId = commentId;
        this.entryId = entryId;
        this.authorID = authorID;
        this.commentContent = commentContent;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getEntryId() {
        return entryId;
    }

    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
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
    
    
    
}
