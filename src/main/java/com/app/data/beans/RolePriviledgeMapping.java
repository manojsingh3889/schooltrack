package com.app.data.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="role_priviledge", 
uniqueConstraints = {@UniqueConstraint(columnNames = {"role_id","priviledge_id"})})
public class RolePriviledgeMapping implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;

	@ManyToOne
	@JoinColumn(name="priviledge_id")
	private Priviledge priviledge;

	public RolePriviledgeMapping(Role role, Priviledge priviledge) {
		this.role = role;
		this.priviledge = priviledge;
	}

	public RolePriviledgeMapping() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Priviledge getPriviledge() {
		return priviledge;
	}

	public void setPriviledge(Priviledge priviledge) {
		this.priviledge = priviledge;
	}

}
