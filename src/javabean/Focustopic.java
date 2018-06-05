package javabean;
// default package



/**
 * Focustopic entity. @author MyEclipse Persistence Tools
 */

public class Focustopic  implements java.io.Serializable {


    // Fields    

     private Integer ftpId;
     private String userName;
     private Integer tpcId;


    // Constructors

    /** default constructor */
    public Focustopic() {
    }

    
    /** full constructor */
    public Focustopic(String userName, Integer tpcId) {
        this.userName = userName;
        this.tpcId = tpcId;
    }

   
    // Property accessors

    public Integer getFtpId() {
        return this.ftpId;
    }
    
    public void setFtpId(Integer ftpId) {
        this.ftpId = ftpId;
    }

    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getTpcId() {
        return this.tpcId;
    }
    
    public void setTpcId(Integer tpcId) {
        this.tpcId = tpcId;
    }
   








}