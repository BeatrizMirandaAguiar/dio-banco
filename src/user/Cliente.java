package user;

import java.util.Random;

public class Cliente {
	private static int AGENCIA_PADRAO = 18;
	private String cpf;
	private int agencia;
	private int numeroConta;
	private double saldo;
	private String titular;
	
	public Cliente(String titular, String cpf) {
		this.agencia = AGENCIA_PADRAO;
		this.numeroConta = new Random().nextInt(100,100000);
		this.saldo = 0;
		this.titular = titular;
		this.cpf = cpf;
	}
	
	public int getAgencia() {
		return agencia;
	}
	
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	
	public int getNumeroConta() {
		return numeroConta;
	}
	
	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public String getTitular() {
		return titular;
	}
	
	public void setTitular(String titular) {
		this.titular = titular;
	}
	
}
