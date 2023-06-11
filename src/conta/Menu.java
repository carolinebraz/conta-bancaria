package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {
	public static void main(String[] args) {

		ContaController contas = new ContaController();

		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "Alice B", 200000.0f, 10000.0f);
		contas.cadastrar(cc1);

		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 456, 1, "Berenice C", 150000.0f, 15000.0f);
		contas.cadastrar(cc2);

		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 789, 2, "Clarice D", 100000.0f, 15);
		contas.cadastrar(cp1);

		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 101, 2, "Doralice E", 50000.0f, 13);
		contas.cadastrar(cp2);

		Scanner scan = new Scanner(System.in);

		String titular;
		int opcao, numero, agencia, tipo, aniversario;
		float saldo, limite;

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

			try {
				opcao = scan.nextInt();
			} catch (InputMismatchException e) {
				System.out.print(Cores.TEXT_RED_BOLD + Cores.ANSI_BLACK_BACKGROUND);
				System.out.println("                                                        ");
				System.out.println("Opção inválida! Por favor, tente novamente.             ");
				System.out.println("                                                        ");
				System.out.println(Cores.TEXT_RESET);
				scan.nextLine();
				opcao = 0;
			}

			switch (opcao) {
			case 1:
				System.out.println("\nCriar conta\n\n");

				System.out.println("Digite o número da Agência: ");
				agencia = scan.nextInt();

				System.out.println("Digite o nome do Titular: ");
				scan.skip("\\R?");
				titular = scan.nextLine();

				do {
					System.out.println("Digite o tipo da conta [1 - Conta Corrente | 2 - Conta Poupança]: ");
					tipo = scan.nextInt();

				} while (tipo < 1 && tipo > 2);

				System.out.println("Digite o saldo da conta: R$ ");
				saldo = scan.nextFloat();

				switch (tipo) {
				case 1 -> {
					System.out.println("Digite o limite de crédito: R$ ");
					limite = scan.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				case 2 -> {
					System.out.println("Digite o dia do aniversário da conta: ");
					aniversario = scan.nextInt();
					contas.cadastrar(
							new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				}
				}
				keyPress();
				break;
			case 2:
				System.out.println("\nListar todas as contas\n\n");

				contas.listarContas();

				keyPress();
				break;
			case 3:
				System.out.println("\nConsultar dados da conta (por número)\n\n");
				System.out.println("Digite o número da conta: ");
				numero = scan.nextInt();

				contas.procurarPorNumero(numero);

				keyPress();
				break;
			case 4:
				System.out.println("\nAtualizar dados da conta\n\n");

				System.out.println("Digite o número da conta que deseja atualizar: ");
				numero = scan.nextInt();

				if (contas.pesquisarConta(numero) != null) {

					System.out.println("Digite o número da Agência: ");
					agencia = scan.nextInt();

					System.out.println("Digite o nome do Titular: ");
					scan.skip("\\R?");
					titular = scan.nextLine();

					System.out.println("Digite o saldo da conta: R$ ");
					saldo = scan.nextFloat();

					tipo = contas.retornarTipo(numero);

					switch (tipo) {
					case 1 -> {
						System.out.println("Digite o limite de crédito: R$ ");
						limite = scan.nextFloat();
						contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Digite o dia do aniversário da conta: ");
						aniversario = scan.nextInt();
						contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
					}
					default -> {
						System.out.println("Tipo de conta inválido");
					}
					}

				} else {
					System.out.println("A conta nº " + numero + " não foi localizada!");
				}

				keyPress();
				break;
			case 5:
				System.out.println("\nApagar conta\n\n");

				System.out.println("Digite o número da conta que deseja apagar: ");
				numero = scan.nextInt();

				contas.deletar(numero);

				keyPress();
				break;
			case 6:
				System.out.println("\nSaque\n\n");
				keyPress();
				break;
			case 7:
				System.out.println("\nDepósito\n\n");
				keyPress();
				break;
			case 8:
				System.out.println("\nTransferência entre contas\n\n");
				keyPress();
				break;
			case 9:
				System.out.print(Cores.TEXT_GREEN_BRIGHT + Cores.ANSI_BLACK_BACKGROUND);
				System.out.println("                                                        ");
				System.out.println("        Banco Braz - Parceria para toda a vida          ");
				System.out.println("                                                        ");
				scan.close();
				System.exit(0);
			default:
				System.out.print(Cores.TEXT_GREEN_BOLD + Cores.ANSI_BLACK_BACKGROUND);
				System.out.println("                                                        ");
				System.out.println("Escolha uma opção de 1 a 9.                             ");
				System.out.println("                                                        ");
				System.out.println(Cores.TEXT_RESET);
				keyPress();
				break;
			}
		} while (true);
	}

	public static void keyPress() {
		try {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}
}