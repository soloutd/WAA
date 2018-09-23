package edu.mum.cs545.repository;

import edu.mum.cs545.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    
    @Query("Select u from User u where u.email=:email")
    public User getByEmail(@Param("email") String email);

}
