package com.alura.literAlura;

import com.alura.literAlura.service.ConsumoApi;
import com.alura.literAlura.service.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

	private final Principal principal;

	private final ConsumoApi consumoApi;

	public LiterAluraApplication(Principal principal, ConsumoApi consumoApi) {
        this.principal = principal;
        this.consumoApi = consumoApi;
	}

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("");
			System.out.println("###########Bienvenido a LiterAlura by Mauro###########");
			System.out.println("1.Quieres Guardar un libro En tu base de datos");
			System.out.println("2.Deseas hacer una operacion en especifica");
			System.out.println("######################################################");
			Scanner scannerName = new Scanner(System.in);
			Scanner scannerCode = new Scanner(System.in);
			switch (scannerCode.nextInt()){
				case 1:
					System.out.println("Ingresa el nombre del libro que deseas guadar");
					consumoApi.obtenerDatos(scannerName.nextLine());
					break;
				case 2:
					principal.ShowMenu();
					break;
			}
			System.out.println("Desea realizar otra busqueda: 1(Si) 0(NO)");
		}while (scanner.nextInt() == 1);

	}
}
