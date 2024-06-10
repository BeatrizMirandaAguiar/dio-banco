package cartao;


public class Credito extends Cartao{
	private double limite;
	
	public Credito(double limite) {
		super();
		this.limite = limite;
		this.funcao = "credito";
	}

	public double getLimite() {
		return limite;
	}
}
