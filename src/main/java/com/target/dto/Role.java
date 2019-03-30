package com.target.dto;

public class Role {

	private int roleID;
	private String roleName;
	private boolean isActiveRole;

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public boolean isActiveRole() {
		return isActiveRole;
	}

	public void setActiveRole(boolean isActiveRole) {
		this.isActiveRole = isActiveRole;
	}

}
