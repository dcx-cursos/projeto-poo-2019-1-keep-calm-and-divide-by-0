package ufpb.rt.pooPrjt.bancoImb.principal;

import java.util.ArrayList;
import java.util.Random;
import ufpb.rt.pooPrjt.bancoImb.exceptions.DinheiroInsuficienteException;
import ufpb.rt.pooPrjt.bancoImb.exceptions.SemCartasDeSairDaPrisao;
import ufpb.rt.pooPrjt.bancoImb.interfaces.Propriedade;
import ufpb.rt.pooPrjt.bancoImb.interfaces.SorteOuReves;


public class Jogador  {
	private String nome;
	private String cor;
	private int carteira = 1500;
	private int posicao = 0;
	private int diasNaPrisao = 0;
	private int vezesQueTirouDadosIguais = 0;
	private ArrayList<Propriedade> propriedades = new ArrayList<Propriedade>();
	private ArrayList<SorteOuReves> cartaPrisao;
	
	
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
	 * @return retorna um valor aleatorio de um dado de 6 lados
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
	 * quando o jogador conseguir dois números iguais no dado, um contador é incrementado representando as vezes em que isso ocorreu
	 */
	public int andarCasas(int numDadoI, int numDadoII) {
		int numDados = numDadoI+numDadoII;
		if((numDados%2)==0 && this.diasNaPrisao==0) {
			vezesQueTirouDadosIguais+=1;
		}
		
		if((this.posicao+(numDados)>39)) {
			this.posicao = (this.posicao+(numDados)) - 40;
			this.carteira += 200;
		}else {
			this.posicao += numDados;
		}
		return numDados;
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
		this.posicao = 10;
	}
	

	public void sairDaPrisao() {
		this.diasNaPrisao = 0;
		
	}
	
	/**
	 * 
	 * @return dias que o jogador esta preso
	 */
	public int getDiasNaPrisao() {
		return this.diasNaPrisao;
	}
	
	public void setCartaPrisao(SorteOuReves carta) {
		this.cartaPrisao.add(carta);
		
	}
	
	public void usarCartaPrisao() throws SemCartasDeSairDaPrisao {
		if(cartaPrisao==null) {
			throw new SemCartasDeSairDaPrisao("Você não tem cartas para sair da prisão.");
		}else {
			cartaPrisao.get(0).acao(this);
			cartaPrisao.remove(0);
		}
	}

	public void pagarParaSairDaPrisao(int fianca) throws DinheiroInsuficienteException {
		if(this.carteira<fianca) {
			throw new DinheiroInsuficienteException("Você não tem saldo suficiente.");
		}else {
			debitar(fianca);
			sairDaPrisao();
		}
		
	}

	public void setDiaPassadoNaPrisao(int dia) {
		this.diasNaPrisao-=1;
		
	}
	
	/**
	 * 
	 * @param valorCompraPropriedade valor para comprar a propriedade
	 * @param propriedade propriedade no qual o jogador deseja comprar
	 * 
	 * metodo para realizar a compra de uma propriedade no tabuleiro
	 * @throws DineheiroInsuficienteException caso o jogador nao tenha dineheiro suficiente para comparar a propriedade
	 * este metodo deve realizar a venda de uma propriedade 
	 */
	public void compraPropriedade(int valorCompraPropriedade, Propriedade propriedade) throws DinheiroInsuficienteException {
		if (this.carteira < valorCompraPropriedade) {
			throw new DinheiroInsuficienteException("Jogador não possui dinheiro sufiente para comprar a propriedade");
		}else {
			this.carteira -= valorCompraPropriedade;
			this.propriedades.add(propriedade);
			propriedade.setDono(this);
			
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
	 * 
	 * @param propriedades recebe a lista de todas as propriedades
	 * @return o status do jogador de acordo com a sua posiçao 
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
						propriedadesJogador += "["+propriedade.getNome()+"] - propriedade "+this.cor+", aluguel "+propriedade.getInformacoesStatus()+"\n";
					}else {//Se não é então é companhia
						propriedadesJogador += "["+propriedade.getNome()+"] - multiplicador "+propriedade.getInformacoesStatus()+"\n";
					}
			}
		}
		
		if(this.posicao==0) {
			return "O status de " + this.nome+" - " + this.cor + " é o seguinte:\n"
					+ "Situado na posição "+this.posicao+" - Inicio\n"
							+ "Possui "+this.getCarteira() + "$ \n"
									+ "Títulos:\n" + propriedadesJogador;
			
		}else if(this.posicao==10) {
			return "O status de " + this.nome+" - " + this.cor + " é o seguinte:\n"
					+ "Situado na posição "+this.posicao+" - Prisão\n"
							+ "Possui "+this.getCarteira() + "$ \n"
									+ "Títulos:\n" + propriedadesJogador;
			
		}else if((this.posicao==2|this.posicao==12)|(this.posicao==16|this.posicao==22)|(this.posicao==27|this.posicao==37)){
			return "O status de " + this.nome+" - " + this.cor + " é o seguinte:\n"
					+ "Situado na posição "+this.posicao+" - Sorte ou Reves\n"
							+ "Possui "+this.getCarteira() + "$ \n"
									+ "Títulos:\n" + propriedadesJogador;
			
		}else if((this.posicao!=18 && this.posicao!=20)&&(this.posicao!=24&&this.posicao!=30)) {//Excluí todas as posições que são null. Podem haver modificações pra ela retornar somente o nome dessas posições 
			return "O status de " + this.nome+" - " + this.cor + " é o seguinte:\n"
					+ "Situado na posição "+this.posicao+" - "+localPropriedade.getNome()+"\n"
							+ "Possui "+this.getCarteira() + "$ \n"
									+ "Títulos:\n" + propriedadesJogador;
		}else {//Se for uma dessas então retorne...
			return "O status de " + this.nome+" - " + this.cor + " é o seguinte:\n"
					+ "Situado na posição "+this.posicao+"\n"
							+ "Possui "+this.getCarteira() + "$ \n"
									+ "Títulos:\n" + propriedadesJogador;
		}
	}

	public void debitar(int valor) {
		this.carteira-=valor;
		
	}

	public void creditar(int valor) {
		this.carteira+=valor;
		
	}

	public void setPosicao(int posi) {
		this.posicao = posi;
		
	}	

}
