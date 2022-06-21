package com.cognizant.admin.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.cognizant.admin.models.Question;
import com.cognizant.admin.models.Quiz;
import com.cognizant.admin.repository.QuestionRepository;
import com.cognizant.admin.service.QuestionService;

import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@Service
@Slf4j
public class QuestionServiceImpl implements QuestionService {
    private QuestionRepository questionRepository;

	public Question addQuestion(Question question) {
	    return questionRepository.save(question);
	}

	public Question updateQuestion(Question question) {
		 return questionRepository.save(question);
	}

	public Set<Question> getAllQuestions() {
		return new LinkedHashSet<Question>(questionRepository.findAll());
	}

	public Question getQuestion(Long questionId) {
		return questionRepository.findById(questionId).get();
		 
	}

	public Set<Question> getQuestionBasedOnQuiz(Quiz quiz) {
		return questionRepository.findByQuiz(quiz);
	}

	public void deleteQuestion(Long questionId) {
        questionRepository.deleteById(questionId);
		
	}

}
