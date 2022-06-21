package com.cognizant.authorization.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.authorization.models.Role;
import com.cognizant.authorization.models.User;
import com.cognizant.authorization.models.UserRole;
import com.cognizant.authorization.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@CrossOrigin("*")
public class UserController {
    private UserService userService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @PostMapping("/")
    public ResponseEntity<?> createUser(@RequestBody User user) throws Exception {
        Set<UserRole> userRoleSet=new HashSet<UserRole>();
        Role role=new Role();
        role.setRoleId(45L);
        role.setRoleName("NORMAL");

        UserRole userRole=new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        userRoleSet.add(userRole);
        user.setProfile("default.png");
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return ResponseEntity.status(HttpStatus.OK).body(userService.createUser(user,userRoleSet));
    }
    @GetMapping("/{username}")
    public ResponseEntity<?> getUser(@PathVariable("username") String username) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUser(username));
    }
    @DeleteMapping("/{userId}")
     public void deleteUser(@PathVariable("userId") Long userId) throws Exception {
            userService.deleteUser(userId);
    }
    @PutMapping("/{username}")
    public ResponseEntity<?> updateUser(@PathVariable("username") String username, @RequestBody User user) throws Exception {
        bCryptPasswordEncoder.encode(user.getPassword());
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(username,user));
    }
}
