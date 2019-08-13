package bancoMobiliario;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Partida{
	
	
	public static void main(String[] args) throws CorInvalidaException {
		Scanner leitor = new Scanner(System.in);
		SisJogo sis = new SisJogo();
		ArrayList<Propriedade> tabuleiro = sis.genetareBoard();
		sis.carregaCores();

		
		while(true) {
			int numJogadores = 0;
			try {
				System.out.printf("Digite o número de jogadores [2-8]:");
				numJogadores = leitor.nextInt();
			} catch (InputMismatchException e) {
				// TODO Auto-generated catch block
				System.err.printf("%nException: %s%n",e);
				leitor.nextLine();
				System.out.printf("Você precisa digitar inteiros. Porfavor tente denovo.%n%n");
			}
			
			if(numJogadores<2 || numJogadores > 8) {System.out.println("Número de jogadores invalido");
			}else {
				for (int k=0; k<numJogadores; k++) {
					String nome,cor;
					
					System.out.printf("Digite o nome do jogador"+(k+1)+":");
					nome = leitor.next();
					
					System.out.printf("Digite a cor do peão do jogador "+(k+1)+" entre as opções seguintes:\n"
							+ "[preto][branco][vermelho][verde][azul][amarelo][laranja][rosa]\n:");
					cor = leitor.next().toLowerCase();
					try {
						sis.gravaJogador((new Jogador(nome,cor)));/**JOGADOR É ADICIONADO A LISTA DE JOGADORES*/
					}catch (JogadorComACorEscolhidaExiteException e) {
			
						System.err.println(e.getMessage());
						k = k-1;
					}catch (CorInvalidaException e) {
						System.err.println(e.getMessage());
						k = k-1;
					}
				}
				break;
			}
		}
		System.out.println("O Banco Imobiliário vai começar. Aproveite!");
		while(true) {
			if(sis.getJogadores().size()==1) {
				/**
				 * JOGO É ENCERRADO QUANDO RESTOU APENAS UM JOGADOR
				 */
				System.out.println("Jogo encerrado.");
				break;
			}
			for(int k = 0; k<sis.getJogadores().size(); k++) {
				Jogador e = sis.getJogadores().get(k);
				while(true) {
					if(e.getDiasNaPrisao()==0){
						System.out.printf("A jogada de "+e.getNome()+" ("+e.getCor()+") começou.\n"
								+ "Comandos disponíveis: [jogar][status][sair]\n" 
								+ "Digite um comando:");
						String opcao = leitor.next().toUpperCase();
						
						if(opcao.equals("JOGAR")) {
							int numDadoUm = e.lancaDado();
							int numDadoDois = e.lancaDado();sis.getJogadores();
							e.setPosicao(numDadoUm, numDadoDois);
							if(e.getPosicao()==30) {
								/** 
								 * JOGADOR NÃO REALIZA NENHUMA AÇÃO E VAI PARA PRISÃO
								 */
								System.out.println("O jogador "+e.getNome()+" "+e.getCor()+" tirou "+numDadoUm+","+numDadoDois+" e o peão avançou para "
										+ ""+e.getPosicao()+" "
										+ "– Prisão por 3 rodadas.");
								e.irParaPrisao();
								break;
							}else if(e.getPosicao()==10){
								/** 
								 * JOGADOR NÃO REALIZA NENHUMA AÇÃO E VAI PARA PRISÃO COMO VISITANTE
								 */
								System.out.println("O jogador "+e.getNome()+" "+e.getCor()+" tirou "+numDadoUm+","+numDadoDois+" e o peão avançou para "
										+ ""+e.getPosicao()+" "
										+ "– Prisão como visitante.");
								break;
									
							}else if((e.getPosicao()!=0 && e.getPosicao()!=2)&&(e.getPosicao()!=12 && e.getPosicao()!=16)&&(e.getPosicao()!=18 && e.getPosicao()!=20)
									&&(e.getPosicao()!=24 && e.getPosicao()!=27)&&(e.getPosicao()!=37)){
								Propriedade propriedade = tabuleiro.get(e.getPosicao());
								if(propriedade.existeDono()==true) {
									System.out.println("O jogador "+e.getNome()+" "+e.getCor()+" tirou "+numDadoUm+", "+numDadoDois+" e o peão avançou para "
											+ ""+e.getPosicao()+" "
											+ "– "+propriedade.getNome()+" cujo dono é "+propriedade.getDono().getNome()+".");
									/**
									 * if (propriedade.getTipo.equals("TERRENO")){
									 * TODO
									 * }else if(propriedade.getTipo.equals("COMPANHIA")){
									 * TODO
									 * }
									 */
									break;
								}
								
								System.out.printf("O jogador "+e.getNome()+" "+e.getCor()+" tirou "+numDadoUm+", "+numDadoDois+" e o peão avançou para "
									+ ""+e.getPosicao()+" "
									+ "– "+propriedade.getNome()+". O título da propriedade "+ e.getNome()+" está disponível por $"+propriedade.getPrecoCompra()+"\n"
									+ e.getNome()+", você possui "+e.getCarteira()+".\n"
									+ "Você deseja comprar "+propriedade.getNome()+" (Sim/Não)? "); 
								String escolha = leitor.next().toUpperCase();
								if(escolha.equals("NÃO") | escolha.equals("NAO")) {
									break;
								}else {
									try {
										e.compraPropriedade(propriedade.getPrecoCompra(), propriedade);
										propriedade.setDono(e);
										System.out.println("Compra efetuada.");
										break;
									}catch(DineheiroInsuficienteException exception) {
										System.out.println(exception);
										break;
									}
								}/**JOGADOR DEVE ESCOLHER A AÇÃO A SER REALIZADA DEPENDENDO DA DE PROPRIEDADE ONDE ESTÁ LOZALIZADO*/}
							
						}else if (opcao.equals("STATUS")) {
							System.out.println(e.getStatus(tabuleiro));	
							
						}else if(opcao.equals("SAIR")){
								System.out.printf("Você realmente quer sair (Sim/Não)?");
								String escolha = leitor.next().toUpperCase();
								if(escolha.equals("SIM") | escolha.equals("S")) {
									sis.removeJogador(e);
									break;/** JOGADOR SERÁ REMOVIDO DA LISTA DE JOGADORES*/
								}else if(escolha.equals("NÃO") | escolha.equals("NAO")) {}/**JOGADOR DEVERA ESCOLHER AS OPÇÕES DE JOGO NOVAMENTE*/
						}else {
							System.out.println("Digite uma opção válida.\n");
						}
					}else {System.out.println(e.getNome()+"Esta na prisão como visitante.");e.setDiasNaProsao(1); break;/**OS DIAS NA PRISÃO DO JOGADOR SÃO DECREMENTADOS EM 1*/}
							
				}//fim while
			
			}
			
		}
	}
}
