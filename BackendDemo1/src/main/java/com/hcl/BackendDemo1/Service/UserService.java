package com.hcl.BackendDemo1.Service;

import com.hcl.BackendDemo1.Entity.User;
import com.hcl.BackendDemo1.Exception.ResourceNotFoundException;
import com.hcl.BackendDemo1.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    PasswordEncoder passwordEncoder;
    
    public User createUser(User user){
        return userRepo.save(user);
    }
    
    public User updateUser(Integer userId, User userDetails){
        User user = getUserById(userId);
        user.setName(userDetails.getName());
        user.setPassword(encodePassword(userDetails.getPassword()));
        return userRepo.save(user);
    }

    private User getUserById(Integer userId) {
        return userRepo.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("User not found with id" + userId));
    }

    public String encodePassword(String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }


}
