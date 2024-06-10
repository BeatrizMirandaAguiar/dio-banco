import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import cartao.Cartao;
import conta.Conta;

public class Main {
	
	public static void main(String[] args) {
		
		Banco.aberturaConta("Laura", "20");
		Banco.aberturaConta("Maria", "24");
		Banco.aberturaConta("Mario", "26");
		Banco.aberturaConta("Antunes", "23");
		Banco.aberturaConta("Laura", "20");
		Banco.aberturaConta("Gabriela", "29");
		Banco.aberturaConta("Maria", "24");
		Banco.aberturaConta("Paulo", "21");
		Banco.aberturaConta("Vinicius", "27");
		Scanner scan = new Scanner(System.in);
		
		boolean continuarAtendimento = true;
		System.out.println("Bem vindo ao atendimento do BANCO JAVA!\nVocê deve ser novo por aqui. "
				+ "Eu sou Javete, a atendente virtual, e estou aqui para te auxiliar nos primeiros passos dentro do nosso banco."
				+ "Primeiramente, como você se chama? ");
		String name = scan.next();
		System.out.println("É um prazer atendê-lo(a), "+name+"!\n"+name+", você poderia me informar seu CPF? ");
		String cpf = scan.next();
		System.out.printf("Agora vamos abrir sua conta e solicitar seu cartão. \nPreparado(a), %s?(y/n) ",name);
		String resposta = scan.next().toLowerCase();
		if(resposta.equalsIgnoreCase("y") == true || resposta.equalsIgnoreCase("yes") == true || resposta.equalsIgnoreCase("s") == true || resposta.equalsIgnoreCase("sim") == true) {System.out.println("Vamos lá!");}
		else {System.out.println("Não fique assim, vai dar certo! Você só precisa responder algumas perguntas é bem rápido...");}
		Map<Conta, Cartao> contaCartao = new TreeMap<>();
		Conta conta = null;
		Cartao cartao = null;
		contaCartao = Banco.aberturaConta(name, cpf);
		for(Map.Entry<Conta, Cartao> entry : contaCartao.entrySet()) {
			conta = entry.getKey();
			cartao = entry.getValue();
		}
		
		System.out.println("Tudo certo! Sua conta já está pronta para uso! Se dirija ao caixa eletrônico para fazer suas movimenações.");
		do {
			System.out.println("\nDigite...\n1 para Depósito\n2 para Saque\n3 para Transferência\n4 para Extrato\n5 para Contas\n0 para Sair. ");
			if(scan.nextInt() == 0) {
				System.out.println("Fim do atendimento! Obrigada pela preferência.");
				continuarAtendimento = false;
			} else if(scan.nextInt() == 1) {
				System.out.println("Digite o valor do depósito: ");
				
				conta.depositar(scan.nextDouble());
			} else if(scan.nextInt() == 2) {
				System.out.println("Digite o valor do depósito: ");
				conta.depositar(scan.nextDouble());
			} else if(scan.nextInt() == 3) {
				System.out.println("Digite o valor da transferência: ");
				double valor = scan.nextDouble();
				System.out.println("Digite o número da conta de destino: ");
				int contaDestino = scan.nextInt();
				conta.transferir(valor, Banco.pesquisarConta(contaDestino));
			} else if(scan.nextInt() == 4) {conta.extrato();}
			else if(scan.nextInt() == 5) {Banco.imprimirContas();}
			else {System.out.println("Opção inválida");}
		} while(continuarAtendimento);
		scan.close();
	}

}
