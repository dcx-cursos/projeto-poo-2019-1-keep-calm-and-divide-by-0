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
	
	/**
	 * Testar o metodo para ver se funciona desta forma
	 * Algumas condições do metodo podem ser realocadas no main
	 */
	public String getStatus(Jogador jogador ,ArrayList<Propriedade> propriedades) {
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

}
