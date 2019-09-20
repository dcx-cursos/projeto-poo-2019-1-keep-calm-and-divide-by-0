package ufpb.rt.pooPrjt.bancoImb.logradouros;

import ufpb.rt.pooPrjt.bancoImb.interfaces.Propriedade;
import ufpb.rt.pooPrjt.bancoImb.principal.Jogador;

public class Companhia implements Propriedade {
	
	private String nome;
	private int precoCompra;
	private int hipoteca;
	private int multiplicador;
	private String cor;
	private Jogador dono = null;
	private String TIPO = "COMPANHIA";

	
	
	/**
	 * 
	 * @param nome nome da companhia
	 * @param precoCompra preço para comprar 
	 * @param hipoteca preço da hipoteca 
	 * @param multiplicador multplicador da companhia ( valor que deve dser multiplicado pelo a soma dos dados do jogador)
	 */
	public Companhia(String nome, int precoCompra, int hipoteca, int multiplicador ) {
		this.nome = nome;
		this.precoCompra = precoCompra;
		this.hipoteca = hipoteca;
		this.multiplicador = multiplicador;

	}


	
	/**
	 * retorna o nome da companhia
	 */
	public String getNome() {
		return nome;
	}


	
	/**
	 * retorna o preço para a compra 
	 */
	public int getPrecoCompra() {
		return precoCompra;
	}


	
	/**
	 * 
	 * @return preço da hiṕoteca
	 */
	public int gethipoteca() {
		return hipoteca;
	}

	/**
	 * 
	 * @return valor q vai ser mulplicado o valor da somas dos resultados dos dados
	 */
 	public int getMultiplicador() {
		return multiplicador;
	}
	
 	
 	/**
 	 * quando o jogador cai em uma companhia que nao seja sua ele deve pagar uma taxa que sera calculada nesse metodo
 	 */
	public void pagamentoDeTaxa(Jogador jogadorVisitante, int numDados) {
		int valorPagamento = getMultiplicador()*numDados;
		jogadorVisitante.debitar(valorPagamento);
		this.dono.creditar(valorPagamento);
	}

	
	/**
	 * retorna o dono da companhia
	 */
	public Jogador getDono() {
		return dono;
	}

	
	/**
	 * muda o dono da companhia
	 */
	public void setDono(Jogador dono) {
		this.dono = dono;
	}

	@Override
	public String toString() {
		return "Companhia :" + nome + ", preco para compra=" + precoCompra + ", hipoteca :"
				+ hipoteca + ", multiplicador : " + multiplicador + ", dono : " + dono ;
	}


	/**
	 * verifica se a companhia tem dono
	 */
	public boolean existeDono() {
		if(this.dono != null) {
			return true;
		}
		return false;
	}
	
	public String getInformacoesStatus() {
		return String.valueOf(this.multiplicador);
	}


	/**
	 * mostra o tipo da classe
	 */
	public String getTipo() {
		return TIPO;
	}


	
	public int valorAserPagoParaODonoDaCompanhia(int numDados) {
		return this.multiplicador * numDados;
	}


	/**
	 * valor que o dono deve receber de outro jogador
	 */
	public int valorAserPagoParaODonoDoTerreno() {
		return 0;
	}



	@Override
	public String getCor() {
		// TODO Auto-generated method stub
		return this.cor;
	}

}
