package com.target.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROLE")
@Access(AccessType.PROPERTY)
public class RoleEntity {

	private int roleID;
	private String roleName;
	private boolean isActiveRole;

	@Id
	@Column(name = "ROLE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	@Column(name = "ROLE_NAME", unique = true, nullable = false)
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Column(name = "IS_ACTIVE", nullable = false)
	public boolean isActiveRole() {
		return isActiveRole;
	}

	public void setActiveRole(boolean isActiveRole) {
		this.isActiveRole = isActiveRole;
	}

}
