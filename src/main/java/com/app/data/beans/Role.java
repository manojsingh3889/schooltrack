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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


/**
 * Role entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="role"
    ,catalog="stdummy"
)

public class Role  implements java.io.Serializable {


    // Fields    

     private Integer roleid;
     private String name;
     private Set<UserInfo> userInfos = new HashSet<UserInfo>(0);
     private Set<Priviledge> priviledges = new HashSet<Priviledge>(0);


    // Constructors

    /** default constructor */
    public Role() {
    }

	/** minimal constructor */
    public Role(String name) {
        this.name = name;
    }
    
    /** full constructor */
    public Role(String name, Set<UserInfo> userInfos, Set<Priviledge> priviledges) {
        this.name = name;
        this.userInfos = userInfos;
        this.priviledges = priviledges;
    }

   
    // Property accessors
    @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="roleid", unique=true, nullable=false)

    public Integer getRoleid() {
        return this.roleid;
    }
    
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }
    
    @Column(name="name", nullable=false)

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinTable(name="role_user", catalog="stdummy", joinColumns = { 
        @JoinColumn(name="role", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="user", nullable=false, updatable=false) })

    public Set<UserInfo> getUserInfos() {
        return this.userInfos;
    }
    
    public void setUserInfos(Set<UserInfo> userInfos) {
        this.userInfos = userInfos;
    }
@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinTable(name="priviledge_role", catalog="stdummy", joinColumns = { 
        @JoinColumn(name="role", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="priviledge", nullable=false, updatable=false) })

    public Set<Priviledge> getPriviledges() {
        return this.priviledges;
    }
    
    public void setPriviledges(Set<Priviledge> priviledges) {
        this.priviledges = priviledges;
    }
   








}