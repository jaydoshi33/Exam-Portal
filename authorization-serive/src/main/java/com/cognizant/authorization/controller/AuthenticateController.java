package com.cognizant.authorization.controller;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import com.cognizant.authorization.models.JwtRequest;
import com.cognizant.authorization.models.JwtResponse;
import com.cognizant.authorization.models.User;
import com.cognizant.authorization.models.VaildatingDTO;
import com.cognizant.authorization.service.impl.UserDetailsServiceImpl;
import com.cognizant.authorization.utils.JwtUtil;

import java.security.Principal;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class AuthenticateController {
    private AuthenticationManager authenticationManager;
    private UserDetailsServiceImpl userDetailsService;
    private JwtUtil jwtUtil;
    private VaildatingDTO vaildatingDTO;

    private void authenticate(String username,String password) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));

        }catch (DisabledException e){
            throw  new Exception("USER DISABLED");
        }catch (BadCredentialsException e){
            throw new Exception("Invalid Credentials "+e.getMessage());
        }
    }
    @PostMapping("/token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try{
            authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());

        }catch (UsernameNotFoundException e){

            e.printStackTrace();
            throw new Exception("User not found");
        }
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok().body(new JwtResponse(token));
    }
    
    @GetMapping(path = "/validate")
	public ResponseEntity<VaildatingDTO> validatingAuthorizationToken(@RequestHeader(name = "Authorization") String tokenDup) {
		
//		log.info("BEGIN - [validatingAuthorizationToken(JWT-token)]");
		String token = tokenDup.substring(7);
		try {
			UserDetails user = userDetailsService.loadUserByUsername(jwtUtil.extractUsername(token));
			if (Boolean.TRUE.equals(jwtUtil.validateToken(token, user))) {
//				log.debug("Token matched is Valid");
//				log.info("Token matched is Valid");
//				log.info("END - validate()");
				vaildatingDTO.setValidStatus(true);
				return new ResponseEntity<>(vaildatingDTO, HttpStatus.OK);
			} else {
				throw new Exception("Invalid Token");
			}
		} catch (Exception e) {
//			log.debug("Invalid token - Bad Credentials Exception");
//			log.info("END Exception - validatingAuthorizationToken()");
			vaildatingDTO.setValidStatus(false);
			return new ResponseEntity<>(vaildatingDTO, HttpStatus.BAD_REQUEST);
		}
		
	}


    //returns the details current user
    @GetMapping("/current-user")
    public User getCurrentUser(Principal principal){
        return ((User)userDetailsService.loadUserByUsername(principal.getName()));
    }
}
