package com.cognizant.authorization.service.impl;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.cognizant.authorization.models.User;
import com.cognizant.authorization.models.UserRole;
import com.cognizant.authorization.repository.RoleRepository;
import com.cognizant.authorization.repository.UserRepository;
import com.cognizant.authorization.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@AllArgsConstructor
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		  User local=userRepository.findByUsername(user.getUsername());
		  if(local!=null){
		    log.info("User is already here!!");
		    throw new Exception("User already present !!");
		  }else{
		      for(UserRole ur:userRoles)
		        roleRepository.save(ur.getRole());
		  }
		  user.getUserRoles().addAll(userRoles);
		  local=userRepository.save(user);
		    return local;
	}
	public User getUser(String username) throws Exception {
		User user = userRepository.findByUsername(username);
	    if(user==null){
	        log.info("User not found");
	        throw new Exception("User not found with given username");
	    }else{
	        return user;
	    }
	}
	public void deleteUser(Long userId) throws Exception {
		  Optional<User> deletedUser = userRepository.findById(userId);
		    if(deletedUser.isEmpty()){
		        log.info("User not found with given userId");
		        throw new Exception("User not found with given userId");
		    }else{
		         userRepository.deleteById(deletedUser.get().getId());
		    }
		
	}
	public User updateUser(String username, User user) throws Exception {
		   User userWithName = userRepository.findByUsername(username);
		    if(userWithName==null){
		        log.info("User not found with given username");
		        throw new Exception("User not found with given username");
		    }else{
		        userWithName.setFirstName(user.getFirstName());
		        userWithName.setLastName(user.getLastName());
		        userWithName.setEmail(user.getEmail());
		        userWithName.setPassword(user.getPassword());
		        userWithName.setPhone(user.getPhone());
		        userWithName.setUserRoles(user.getUserRoles());
		        userWithName.setProfile(user.getProfile());
		        userWithName.setEnabled(user.isEnabled());
		        userWithName.setUsername(user.getUsername());
		        User updateUser = userRepository.save(userWithName);
		        return updateUser;
		    }
	}
	}
   
    






