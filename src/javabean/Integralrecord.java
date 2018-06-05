package javabean;
// default package

import java.util.Date;


/**
 * Integralrecord entity. @author MyEclipse Persistence Tools
 */

public class Integralrecord  implements java.io.Serializable {


    // Fields    

     private Integer igdId;
     private String userName;
     private Integer iglNum;
     private String iglRse;
     private Date getTime;


    // Constructors

    /** default constructor */
    public Integralrecord() {
    }

	/** minimal constructor */
    public Integralrecord(String userName, Integer iglNum) {
        this.userName = userName;
        this.iglNum = iglNum;
    }
    
    /** full constructor */
    public Integralrecord(String userName, Integer iglNum, String iglRse, Date getTime) {
        this.userName = userName;
        this.iglNum = iglNum;
        this.iglRse = iglRse;
        this.getTime = getTime;
    }

   
    // Property accessors

    public Integer getIgdId() {
        return this.igdId;
    }
    
    public void setIgdId(Integer igdId) {
        this.igdId = igdId;
    }

    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getIglNum() {
        return this.iglNum;
    }
    
    public void setIglNum(Integer iglNum) {
        this.iglNum = iglNum;
    }

    public String getIglRse() {
        return this.iglRse;
    }
    
    public void setIglRse(String iglRse) {
        this.iglRse = iglRse;
    }

    public Date getGetTime() {
        return this.getTime;
    }
    
    public void setGetTime(Date getTime) {
        this.getTime = getTime;
    }
   








}