package com.app.data.beans;


import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="priviledge")
public class Priviledge  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Integer priviledgeId;

	@Column(name="code", nullable=false, unique=true)
	private String codeName;
	
	@Column(name="display_name")
	private String displayName;
	
	@Column(name="description")
	private String description;

	public Priviledge(String codeName, String displayName, String description) {
		super();
		this.codeName = codeName;
		this.displayName = displayName;
		this.description = description;
	}

	public Priviledge() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getPriviledgeId() {
		return priviledgeId;
	}

	public void setPriviledgeId(Integer priviledgeId) {
		this.priviledgeId = priviledgeId;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}