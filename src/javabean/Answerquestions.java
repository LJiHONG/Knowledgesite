package javabean;
// default package

import java.util.Date;


/**
 * Answerquestions entity. @author MyEclipse Persistence Tools
 */

public class Answerquestions  implements java.io.Serializable {


    // Fields    

     private Integer asqnId;
     private Integer aqnId;
     private String userName;
     private Date asqnTime;
     private String asqnContent;


    // Constructors

    /** default constructor */
    public Answerquestions() {
    }

	/** minimal constructor */
    public Answerquestions(Integer aqnId, String userName, Date asqnTime) {
        this.aqnId = aqnId;
        this.userName = userName;
        this.asqnTime = asqnTime;
    }
    
    /** full constructor */
    public Answerquestions(Integer aqnId, String userName, Date asqnTime, String asqnContent) {
        this.aqnId = aqnId;
        this.userName = userName;
        this.asqnTime = asqnTime;
        this.asqnContent = asqnContent;
    }

   
    // Property accessors

    public Integer getAsqnId() {
        return this.asqnId;
    }
    
    public void setAsqnId(Integer asqnId) {
        this.asqnId = asqnId;
    }

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

    public Date getAsqnTime() {
        return this.asqnTime;
    }
    
    public void setAsqnTime(Date asqnTime) {
        this.asqnTime = asqnTime;
    }

    public String getAsqnContent() {
        return this.asqnContent;
    }
    
    public void setAsqnContent(String asqnContent) {
        this.asqnContent = asqnContent;
    }
   








}