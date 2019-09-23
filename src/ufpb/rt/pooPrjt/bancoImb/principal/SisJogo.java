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
	private ArrayList<Propriedade> tabuleiro = new ArrayList<Propriedade>();
	private ArrayList<String> cores = new ArrayList<String>();
	private ArrayList<SorteOuReves> baralho = new ArrayList<SorteOuReves>();

	private final int num_Terrenos_Verdes = 4;
	private final int num_Terrenos_Vermelhas = 2;
	private final int num_Terrenos_Amarelas = 3;
	private final int num_Terrenos_Azuis = 3;
	private final int num_Terrenos_Azul_Escuro = 2;
	private final int num_Terrenos_Bege = 2;
	private final int num_Terrenos_Roxos = 3;
	private final int num_Terrenos_Roxo_Claro = 3;
	private BaralhoCartas cartasSorteOuReves = new BaralhoCartas();
	private Gravador gravador = new Gravador();
	private Removedor removedor = new Removedor();
	private Verificador verificador = new Verificador();
	private Tabuleiro sisTabuleiro = new Tabuleiro();
	
	/**
	 * Verifica se o jogador pode construir em alguma propriedade
	 * @param propriedadesJogador
	 * @return boolean
	 */
	public boolean verificaSeJogadorPodeConstuir(ArrayList<Propriedade> propriedadesJogador) {
		ArrayList<Propriedade> propriedadesValidasPelaCor = getTerrenosDeCorXValidosParaConstrucao(propriedadesJogador);
		ArrayList<Propriedade> propriedadesValidasPeloNumCasas = getTerrenosComNumCasasValidosParaConstrucao(propriedadesValidasPelaCor);
		if(propriedadesValidasPelaCor.size()>0 || propriedadesValidasPeloNumCasas.size()>0) {
			return true;
		}
		return false;
		
	}
	
	/**
	 * Verifica se o jogador algum terreno com pelo menos uma casa construida
	 * @param propriedadesJogador
	 * @return ArreyList<Prorpriedade>
	 */
	public ArrayList<Propriedade> getTerrenosComNumCasasValidosParaVenda(ArrayList<Propriedade> propriedadesJogador) {
		ArrayList<Propriedade> propriedadesValidas = new ArrayList<Propriedade>();
		for(Propriedade propriedade: propriedadesJogador) {
			if(propriedade.getTipo().contentEquals("TERRENO")) {
				if (propriedade.getNumCasas()>=0) {
					propriedadesValidas.add(propriedade);
				}
			}
		}
		return propriedadesValidas;
	}
	
	/**
	 * veridica a quantidade de casas dos terrenos.
	 * 
	 * @param propriedadesJogador
	 */
	public ArrayList<Propriedade> getTerrenosComNumCasasValidosParaConstrucao(ArrayList<Propriedade> propriedadesJogador) {
		int[] numCasasDePropriedades = new int[propriedadesJogador.size()];
		ArrayList<Propriedade> propriedadesValidas = new ArrayList<Propriedade>();
		for(int k = 0; k<propriedadesJogador.size(); k++) {
			Propriedade propriedade = propriedadesJogador.get(k);
			numCasasDePropriedades[k] = propriedade.getNumCasas();
		}
		
		for(int k = 0; k<numCasasDePropriedades.length; k++) {
			int numCasa = numCasasDePropriedades[k];
			boolean numCasasinValido = false;
			for(int j = 0; j<numCasasDePropriedades.length; j++) {
				if(j==k) {
					j++;
				}else {
					if (numCasa>numCasasDePropriedades[j]+1 | numCasa>4) {
						numCasasinValido = true;
					}
				}
			}
			if(numCasasinValido!=true) {
				propriedadesValidas.add(propriedadesJogador.get(k));
			}
			
		}
		return propriedadesValidas;
	}
	
	/**
	 * Retorna um vetor de terrenos válidos para construção pela cor.
	 * @param propriedadesJogador
	 * @return arrayList<Propriedades>
	 */
	public ArrayList<Propriedade> getTerrenosDeCorXValidosParaConstrucao(ArrayList<Propriedade> propriedadesJogador){
		ArrayList<Propriedade> propriedadesValidas = new ArrayList<Propriedade>();
		
		int numTerrenosVerdesDoJogador = 0;
		int numTerrenosVermelhasDoJogador = 0;
		int numTerrenosAmarelasDoJogador = 0;
		int numTerrenosAzuisDoJogador = 0;
		int numTerrenosAzulEscuroDoJogador = 0;
		int numTerrenosBegeDoJogador = 0;
		int numTerrenosRoxosDoJogador = 0;
		int numTerrenosRoxoClaroDoJogador = 0;
		
	
		for (Propriedade propriedade: propriedadesJogador) {
			if(propriedade.getCor().equals("VERDE")) {
				numTerrenosVerdesDoJogador++;
			}else if(propriedade.getCor().equals("VERMELHA")) {
				numTerrenosVermelhasDoJogador++;
			}else if(propriedade.getCor().equals("AMARELA")) {
				numTerrenosAmarelasDoJogador++;
			}else if(propriedade.getCor().equals("AZUL")) {
				numTerrenosAzuisDoJogador++;
			}else if(propriedade.getCor().equals("AZUL-ESCURO")) {
				numTerrenosAzulEscuroDoJogador++;
			}else if(propriedade.getCor().equals("BEGE")) {
				numTerrenosBegeDoJogador++;
			}else if(propriedade.getCor().equals("ROXO")) {
				numTerrenosRoxosDoJogador++;
			}else if(propriedade.getCor().equals("ROXO-CLARO")) {
				numTerrenosRoxoClaroDoJogador++;
			}
		}
		
		if(numTerrenosVerdesDoJogador==this.num_Terrenos_Verdes) {
			for (Propriedade propriedade: propriedadesJogador) {
				if(propriedade.getCor().equals("VERDE")) {
					propriedadesValidas.add(propriedade);
				}
			}
		}
		if(numTerrenosVermelhasDoJogador==this.num_Terrenos_Vermelhas) {
			for (Propriedade propriedade: propriedadesJogador) {
				if(propriedade.getCor().equals("VERMELHA")) {
					propriedadesValidas.add(propriedade);
				}
			}
		}
		if(numTerrenosAmarelasDoJogador==this.num_Terrenos_Amarelas) {
			for (Propriedade propriedade: propriedadesJogador) {
				if(propriedade.getCor().equals("AMARELA")) {
					propriedadesValidas.add(propriedade);
				}
			}
		}
		if(numTerrenosAzuisDoJogador==this.num_Terrenos_Azuis) {
			for (Propriedade propriedade: propriedadesJogador) {
				if(propriedade.getCor().equals("AZUL")) {
					propriedadesValidas.add(propriedade);
				}
			}
		}
		if(numTerrenosAzulEscuroDoJogador==this.num_Terrenos_Azul_Escuro) {
			for (Propriedade propriedade: propriedadesJogador) {
				if(propriedade.getCor().equals("AZUL-ESCURO")) {
					propriedadesValidas.add(propriedade);
				}
			}
		}
		if(numTerrenosBegeDoJogador==this.num_Terrenos_Bege) {
			for (Propriedade propriedade: propriedadesJogador) {
				if(propriedade.getCor().equals("BEGE")) {
					propriedadesValidas.add(propriedade);
				}
			}
		}
		if(numTerrenosRoxosDoJogador==this.num_Terrenos_Roxos) {
			for (Propriedade propriedade: propriedadesJogador) {
				if(propriedade.getCor().equals("ROXO")) {
					propriedadesValidas.add(propriedade);
				}
			}
		}
		if(numTerrenosRoxoClaroDoJogador==this.num_Terrenos_Roxo_Claro) {
			for (Propriedade propriedade: propriedadesJogador) {
				if(propriedade.getCor().equals("ROXO-CLARO")) {
					propriedadesValidas.add(propriedade);
				}
			}
		}
		return propriedadesValidas;
	}

	/**
	 * gera o baralho com todas as 32 cartas
	 */
	public void gerarBaralho() {
		this.baralho = cartasSorteOuReves.gerarBaralhoEmbaralhado();
	}

	/**
	 * 
	 * @param numDadoI  valor do primeiro dado
	 * @param numDadoII valor do segundo dado
	 * @return se o jogador conseguiu tirar numeros iguais nos dados
	 */
	public boolean verificaJogadaDoisDadosIguais(int numDadoI, int numDadoII) {
		return verificador.verificaDoisInteirosIguais(numDadoI, numDadoII);
	}

	/**
	 * 
	 * @return carta tirada pelo jogador
	 */
	public SorteOuReves pegaCartaDoBaralho() {
		return cartasSorteOuReves.pegaCartaDobaralho(baralho);
	}

	/**
	 * 
	 * @param jogador jgador que estar preso metodo para saber quantos dias o
	 *                jogador ficou preso
	 */
	public void jogadorPassouDiaNaPrisao(Jogador jogador) {
		jogador.setDiaPassadoNaPrisao(1);
	}

	/**
	 * 
	 * @param Numjogadores numero de jogadores que é informado no inicio do jogo
	 * @return retorna o valor de jogadores e se o numero e valido para o jogo (de 2
	 *         ate 8 jogadores)
	 */
	public boolean quantidadeDeJogadoresEValida(int Numjogadores) {
		if (Numjogadores >= 2 && Numjogadores <= 8) {
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
	 * @throws JogadorComACorEscolhidaExiteException caso algum outro jogador ja
	 *                                               tenha escolhida a mesma cor ,
	 *                                               visto que nao pode ter
	 *                                               jogadores com a mesma cor
	 */
	public void gravaJogador(Jogador jogador) throws JogadorComCorEscolhidaExisteException, CorInvalidaException {
		if (ExisteJogadorComEstaCorPiao(jogador.getCor()) == true) { // existe jogador que escolheu esta cor
			throw new JogadorComCorEscolhidaExisteException("Esta cor do peão ja foi escolhida.");
		} else if (verificaCorInvalida(jogador.getCor().toUpperCase())) {
			throw new CorInvalidaException("Esta cor é invlálida.");
		} else {// a cor ja foi escolhida
			gravador.gravaEmLista(jogadores, jogador);

		}
	}

	/**
	 * 
	 * @param Jogador jogador que deseja sair do jogo
	 * 
	 *                metodo que retira um jogador do jogo
	 */
	public void removeJogador(Jogador Jogador) {
		removedor.removeDeLista(jogadores, Jogador);

	}

	/**
	 * lista de todas as cores disponiveis para o jogador escolher a cor do seu piao
	 */
	public void carregaCores() {
		gravador.gravaEmLista(cores, "BRANCO");
		gravador.gravaEmLista(cores, "VERMELHO");
		gravador.gravaEmLista(cores, "VERDE");
		gravador.gravaEmLista(cores, "AZUL");
		gravador.gravaEmLista(cores, "AMARELO");
		gravador.gravaEmLista(cores, "LARANJA");
		gravador.gravaEmLista(cores, "ROSA");
		gravador.gravaEmLista(cores, "PRETO");
	}

	/**
	 * 
	 * @param cor que não existe nas opções
	 * @return true
	 * 
	 *         verifica se a cor digitada pelo jogador é valida ou não
	 */
	public boolean verificaCorInvalida(String cor) {
		if (verificador.verificaStringEmLista(cores, cor)) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param cor, escolhida pelo jogador remove da lista de cores uma cor de
	 *             entrada que já foi escoligda por um jogador
	 */
	public void removerCorQueJaFoiEscolhida(String cor) {
		removedor.removeDeLista(cores, cor.toUpperCase());
	}

	/**
	 * 
	 * @param cor escolhida pelo jogador
	 * @return verifica se a cor digitada pelo jogador ja foi escolhida , caso ja
	 *         tenha algum jogador com esta cor return true , caso a cor ainda nao
	 *         foi escolhida retorne false
	 */
	public boolean ExisteJogadorComEstaCorPiao(String cor) {
		for (int k = 0; k < jogadores.size(); k++) {
			Jogador p = jogadores.get(k);
			if (verificador.verificaDuasStrings(p.getCor(), cor)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @return retorna um arraylist de jogadores
	 */
	public ArrayList<Jogador> getJogadores() {
		return jogadores;
	}

	/**
	 * 
	 * @return o tabuleiro com todas as posiçoes das companhia e terrenos no qual o
	 *         jogador pode comprar , e null para as pociçoes especiais como , sorte
	 *         ou reves, partida ,prisao , prisao como visitante
	 */
	public void genetareBoard() {
		tabuleiro = sisTabuleiro.criartabuleiro();
	}

	/**
	 * 
	 * @return uma lista de Propriedade que servirá de tabuleiro
	 */
	public ArrayList<Propriedade> getTabuleiro() {
		return tabuleiro;
	}

	/**
	 * 
	 * @return retorna uma lista de cores
	 */
	public ArrayList<String> getCores() {
		// TODO Auto-generated method stub
		return cores;
	}

	/**
	 * 
	 * @return retorna uma lista de cartas Sorte ou Reves
	 */
	public ArrayList<SorteOuReves> getBaralho() {
		return baralho;
	}

}