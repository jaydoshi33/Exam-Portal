package com.cognizant.admin.service;


import java.util.Set;

import com.cognizant.admin.models.Question;
import com.cognizant.admin.models.Quiz;

public interface QuestionService{
    public Question addQuestion(Question question);
    public Question updateQuestion(Question question);
    public Set<Question> getAllQuestions();
    public Question getQuestion(Long questionId);
    public Set<Question> getQuestionBasedOnQuiz(Quiz quiz);
    public void deleteQuestion(Long questionId);

}
