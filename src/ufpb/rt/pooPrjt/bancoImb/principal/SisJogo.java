package ufpb.rt.pooPrjt.bancoImb.principal;

import java.util.ArrayList;
import java.util.List;

import ufpb.rt.pooPrjt.bancoImb.exceptions.CorInvalidaException;
import ufpb.rt.pooPrjt.bancoImb.exceptions.JogadorComCorEscolhidaExisteException;
import ufpb.rt.pooPrjt.bancoImb.interfaces.Propriedade;
import ufpb.rt.pooPrjt.bancoImb.interfaces.SorteOuReves;
import ufpb.rt.pooPrjt.bancoImb.logradouros.Companhia;
import ufpb.rt.pooPrjt.bancoImb.logradouros.Terreno;
import ufpb.rt.pooPrjt.bancoImb.metodosUtilirarios.Gravador;
import ufpb.rt.pooPrjt.bancoImb.metodosUtilirarios.Removedor;
import ufpb.rt.pooPrjt.bancoImb.metodosUtilirarios.Verificador;

public class SisJogo {
	private ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
	private int quantidadeDeJogadores = 0;
	private ArrayList<Propriedade> tabuleiro = new ArrayList<Propriedade>();
	private ArrayList<String> cores = new ArrayList<String>();
	private ArrayList<SorteOuReves> baralho = new ArrayList<SorteOuReves>();
	
	private BaralhoCartas cartasSorteOuReves = new BaralhoCartas();
	private Gravador gravador = new Gravador();
	private Removedor removedor = new Removedor();
	private Verificador verificador = new Verificador();
	private Tabuleiro sisTabuleiro = new Tabuleiro();
	
	public void gerarBaralho() {
		this.baralho = cartasSorteOuReves.gerarBaralhoEmbaralhado();
	}
	
	
	public boolean jogadaValidaJogadorPrisao(int numDadoI, int numDadoII) {
		if(numDadoI==numDadoII) {
			return true;
		}
		return false;
	}
	
	public SorteOuReves pegaCartaDoBaralho() {
		return cartasSorteOuReves.pegaCartaDobaralho(baralho);
	}
	
	public void jogadorPassouDiaNaPrisao(Jogador jogador) {
		jogador.setDiaPassadoNaPrisao(1);
	}
	
	public boolean quantidadeDeJogadoresEValida(int Numjogadores){
		if (Numjogadores >= 2 && Numjogadores <=8  ) {	
			return true;
		}
		return false;
	}
	
	public void efetuarPagamentoDeTaxaDeVisita(Jogador jogadorVisitante, Propriedade propriedade, int infPagamento) {
		propriedade.pagamentoDeTaxa(jogadorVisitante, infPagamento);
	}
	
	/**
	 * 
	 * @param jogador informaçoes do novo jogador , nome e cor do seu peao
	 * @throws CorInvalidaException 
	 * @throws JogadorComACorEscolhidaExiteException caso algum outro jogador ja tenha escolhida a mesma cor , visto que nao pode ter jogadores com a mesma cor
	 */
	public void gravaJogador(Jogador jogador) throws JogadorComCorEscolhidaExisteException, CorInvalidaException{
		if (ExisteJogadorComEstaCorPiao(jogador.getCor())==true) { // existe jogador que escolheu esta cor
			throw new JogadorComCorEscolhidaExisteException("Esta cor do peão ja foi escolhida");
		}else if(verificaCorInvalida(jogador.getCor().toUpperCase())) {
			throw new CorInvalidaException("Esta cor é invlálida.");
		}else {// a cor ja foi escolhida
			gravador.gravaEmLista(jogadores, jogador);
			this.quantidadeDeJogadores ++;
			

		}
	}
	
	/**
	 * 
	 * @param Jogador jogador que deseja sair do jogo
	 * 
	 * metodo que retira um jogador do jogo
	 */
	public void removeJogador(Jogador Jogador) {
		removedor.removeDeLista(jogadores,Jogador);
		this.quantidadeDeJogadores --;
		
	}
	
	public void carregaCores() {
		gravador.gravaEmLista(cores,"BRANCO");
		gravador.gravaEmLista(cores,"VERMELHO");
		gravador.gravaEmLista(cores,"VERDE");
		gravador.gravaEmLista(cores,"AZUL");
		gravador.gravaEmLista(cores,"AMARELO");
		gravador.gravaEmLista(cores,"LARANJA");
		gravador.gravaEmLista(cores,"ROSA");
		gravador.gravaEmLista(cores,"PRETO");
	}
	
	/**
	 * 
	 * @param cor que não existe nas opções
	 * @return true
	 * 
	 * verifica se a cor digitada pelo jogador é valida ou não
	 */
	public boolean verificaCorInvalida(String cor) {
		if(verificador.verificaStringEmLista(cores, cor)) {
			return false;
		}
		return true;
	}
	
	public void removerCorQueJaFoiEscolhida(String cor) {
		removedor.removeDeLista(cores,cor.toUpperCase());
	}
	
	
	/**
	 * 
	 * @param cor escolhida pelo jogador
	 * @return verifica se a cor digitada pelo jogador ja foi escolhida , caso ja tenha algum jogador com esta cor return true , caso a cor ainda nao foi escolhida retorne false
	 */
	public boolean ExisteJogadorComEstaCorPiao(String cor) {
		for (int k = 0; k<jogadores.size(); k++) {
			Jogador p = jogadores.get(k);
			if(verificador.verificaDuasStrings(p.getCor(),cor)) {
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Jogador> getJogadores(){
		return jogadores;
	}
	
	
	/**
	 * 
	 * @return o tabuleiro com todas as posiçoes das companhia e terrenos no qual o jogador pode comprar , e null para as pociçoes especiais como , sorte ou reves, partida ,prisao , prisao como visitante
	 */
	public void genetareBoard() {
		tabuleiro = sisTabuleiro.criartabuleiro();
	}
	
	public ArrayList<Propriedade> getTabuleiro() {
		return tabuleiro;
	}

	public ArrayList<String> getCores() {
		// TODO Auto-generated method stub
		return cores;
	}

	public ArrayList<SorteOuReves> getBaralho() {
		return baralho;
	}

	public int getQuantidadeDeJogadores() {
		return quantidadeDeJogadores;
	}
	
	
	
}