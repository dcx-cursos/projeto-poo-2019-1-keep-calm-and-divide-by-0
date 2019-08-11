package bancoMobiliario;

import java.util.ArrayList;
import java.util.Random;


public class Jogador  {
	private String nome;
	private String cor;
	private int carteira = 1500;
	private int posicao = 0;
	private int diasNaPrisao = 0;
	private ArrayList<Propriedade> propriedades = new ArrayList<Propriedade>();
	
	Random r = new Random();
	
	
	/**
	 * 
	 * @param nome nome do jogador
	 * @param cor a cor do jogador
	 */
	public Jogador(String nome, String cor) {
		this.nome = nome;
		this.cor = cor;
	}
	
	/**
	 * 
	 * @return posiçao atual do jogador
	 */
	public int getPosicao() {
		return this.posicao;
	}
	
	/**
	 * 
	 * @return cor escolhida pelo jogador
	 */
	public String getCor() {
		return this.cor;
	}
	
	/**
	 * 
	 * @return nome do jogador
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * 
	 * @return retorna o valor do dado
	 */
	public int lancaDado() {
		return r.nextInt(6)+1;
	}
	
	/**
	 * 
	 * @param numDadoUm valor do primeiro dado jogado
	 * @param numDadoDois valor do segundo dado jogado
	 * 
	 * 
	 * metodo para mudar a posiçao do jogador , soma o reultado dos dados e avança o jogador 
	 * caso a soma dos dados for superior a 40 , diminua 40 , indicando que o jagador deu uma volta completa no tabuleiro
	 */
	public void setPosicao(int numDadoUm, int numDadoDois) {
		if((this.posicao+(numDadoUm+numDadoDois)>39)) {
			this.posicao = (this.posicao+(numDadoUm+numDadoDois)) - 40;
		}else {
			this.posicao += numDadoUm+numDadoDois;
		}
	}
	
	/**
	 * 
	 * @return uma lista de todas as propriedades que pertence ao jogador
	 */
	public ArrayList<Propriedade> getPropriedades() {
		return propriedades;
	}

	public void setPropriedades(ArrayList<Propriedade> propriedades) {
		this.propriedades = propriedades;
	}

	/**
	 *  caso o jogador va para prisao ele deve ficar la por 3 dias
	 */
	public void irParaPrisao() {
		this.diasNaPrisao = 3;
	}
	
	/**
	 * 
	 * @return dias que o jogador esta preso
	 */
	public int getDiasNaPrisao() {
		return this.diasNaPrisao;
	}
	
	public void setDiasNaProsao(int numDias) {
		this.diasNaPrisao -= numDias;
	}
	
	/**
	 * 
	 * @param valorCompraPropriedade valor para comprar a propriedade
	 * @param propriedade propriedade no qual o jogador deseja comprar
	 * 
	 * metodo para realizar a compra de uma propriedade no tabuleiro
	 * @throws DineheiroInsuficienteException caso o jogador nao tenha dineheiro suficiente para comparar a propriedade
	 */
	public void compraPropriedade(int valorCompraPropriedade, Propriedade propriedade) throws DineheiroInsuficienteException {
		if (this.carteira < valorCompraPropriedade) {
			throw new DineheiroInsuficienteException("Jogador não possui dinheiro sufiente para comprar a propriedade");
		}else {
			this.carteira -= valorCompraPropriedade;
			this.propriedades.add(propriedade);
			
		}
		
	}
	
	/**
	 * 
	 * @param valorCompraPropriedade valor para vender sua propriedade
	 * @param propriedade propriedade no qual o jogador que vender
	 */
	public void vendePropriedade(int valorCompraPropriedade, Propriedade propriedade) {
		this.carteira += valorCompraPropriedade;
		this.propriedades.remove(propriedade);
	}
	
	/**
	 * 
	 * @return total de dinheiro que o jogador possui
	 */
	public int getCarteira() {
		return this.carteira;
	}
	
	/**
	 * Testar o metodo para ver se funciona desta forma
	 * Algumas condições do metodo podem ser realocadas no main
	 */
	public String getStatus(ArrayList<Propriedade> propriedades) {
		Propriedade localPropriedade = propriedades.get(this.posicao);//Propriedade do local do jogador
		String propriedadesJogador = "";//Variavel para guardar o nome das propriedades que o jogador possui
		if(this.propriedades.isEmpty()) {//Se o vetor de propriedades do jogador estiver vazio faça...
			propriedadesJogador += "Jogador não tem nenhuma propriedade ainda\n";
			
		}else {// Se não estiver vazio faça...
			for(int i = 0; i <this.propriedades.size(); i++) {
				Propriedade propriedade = this.propriedades.get(i);//Propriedade da lista de propriedades que o jogador possui
					if(propriedade.getTipo().equals("TERRENO")) {//Se for fo tipo TERRENO faça
						propriedadesJogador += "["+propriedade.getNome()+"] - propriedade "+this.cor+", aluguel "+propriedade.getInformacoesStatus();
					}else {//Se não é então é companhia
						propriedadesJogador += "["+propriedade.getNome()+"] - multiplicador "+propriedade.getInformacoesStatus();
					}
			}
		}
		
		if((getPosicao()!=0 && getPosicao()!=2)&&(getPosicao()!=12 && getPosicao()!=16)&&(getPosicao()!=18 && getPosicao()!=20)
				&&(getPosicao()!=24 && getPosicao()!=27)&&(getPosicao()!=30 && getPosicao()!=37)) {//Excluí todas as posições que são null. Podem haver modificações pra ela retornar somente o nome dessas posições 
			return "O status de " + this.nome+" - " + this.cor + " é o seguinte:\n"
					+ "Situado na posição "+this.getPosicao()+" - "+localPropriedade.getNome()+"\n"
							+ "Possui "+this.getCarteira() + "$ \n"
									+ "Títulos:\n" + propriedadesJogador;
			
		}else {//Se for uma dessas então retorne...
			return "O status de " + this.nome+" - " + this.cor + " é o seguinte:\n"
					+ "Situado na posição "+this.getPosicao()+"\n"
							+ "Possui "+this.getCarteira() + "$ \n"
									+ "Títulos:\n" + propriedadesJogador;
		}
	}

	public void setCarteira(int carteira) {
		this.carteira = carteira;
	}
	

}

