package com.target.dto;

public class RoleDto {

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

	public boolean getIsActiveRole() {
		return isActiveRole;
	}

	public void setIsActiveRole(boolean isActiveRole) {
		this.isActiveRole = isActiveRole;
	}

}
