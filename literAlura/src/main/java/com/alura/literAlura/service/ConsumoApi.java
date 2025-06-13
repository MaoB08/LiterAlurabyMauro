package com.alura.literAlura.service;

import com.alura.literAlura.DTO.BookDTO;
import com.alura.literAlura.model.BookResultsDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;


@Service
public class ConsumoApi {

    @Autowired
    private BookService bookService;

    public void obtenerDatos(String name) throws IOException, InterruptedException {
        try {
            HttpClient client = HttpClient.newBuilder()
                    .followRedirects(HttpClient.Redirect.ALWAYS)
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://gutendex.com/books/?search=" + name.replace(" ", "%20")))
                    .GET()
                    .header("Accept", "application/json")
                    .timeout(Duration.ofSeconds(15))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Verificar el código de estado HTTP
            if (response.statusCode() != 200) {
                System.out.println("Error en la respuesta de la API: " + response.statusCode());
                return;
            }

            ObjectMapper mapper = new ObjectMapper();
            BookResultsDTO result = mapper.readValue(response.body(), BookResultsDTO.class);

            // Verificar si hay resultados ANTES de intentar procesarlos
            if (result.count() == 0 || result.results() == null || result.results().isEmpty()) {
                System.out.println("El libro que está buscando no se encuentra");
                return;
            }

            // Buscar libro con título que coincida exactamente (ignorando mayúsculas/minúsculas)
            BookDTO book = result.results()
                    .stream()
                    .filter(bookDTO -> bookDTO != null && bookDTO.title() != null)
                    .filter(bookDTO -> bookDTO.title().equalsIgnoreCase(name.trim()))
                    .findFirst()
                    .map(bookDTO -> new BookDTO(
                            bookDTO.id(),
                            bookDTO.title(),
                            bookDTO.authors(),
                            bookDTO.subjects()
                    ))
                    .orElse(null);

            if (book != null) {
                bookService.saveBook(book);
                System.out.println("Libro guardado exitosamente: " + book.title());
            } else {
                System.out.println("El libro que está buscando no se encuentra (el título debe coincidir exactamente)");
            }

        } catch (JsonProcessingException e) {
            System.out.println("Error al procesar la respuesta JSON: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("Operación interrumpida: " + e.getMessage());
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }
}