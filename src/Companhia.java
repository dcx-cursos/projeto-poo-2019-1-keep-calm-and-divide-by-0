
public class Companhia implements Posicionavel, Propriedade {

	private String nome;
	private int posicao;
	private int precoCompra;
	private int Hipoteca;
	private int Multiplicador;
	private Jogador dono = null;

	public Companhia(String nome, int posicao, int precoCompra, int hipoteca, int multiplicador ) {
		this.nome = nome;
		this.posicao = posicao;
		this.precoCompra = precoCompra;
		Hipoteca = hipoteca;
		Multiplicador = multiplicador;

	}

	

	public int getPosicao() {
		return posicao;
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

	public void setposicao(int posicao) {
		this.posicao = posicao;
	}

	public Jogador getDono() {
		return dono;
	}

	public void setDono(Jogador dono) {
		this.dono = dono;
	}



	@Override
	public String toString() {
		return "Companhia :" + nome + ", posicao : " + posicao + ", preco para compra=" + precoCompra + ", Hipoteca :"
				+ Hipoteca + ", Multiplicador : " + Multiplicador + ", dono : " + dono ;
	}
	
	

}
