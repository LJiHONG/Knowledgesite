package javabean;
// default package

import java.util.Date;


/**
 * Article entity. @author MyEclipse Persistence Tools
 */

public class Article  implements java.io.Serializable {


    // Fields    

     private Integer artId;
     private String artTitle;
     private String artContent;
     private String userName;
     private Date artTime;


    // Constructors

    /** default constructor */
    public Article() {
    }

    
    /** full constructor */
    public Article(String artTitle, String artContent, String userName, Date artTime) {
        this.artTitle = artTitle;
        this.artContent = artContent;
        this.userName = userName;
        this.artTime = artTime;
    }

   
    // Property accessors

    public Integer getArtId() {
        return this.artId;
    }
    
    public void setArtId(Integer artId) {
        this.artId = artId;
    }

    public String getArtTitle() {
        return this.artTitle;
    }
    
    public void setArtTitle(String artTitle) {
        this.artTitle = artTitle;
    }

    public String getArtContent() {
        return this.artContent;
    }
    
    public void setArtContent(String artContent) {
        this.artContent = artContent;
    }

    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getArtTime() {
        return this.artTime;
    }
    
    public void setArtTime(Date artTime) {
        this.artTime = artTime;
    }
   








}