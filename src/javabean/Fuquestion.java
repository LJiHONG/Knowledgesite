package javabean;
// default package



/**
 * Fuquestion entity. @author MyEclipse Persistence Tools
 */

public class Fuquestion  implements java.io.Serializable {


    // Fields    

     private Integer fqutId;
     private String userName;
     private Integer aqnId;


    // Constructors

    /** default constructor */
    public Fuquestion() {
    }

    
    /** full constructor */
    public Fuquestion(String userName, Integer aqnId) {
        this.userName = userName;
        this.aqnId = aqnId;
    }

   
    // Property accessors

    public Integer getFqutId() {
        return this.fqutId;
    }
    
    public void setFqutId(Integer fqutId) {
        this.fqutId = fqutId;
    }

    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAqnId() {
        return this.aqnId;
    }
    
    public void setAqnId(Integer aqnId) {
        this.aqnId = aqnId;
    }
   








}