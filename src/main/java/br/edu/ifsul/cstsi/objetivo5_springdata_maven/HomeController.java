package br.edu.ifsul.cstsi.objetivo5_springdata_maven;

import br.edu.ifsul.cstsi.objetivo5_springdata_maven.carros.CarroController;

import java.util.Scanner;

public class HomeController {
	
	private static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		int opcao;
		do {
			System.out.print("\n-------  Home -------");
			System.out.print(
				"""

					1. Vender
					2. Manter Produtos
					3. Carros
					4. Manter Itens
					5. Manter Pedidos
					Opção (Zero p/sair):\s""");
			opcao = input.nextInt();
			input.nextLine();
			switch (opcao) {
				case 1 -> System.out.println("Em desenvolvimento");
				case 2 -> System.out.println("Em desenvolvimento");
				case 3 -> CarroController.main(null);
				case 4 -> System.out.println("Em desenvolvimento");
				case 5 -> System.out.println("Em desenvolvimento");
				default -> {
					if (opcao != 0) System.out.println("Opção inválida.");
				}
			}
		} while(opcao != 0) ;
		System.out.println("\n\n!!!!!!!! Fim da aplicação !!!!!!!!");
		input.close();
	}
}
