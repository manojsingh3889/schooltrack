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
import javax.persistence.Table;


/**
 * Priviledge entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="priviledge"
    ,catalog="stdummy"
)

public class Priviledge  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Set<Role> roles = new HashSet<Role>(0);


    // Constructors

    /** default constructor */
    public Priviledge() {
    }

    
    /** full constructor */
    public Priviledge(Set<Role> roles) {
        this.roles = roles;
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
@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="priviledges")

    public Set<Role> getRoles() {
        return this.roles;
    }
    
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
   








}