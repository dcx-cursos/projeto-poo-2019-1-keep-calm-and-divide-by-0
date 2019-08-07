package bancoMobiliario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Partida{
	
	
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		sisJogo sis = new sisJogo();

		
		while(true) {
			System.out.printf("Digite o número de jogadores [2-8]:");
			int numJogadores = leitor.nextInt();
			
			if(numJogadores<2) {System.out.println("Número de jogadores não pode ser menor que 2.");
			}else {
				for (int k=0; k<numJogadores; k++) {
					String nome,cor;
					
					System.out.printf("Digite o nome do jogador"+(k+1)+":");
					nome = leitor.next();
					
					System.out.printf("Digite a cor do peão do jogadorjogador "+(k+1)+" entre as opções seguintes:\n"
							+ "[preto][branco][vermelho][verde][azul][amarelo][laranja][rosa]\n:");
					cor = leitor.next();
					sis.gravaJogador((new Jogador(nome,cor)));/**JOGADOR É ADICIONADO A LISTA DE JOGADORES*/
				}
				break;
			}
		}
		System.out.println("O Banco Imobiliário vai começar. Aproveite!");
		
		for(Jogador e: sis.getJogadores()) {
			while(true) {
				if(e.getDiasNaPrisao()==0) {
					System.out.printf("A jogada de "+e.getNome()+" ("+e.getCor()+") começou.\n"
							+ "Comandos disponíveis: [jogar][sair]\n" 
							+ "Digite um comando:");
					String opcao = leitor.next().toUpperCase();
					
					if(opcao.equals("JOGAR")) {
						int numDadoUm = e.lancaDado();
						int numDadoDois = e.lancaDado();
						e.setPosicao(numDadoUm, numDadoDois);
						if(e.getPosicao()==10) {
							/**
							 * JOGADOR NÃO REALIZA NENHUMA AÇÃO E VAI PARA PRISÃO
							 */
							System.out.println("O jogador "+e.getNome()+" "+e.getCor()+" tirou "+numDadoUm+","+numDadoDois+" e o peão avançou para "
									+ ""+e.getPosicao()+" "
									+ "– Prisão como visitante.");
							e.irParaPrisao();
							break;
						}else {break;/**JOGADOR DEVE ESCOLHER A AÇÃO A SER REALIZADA DEPENDENDO DA DE PROPRIEDADE ONDE ESTÁ LOZALIZADO*/}
						
						
					}else {
							System.out.printf("Você realmente quer sair (Sim/Não)?");
							String escolha = leitor.next().toUpperCase();
							if(escolha.equals("NÃO") | escolha.equals("NAO")) {sis.removeJogador(e);/** JOGADOR SERÁ REMOVIDO DA LISTA DE JOGADORES*/
							}else if(escolha.equals("SIM") | escolha.equals("S")) {break;}/**JOGADOR DEVERA ESCOLHER AS OPÇÕES DE JOGO NOVAMENTE*/
					}
				}else {e.setDiasNaPrisao(); break;/**OS DIAS NA PRISÃO DO JOGADOR SÃO DECREMENTADOS EM 1*/}
						
			}//fim while
		
		}
	}
}
	

