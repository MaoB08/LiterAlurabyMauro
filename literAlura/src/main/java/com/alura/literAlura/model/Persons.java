package com.alura.literAlura.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "authors")
public class Persons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int birth_year;
    private int death_year;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

    public Persons(Long id, String name, int i, int i1) {
    }
}
