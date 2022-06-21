package com.cognizant.admin.service;

import org.springframework.stereotype.Service;

import com.cognizant.admin.models.Category;
import com.cognizant.admin.models.Quiz;

import java.util.Set;

@Service
public interface QuizService {
    public Quiz addQuiz(Quiz quiz);
    public Quiz updateQuiz(Quiz quiz);
    public Set<Quiz> getQuizzess();
    public Quiz getQuiz(Long quizId);
    public void deleteQuiz(Long quizId);
    public Set<Quiz> getQuizBasedOnCategory(Category category);
}
