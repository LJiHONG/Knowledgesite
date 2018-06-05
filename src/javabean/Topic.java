package javabean;
// default package

import java.util.Date;


/**
 * Topic entity. @author MyEclipse Persistence Tools
 */

public class Topic  implements java.io.Serializable {


    // Fields    

     private Integer tpcId;
     private String userName;
     private String tpcContent;
     private Date tpcTime;


    // Constructors

    /** default constructor */
    public Topic() {
    }

    
    /** full constructor */
    public Topic(String userName, String tpcContent, Date tpcTime) {
        this.userName = userName;
        this.tpcContent = tpcContent;
        this.tpcTime = tpcTime;
    }

   
    // Property accessors

    public Integer getTpcId() {
        return this.tpcId;
    }
    
    public void setTpcId(Integer tpcId) {
        this.tpcId = tpcId;
    }

    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTpcContent() {
        return this.tpcContent;
    }
    
    public void setTpcContent(String tpcContent) {
        this.tpcContent = tpcContent;
    }

    public Date getTpcTime() {
        return this.tpcTime;
    }
    
    public void setTpcTime(Date tpcTime) {
        this.tpcTime = tpcTime;
    }
   








}