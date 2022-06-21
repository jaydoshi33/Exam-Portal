package com.cognizant.normal.feing;

import java.util.List;
import java.util.Set;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.normal.models.CategoryDTO;
import com.cognizant.normal.models.QuestionDTO;
import com.cognizant.normal.models.QuizDTO;
import com.cognizant.normal.models.ResultDTO;
@FeignClient(name = "normal-user-service", url = "${Admin.URL}")
public interface AdminClient {
	
	@GetMapping("/category/{categoryId}")
	public CategoryDTO getCategory(@PathVariable("categoryId") Long categoryId,@RequestHeader(name = "Authorization", required = true) String token);

	@GetMapping("/category/")
	public Set<CategoryDTO> getCategories(@RequestHeader(name = "Authorization", required = true) String token);

	@GetMapping("/quiz/")
	public Set<QuizDTO> getQuizzess(@RequestHeader(name = "Authorization", required = true) String token);

	@GetMapping("/quiz/{quizId}")
	public QuizDTO getQuiz(@PathVariable("quizId") Long quizId, @RequestHeader(name = "Authorization", required = true) String token);

	@GetMapping("/quiz/category/{categoryId}")
	public Set<QuizDTO> getQuizBasedOnCategory(@PathVariable("categoryId") Long categoryId, @RequestHeader(name = "Authorization", required = true) String token); 
	
	@GetMapping("/question/quiz/{quizId}")
	public List<QuestionDTO> getQuestionByQuiz(@PathVariable("quizId") Long quizId, @RequestHeader(name = "Authorization", required = true) String token);
	
	@PostMapping("/question/eval-quiz")
	public ResultDTO evalQuiz(List<QuestionDTO> questions,@RequestHeader(name = "Authorization", required = true) String token);

}
