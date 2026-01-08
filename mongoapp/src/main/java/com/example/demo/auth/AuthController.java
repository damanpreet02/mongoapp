package com.example.demo.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AppUserRepository repo;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @PostMapping("/register")
    public String register(@RequestBody AppUser user){
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
        return "Registered successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody AppUser user){
        AppUser u = repo.findByUsername(user.getUsername());
        if(u != null && encoder.matches(user.getPassword(), u.getPassword())){
            return "Login successful";
        }
        return "Invalid credentials";
    }
}