package javabean;
// default package

import java.util.Date;


/**
 * Askquestions entity. @author MyEclipse Persistence Tools
 */

public class Askquestions  implements java.io.Serializable {


    // Fields    

     private Integer aqnId;
     private String userName;
     private String aqnContent;
     private Date aqnTime;
     private Integer aqnIgl;


    // Constructors

    /** default constructor */
    public Askquestions() {
    }

    
    /** full constructor */
    public Askquestions(String userName, String aqnContent, Date aqnTime, Integer aqnIgl) {
        this.userName = userName;
        this.aqnContent = aqnContent;
        this.aqnTime = aqnTime;
        this.aqnIgl = aqnIgl;
    }

   
    // Property accessors

    public Integer getAqnId() {
        return this.aqnId;
    }
    
    public void setAqnId(Integer aqnId) {
        this.aqnId = aqnId;
    }

    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAqnContent() {
        return this.aqnContent;
    }
    
    public void setAqnContent(String aqnContent) {
        this.aqnContent = aqnContent;
    }

    public Date getAqnTime() {
        return this.aqnTime;
    }
    
    public void setAqnTime(Date aqnTime) {
        this.aqnTime = aqnTime;
    }

    public Integer getAqnIgl() {
        return this.aqnIgl;
    }
    
    public void setAqnIgl(Integer aqnIgl) {
        this.aqnIgl = aqnIgl;
    }
   








}