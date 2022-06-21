package com.cognizant.authorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.authorization.models.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
   public User findByUsername(String username);
}
