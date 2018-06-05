package javabean;
// default package

import java.util.Date;


/**
 * Topicdiscuss entity. @author MyEclipse Persistence Tools
 */

public class Topicdiscuss  implements java.io.Serializable {


    // Fields    

     private Integer tpdId;
     private Integer tpcId;
     private String userName;
     private String tpdContent;
     private Date tpdTime;


    // Constructors

    /** default constructor */
    public Topicdiscuss() {
    }

    
    /** full constructor */
    public Topicdiscuss(Integer tpcId, String userName, String tpdContent, Date tpdTime) {
        this.tpcId = tpcId;
        this.userName = userName;
        this.tpdContent = tpdContent;
        this.tpdTime = tpdTime;
    }

   
    // Property accessors

    public Integer getTpdId() {
        return this.tpdId;
    }
    
    public void setTpdId(Integer tpdId) {
        this.tpdId = tpdId;
    }

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

    public String getTpdContent() {
        return this.tpdContent;
    }
    
    public void setTpdContent(String tpdContent) {
        this.tpdContent = tpdContent;
    }

    public Date getTpdTime() {
        return this.tpdTime;
    }
    
    public void setTpdTime(Date tpdTime) {
        this.tpdTime = tpdTime;
    }
   








}