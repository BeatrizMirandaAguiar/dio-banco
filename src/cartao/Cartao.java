package cartao;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public abstract class Cartao {
	protected BigInteger numeroCartao;
	protected int cvv;
	protected String funcao;
	protected double saldo;
	
	Scanner scan = new Scanner(System.in);
	
	public BigInteger gerarNumeroCartao() {
		BigInteger numeroCartao = new BigInteger(new Random().nextInt(13,16), new Random());
		while(numeroCartao.compareTo(new BigInteger("10000000000000"))>=0) {
			numeroCartao = new BigInteger(new Random().nextInt(13,16), new Random());
		}
		return numeroCartao;
	}
	
	public Cartao() {
		this.numeroCartao = gerarNumeroCartao();
		this.cvv = new Random().nextInt(1,999);
	}

	public String getFuncao() {
		return funcao;
	}
}
