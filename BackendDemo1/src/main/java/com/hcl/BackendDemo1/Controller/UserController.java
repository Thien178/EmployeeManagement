package com.hcl.BackendDemo1.Controller;

import com.hcl.BackendDemo1.Entity.User;
import com.hcl.BackendDemo1.Repo.UserRepo;
import com.hcl.BackendDemo1.Service.EmployeeService;
import com.hcl.BackendDemo1.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping(path = "/login")
    public User loginUser(@RequestBody User user){
        User existingUser = userRepo.findByName(user.getName());
        if(existingUser != null){
            if (passwordEncoder.matches(user.getPassword(),existingUser.getPassword())){
                return existingUser;
            }
        }
        return null;
    }
}
