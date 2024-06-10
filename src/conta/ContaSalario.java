package conta;

import user.Cliente;

public class ContaSalario extends Conta{

	public ContaSalario(Cliente cliente) {
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
	
	public void depositar(double valor) {System.out.println("Operação indisponíevel para esse tipo de conta.");}
	
	public void transferir(double valor, Conta contaDestino) {System.out.println("Operação indisponíevel para esse tipo de conta.");}
	
	public void extrato() {System.out.println(registroExtrato);}
}
