package conta;
import java.util.List;
import java.util.Scanner;
import user.Cliente;
import cartao.Cartao;

public class Conta {
	private static int AGENCIA_PADRAO = 18,  BANCO_PADRAO = 2606, SEQUENCIAL = 1;
	protected int agencia, numeroConta, numeroBanco;
	protected double saldo, limite = 0;
	protected String tipoConta;
	protected Cliente cliente;
	protected Cartao cartao;
	protected List<String> registroExtrato;
	
	Scanner scan = new Scanner(System.in);

	public Conta(Cliente cliente) {
		this.agencia = AGENCIA_PADRAO;
		this.numeroConta = SEQUENCIAL++;
		this.numeroBanco = BANCO_PADRAO;
		this.cliente = cliente;
	}
	
	public int getAgencia() {
		return agencia;
	}
	
	public int getNumeroConta() {
		return numeroConta;
	}
	
	public int getNumeroBanco() {
		return numeroBanco;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}
	
	public String gerarFuncao() {
		String resposta = null;
		do{
			System.out.println("Deseja função débito (d), crédito (c) ou múltiplo (m)? ");
			resposta = scan.next().toLowerCase();
			} while(resposta.equalsIgnoreCase("d") == false && resposta.equalsIgnoreCase("c") == false && resposta.equalsIgnoreCase("m") == false);
		return resposta;
	}
	
	public void sacar(double valor) {}
	
	public void depositar(double valor) {}
	
	public void transferir(double valor, Conta contaDestino) {}
	
	public void extrato() {System.out.println(registroExtrato);}
}
