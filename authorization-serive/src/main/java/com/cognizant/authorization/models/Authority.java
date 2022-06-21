package com.cognizant.authorization.models;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
public class Authority implements GrantedAuthority {
    private String authority;

   
	public String getAuthority() {
		// TODO Auto-generated method stub
		return authority;
	}
    
}
