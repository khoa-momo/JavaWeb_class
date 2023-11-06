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
    private int CommentID;
    private String CommentContent;

    public Comment(int CommentID, String CommentContent) {
        this.CommentID = CommentID;
        this.CommentContent = CommentContent;
    }

    public int getCommentID() {
        return CommentID;
    }

    public void setCommentID(int CommentID) {
        this.CommentID = CommentID;
    }

    public String getCommentContent() {
        return CommentContent;
    }

    public void setCommentContent(String CommentContent) {
        this.CommentContent = CommentContent;
    }

    @Override
    public String toString() {
        return "Comment{" + "CommentID=" + CommentID + ", CommentContent=" + CommentContent + '}';
    }
    
    
}
