package com.cognizant.normal.Controller;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cognizant.normal.feing.AdminClient;
import com.cognizant.normal.feing.AuthClient;
import com.cognizant.normal.models.CategoryDTO;

@RestController
@RequestMapping("/quiz")
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class QuizController {

    private AdminClient adminClient;
    private AuthClient authClient;
    

    //get all quiz
    @GetMapping("/")
    public ResponseEntity<?> getAllQuiz(@RequestHeader(name = "Authorization", required = true)String token) throws Exception{
    	if (!authClient.getsValidity(token).isValidStatus()) {
			throw new Exception("Token is either expired or invalid...");
		}
        return ResponseEntity.ok().body(adminClient.getQuizzess(token));
    }

    //get quiz based on quizId
    @GetMapping("/{quizId}")
    public ResponseEntity<?> getQuiz(@PathVariable ("quizId") Long quizId,@RequestHeader(name = "Authorization", required = true)String token) throws Exception{
    	if (!authClient.getsValidity(token).isValidStatus()) {
			throw new Exception("Token is either expired or invalid...");
		}
        return ResponseEntity.ok().body(adminClient.getQuiz(quizId,token));
    }
    //get all quiz of a particular category
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<?>getQuizBasedOnCategory(@PathVariable("categoryId") Long categoryId,@RequestHeader(name = "Authorization", required = true)String token) throws Exception{
    	if (!authClient.getsValidity(token).isValidStatus()) {
			throw new Exception("Token is either expired or invalid...");
		}
        return ResponseEntity.ok().body(adminClient.getQuizBasedOnCategory(categoryId,token));
    }

    
}
