/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author DELL
 */
public class Entry {
    private int EntryID;
    private String Title;
    private String EntryContent;
    private Date DateModified;
    private List<Comment> listCommentss;

    public Entry(int EntryID, String Title, String EntryContent, Date DateModified, List<Comment> listCommentss) {
        this.EntryID = EntryID;
        this.Title = Title;
        this.EntryContent = EntryContent;
        this.DateModified = DateModified;
        this.listCommentss = listCommentss;
    }

    public Entry(int EntryID, String Title) {
        this.EntryID = EntryID;
        this.Title = Title;
    }
    
    

    public int getEntryID() {
        return EntryID;
    }

    public void setEntryID(int EntryID) {
        this.EntryID = EntryID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getEntryContent() {
        return EntryContent;
    }

    public void setEntryContent(String EntryContent) {
        this.EntryContent = EntryContent;
    }

    public Date getDateModified() {
        return DateModified;
    }

    public void setDateModified(Date DateModified) {
        this.DateModified = DateModified;
    }

    public List<Comment> getListCommentss() {
        return listCommentss;
    }

    public void setListCommentss(List<Comment> listCommentss) {
        this.listCommentss = listCommentss;
    }

    @Override
    public String toString() {
        return "Entry{" + "EntryID=" + EntryID + ", Title=" + Title + ", EntryContent=" + EntryContent + ", DateModified=" + DateModified + ", listCommentss=" + listCommentss + '}';
    }
    
    
}
