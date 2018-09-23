package edu.mum.cs545.service;

import edu.mum.cs545.model.User;

import java.util.List;

public interface UserService {
    
    User getById(Long id);
    
    User save(User user);
    
    List<User> getAll();
    
    User getByEmail(String name);
    
}
