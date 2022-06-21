package com.cognizant.normal.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class QuizDTO  {
    
		private Long quizId;

	    private String title;

	    private String description;

	    private String maxMarks;

	    private String numberOfQuestions;

	    private boolean active=false;
	   
	    private CategoryDTO category;
	    @JsonIgnore
	    private List<QuestionDTO> questions=new ArrayList<QuestionDTO>();
    
}