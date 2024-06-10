package conta;

import user.Cliente;

public class ContaPoupanca extends Conta{

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}
	
	public void sacar(double valor) {
		String operacao = null;
		if(valor > saldo){System.out.println("Valor superior ao saldo!");} 
		else {
			saldo -= valor;
			System.out.println("\nConta:"+numeroConta+"\nSaque realizado com sucesso! Recolha as cédulas.");
			operacao = ("\nSaque: "+valor+"\nSaldo: "+saldo);
		}
		registroExtrato.add(operacao);
	}
	
	public void depositar(double valor) {
		String operacao = null;
		saldo += valor;
		System.out.println("Depósito realizado com sucesso! \nO valor já está disponível na sua conta.");
		operacao = ("\nConta:"+numeroConta+"\nDeposito: "+valor+"\nSaldo: "+saldo);
		registroExtrato.add(operacao);
	}
	
	public void transferir(double valor, Conta contaDestino) {
		String operacao = null, operacaoDestino = null;
		if(valor > saldo) {System.out.println("Valor superior ao saldo!");}
		else {
			double temp = valor - saldo;
			this.limite -= temp;
			contaDestino.depositar(valor);
			System.out.println("Transferência realizada com sucesso! \nVocê está usando o cheque especial.");
			operacao = ("\nConta:"+this.numeroConta+"\nTransferência: "+valor+"\nSaldo: -"+this.saldo);
			operacaoDestino = ("\nConta:"+contaDestino.numeroConta+"\nTransferência: "+valor+"\nSaldo: -"+contaDestino.saldo);
		}
		registroExtrato.add(operacao);
		registroExtrato.add(operacaoDestino);
	}
	
	public void extrato() {System.out.println(registroExtrato);}
}
