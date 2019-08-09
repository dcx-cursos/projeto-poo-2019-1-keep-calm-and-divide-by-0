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
		if((this.posicao+(numDadoUm+numDadoDois)>39)) {
			this.posicao = (this.posicao+(numDadoUm+numDadoDois)) - 40;
		}else {
			this.posicao += numDadoUm+numDadoDois;
		}
	}
	
	
	public ArrayList<Propriedade> getPropriedades() {
		return propriedades;
	}

	public void setPropriedades(ArrayList<Propriedade> propriedades) {
		this.propriedades = propriedades;
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
	
	public void compraPropriedade(int valorCompraPropriedade, Propriedade propriedade) {
		this.carteira -= valorCompraPropriedade;
		this.propriedades.add(propriedade);
	}
	
	public void vendePropriedade(int valorCompraPropriedade, Propriedade propriedade) {
		this.carteira += valorCompraPropriedade;
		this.propriedades.remove(propriedade);
	}
	
	public int getCarteira() {
		return this.carteira;
	}
	
	public String getStatus(Propriedade propriedade) {
		return "O status de " + this.getNome()+" - " + this.getCor() + " é o seguinte:\n"
				+ "Situado na posição "+this.getPosicao()+" - " + "Nome da propriedade" +"\n"
						+ "Possui "+this.getCarteira() + "$ \n"
								+ "Propriedades " + "Lista de todas as propriedades";
	}

}
