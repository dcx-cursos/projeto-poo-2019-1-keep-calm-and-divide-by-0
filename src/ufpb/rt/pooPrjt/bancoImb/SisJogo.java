package bancoMobiliario;

import java.util.ArrayList;
import java.util.List;

public class SisJogo {
	private ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
	private Tabuleiro tabuleiro = new Tabuleiro();
	private ArrayList<String> cores = new ArrayList<String>();
	//ArrayList<SorteOuReves> cartas = new ArrayList<SorteOuReves>();
	
	/**
	 * 
	 * @param novoJogador informaçoes do novo jogador , nome e cor do seu peao
	 * @throws CorInvalidaException 
	 * @throws JogadorComACorEscolhidaExiteException caso algum outro jogador ja tenha escolhida a mesma cor , visto que nao pode ter jogadores com a mesma cor
	 */
	public void gravaJogador(Jogador novoJogador) throws JogadorComACorEscolhidaExisteException, CorInvalidaException{
		if (ExisteJogadorComEstaCorPiao(novoJogador.getCor())) { // existe jogador que escolheu esta cor
			throw new JogadorComACorEscolhidaExisteException("Esta cor do peão ja foi escolhida");
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
	public void removerCorQueJaFoiEscolhida(String cor) {
		this.cores.remove(cor.toUpperCase());
	}
	
	
	
	public ArrayList<String> getCores() {
		return cores;
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
	
	
	
	public boolean QuantidadeDeJogadores(int Numjogadores) throws NumerosDeJogadoresInvalidoException {
		
		if (Numjogadores > 2 && Numjogadores < 8) {
			
			return true;
		}else {
			throw new NumerosDeJogadoresInvalidoException("Numero de Jogadores invalido");
		}
		
	}
	
	
	/**
	 * 
	 * @return o tabuleiro com todas as posiçoes das companhia e terrenos no qual o jogador pode comprar , e null para as pociçoes especiais como , sorte ou reves, partida ,prisao , prisao como visitante
	 */
	public ArrayList<Propriedade> genetareBoard() {
		return tabuleiro.criartabuleiro();
	}
}
