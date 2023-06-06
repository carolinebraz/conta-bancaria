package conta;

import java.util.Scanner;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {
	public static void main(String[] args) {

		// Teste Conta Corrente
		ContaCorrente cc1 = new ContaCorrente(2, 456, 1, "Berenice C", 150000.0f, 15000.0f);
		cc1.visualizar();
		cc1.sacar(120000.0f);
		cc1.visualizar();
		cc1.depositar(50000.0f);
		cc1.visualizar();

		// Teste Conta Poupança
		ContaPoupanca cp1 = new ContaPoupanca(3, 789, 2, "Clarice D", 100000.0f, 15);
		cp1.visualizar();
		cp1.sacar(10000.0f);
		cp1.visualizar();
		cp1.depositar(50000.0f);
		cp1.visualizar();

		Scanner scan = new Scanner(System.in);

		int opcao;

		do {
			System.out.print(Cores.TEXT_GREEN_BRIGHT + Cores.ANSI_BLACK_BACKGROUND);
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("                                                        ");
			System.out.println("                      BANCO BRAZ                        ");
			System.out.println("                                                        ");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("                                                        ");
			System.out.println("           1 - Criar conta                              ");
			System.out.println("           2 - Listar todas as contas                   ");
			System.out.println("           3 - Buscar conta por número                  ");
			System.out.println("           4 - Atualizar dados da conta                 ");
			System.out.println("           5 - Apagar conta                             ");
			System.out.println("           6 - Sacar                                    ");
			System.out.println("           7 - Depositar                                ");
			System.out.println("           8 - Transferir valores entre contas          ");
			System.out.println("           9 - Sair                                     ");
			System.out.println("                                                        ");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("                                                        ");
			System.out.println("Entre com a opção desejada:                             ");
			System.out.println("                                                        ");
			System.out.print(Cores.TEXT_RESET);

			opcao = scan.nextInt();

			switch (opcao) {
			case 1:
				System.out.println("\nCriar conta\n\n");
				break;
			case 2:
				System.out.println("\nListar todas as contas\n\n");
				break;
			case 3:
				System.out.println("\nConsultar dados da conta (por número)\n\n");
				break;
			case 4:
				System.out.println("\nAtualizar dados da conta\n\n");
				break;
			case 5:
				System.out.println("\nApagar conta\n\n");
				break;
			case 6:
				System.out.println("\nSaque\n\n");
				break;
			case 7:
				System.out.println("\nDepósito\n\n");
				break;
			case 8:
				System.out.println("\nTransferência entre contas\n\n");
				break;
			case 9:
				System.out.print(Cores.TEXT_GREEN_BRIGHT + Cores.ANSI_BLACK_BACKGROUND);
				System.out.println("                                                        ");
				System.out.println("        Banco Braz - Parceria para toda a vida          ");
				System.out.println("                                                        ");
				scan.close();
				System.exit(0);
			default:
				System.out.print(Cores.TEXT_RED_BOLD + Cores.ANSI_BLACK_BACKGROUND);
				System.out.println("                                                        ");
				System.out.println("Opção inválida! Por favor, tente novamente.             ");
				System.out.println("                                                        ");
				System.out.println(Cores.TEXT_RESET);
				break;
			}
		} while (true);
	}
}