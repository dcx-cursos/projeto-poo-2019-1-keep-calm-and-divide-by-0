package bancoMobiliario;

public class Carteira {
	
	private int quantia;
	
	public Carteira(int valor) {
		this.quantia = valor;
	}
	
	public void debitar(int valor) {
		this.quantia -= valor;
	}
	
	public void creditar(int valor) {
		this.quantia += valor;
	}

}
