package com.app.data.beans;
// default package

import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;


@Entity
@Table(name="role")

public class Role  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer roleId;

	@Column(name="code", nullable=false, unique=true)
	private String codeName;

	@Column(name="display_name")
	private String displayName;

	@Column(name="description")
	private String description;

	@ElementCollection (fetch=FetchType.EAGER)
	@CollectionTable(name="role_based_worker" , joinColumns=@JoinColumn(name="role_id"))
	@MapKeyColumn(name="task")
	@Column(name="worker")
	private Map<String, String> taskWorkerMap;

	public Role() {
	}

	public Role(String codeName, String displayName, String description) {
		this.codeName = codeName;
		this.displayName = displayName;
		this.description = description;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
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

	public Map<String, String> getTaskWorkerMaps() {
		return taskWorkerMap;
	}

	public void setTaskWorkerMaps(Map<String, String> taskWorkerMap) {
		this.taskWorkerMap = taskWorkerMap;
	}
}