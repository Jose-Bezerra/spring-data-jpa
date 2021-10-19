package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudCargoService {
    private final CargoRepository cargoRepository;
    private boolean system = true;

    public CrudCargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public void inicial(Scanner scanner) {
        while (system) {
            System.out.println("Qual ação de cargo deseja executar? ");
            System.out.println("0 - Sair");
            System.out.println("1 - Salvar");
            System.out.println("2 - Atualizar");

            int action = scanner.nextInt();
            switch (action){
                case 1:
                    salvar(scanner);
                    break;
                case 2:
                    atualizar(scanner);
                    break;
                default:
                    system = false;
                    break;
            }
        }
    }

    private void salvar(Scanner scanner) {
        System.out.println("Descrição do cargo: ");
        String description = scanner.next();
        Cargo cargo = new Cargo();
        cargo.setDescription(description);
        cargoRepository.save(cargo);
        System.out.println("Salvo com sucesso!");
    }

    private void atualizar(Scanner scanner) {
        System.out.println("Informe o Id: ");
        int id = scanner.nextInt();
        System.out.println("Descrição do Cargo: ");
        String description = scanner.next();
        Cargo cargo = new Cargo();
        cargo.setId(id);
        cargo.setDescription(description);
        cargoRepository.save(cargo);
        System.out.println("Registro atualizado com sucesso!");
    }
}
