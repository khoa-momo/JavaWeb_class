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
public class Message {
    private int messageid;
    private String messagetitle;
    private String messagetime;
    private String from;
    private String to;
    private String messagecontent;
    private int isread; 
  
    public Message(int messageid, String messagetitle, String messagetime, String from, String to, String messagecontent, int isread) {
        this.messageid = messageid;
        this.messagetitle = messagetitle;
        this.messagetime = messagetime;
        this.from = from;
        this.to = to;
        this.messagecontent = messagecontent;
        this.isread = isread;
    } 
    
    public int getMessageid() {
        return messageid;
    }

    public void setMessageid(int messageid) {
        this.messageid = messageid;
    }

    public String getMessagetitle() {
        return messagetitle;
    }

    public void setMessagetitle(String messagetitle) {
        this.messagetitle = messagetitle;
    }

    public String getMessagetime() {
        return messagetime;
    }

    public void setMessagetime(String messagetime) {
        this.messagetime = messagetime;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessagecontent() {
        return messagecontent;
    }

    public void setMessagecontent(String messagecontent) {
        this.messagecontent = messagecontent;
    }

    public int getIsread() {
        return isread;
    }

    public void setIsread(int isread) {
        this.isread = isread;
    }
    
    
}
