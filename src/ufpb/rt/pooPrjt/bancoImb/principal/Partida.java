package ufpb.rt.pooPrjt.bancoImb.principal;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ufpb.rt.pooPrjt.bancoImb.exceptions.CorInvalidaException;
import ufpb.rt.pooPrjt.bancoImb.exceptions.DinheiroInsuficienteException;
import ufpb.rt.pooPrjt.bancoImb.exceptions.JogadorComCorEscolhidaExisteException;
import ufpb.rt.pooPrjt.bancoImb.exceptions.SemCartasDeSairDaPrisao;
import ufpb.rt.pooPrjt.bancoImb.interfaces.Propriedade;
import ufpb.rt.pooPrjt.bancoImb.interfaces.SorteOuReves;

public class Partida {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		SisJogo sis = new SisJogo();
		sis.carregaCores();
		sis.gerarBaralho();
		sis.genetareBoard();

		while (true) {
			boolean continueLoop = true;
			int numJogadores = 0;
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
					do {
						try {
							String nome, cor;

							System.out.printf("Digite o nome do jogador" + (k + 1) + ":");
							nome = leitor.next();

							System.out.printf("Digite a cor do peão do jogador " + (k + 1)
									+ " entre as opções seguintes:\n" + sis.getCores());
							cor = leitor.next().toLowerCase();

							sis.gravaJogador(new Jogador(nome, cor));/** JOGADOR É ADICIONADO A LISTA DE JOGADORES */
							sis.removerCorQueJaFoiEscolhida(cor);
							break;
						} catch (JogadorComCorEscolhidaExisteException | CorInvalidaException exception) {
							System.err.printf("Exception:", exception.getMessage() + "\n");
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
			for (int k = 0; k < sis.getJogadores().size(); k++) {
				Jogador jogador = sis.getJogadores().get(k);
				while (true) {
					if(jogador.getCarteira()<=0) {
						System.out.println(jogador.getNome()+" perdeu o jogo.");
						sis.removeJogador(jogador);
						break;
					}
					if (jogador.getDiasNaPrisao() == 0) {
						System.out.printf("A jogada de " + jogador.getNome() + " (" + jogador.getCor() + ") começou.\n"
								+ "Comandos disponíveis: [jogar][status][sair] \n" + "Digite um comando :");
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
							} else if ((jogador.getVezesQueTirouDadosIguais() % 3) == 0 && jogador.getVezesQueTirouDadosIguais()>0) {
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
									| (jogador.getPosicao() == 27 | jogador.getPosicao() == 37)) {
								SorteOuReves carta = sis.pegaCartaDoBaralho();
								System.out.println("O jogador " + jogador.getNome() + " " + jogador.getCor() + " tirou "
										+ numDadoUm + ", " + numDadoDois + " e o peão avançou para " + ""
										+ jogador.getPosicao() + " " + "– Sorte Ou Reves - " + carta.getDescricao());
								if (carta.getDescricao().equals("Utilize este cartão para se livrar da prisão")) {
									jogador.setCartaPrisao(carta);
									break;
								} else {
									carta.acao(jogador);
									break;
								}

							} else if ((jogador.getPosicao() != 18 && jogador.getPosicao() != 20)
									&& (jogador.getPosicao() != 24 && jogador.getPosicao() != 30)) {
								Propriedade propriedade = sis.getTabuleiro().get(jogador.getPosicao());
								if (propriedade.existeDono() == true) {
									System.out.println("O jogador " + jogador.getNome() + " " + jogador.getCor()
											+ " tirou " + numDadoUm + ", " + numDadoDois + " e o peão avançou para "
											+ "" + jogador.getPosicao() + " " + "– " + propriedade.getNome()
											+ " cujo dono é " + propriedade.getDono().getNome() + ".");
									if (propriedade.getTipo().equals("TERRENO")) {

									} else if (propriedade.getTipo().equals("COMPANHIA")) {
									}
									break;
								}

								System.out.printf("O jogador " + jogador.getNome() + " " + jogador.getCor() + " tirou "
										+ numDadoUm + ", " + numDadoDois + " e o peão avançou para " + ""
										+ jogador.getPosicao() + " " + "– " + propriedade.getNome()
										+ ". O título da propriedade " + jogador.getNome() + " está disponível por $"
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
										System.out.println(exception);
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

						} else if (opcao.equals("SAIR")) {
							System.out.printf("Você realmente quer sair (Sim/Não)?");
							String escolha = leitor.next().toUpperCase();
							if (escolha.equals("SIM") | escolha.equals("S")) {
								sis.removeJogador(jogador);
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
									jogador.pagarParaSairDaPrisao(500);
									k = k - 1;
									break;
								} catch (DinheiroInsuficienteException e) {
									// TODO Auto-generated catch block
									System.out.println(e);
									break;
								}
							} else if (escolhaPrisioneiro.equals("CARTA")) {
								try {
									jogador.usarCartaPrisao();
									k = k - 1;
									break;
								} catch (SemCartasDeSairDaPrisao e) {
									// TODO Auto-generated catch block
									System.out.println(e);
									break;
								}

							} else if (escolhaPrisioneiro.equals("JOGAR")) {
								int numDadoI = jogador.lancaDado();
								int numDadoII = jogador.lancaDado();
								if (sis.jogadaValidaJogadorPrisao(numDadoI, numDadoII) == true) {
									jogador.sairDaPrisao();
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
							}else {
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
