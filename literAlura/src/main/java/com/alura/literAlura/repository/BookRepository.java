package com.alura.literAlura.repository;

import com.alura.literAlura.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByTitleIgnoreCase(String title);

    @Query("SELECT b FROM Book b WHERE b.title = :title")
    Book findBookDetails(@Param("title") String title);

    @Query("SELECT b FROM Book b JOIN b.subjects s WHERE LOWER(s) LIKE LOWER(CONCAT('%', :subject, '%'))")
    List<Book> findBySubjectContaining(@Param("subject") String subject);

    @Query("SELECT b FROM Book b JOIN b.authors a WHERE LOWER(a.name) LIKE LOWER(CONCAT('%', :author, '%'))")
    List<Book> findByAuthorLikeIgnoreCase(@Param("author") String author);

    @Query("SELECT b FROM Book b JOIN FETCH b.authors")
    List<Book> findAllWithAuthors();
}
