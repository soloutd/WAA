package edu.mum.cs545.repository;

import edu.mum.cs545.model.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    
    @Query("SELECT r FROM Role r WHERE r.roleName not in ('ROLE_ADMIN') ")
    public List<Role> getRoleNotAdmin();
}
