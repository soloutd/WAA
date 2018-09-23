package edu.mum.cs545.service.impl;

import edu.mum.cs545.model.User;
import edu.mum.cs545.repository.UserRepository;
import edu.mum.cs545.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    
    @Override
    public User getById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User save(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getByEmail(String name) {
        return userRepository.getByEmail(name);
    }

}
