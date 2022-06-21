package com.cognizant.admin.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.cognizant.admin.models.Category;
import com.cognizant.admin.models.Quiz;
import com.cognizant.admin.repository.QuizRepository;
import com.cognizant.admin.service.QuizService;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
@Slf4j
public class QuizServiceImpl implements QuizService {
    private QuizRepository quizRepository;

	public Quiz addQuiz(Quiz quiz) {
		log.info("Inside add quiz method in serivce impl");
        return quizRepository.save(quiz);
	}

	public Quiz updateQuiz(Quiz quiz) {
		return quizRepository.save(quiz);
	}

	public Set<Quiz> getQuizzess() {
		 return new LinkedHashSet<Quiz>(quizRepository.findAll());
	}

	public Quiz getQuiz(Long quizId) {
		 return quizRepository.findById(quizId).get();
	}

	public void deleteQuiz(Long quizId) {
		 quizRepository.deleteById(quizId);
		
	}

	public Set<Quiz> getQuizBasedOnCategory(Category category) {
		 List<Quiz> byCategory = quizRepository.findByCategory(category);
	        return new LinkedHashSet<Quiz>(byCategory);
	}
   
}
