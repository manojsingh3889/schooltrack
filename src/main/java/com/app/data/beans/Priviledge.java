package com.app.data.beans;


import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
@Table(name="role")
public class Priviledge  implements java.io.Serializable {

	@Id 
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="priviledge_id", unique=true, nullable=false)
	private Integer priviledgeId;

	public Priviledge() {
	}

	public Integer getPriviledgeId() {
		return priviledgeId;
	}

	public void setPriviledgeId(Integer priviledgeId) {
		this.priviledgeId = priviledgeId;
	}
}