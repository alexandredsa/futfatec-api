package br.com.futfatec.api.domain.auth;

public class ValidationStatus {
	private boolean permission;
	private Role role;

	public boolean isPermission() {
		return permission;
	}

	public void setPermission(boolean permission) {
		this.permission = permission;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
