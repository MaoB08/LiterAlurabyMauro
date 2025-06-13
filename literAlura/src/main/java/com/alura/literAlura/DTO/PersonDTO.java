package com.alura.literAlura.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PersonDTO(
        String name,
        int birth_year,
        int death_year
) {
}
