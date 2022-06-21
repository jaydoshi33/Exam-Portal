package com.cognizant.authorization.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.cognizant.authorization.models.User;
import com.cognizant.authorization.models.UserRole;
@Service
public interface UserService {
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;
    public User getUser(String username) throws Exception;
    public void deleteUser(Long userId) throws Exception;

    public User updateUser(String username,User user) throws Exception;
}
