package com.alura.literAlura.DTO;

import com.alura.literAlura.model.Persons;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record BookDTO(
         Long id,
         String title,
         List<PersonDTO>authors,
         List<String> subjects,
         List<String> languages
) {
}
