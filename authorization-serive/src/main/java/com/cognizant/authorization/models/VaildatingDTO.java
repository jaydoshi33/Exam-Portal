package com.cognizant.authorization.models;

import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Component
public class VaildatingDTO {
   
    @JsonProperty
    private boolean validStatus;
        
}