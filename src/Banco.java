
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import cartao.Cartao;
import cartao.Credito;
import cartao.Debito;
import cartao.Multiplo;
import conta.Conta;
import conta.ContaCorrente;
import conta.ContaPoupanca;
import conta.ContaSalario;
import user.Cliente;

public class Banco {
	private String nome;
	private int numeroBanco;
	private static Map<String, List<Conta>> contasPorCpfEstatico = new HashMap<>();
	
	static Scanner scan = new Scanner(System.in);
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNumeroBanco() {
		return numeroBanco;
	}
	
	private static void adicionarConta(Conta conta, String cpf) {
		boolean clientePreviamenteCadastrado = verificarCpfCadastrado(cpf);
		if(clientePreviamenteCadastrado) {
			for(Map.Entry<String, List<Conta>> entry : contasPorCpfEstatico.entrySet()) {
				entry.getValue().add(conta);
			}
		} else {
			List<Conta> contaAdicionar = new ArrayList<Conta>();
			contaAdicionar.add(conta);
			contasPorCpfEstatico.put(cpf, contaAdicionar);
		}
	}
	
	static boolean verificarCpfCadastrado(String cpf) {
		boolean cpfCadastrado = false;
		if(contasPorCpfEstatico != null && !contasPorCpfEstatico.isEmpty()) {
			for(Map.Entry<String, List<Conta>> entry : contasPorCpfEstatico.entrySet()) {
				if(entry.getKey().equalsIgnoreCase(cpf)) {cpfCadastrado = true;}
			}
		}
		return cpfCadastrado;
	}
	
	static Conta pesquisarConta(int numeroDeConta) {
		Conta resultado = null;
		for(Map.Entry<String, List<Conta>> contas : contasPorCpfEstatico.entrySet()) {
			for(Conta c : contas.getValue()) {
				if(c.getNumeroConta() == numeroDeConta) {
					resultado = c;
					break;
				}
			}
		}
		return resultado;
	}
	
	public static void imprimirContas() {System.out.println(contasPorCpfEstatico);}
	
	public static Map<Conta, Cartao> aberturaConta(String name, String cpf) {
		Conta contaAbertura = null;
		Cartao cartao = null;
		String tipoConta = "";
		while(tipoConta.equalsIgnoreCase("cc") == false && tipoConta.equalsIgnoreCase("cp") == false && tipoConta.equalsIgnoreCase("cs") == false) {
			System.out.println("Informe tipo de conta escolhido (Conta Corrente - cc, Conta Poupança - cp, Conta Salário - cs): ");
			tipoConta = scan.next().toLowerCase();
		}
		if(tipoConta.equalsIgnoreCase("cc")) {
			contaAbertura = new ContaCorrente(new Cliente(name, cpf));
			String funcao = contaAbertura.gerarFuncao();
			if(funcao.equalsIgnoreCase("d")) {cartao = new Debito();}
			else if(funcao.equalsIgnoreCase("c")) {
				System.out.println("Digite o valor do limite do seu cartão de crédito: ");
				contaAbertura.setLimite(scan.nextDouble());
				cartao = new Credito(contaAbertura.getLimite());
			} else {
				System.out.println("Digite o valor do limite do seu cartão multiplo: ");
				contaAbertura.setLimite(scan.nextDouble());
				cartao = new Multiplo(contaAbertura.getLimite());
			}
		} else if(tipoConta.equalsIgnoreCase("cp")) {
			contaAbertura = new ContaPoupanca(new Cliente(name, cpf));
			cartao = new Debito();
		} else {
			contaAbertura = new ContaSalario(new Cliente(name, cpf));
			cartao = new Debito();
		}
		adicionarConta(contaAbertura, cpf);
		Map<Conta, Cartao> cartaoConta = new HashMap<>();
		cartaoConta.put(contaAbertura, cartao);
		return cartaoConta;
		}
}
