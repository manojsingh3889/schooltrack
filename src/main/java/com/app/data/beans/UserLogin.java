package com.app.data.beans;
// default package

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * UserLogin entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="User_login")

public class UserLogin  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private UserInfo userInfo;
     private String email;
     private String passwordhash;
     private String passwordsalt;


    // Constructors

    /** default constructor */
    public UserLogin() {
    }

    
    /** full constructor */
    public UserLogin(String email, String passwordhash, String passwordsalt) {
        this.email = email;
        this.passwordhash = passwordhash;
        this.passwordsalt = passwordsalt;
    }

   
    // Property accessors
    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
	@OneToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="userinfo", nullable=false)
    public UserInfo getUserInfo() {
        return this.userInfo;
    }
    
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
    
    @Column(name="email", unique=true, nullable=false, length=100)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Column(name="passwordhash", nullable=false)
    public String getPasswordhash() {
        return this.passwordhash;
    }
    
    public void setPasswordhash(String passwordhash) {
        this.passwordhash = passwordhash;
    }
    
    @Column(name="passwordsalt", nullable=false)
    public String getPasswordsalt() {
        return this.passwordsalt;
    }
    
    public void setPasswordsalt(String passwordsalt) {
        this.passwordsalt = passwordsalt;
    }


	@Override
	public String toString() {
		return "UserLogin [id=" + id + ", userInfo=" + userInfo + ", email="
				+ email + ", passwordhash=" + passwordhash + ", passwordsalt="
				+ passwordsalt + "]";
	}
}