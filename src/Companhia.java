package bancoMobiliario;

public class Companhia implements InterfCompanhia {
	
	private String nome;
	private int precoCompra;
	private int Hipoteca;
	private int Multiplicador;
	private Jogador dono = null;
	private String TIPO = "COMPANHIA";

	public Companhia(String nome, int precoCompra, int hipoteca, int multiplicador ) {
		this.nome = nome;
		this.precoCompra = precoCompra;
		Hipoteca = hipoteca;
		Multiplicador = multiplicador;

	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPrecoCompra() {
		return precoCompra;
	}

	public void setPrecoCompra(int precoCompra) {
		this.precoCompra = precoCompra;
	}

	public int getHipoteca() {
		return Hipoteca;
	}

	public void setHipoteca(int hipoteca) {
		Hipoteca = hipoteca;
	}

	public int getMultiplicador() {
		return Multiplicador;
	}

	public void setMultiplicador(int multiplicador) {
		Multiplicador = multiplicador;
	}

	public Jogador getDono() {
		return dono;
	}

	public void setDono(Jogador dono) {
		this.dono = dono;
	}

	@Override
	public String toString() {
		return "Companhia :" + nome + ", preco para compra=" + precoCompra + ", Hipoteca :"
				+ Hipoteca + ", Multiplicador : " + Multiplicador + ", dono : " + dono ;
	}


	@Override
	public boolean existeDono() {
		if(this.dono != null) {
			return true;
		}
		return false;
	}


	@Override
	public String getTipo() {
		return TIPO;
	}

}
