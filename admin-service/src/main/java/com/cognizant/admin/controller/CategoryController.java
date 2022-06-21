package com.cognizant.admin.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cognizant.admin.feing.AuthClient;
import com.cognizant.admin.models.Category;
import com.cognizant.admin.service.CategoryService;

import java.util.Set;

@RestController
@RequestMapping("/category")
@AllArgsConstructor
@CrossOrigin("*")
public class CategoryController {
    private CategoryService categoryService;
   	private AuthClient authClient;
  
//    add category
    @PostMapping("/")
    public ResponseEntity<?> addCategory(@RequestBody Category category,@RequestHeader(name = "Authorization", required = true)String token) throws Exception{

		if (!authClient.getsValidity(token).isValidStatus()) {
			
			throw new Exception("Token is either expired or invalid...");
		}
        Category category1 = categoryService.addCategory(category);
        return ResponseEntity.ok().body(category1);

    }

    //get category based on category id
    @GetMapping("/{categoryId}")
    public ResponseEntity<?> getCategory(@PathVariable("categoryId") Long categoryId,@RequestHeader(name = "Authorization", required = true)String token) throws Exception{
    	if (!authClient.getsValidity(token).isValidStatus()) {
			
			throw new Exception("Token is either expired or invalid...");
		}
    	Category category = categoryService.getCategory(categoryId);
        return ResponseEntity.ok().body(category);
    }

    //get all category
    @GetMapping("/")
    public ResponseEntity<?> getAllCategory(@RequestHeader(name = "Authorization", required = true)String token) throws Exception{
    	if (!authClient.getsValidity(token).isValidStatus()) {
			
			throw new Exception("Token is either expired or invalid...");
		}
//    	System.out.println("CATEGORIES " +token);
    	Set<Category> categories = categoryService.getCategories();
        return ResponseEntity.ok().body(categories);
    }

    //update category
    @PutMapping("/")
    public ResponseEntity<?> updateCategory(@RequestBody Category category,@RequestHeader(name = "Authorization", required = true)String token) throws Exception{
    	if (!authClient.getsValidity(token).isValidStatus()) {
			
			throw new Exception("Token is either expired or invalid...");
		}
    	Category category1 = categoryService.updateCategory(category);
        return ResponseEntity.ok().body(category1);
    }
    //delete category
    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") Long categoryId,@RequestHeader(name = "Authorization", required = true)String token) throws Exception{
    	if (!authClient.getsValidity(token).isValidStatus()) {
			
			throw new Exception("Token is either expired or invalid...");
		}
    	categoryService.deleteCategory(categoryId);
    }


}


