package javabean;
// default package



/**
 * Fuser entity. @author MyEclipse Persistence Tools
 */

public class Fuser  implements java.io.Serializable {


    // Fields    

     private Integer fuserId;
     private String userName;
     private Integer userId;


    // Constructors

    /** default constructor */
    public Fuser() {
    }

    
    /** full constructor */
    public Fuser(String userName, Integer userId) {
        this.userName = userName;
        this.userId = userId;
    }

   
    // Property accessors

    public Integer getFuserId() {
        return this.fuserId;
    }
    
    public void setFuserId(Integer fuserId) {
        this.fuserId = fuserId;
    }

    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
   








}