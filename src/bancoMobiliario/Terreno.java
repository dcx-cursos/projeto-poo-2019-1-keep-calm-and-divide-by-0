package bancoMobiliario;

public class Terreno implements Propriedade {

	private String nome;
	private int precoCompra;
	private int aluguelSemCasa;
	private int aluguelUmaCasa;
	private int aluguelDuasCasas;
	private int aluguelTresCasas;
	private int aluguelQuatroCasas;
	private int aluguelHotel;
	private int hipoteca;
	private int precoCasa;
	private int numCasas;
	private int aluguel;
	private String TIPO = "TERRENO";
	private Jogador dono = null;

	
	/**
	 * 
	 * @param nome , nome do terreno
	 * @param precoCompra , preço para comprar o terreno
	 * @param aluguelSemCasa , preço do aluguel quando nao ha nenhuma casa construida
	 * @param aluguelUmaCasa , preço do aluguel quando ha uma casa construida
	 * @param aluguelDuasCasas , preço do aluguel quando ha duas casa construida
	 * @param aluguelTresCasas , preço do aluguel quando ha tres casa construida
	 * @param aluguelQuatroCasas , preço do aluguel quando ha quatro casa construida
	 * @param aluguelHotel , preço do aluguel quando a um hotel no terreno( somente apos contruir 4 casas)
	 * @param hipoteca , custo para hipotecar o terreno
	 * @param precoCasa , preço para contruir cada casa
	 * @param numCasas  , numero de casas no terreno
	 * @param aluguel , preço pago ao dono quando um jogador cai no seu terreno
	 */
	public Terreno(String nome, int precoCompra, int aluguelSemCasa, int aluguelUmaCasa,
			int aluguelDuasCasas, int aluguelTresCasas, int aluguelQuatroCasas, int aluguelHotel, int hipoteca,
			int precoCasa, int numCasas, int aluguel) {
		this.nome = nome;
		this.precoCompra = precoCompra;
		this.aluguelSemCasa = aluguelSemCasa;
		this.aluguelUmaCasa = aluguelUmaCasa;
		this.aluguelDuasCasas = aluguelDuasCasas;
		this.aluguelTresCasas = aluguelTresCasas;
		this.aluguelQuatroCasas = aluguelQuatroCasas;
		this.aluguelHotel = aluguelHotel;
		this.hipoteca = hipoteca;
		this.precoCasa = precoCasa;
		this.numCasas = numCasas;
		this.aluguel = aluguel;
	}

	/**
	 * @return nome da companhia 
	 */
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return preço para comprar o terreno
	 */
	public int getPrecoCompra() {
		return precoCompra;
	}

	public void setPrecoCompra(int precoCompra) {
		this.precoCompra = precoCompra;
	}
	
	/**
	 * 
	 * @return preço que deve ser pago por outro jogador ao dono quando cair no terreno e nao ha nehuma casa construida
	 */
	public int getAluguelSemCasa() {
		return aluguelSemCasa;
	}

	public void setAluguelSemCasa(int aluguelSemCasa) {
		this.aluguelSemCasa = aluguelSemCasa;
	}

	/**
	 * 
	 * @return preço que deve ser pago por outro jogador ao dono quando cair no terreno e nao ha uma casa construida
	 */
	public int getAluguelUmaCasa() {
		return aluguelUmaCasa;
	}

	public void setAluguelUmaCasa(int aluguelUmaCasa) {
		this.aluguelUmaCasa = aluguelUmaCasa;
	}

	/**
	 * 
	 * @return preço que deve ser pago por outro jogador ao dono quando cair no terreno e nao ha duas casas construida
	 */
	public int getAluguelDuasCasas() {
		return aluguelDuasCasas;
	}

	public void setAluguelDuasCasas(int aluguelDuasCasas) {
		this.aluguelDuasCasas = aluguelDuasCasas;
	}

	/**
	 * 
	 * @returnpreço que deve ser pago por outro jogador ao dono quando cair no terreno e nao ha tres casas construida
	 */
	public int getAluguelTresCasas() {
		return aluguelTresCasas;
	}

	public void setAluguelTresCasas(int aluguelTresCasas) {
		this.aluguelTresCasas = aluguelTresCasas;
	}

	/**
	 * 
	 * @return preço que deve ser pago por outro jogador ao dono quando cair no terreno e nao ha quatro casas construida
	 */
	public int getAluguelQuatroCasas() {
		return aluguelQuatroCasas;
	}

	public void setAluguelQuatroCasas(int aluguelQuatroCasas) {
		this.aluguelQuatroCasas = aluguelQuatroCasas;
	}
	
	/**
	 * 
	 * @return preço que deve ser pago por outro jogador ao dono quando cair no terreno e ha um hotel construido
	 */
	public int getAluguelHotel() {
		return aluguelHotel;
	}

	public void setAluguelHotel(int aluguelHotel) {
		this.aluguelHotel = aluguelHotel;
	}

	/**
	 * 
	 * @return preço para hipotecar o terreno
	 */
	public int getHipoteca() {
		return hipoteca;
	}

	public void setHipoteca(int hipoteca) {
		this.hipoteca = hipoteca;
	}

	/**
	 * 
	 * @return o preço para contruir cada casa
	 */
	public int getPrecoCasa() {
		return precoCasa;
	}

	public void setPrecoCasa(int precoCasa) {
		this.precoCasa = precoCasa;
	}

	/**
	 * 
	 * @return numeros de casas contruidas no terreno
	 */
	public int getNumCasas() {
		return numCasas;
	}

	public void setNumCasas(int numCasas) {
		this.numCasas = numCasas;
	}

	/**
	 * 
	 * @return valor a ser pago pelo outro jogador que caia no terreno que ja tem dono
	 */
	public int getAluguel() {
		return aluguel;
	}

	public void setAluguel(int aluguel) {
		this.aluguel = aluguel;
	}

	/**
	 * @return as informaçoes do dono do terreno
	 */
	public Jogador getDono() {
		return dono;
	}

	@Override
	public void setDono(Jogador dono) {
		this.dono = dono;
	}

	/**
	 * @return verifica se o terreno ja tem dono , se tiver dono retorne true caso nao tenha retorne false
	 */
	public boolean existeDono() {
		if(this.dono != null) {
			return true;
		}
		return false;
	}
	

	public String getInformacoesStatus() {
		return String.valueOf(this.aluguel);
	}

	/**
	 * @return o tipo do terreno
	 */
	public String getTipo() {
		return TIPO;
	}
}

