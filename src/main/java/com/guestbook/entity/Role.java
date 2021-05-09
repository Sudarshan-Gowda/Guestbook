package com.guestbook.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ROLE")
public class Role implements Serializable {

	// Static Attributes
	//////////////////////
	private static final long serialVersionUID = 1008591488915658609L;

	// Attributes
	//////////////////
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ROLE_ID")
	private Long roleId;

	@Column(name = "ROLE_NAME")
	private String roleName;

	@Column(name = "IS_ACTIVE")
	private Boolean active;

	@ManyToMany(mappedBy = "roles")
	private Set<User> users;

	// Constructors
	//////////////////
	public Role() {
		super();
	}

	/**
	 * @param roleId
	 */
	public Role(Long roleId) {
		super();
		this.roleId = roleId;
	}

	/**
	 * @param roleId
	 * @param roleName
	 * @param active
	 * @param users
	 */
	public Role(Long roleId, String roleName, Boolean active, Set<User> users) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.active = active;
		this.users = users;
	}

	// Properties
	///////////////
	public Long getRoleId() {
		return roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public Boolean getActive() {
		return active;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
