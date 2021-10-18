package br.com.alura.spring.data;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.service.CrudCargoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private final CrudCargoService cargoService; //não podemos instanciar uma interface
	private boolean system = true; //permanecer no sistema

	//Injeção de dependência através do construtor
	public SpringDataApplication(CrudCargoService cargoService) {
		this.cargoService = cargoService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Pegando os valores do cliente pela console, normalmente seria pelo site
		Scanner scanner = new Scanner(System.in);

		while (system) {
			System.out.println("Qual ação deseja executar? ");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");

			int action = scanner.nextInt();
			if (action == 1) {
				cargoService.inicial(scanner);
			} else {
				system = false;
			}
		}

	}
}
