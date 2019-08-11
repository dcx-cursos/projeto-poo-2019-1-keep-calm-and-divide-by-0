package bancoMobiliario;

public class Companhia implements Propriedade {
	
	private String nome;
	private int precoCompra;
	private int Hipoteca;
	private int Multiplicador;
	private Jogador dono = null;
	private String TIPO = "COMPANHIA";

	/**
	 * 
	 * @param nome ,nome da companhia
	 * @param precoCompra ,preço de compra da companhia 
	 * @param hipoteca , quanto custa para hipotecar a companhia
	 * @param multiplicador , multiplica o valor do dado tirado pelo jogador para saber quanto ele deve pagar ao dono 
	 */
	public Companhia(String nome, int precoCompra, int hipoteca, int multiplicador ) {
		this.nome = nome;
		this.precoCompra = precoCompra;
		this.Hipoteca = hipoteca;
		this.Multiplicador = multiplicador;

	}


	/**
	 * @return retorna o nome da companhia
	 */
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	/**
	 * @return retorna o preço para comprar a companhia
	 */
	public int getPrecoCompra() {
		return precoCompra;
	}

	public void setPrecoCompra(int precoCompra) {
		this.precoCompra = precoCompra;
	}

	/**
	 * 
	 * @return preço da hipoteca da companhia
	 */
	public int getHipoteca() {
		return Hipoteca;
	}

	public void setHipoteca(int hipoteca) {
		Hipoteca = hipoteca;
	}

	/**
	 * 
	 * @return retorna da multiplicador da companhia
	 */
	public int getMultiplicador() {
		return Multiplicador;
	}

	public void setMultiplicador(int multiplicador) {
		Multiplicador = multiplicador;
	}
	
	/**
	 * @return retorna o nome do dono da companhia
	 */
	public Jogador getDono() {
		return dono;
	}

	public void setDono(Jogador dono) {
		this.dono = dono;
	}

	

	/**
	 * @return , retorna todas as informaçoes desta companhia , tais como o nome , preço , hipoteca , seu multiplicador e seu dono 
	 */
	public String toString() {
		return "Companhia :" + nome + ", preco para compra=" + precoCompra + ", Hipoteca :"
				+ Hipoteca + ", Multiplicador : " + Multiplicador + ", dono : " + dono ;
	}


	/**
	 * @return caso a companhia tenha um dono o metodo retorna true, caso não tenha dono deve retorna false
	 * 
	 */
	public boolean existeDono() {
		if(this.dono != null) {
			return true;
		}
		return false;
	}
	
	
	public String getInformacoesStatus() {
		return String.valueOf(this.Multiplicador);
	}


	
	public String getTipo() {
		return TIPO;
	}

}

