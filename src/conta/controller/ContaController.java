package conta.controller;

import java.util.ArrayList;
import conta.model.Conta;
import conta.repository.IContaRepository;

public class ContaController implements IContaRepository {

	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0;

	@Override
	public void procurarPorNumero(int numero) {
		var conta = pesquisarConta(numero);

		if (conta != null) {
			conta.visualizar();
		} else {
			System.out.println("\nA conta nº " + numero + " não foi localizada!");
		}
	}

	@Override
	public void listarContas() {
		for (var conta : listaContas) {
			conta.visualizar();
		}
	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("A conta nº " + conta.getNumero() + " foi criada com sucesso!");
	}

	@Override
	public void atualizar(Conta conta) {
		var pesquisaConta = pesquisarConta(conta.getNumero());

		if (pesquisaConta != null) {
			listaContas.set(listaContas.indexOf(pesquisaConta), conta);
			System.out.println("A conta nº " + conta.getNumero() + " foi atualizada com sucesso!");
		} else {
			System.out.println("\nA conta nº " + conta.getNumero() + " não foi localizada!");
		}
	}

	@Override
	public void deletar(int numero) {
		var conta = pesquisarConta(numero);

		if (conta != null) {
			listaContas.remove(conta);
			System.out.println("A conta nº " + numero + " foi apagada com sucesso!");
		} else {
			System.out.println("\nA conta nº " + numero + " não foi localizada!");
		}
	}

	@Override
	public void sacar(int numero, float valor) {
		var conta = pesquisarConta(numero);

		if (conta != null) {
			if (conta.sacar(valor) == true)
				System.out.printf("\nO saque foi realizado com sucesso! Valor retirado R$ %.2f", valor);

		} else {
			System.out.println("\nNão é possível sacar! Conta nº " + numero + " não encontrada.");
		}
	}

	@Override
	public void depositar(int numero, float valor) {
		var conta = pesquisarConta(numero);

		if (conta != null) {
			conta.depositar(valor);
			System.out.printf("\nO depósito foi realizado com sucesso! Valor depositado R$ %.2f", valor);

		} else {
			System.out.println("\nNão é possível depositar! Conta nº " + numero + " não encontrada.");
		}
	}

	@Override
	public void transferir(int cOrigem, int cDestino, float valor) {
		var contaOrigem = pesquisarConta(cOrigem);
		var contaDestino = pesquisarConta(cDestino);

		if (contaOrigem != null && contaDestino != null) {
			if (contaOrigem.sacar(valor) == true) {
				contaDestino.depositar(valor);
				System.out.println("\nTransferência realizada com sucesso!");
			}
		} else {
			System.out.println("As contas de origem e/ou destino não foram encontradas.");
		}

	}

	public int gerarNumero() {
		return ++numero;
	}

	public Conta pesquisarConta(int numero) {
		for (var conta : listaContas) {
			if (conta.getNumero() == numero) {
				return conta;
			}
		}
		return null;
	}

	public int retornarTipo(int numero) {
		for (var conta : listaContas) {
			if (conta.getNumero() == numero) {
				return conta.getTipo();
			}
		}
		return 0;
	}
}