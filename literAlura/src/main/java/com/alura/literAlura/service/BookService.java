package com.alura.literAlura.service;

import com.alura.literAlura.DTO.BookDTO;
import com.alura.literAlura.model.Book;
import com.alura.literAlura.model.Persons;
import com.alura.literAlura.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book saveBook(BookDTO bookDTO) {

        Optional<Book> existingBook = bookRepository.findByTitleIgnoreCase(bookDTO.title());
        if (existingBook.isPresent()) {
            System.out.println("⚠️ El libro ya existe en la base de datos: " + bookDTO.title());
            return existingBook.get();
        }
        Book book = new Book();
        book.setTitle(bookDTO.title());
        List<Persons> authors = bookDTO.authors().stream()
                .map(personDTO -> {
                    Persons person = new Persons();
                    person.setName(personDTO.name());
                    person.setBirth_year(personDTO.birth_year());
                    person.setDeath_year(personDTO.death_year());
                    return person;
                })
                .collect(Collectors.toList());
        book.setAuthors(authors);
        book.setSubjects(bookDTO.subjects());
        book.setLanguages(bookDTO.languages());
        return bookRepository.save(book);
    }
    public void listAll(){
        List<Book> books = bookRepository.findAllWithAuthors();
        for (Book book : books){
            System.out.println();
            System.out.println("######### Libro ##########");
            System.out.println("Titulo: " + book.getTitle());
            String autores = book.getAuthors().stream().map(Persons::getName).collect(Collectors.joining(", "));
            System.out.println("Autores: " + autores);
            System.out.println("Generos: " + book.getSubjects());
            System.out.println("Lenguajes: " + book.getLanguages());
            System.out.println("##########################");
        }
    }

    public void findByTitulo(String title) {
        Book book = bookRepository.findBookDetails(title);
        if (book != null){
            System.out.println();
            System.out.println("######### Libro ##########");
            System.out.println("Titulo: " +book.getTitle());
            String autores = book.getAuthors().stream().map(Persons::getName).collect(Collectors.joining(", "));
            System.out.println("Autores: " + autores);
            System.out.println("Generos: " + book.getSubjects());
            System.out.println("Lenguajes: " + book.getLanguages());
            System.out.println("##########################");
        }else{
            System.out.println("No hemos podido encontrar tu libro");
        }
    }

    public void findByGenero(String subject) {
        List<Book> books = bookRepository.findBySubjectContaining(subject);
        for (Book book : books){
            System.out.println();
            System.out.println("######### Libro ##########");
            System.out.println("Titulo: " + book.getTitle());
            String autores = book.getAuthors().stream().map(Persons::getName).collect(Collectors.joining(", "));
            System.out.println("Autores: " + autores);
            System.out.println("Generos: " + book.getSubjects());
            System.out.println("Lenguajes: " + book.getLanguages());
            System.out.println("##########################");
        }
    }

    public void findByAuthor(String author) {
        List<Book> books = bookRepository.findByAuthorLikeIgnoreCase(author);
        for (Book book : books){
            System.out.println();
            System.out.println("######### Libro ##########");
            System.out.println("Titulo: " + book.getTitle());
            String autores = book.getAuthors().stream().map(Persons::getName).collect(Collectors.joining(", "));
            System.out.println("Autores: " + autores);
            System.out.println("Generos: " + book.getSubjects());
            System.out.println("Lenguajes: " + book.getLanguages());
            System.out.println("##########################");
        }
    }
    public void findByLanguages(String author) {
        List<Book> books = bookRepository.findByLanguajes(author);
        for (Book book : books){
            System.out.println();
            System.out.println("######### Libro ##########");
            System.out.println("Titulo: " + book.getTitle());
            String autores = book.getAuthors().stream().map(Persons::getName).collect(Collectors.joining(", "));
            System.out.println("Autores: " + autores);
            System.out.println("Generos: " + book.getSubjects());
            System.out.println("Lenguajes: " + book.getLanguages());
            System.out.println("##########################");
        }
    }

    public void findByCentury(int i) {
        int initAge = ((i-1)*100)+1;
        int finalAge = (i*100);
        System.out.println(initAge + "-" + finalAge);
    }
}
