package com.alura.literAlura.model;

import com.alura.literAlura.DTO.BookDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookResultsDTO(
        int count,
        List<BookDTO> results
) {
}
