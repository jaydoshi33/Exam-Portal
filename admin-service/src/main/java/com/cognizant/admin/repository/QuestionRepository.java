package com.cognizant.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.admin.models.Question;
import com.cognizant.admin.models.Quiz;

import java.util.Set;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long>{

    Set<Question> findByQuiz(Quiz quiz);
}
