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
		// conta.setNumero(gerarNumero());
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

	}

	@Override
	public void depositar(int numero, float valor) {

	}

	@Override
	public void transferir(int contaOrigem, int contaDestino, float valor) {

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