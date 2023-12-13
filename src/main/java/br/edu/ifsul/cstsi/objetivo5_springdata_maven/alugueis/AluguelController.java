package br.edu.ifsul.cstsi.objetivo5_springdata_maven.alugueis;

import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.Scanner;

@Controller
public class AluguelController {

    private static final Scanner input = new Scanner(System.in);
    private static AluguelService aluguelService;

//    Injeção de dependência
    public AluguelController(AluguelService AluguelService) {
        AluguelController.aluguelService = AluguelService;
    }

    public static void main(String[] args) {

        int opcao;
        do {
            System.out.print("\n\"-------  MENU cliente -------\"");
            System.out.print(
                """

                    1. Inserir novo cliente
                    2. Atualizar um cliente
                    3. Excluir um cliente (tornar inativo)
                    4. Ativar ou Desativar um cliente
                    5. Listar todos os clientes
                    6. Buscar cliente pelo código
                    7. Buscar clientes pelo nome
                    8. Buscar clientes pela situação
                    Opção (Zero p/sair):\s""");
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1 -> inserir();
                case 2 -> atualizar();
                case 3 -> excluir();
                case 4 -> ativar();
                case 5 -> selectclientes();
                case 6 -> selectclientesById();
                case 7 -> selectclientesByNome();
                case 8 -> selectClientesBySituacao();
                default -> {
                    if (opcao != 0) System.out.println("Opção inválida.");
                }
            }
        } while (opcao != 0);
    }

    private static void inserir() {
        Aluguel aluguel = new Aluguel();
        System.out.println("\n++++++ Cadastro de novo Aluguel ++++++");
        System.out.print("Digite a data do pedido: ");
        aluguel.setDataPedido (LocalDate.parse("dd/MM/yyyy"));
        System.out.print("\nDigite a data da entrega: ");
        aluguel.setDataEntrega(LocalDate.parse("dd/MM/yyyy"));
        System.out.print("\nDigite a data da devolucao: ");
        aluguel.setDataDevolucao(LocalDate.parse("dd/MM/yyyy"));
        System.out.print("\nDigite o valor total : ");
        aluguel.setValorTotal(input.nextBigDecimal());
        System.out.println("aluguel salvo com sucesso:" + aluguelService.insert(aluguel));
    }

    private static void atualizar() {
        System.out.println("atualizar");
    }

    private static void excluir() {
        System.out.println("excluir");
    }

    private static void ativar(){
        System.out.println("ativar");
    }

    private static void selectclientes() {
        System.out.println("select Clientes");
    }

    private static void selectclientesById() {
        System.out.println("Select clienes by id");
    }

    private static void selectclientesByNome() {
        System.out.println("select clientes by nome");
    }

    private static void selectClientesBySituacao() {
        System.out.println("select clientes by situação");
    }

}
