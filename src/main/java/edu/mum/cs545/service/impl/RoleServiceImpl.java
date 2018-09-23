package edu.mum.cs545.service.impl;

import edu.mum.cs545.model.Role;
import edu.mum.cs545.repository.RoleRepository;
import edu.mum.cs545.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
    RoleRepository rolerepository;

	@Override
	public List<Role> getAllRole() {
		
		return (List<Role>)rolerepository.findAll();
	}

	@Override
	public Role getRoleById(long id) {
		return rolerepository.findOne(id);
	}

	@Override
	public Role saveOrder(Role role) {
		return rolerepository.save(role);
	}
	
	@Override
	public List<Role> getRoleNotAdmin(){
	    return rolerepository.getRoleNotAdmin();
	}
	
}
