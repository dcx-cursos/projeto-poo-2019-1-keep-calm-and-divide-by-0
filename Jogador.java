package bancoMobiliario;

import java.util.Random;


public class Jogador {
	private String nome;
	private String cor;
	private Carteira carteira = new Carteira(1500);
	private int posicao = 0;
	private int diasNaPrisao = 0;
	//private ArrayList<Propriedade> propriedades = new ArrayList<Propriedade>();
	
	Random r = new Random();
	
	public Jogador(String nome, String cor) {
		this.nome = nome;
		this.cor = cor;
	}
	
	public int getPosicao() {
		return this.posicao;
	}
	
	public String getCor() {
		return this.cor;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public int lancaDado() {
		return r.nextInt(6)+1;
	}
	
	public void setPosicao(int numDadoUm, int numDadoDois) {
		this.posicao = numDadoUm+numDadoDois;
	}
	
	public void irParaPrisao() {
		this.diasNaPrisao = 3;
	}
	
	public int getDiasNaPrisao() {
		return this.diasNaPrisao;
	}
	
	public void setDiasNaProsao(int numDias) {
		this.diasNaPrisao -= numDias;
	}
	
	public void compraPropriedade(int valorCompraPropriedade) {
		this.carteira.debitar(valorCompraPropriedade);
		//this.propriedades.add(propriedade);
	}
	}
