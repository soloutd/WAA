package edu.mum.cs545.service;

import edu.mum.cs545.model.Role;

import java.util.List;

public interface RoleService {
	public List<Role> getAllRole();
	public Role getRoleById(long id);
	public Role saveOrder(Role role);
	public List<Role> getRoleNotAdmin();
}
