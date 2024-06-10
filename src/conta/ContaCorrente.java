package conta;

import user.Cliente;

public class ContaCorrente extends Conta{

	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}
	
	public void sacar(double valor) {
		String operacao = null;
		if(valor > saldo){
			if(cartao.getFuncao().equalsIgnoreCase("credito")) {
				if(valor > (saldo + limite)) {
					System.out.println("Valor superior ao saldo e ao limite!");
				} else {
					double temp = valor - saldo;
					limite -= temp;
					saldo -= valor;
					System.out.println("Saque realizado com sucesso! Recolha as cédulas. \nVocê está usando o cheque especial.");
					operacao = ("\nConta:"+numeroConta+"\nSaque: "+valor+"\nSaldo: -"+saldo);
				}
			} else {System.out.println("Saldo insuficiente para saque!\n Contate sua agência caso deseje a opção de crédito.");}
		} else {
			saldo -= valor;
			operacao = ("\nConta:"+numeroConta+"\nSaque: "+valor+"\nSaldo: "+saldo);
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
		this.sacar(valor);
		contaDestino.depositar(valor);
		if(valor > saldo){
			if(cartao.getFuncao().equalsIgnoreCase("credito")) {
				if(valor > (saldo + limite)) {
					System.out.println("Valor superior ao saldo e ao limite!");
				} else {
					this.limite -= valor - saldo;
					saldo -= valor;
					contaDestino.depositar(valor);
					System.out.println("Transferência realizada com sucesso! \nVocê está usando o cheque especial.");
					operacao = ("\nConta:"+this.numeroConta+"\nTransferência: "+valor+"\nSaldo: -"+this.saldo);
					operacaoDestino = ("\nConta:"+contaDestino.numeroConta+"\nTransferência: "+valor+"\nSaldo: -"+contaDestino.saldo);
				}
			} else {System.out.println("Saldo insuficiente para transferência!\n Contate sua agência caso deseje a opção de crédito.");}
		} else {
			this.saldo -= valor;
			operacao = ("\nConta:"+numeroConta+"\nTrasferência: "+valor+"\nSaldo: "+this.saldo);
			operacaoDestino = ("\nConta:"+contaDestino.numeroConta+"\nTransferência: "+valor+"\nSaldo: -"+contaDestino.saldo);
		}
		registroExtrato.add(operacao);
		registroExtrato.add(operacaoDestino);
	}
	public void extrato() {}
}
