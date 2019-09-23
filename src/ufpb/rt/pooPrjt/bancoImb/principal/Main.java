package ufpb.rt.pooPrjt.bancoImb.principal;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ufpb.rt.pooPrjt.bancoImb.cartas.sorte.CartaPresenteAniversario;
import ufpb.rt.pooPrjt.bancoImb.exceptions.CorInvalidaException;
import ufpb.rt.pooPrjt.bancoImb.exceptions.DinheiroInsuficienteException;
import ufpb.rt.pooPrjt.bancoImb.exceptions.JogadorComCorEscolhidaExisteException;
import ufpb.rt.pooPrjt.bancoImb.exceptions.SemCartasDeSairDaPrisao;
import ufpb.rt.pooPrjt.bancoImb.exceptions.SemCasasParaVendaException;
import ufpb.rt.pooPrjt.bancoImb.interfaces.Propriedade;
import ufpb.rt.pooPrjt.bancoImb.interfaces.SorteOuReves;

public class Main {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		SisJogo sis = new SisJogo();
		sis.carregaCores(); // carrega todas as cores disponivel
		sis.gerarBaralho(); // cria o baralho
		sis.genetareBoard(); // cria o tabuleiro

		while (true) {
			boolean continueLoop = true;
			int numJogadores = 0; // numero de jogadores que vao jogar
			do {
				try {
					System.out.printf("Digite o número de jogadores [2-8]:");
					numJogadores = leitor.nextInt();
					break;
				} catch (InputMismatchException e) {
					// TODO Auto-generated catch block
					System.err.printf("", e.getMessage() + "\n");
					leitor.nextLine();
					System.out.println("Você precisa digitar inteiros. Por favor tente denovo.");
				}
			} while (continueLoop);

			if (sis.quantidadeDeJogadoresEValida(numJogadores) == false) {
				System.out.println("Número de jogadores inválido.");
			} else {
				boolean continueLoopII = true;
				for (int k = 0; k < numJogadores; k++) {
					String nome, cor;

					System.out.printf("Digite o nome do jogador" + (k + 1) + ":");
					nome = leitor.next();
					do {
						try {

							System.out.printf("Digite a cor do peão do jogador " + (k + 1)
									+ " entre as opções seguintes:\n" + sis.getCores());
							cor = leitor.next().toLowerCase();

							sis.gravaJogador(new Jogador(nome, cor));/** JOGADOR É ADICIONADO A LISTA DE JOGADORES */
							sis.removerCorQueJaFoiEscolhida(cor);
							break;
						} catch (JogadorComCorEscolhidaExisteException | CorInvalidaException exception) {
							System.err.printf("Exception: " + exception.getMessage() + "\n");
							leitor.nextLine();
							System.out.println("Você precisa digitar uma cor diferente. Porfavor tente denovo.");
						}
					} while (continueLoopII);
				}
				break;
			}
		}

		System.out.println("O Banco Imobiliário vai começar. Aproveite!");

		while (true) {
			if (sis.getJogadores().size() == 1) {
				/**
				 * JOGO É ENCERRADO QUANDO RESTOU APENAS UM JOGADOR
				 */
				System.out.println("Jogo encerrado.");
				break;
			}
			for (int k = 0; k < sis.getJogadores().size();k++) {

				Jogador jogador = sis.getJogadores().get(k);
				while (true) {
					if (jogador.getCarteira() <= 0) {
						System.out.println(jogador.getNome() + " perdeu o jogo.");
						sis.removeJogador(jogador);
						break;
					}
					if (jogador.getDiasNaPrisao() == 0) { // o jogador nao estar na prisao
						if(sis.verificaSeJogadorPodeConstuir(jogador.getPropriedades())) {
							System.out.printf("A jogada de " + jogador.getNome() + " (" + jogador.getCor() + ") começou.\n"
									+ "Comandos disponíveis: [construir][vender][jogar][status][sair] \n" + "Digite um comando :");
						}else {
							System.out.printf("A jogada de " + jogador.getNome() + " (" + jogador.getCor() + ") começou.\n"
									+ "Comandos disponíveis: [vender][jogar][status][sair] \n" + "Digite um comando :");
						}
						String opcao = leitor.next().toUpperCase();

						if (opcao.equals("JOGAR")) {
							int numDadoUm = jogador.lancaDado();
							int numDadoDois = jogador.lancaDado();

							jogador.andarCasas(numDadoUm, numDadoDois);
							if (jogador.getPosicao() == 30) {
								/**
								 * JOGADOR NÃO REALIZA NENHUMA AÇÃO E VAI PARA PRISÃO
								 */
								System.out.println("O jogador " + jogador.getNome() + " " + jogador.getCor() + " tirou "
										+ numDadoUm + "," + numDadoDois + " e o peão avançou para " + ""
										+ jogador.getPosicao() + " " + "– Prisão por 3 rodadas.");
								jogador.irParaPrisao();
								break;
							} else if ((jogador.getVezesQueTirouDadosIguais() % 3) == 0
									&& jogador.getVezesQueTirouDadosIguais() > 0) {
								System.out.println("O jogador " + jogador.getNome() + " " + jogador.getCor() + " tirou "
										+ numDadoUm + "," + numDadoDois + " e o peão avançou para " + ""
										+ jogador.getPosicao() + " " + "– Prisão por 3 rodadas.");
								jogador.irParaPrisao();
								break;
							} else if (jogador.getPosicao() == 10) {
								/**
								 * JOGADOR NÃO REALIZA NENHUMA AÇÃO E VAI PARA PRISÃO COMO VISITANTE
								 */
								System.out.println("O jogador " + jogador.getNome() + " " + jogador.getCor() + " tirou "
										+ numDadoUm + "," + numDadoDois + " e o peão avançou para " + ""
										+ jogador.getPosicao() + " " + "– Prisão como visitante.");
								break;

							} else if ((jogador.getPosicao() == 2 | jogador.getPosicao() == 12)
									| (jogador.getPosicao() == 16 | jogador.getPosicao() == 22)
									| (jogador.getPosicao() == 27 | jogador.getPosicao() == 37)) { // jogador cai nas
																									// posiçao de sorte
																									// ou reves
								SorteOuReves carta = sis.pegaCartaDoBaralho();
								System.out.println("O jogador " + jogador.getNome() + " " + jogador.getCor() + " tirou "
										+ numDadoUm + ", " + numDadoDois + " e o peão avançou para " + ""
										+ jogador.getPosicao() + " " + "– Sorte Ou Reves - " + carta.getDescricao());

								/**
								 * SE O JOGADOR TIRAR DOIS DADOS IGUAIS, ELE JOGA MAIS UMA VEZ
								 */
								if (sis.verificaJogadaDoisDadosIguais(numDadoUm, numDadoDois)) {
									k = k - 1;
								}else {
									jogador.zeraVezesQueTirouDadosIguais();
								}
								
								if (carta.getDescricao().equals("Utilize este cartão para se livrar da prisão")) {
									jogador.setCartaPrisao(carta);
									break;
								}else {
									carta.acao(jogador);
									break;
								}
							}else if(jogador.getPosicao() == 0) {
								System.out.println("O jogador " + jogador.getNome() + " " + jogador.getCor()
								+ " tirou " + numDadoUm + ", " + numDadoDois + " e o peão avançou para "
								+ "início - receba 200");
								jogador.creditar(200);

							} else if ((jogador.getPosicao() != 18 && jogador.getPosicao() != 20)
									&& (jogador.getPosicao() != 24 && jogador.getPosicao() != 30)) {
								Propriedade propriedade = sis.getTabuleiro().get(jogador.getPosicao());
								/**
								 * SE O JOGADOR TIRAR DOIS DADOS IGUAIS, ELE JOGA MAIS UMA VEZ
								 */
								if (sis.verificaJogadaDoisDadosIguais(numDadoUm, numDadoDois)) {
									k = k - 1;
								}else {
									jogador.zeraVezesQueTirouDadosIguais();
								}
								
								if (propriedade.existeDono() == true) {
									System.out.println("O jogador " + jogador.getNome() + " " + jogador.getCor()
											+ " tirou " + numDadoUm + ", " + numDadoDois + " e o peão avançou para "
											+ "" + jogador.getPosicao() + " " + "– " + propriedade.getNome()
											+ " cujo dono é " + propriedade.getDono().getNome() + ".");
									
									if (propriedade.getTipo().equals("TERRENO")) {
										if (jogador.getNome().equals(propriedade.getDono().getNome())) {
											System.out.println("Jogador em uma das suas propriedade \nNada aconteceu");

										} else {
											int valorPago = propriedade.valorAserPagoParaODonoDoTerreno();
											propriedade.pagamentoDeTaxa(jogador,
													propriedade.valorAserPagoParaODonoDoTerreno());
											System.out.println("O jogador" + jogador.getNome() + " pagou: " + valorPago
													+ " para o jogador: " + propriedade.getDono().getNome());
										}

									} else if (propriedade.getTipo().equals("COMPANHIA")) {
										if (jogador.getNome().equals(propriedade.getDono().getNome())) {
											System.out.println("Jogador em uma das suas propriedade \nNada aconteceu");

										} else {
											int valorPago = propriedade
													.valorAserPagoParaODonoDaCompanhia(numDadoUm + numDadoDois);
											propriedade.pagamentoDeTaxa(jogador, numDadoUm + numDadoDois);
											System.out.println("O jogador" + jogador.getNome() + "pagou: " + valorPago
													+ " para o jogador: " + propriedade.getDono().getNome());
										}
									}
									break;
								}

								System.out.printf("O jogador " + jogador.getNome() + " " + jogador.getCor() + " tirou "
										+ numDadoUm + ", " + numDadoDois + " e o peão avançou para " + ""
										+ jogador.getPosicao() + " " + "– " + propriedade.getNome()
										+ ". O título da propriedade está disponível por $"
										+ propriedade.getPrecoCompra() + "\n" + jogador.getNome() + ", você possui "
										+ jogador.getCarteira() + ".\n" + "Você deseja comprar " + propriedade.getNome()
										+ " (Sim/Não)? ");
								String escolha = leitor.next().toUpperCase();
								if (escolha.equals("NÃO") | escolha.equals("NAO")) {
									break;
								} else {
									try {
										jogador.compraPropriedade(propriedade.getPrecoCompra(), propriedade);
										System.out.println("Compra efetuada.");
										break;
									} catch (DinheiroInsuficienteException exception) {
										System.err.println(exception.getMessage());
										break;
									}
								}
								/**
								 * JOGADOR DEVE ESCOLHER A AÇÃO A SER REALIZADA DEPENDENDO DA DE PROPRIEDADE
								 * ONDE ESTÁ LOZALIZADO
								 */
							}

						} else if (opcao.equals("STATUS")) {
							System.out.println(jogador.getStatus(sis.getTabuleiro()));
							
						}else if(opcao.equals("VENDER")) {
							ArrayList<Propriedade> propriedadesValidasParaVender = sis.getTerrenosComNumCasasValidosParaVenda(jogador.getPropriedades());
							
							do {
								System.out.println(jogador.getNome()+" possui $"+jogador.getCarteira()+"\n"
										+ "Escolha onde quer vender:");
								int indice = 0;
								for (Propriedade propriedade: propriedadesValidasParaVender) {
									indice++;
									System.out.println(indice+" – "+propriedade.getNome()+" tem "+propriedade.getNumCasas()+" casa(s) construidas, casa custa "+propriedade.getPrecoCasa());
								}
								System.out.printf("Digite o número da propriedade (0 para sair):");
								int numEscolhido =0;
								
								do {
									try {
										numEscolhido = leitor.nextInt();
										break;
									} catch (InputMismatchException e) {
										System.err.printf("", e.getMessage() + "\n");
										leitor.nextLine();
										System.out.println("Você precisa digitar inteiros. Por favor tente denovo.");
									} 
								} while (true);
								if(numEscolhido==0) {
									break;
								}else if(propriedadesValidasParaVender.size()==0) {
									break;
								}
								if(numEscolhido<=numEscolhido && numEscolhido>=0) {
									Propriedade propriedadeEscolhida = propriedadesValidasParaVender.get(numEscolhido-1);
									for(Propriedade propriedadeDoJogador: jogador.getPropriedades()) {
										if(propriedadeDoJogador.getNome()==propriedadeEscolhida.getNome()) {
											try {
												jogador.venderCasaEmTerreno(propriedadeDoJogador);
											} catch (SemCasasParaVendaException exception) {
												System.err.printf("Exception: " + exception.getMessage() + "\n");
											}
										}
									}
									propriedadesValidasParaVender = sis.getTerrenosComNumCasasValidosParaVenda(jogador.getPropriedades());
									
								}else {
									System.out.println("Digite um número válido.");
								}
							}while(true);
							k = k-1;
							break;
							
						//SE O JOGADOR PUDER CONSTRUIR EM ALGUM TERRENO ELE VERIFICA A OPÇÃO CONSTRUIR
						}else if(opcao.equals("CONSTRUIR")) {
							if(sis.verificaSeJogadorPodeConstuir(jogador.getPropriedades())==true) {
								ArrayList<Propriedade> propriedadesValidasPelaCor = sis.getTerrenosDeCorXValidosParaConstrucao(jogador.getPropriedades());
								ArrayList<Propriedade> propriedadesValidasParaConstrucao = sis.getTerrenosComNumCasasValidosParaConstrucao(propriedadesValidasPelaCor);
								
								do {
									propriedadesValidasPelaCor = sis.getTerrenosDeCorXValidosParaConstrucao(jogador.getPropriedades());
									propriedadesValidasParaConstrucao = sis.getTerrenosComNumCasasValidosParaConstrucao(propriedadesValidasPelaCor);
									System.out.println(jogador.getNome()+" possui $"+jogador.getCarteira()+"\n"
											+ "Escolha onde quer construir:");
									int indice = 0;
									for (Propriedade propriedade: propriedadesValidasParaConstrucao) {
										indice++;
										System.out.println(indice+" – "+propriedade.getNome()+" tem "+propriedade.getNumCasas()+" casa(s) construidas, casa custa "+propriedade.getPrecoCasa());
									}
									System.out.printf("Digite o número da propriedade (0 para sair):");
									int numEscolhido = 0;
									do {
										try {
											numEscolhido = leitor.nextInt();
											break;
										} catch (InputMismatchException e) {
											System.err.printf("", e.getMessage() + "\n");
											leitor.nextLine();
											System.out.println("Você precisa digitar inteiros. Por favor tente denovo.");
										} 
									} while (true);
									if(numEscolhido==0) {
										break;
									}else if(propriedadesValidasParaConstrucao.size()==0) {
										break;
									}
									if(numEscolhido<=numEscolhido && numEscolhido>=0) {
										Propriedade propriedadeEscolhida = propriedadesValidasParaConstrucao.get(numEscolhido-1);
										for(Propriedade propriedadeDoJogador: jogador.getPropriedades()) {
											if(propriedadeDoJogador.getNome()==propriedadeEscolhida.getNome()) {
												try {
													jogador.construirCasaEmTerreno(propriedadeDoJogador);
												} catch (DinheiroInsuficienteException exception) {
													// TODO Auto-generated catch block
													System.err.printf("Exception: " + exception.getMessage() + "\n");
												}
											}
										}
										propriedadesValidasPelaCor = sis.getTerrenosDeCorXValidosParaConstrucao(jogador.getPropriedades());
										propriedadesValidasParaConstrucao = sis.getTerrenosComNumCasasValidosParaConstrucao(propriedadesValidasPelaCor);
										
									}else {
										System.out.println("Digite um nnúmero válido.");
									}
								}while(true);
							}else {
								System.out.println("Jogador ainda não pode construir.");
							}
							k = k-1;
							break;

						} else if (opcao.equals("SAIR")) {
							System.out.printf("Você realmente quer sair (Sim/Não)?");
							String escolha = leitor.next().toUpperCase();
							if (escolha.equals("SIM") | escolha.equals("S")) {
								sis.removeJogador(jogador);
								k = (k-1)+1;
								break;/** JOGADOR SERÁ REMOVIDO DA LISTA DE JOGADORES */
							} else if (escolha.equals("NÃO") | escolha.equals("NAO")) {
							} /** JOGADOR DEVERA ESCOLHER AS OPÇÕES DE JOGO NOVAMENTE */
						} else {
							System.out.println("Digite uma opção válida.\n");
						}
					} else {
						System.out.printf("A jogada de " + jogador.getNome() + " (" + jogador.getCor() + ") começou.\n"
								+ jogador.getNome() + " esta na prisão.\n");
						do {
							System.out.println("Comandos disponíveis: [pagar][carta][jogar][status][sair]\n"
									+ "Digite um comando:");
							String escolhaPrisioneiro = leitor.next().toUpperCase();
							if (escolhaPrisioneiro.equals("PAGAR")) {
								try {
									jogador.pagarParaSairDaPrisao(50);
									k = k - 1;
									break;
								} catch (DinheiroInsuficienteException e) {
									// TODO Auto-generated catch block
									System.out.println(e);
									break;
								}
							} else if (escolhaPrisioneiro.equals("CARTA")) { // jogador usa a carta
								try {
									jogador.usarCartaPrisao();
									k = k - 1;
									break;
								} catch (SemCartasDeSairDaPrisao e) {
									// TODO Auto-generated catch block
									System.out.println(e.getMessage());

								}

							} else if (escolhaPrisioneiro.equals("JOGAR")) { // jogador escolheu jogar para tentar sair
																				// da prisao
								int numDadoI = jogador.lancaDado();
								int numDadoII = jogador.lancaDado();
								if (sis.verificaJogadaDoisDadosIguais(numDadoI, numDadoII) == true) {
									jogador.sairDaPrisao(); // sai da prisao casa consiga valores iguais
									jogador.andarCasas(numDadoI, numDadoII);
									System.out.println("O jogador " + jogador.getNome() + " (" + jogador.getCor()
											+ ") tirou " + numDadoI + ", " + numDadoII + " e o peão avançou para " + ""
											+ jogador.getPosicao());
									break;
								} else {
									System.out.println("O jogador " + jogador.getNome() + " (" + jogador.getCor()
											+ ") tirou " + numDadoI + ", " + numDadoII + " e continou na prisão.");
									break;
								}
							} else if (escolhaPrisioneiro.equals("STATUS")) {
								System.out.println(jogador.getStatus(sis.getTabuleiro()));
							} else {
								System.out.println("Digite um comando válido!");
							}

							/** OS DIAS NA PRISÃO DO JOGADOR SÃO DECREMENTADOS EM 1 */
						} while (true);
						break;
					}

				} // fim while

			}

		}
	}
}
