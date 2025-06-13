package com.alura.literAlura.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Scanner;
@Service
public class Principal {

    @Autowired
    private BookService bookService;

    Scanner scanner = new Scanner(System.in);
    Scanner scannerName = new Scanner(System.in);
    Scanner scannerCentury = new Scanner(System.in);
    public void ShowMenu(){
        System.out.println("####Bienvenido al apartado de Funciones Especificas####");
        System.out.println("Por favor escribe el numero de la funcion que requieres: ");
        System.out.println("1. Listar todos los libros");
        System.out.println("2. Buscar un libro por su titulo");
        System.out.println("3. Mostrar todos los libros especificando el genero");
        System.out.println("4. Mostrar todos los libros de un siglo en especifico");
        System.out.println("5. Mostrar todos los libros de un autor en especifico");
        switch (scanner.nextInt()){
            case 1:
                bookService.listAll();
                break;
            case 2:
                System.out.println("Por favor escribe el nombre del libro");
                bookService.findByTitulo(scannerName.nextLine());
                break;
            case 3:
                System.out.println("Especifica el genero de tu interes (En Ingles)");
                bookService.findByGenero(scannerName.nextLine());
                break;
            case 4:
                System.out.println("Especifica el siglo");
                bookService.findByCentury(scannerCentury.nextInt());
                break;
            case 5:
                System.out.println("Especifica el autor de tu interes");
                bookService.findByAuthor(scannerName.nextLine());
                break;
        }
    }
}
