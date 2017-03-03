package com.app.data.beans;
// default package

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * UserInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="User_info"
    ,catalog="stdummy"
)

public class UserInfo  implements java.io.Serializable {


    // Fields    

     private Integer userid;
     private String firstname;
     private String lastname;
     private Set<Role> roles = new HashSet<Role>(0);
     private Set<UserLogin> userLogins = new HashSet<UserLogin>(0);


    // Constructors

    /** default constructor */
    public UserInfo() {
    }

	/** minimal constructor */
    public UserInfo(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
    
    /** full constructor */
    public UserInfo(String firstname, String lastname, Set<Role> roles, Set<UserLogin> userLogins) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.roles = roles;
        this.userLogins = userLogins;
    }

   
    // Property accessors
    @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="userid", unique=true, nullable=false)

    public Integer getUserid() {
        return this.userid;
    }
    
    public void setUserid(Integer userid) {
        this.userid = userid;
    }
    
    @Column(name="firstname", nullable=false)

    public String getFirstname() {
        return this.firstname;
    }
    
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    @Column(name="lastname", nullable=false)

    public String getLastname() {
        return this.lastname;
    }
    
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="userInfos")

    public Set<Role> getRoles() {
        return this.roles;
    }
    
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="userInfo")

    public Set<UserLogin> getUserLogins() {
        return this.userLogins;
    }
    
    public void setUserLogins(Set<UserLogin> userLogins) {
        this.userLogins = userLogins;
    }
   








}