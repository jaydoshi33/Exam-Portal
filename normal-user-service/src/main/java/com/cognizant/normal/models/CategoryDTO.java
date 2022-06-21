package com.cognizant.normal.models;

import java.util.LinkedHashSet;
import java.util.Set;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@AllArgsConstructor 
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CategoryDTO {
	
    private Long cid;
    private String title;
    private String description;
    @JsonIgnore
    private Set<QuizDTO> quizzes=new LinkedHashSet<QuizDTO>();
}
