package com.cognizant.normal.Controller;

import lombok.AllArgsConstructor;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cognizant.normal.feing.AuthClient;
import com.cognizant.normal.models.CategoryDTO;
import com.cognizant.normal.feing.AdminClient;

import java.util.Set;

@RestController
@RequestMapping("/category")
@AllArgsConstructor
@CrossOrigin("*")
public class CategoryController {
    private AdminClient adminClient;
   	private AuthClient authClient;
  
//    add category
    

    //get category based on category id
    @GetMapping("/{categoryId}")
    public ResponseEntity<?> getCategory(@PathVariable("categoryId") Long categoryId,@RequestHeader(name = "Authorization", required = true)String token) throws Exception{
    	if (!authClient.getsValidity(token).isValidStatus()) {
			
			throw new Exception("Token is either expired or invalid...");
		}
    	CategoryDTO categoryDTO = adminClient.getCategory(categoryId,token);
        return ResponseEntity.ok().body(categoryDTO);
    }

    //get all category
    @GetMapping("/")
    public ResponseEntity<?> getAllCategory(@RequestHeader(name = "Authorization", required = true)String token) throws Exception{
    	if (!authClient.getsValidity(token).isValidStatus()) {
			
			throw new Exception("Token is either expired or invalid...");
		}
//    	System.out.println("CATEGORIES " +token);
    	Set<CategoryDTO> categories = adminClient.getCategories(token);
        return ResponseEntity.ok().body(categories);
    }

    

}


