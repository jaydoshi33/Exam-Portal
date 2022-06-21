package com.cognizant.admin.controller;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cognizant.admin.feing.AuthClient;
import com.cognizant.admin.models.Category;
import com.cognizant.admin.models.Quiz;
import com.cognizant.admin.service.QuizService;

@RestController
@RequestMapping("/quiz")
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class QuizController {

    private QuizService quizService;
    private AuthClient authClient;
    //add quiz
    @PostMapping("/")
    public ResponseEntity<?> addQuiz(@RequestBody Quiz quiz,@RequestHeader(name = "Authorization", required = true)String token) throws Exception{
	if (!authClient.getsValidity(token).isValidStatus()) {
			throw new Exception("Token is either expired or invalid...");
		}
      log.info("{}",quiz);
        return ResponseEntity.ok().body(quizService.addQuiz(quiz));
    }
    //update quiz
    @PutMapping("/")
    public ResponseEntity<?> updateQuiz(@RequestBody Quiz quiz,@RequestHeader(name = "Authorization", required = true)String token) throws Exception{
    	if (!authClient.getsValidity(token).isValidStatus()) {
			throw new Exception("Token is either expired or invalid...");
		}
        return ResponseEntity.ok().body(quizService.updateQuiz(quiz));
    }

    //get all quiz
    @GetMapping("/")
    public ResponseEntity<?> getAllQuiz(@RequestHeader(name = "Authorization", required = true)String token) throws Exception{
    	if (!authClient.getsValidity(token).isValidStatus()) {
			throw new Exception("Token is either expired or invalid...");
		}
        return ResponseEntity.ok().body(quizService.getQuizzess());
    }

    //get quiz based on quizId
    @GetMapping("/{quizId}")
    public ResponseEntity<?> getQuiz(@PathVariable ("quizId") Long quizId,@RequestHeader(name = "Authorization", required = true)String token) throws Exception{
    	if (!authClient.getsValidity(token).isValidStatus()) {
			throw new Exception("Token is either expired or invalid...");
		}
        return ResponseEntity.ok().body(quizService.getQuiz(quizId));
    }
    //get all quiz of a particular category
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<?>getQuizBasedOnCategory(@PathVariable("categoryId") Long categoryId,@RequestHeader(name = "Authorization", required = true)String token) throws Exception{
    	if (!authClient.getsValidity(token).isValidStatus()) {
			throw new Exception("Token is either expired or invalid...");
		}
        Category category=new Category();
        category.setCid(categoryId);
        return ResponseEntity.ok().body(quizService.getQuizBasedOnCategory(category));
    }

    //delete quiz
    @DeleteMapping("/{quizId}")
    public void deleteQuiz(@PathVariable ("quizId") Long quizId,@RequestHeader(name = "Authorization", required = true)String token) throws Exception{
    	if (!authClient.getsValidity(token).isValidStatus()) {
			throw new Exception("Token is either expired or invalid...");
		}
    	quizService.deleteQuiz(quizId);

    }
}
