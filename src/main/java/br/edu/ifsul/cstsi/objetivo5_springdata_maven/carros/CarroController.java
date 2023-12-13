package br.edu.ifsul.cstsi.objetivo5_springdata_maven.carros;

import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;
@Controller
public class CarroController {
    private static final Scanner input = new Scanner(System.in);
    private static CarroService carroService;
    public CarroController(CarroService CarroService) {
        CarroController.carroService=CarroService;
    }
    public static void main(String[] args) {
        int opcao;
        do {
            System.out.print("\n\"-------  MENU loja -------\"");
            System.out.print(
                    """
                        
                        1. Inserir novo carro
                        2. Atualizar um carro
                        3. Excluir um carro (tornar inativo)
                        4. Ativar ou Desativar um carro
                        5. Listar todos os carros
                        6. Buscar carro pelo código
                        7. Buscar carro pela placa
                        8. Buscar carro pela situação
                        Opção (Zero p/sair):\s""");
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1 -> inserir();
                case 2 -> atualizar();
                case 3 -> excluir();
                case 4 -> ativar();
                case 5 -> selectCarros();
                case 6 -> selectCarrosById();
                case 7 -> selectCarrosByPlaca();
                case 8 -> selectCarrosBySituacao();
                default -> {
                    if (opcao != 0) System.out.println("Opção inválida.");
                }
            }
        } while (opcao != 0);
    }

    private static void inserir() {
        Carro carro = new Carro();
        System.out.println("\n------- Cadastro de novo Carro --------");
        System.out.print("Digite a placa: ");
        carro.setPlaca (input.nextLine());
        System.out.print("\nDigite o chassi: ");
        carro.setChassi(input.nextLine());
        System.out.print("\nDigite a cor: ");
        carro.setCor(input.nextLine());
        System.out.print("\nDigite o valor da diaria: ");
        carro.setValorDiaria(input.nextBigDecimal());
        carro.setSituacao(true);
        System.out.println("Carro salvo com sucesso:" + carroService.insert(carro));
    }

    private static void atualizar() {
        System.out.println("\n------ Atualizar um carro ------");
        Carro carro;
        int opcao = 0;
        do {
            System.out.print("\nDigite o código do carro (Zero p/sair): ");
            long codigo = input.nextLong();
            input.nextLine();
            if (codigo == 0) {
                opcao = 0;
            } else {
                carro = carroService.getCarroById(codigo);
                if (carro == null) {
                    System.out.println("Código inválido.");
                } else {
                    System.out.println("Placa: " + carro.getPlaca());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.println("Digite a nova placa do carro: ");
                        carro.setPlaca(input.nextLine());
                    }
                    System.out.println("Chassi: " + carro.getChassi());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.print("Digite o novo chassi do carro: ");
                        carro.setChassi(input.nextLine());
                    }
                    carro.setSituacao(true);
                    if(carroService.atualizar(carro) != null) {
                        System.out.println("carro atualizado com sucesso. " + carroService.getCarroById(carro.getId()));
                    } else {
                        System.out.println("Não foi possível atualizar este carro. Por favor, contate o administrador.");
                    }
                    opcao = 1;
                }
            }
        } while (opcao != 0);
    }

    private static void excluir() {
        System.out.println("\n------ Excluir um carro ------");
        Carro carro;
        int opcao = 0;
        do {
            System.out.print("\nDigite o código do carro (Zero p/sair): ");
            long codigo = input.nextLong();
            input.nextLine();
            if (codigo == 0) {
                opcao = 0;
            } else if(codigo > 0){
                carro = carroService.getCarroById(codigo);
                if (carro == null) {
                    System.out.println("Código inválido.");
                } else {
                    System.out.println(carro);
                    System.out.print("Excluir este carro? (0-sim/1-não) ");
                    if (input.nextInt() == 0) {
                        input.nextLine();
                        System.out.print("Tem certeza disso? (0-sim/1-não) ");
                        carro.setSituacao(false);
                        input.nextLine();
                        carroService.excluir(carro.getId());
                        System.out.println("cliente excluído com sucesso:" + carro);
                    }
                }
            } else {
                System.out.println("Digite um código válido!!!");
            }
        } while (opcao != 0);
    }

    private static void ativar(){
        System.out.println("\n------ Ativar/Desativar um carro ------");
        Carro carro;
        int opcao = 0;
        do {
            System.out.print("\nDigite o código do carro (Zero p/sair): ");
            long codigo = input.nextLong();
            input.nextLine();
            if (codigo == 0) {
                opcao = 0;
            } else if(codigo > 0){
                carro = carroService.getCarroById(codigo);
                if (carro == null) {
                    System.out.println("Código inválido.");
                } else {
                    System.out.println(carro);
                    System.out.print("Ativar/Desativar este cliente? (0-sim/1-não) ");
                    if (input.nextInt() == 0) {
                        input.nextLine();
                        System.out.print("Tem certeza disso? (0-sim/1-não) ");
                        //carro.setSituacao(!carro.getSituacao());
                        input.nextLine();
                        if(carroService.atualizar(carro) != null) {
                            System.out.println("Situação do carro alterada com sucesso: " + carroService.getCarroById(codigo));
                        } else {
                            System.out.println("Não foi possível ativar/desativar este carro. Por favor, contate o administrador.");
                        }
                    }
                }
            } else {
                System.out.println("Digite um código válido!!!");
            }
        } while (opcao != 0);
    }

    private static void selectCarros() {
        System.out.println("\nLista de carros cadastrados no banco de dados:\n" + carroService.getCarros());
    }

    private static void selectCarrosById() {
        System.out.print("\nDigite o código do carro: ");
        Carro carro = carroService.getCarroById(input.nextLong());
        input.nextLine();
        if (carro != null) {
            System.out.println(carro);
        } else {
            System.out.println("Código não localizado.");
        }
    }

    private static void selectCarrosByPlaca() {
        System.out.print("Digite o numero da placa: ");
        String placa = input.nextLine();
        System.out.println("Chave de pesquisa: " + placa);
        List<Carro> carros = carroService.getCarroByPlaca(placa + "%");
        if (carros.isEmpty()) {
            System.out.println("Não há registros correspondentes para: " + placa);
        } else {
            System.out.println(carros);
        }
    }

    private static void selectCarrosBySituacao() {
        System.out.print("Escolha uma das situações (0.inativo ou 1.ativo): ");
        int situacao = input.nextInt();
        input.nextLine();
        List<Carro> carros;
        switch (situacao) {
            case 0 -> {
                carros = carroService.getCarroBySituacao(false);
                System.out.println("carros na situação INATIVO:\n " + carros);
            }
            case 1 -> {
                carros = carroService.getCarroBySituacao(true);
                System.out.println("clientes na situação ATIVO:\n " + carros);
            }
        }
    }
}
