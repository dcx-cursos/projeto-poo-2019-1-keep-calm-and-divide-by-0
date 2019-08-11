package bancoMobiliario;

import java.util.ArrayList;
import java.util.List;

public class SisJogo {
	private ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
	private ArrayList<Propriedade> tabuleiro = new ArrayList<Propriedade>();
	private ArrayList<String> cores = new ArrayList<String>();
	//ArrayList<SorteOuReves> cartas = new ArrayList<SorteOuReves>();
	
	/**
	 * 
	 * @param novoJogador informaçoes do novo jogador , nome e cor do seu peao
	 * @throws CorInvalidaException 
	 * @throws JogadorComACorEscolhidaExiteException caso algum outro jogador ja tenha escolhida a mesma cor , visto que nao pode ter jogadores com a mesma cor
	 */
	public void gravaJogador(Jogador novoJogador) throws JogadorComCorEscolhidaExisteException, CorInvalidaException{
		if (ExisteJogadorComEstaCorPiao(novoJogador.getCor())) { // existe jogador que escolheu esta cor
			throw new JogadorComCorEscolhidaExisteException("Esta cor do peão ja foi escolhida");
		}else if(verificaCorInvalida(novoJogador.getCor())) {
			throw new CorInvalidaException("Esta cor é invlálida. Porfavor tente denovo.");
		}else {// a cor ja foi escolhida
			this.jogadores.add(novoJogador);

		}
	}
	
	/**
	 * 
	 * @param Jogador jogador que deseja sair do jogo
	 * 
	 * metodo que retira um jogador do jogo
	 */
	public void removeJogador(Jogador Jogador) {
		this.jogadores.remove(Jogador);
	}
	
	public void carregaCores() {
		this.cores.add("BRANCO");
		this.cores.add("VERMELHO");
		this.cores.add("VERDE");
		this.cores.add("AZUL");
		this.cores.add("AMARELO");
		this.cores.add("LARANJA");
		this.cores.add("ROSA");
		this.cores.add("PRETO");
	}
	
	/**
	 * 
	 * @param cor que não existe nas opções
	 * @return true
	 * 
	 * verifica se a cor digitada pelo jogador é valida ou não
	 */
	public boolean verificaCorInvalida(String cor) {
		if (cores.contains(cor.toUpperCase())) {
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * @param cor escolhida pelo jogador
	 * @return verifica se a cor digitada pelo jogador ja foi escolhida , caso ja tenha algum jogador com esta cor return true , caso a cor ainda nao foi escolhida retorne false
	 */
	public boolean ExisteJogadorComEstaCorPiao(String cor) {
		boolean bool = false;
		for (int k = 0; k<jogadores.size(); k++) {
			Jogador p = jogadores.get(k);
			if (p.getCor().contains(cor)) {
				bool = true;
			}
		}
		return bool;
	}
	
	public ArrayList<Jogador> getJogadores(){
		return jogadores;
	}
	
	
	/**
	 * 
	 * @return o tabuleiro com todas as posiçoes das companhia e terrenos no qual o jogador pode comprar , e null para as pociçoes especiais como , sorte ou reves, partida ,prisao , prisao como visitante
	 */
	public ArrayList<Propriedade> genetareBoard() {
		this.tabuleiro.add(null);//0 inicio
		this.tabuleiro.add(new Terreno("Leblon", 100, 6, 30, 90, 270, 400, 500, 50, 50, 0, 6 ));//1
		this.tabuleiro.add(null); //2 sorte ou reves
		this.tabuleiro.add(new Terreno("av. Presidente Vargas",60,2,10,30,90,100,250,30,50,0,2 ));
		this.tabuleiro.add(new Terreno("av. Nossa Senhora de Copacabana",60,2,10,30,90,100,250,30,50,0,2 ));
		this.tabuleiro.add(new Companhia("Companhia Ferroviaria",200,100,50 ));
		this.tabuleiro.add(new Terreno("Av. Brigadeiro Faria lima",240,20,100,300,750,925,1100,120,150,0,20 ));
		this.tabuleiro.add(new Companhia("Companhia de Aviaçao",200,100,50 ));
		this.tabuleiro.add(new Terreno("Av. Rebouças",220,18,90,250,700,875,1050,110,150,0,18 ));
		this.tabuleiro.add(new Terreno("AV. 9 de Julho",220,18,90,250,700,875,1050,110,150,0,18 ));
		this.tabuleiro.add(null);//10 prisão como visitante
		this.tabuleiro.add(new Terreno("Av. Europa",200,16,80,220,600,800,1000,100,100,0,16 ));
		this.tabuleiro.add(null);//12 sorte ou reves
		this.tabuleiro.add(new Terreno("Rua Augusta",180,14,70,200,550,750,950,90,100,0,14 ));
		this.tabuleiro.add(new Terreno("Av. Pacaembu",180,14,70,200,550,750,950,90,100,0,14 ));
		this.tabuleiro.add(new Companhia("Companhia de taxi",150,75,40 ));
		this.tabuleiro.add(null);//16 sorte ou reves
		this.tabuleiro.add(new Terreno("Interlagos",350,35,175,500,1100,1300,1500,175,200,0,35 ));
		this.tabuleiro.add(null);//18 lucros e dividendos
		this.tabuleiro.add(new Terreno("Morumbi",400,50,200,600,1400,1700,2000,200,200,0,50 ));
		this.tabuleiro.add(null);//20 parada livre
		this.tabuleiro.add(new Terreno("Flamengo",120,8,40,100,300,450,600,60,50,0,8 ));
		this.tabuleiro.add(null);//22 sorte ou reves
		this.tabuleiro.add(new Terreno("Botafogo",100,6,30,90,270,400,500,50,50,0,6 ));
		this.tabuleiro.add(null);//24 imposto de renda
		this.tabuleiro.add(new Companhia("Companhia de Navegaçao",150,75,40 ));
		this.tabuleiro.add(new Terreno("Av. Brasil",160,12,60,180,500,700,900,80,100,0,12 ));
		this.tabuleiro.add(null);//27 sorte ou reves
		this.tabuleiro.add(new Terreno("Av. Paulista",140,10,50,150,450,625,750,70,100,0,10  ));
		this.tabuleiro.add(new Terreno("Jardim Europa",140,12,60,180,500,700,900,80,100,0,12 ));
		this.tabuleiro.add(null);//30 vai para prisão fica preso por tres rodadas
		this.tabuleiro.add(new Terreno("Copacabana",260,22,110,330,800,975,1150,130,150,0,22 ));
		this.tabuleiro.add(new Companhia("Companhia de Aviaçao",200,100,50 ));
		this.tabuleiro.add(new Terreno("Av. Vieira Souto",320,28,150,450,1000,1200,1400,160,200,0,28 ));
		this.tabuleiro.add(new Terreno("Av. Atlâtica",300,26,130,390,900,1100,1275,150,200,0,26 ));
		this.tabuleiro.add(new Companhia("Companhia de Taxi Aereo",200,100,50 ));
		this.tabuleiro.add(new Terreno("Ipanema",300,26,130,390,900,1100,1275,150,200,0,26 ));
		this.tabuleiro.add(null);//37 sorte ou reves
		this.tabuleiro.add(new Terreno("Jardim Paulista",280,24,120,360,850,1025,1200,140,150,0,24 ));
		this.tabuleiro.add(new Terreno("Brooklin",260,22,110,330,800,975,1150,130,150,0,22 ));
		return tabuleiro;
	}
}
