package ufpb.rt.pooPrjt.bancoImb.cartas.metodosAuxiliares;

import java.util.ArrayList;

import ufpb.rt.pooPrjt.bancoImb.principal.Jogador;

public class MetodosCartasEspeciais {
	
	
	/**
	 * 
	 * @param jogador jogador que receberar o dinheiro
	 * @param jogadores jogadores q iram pagar quem pegou a carta
	 * @param valor valor que vai ser retirado de cada jogador
	 * @return valor pago
	 */
	public int debitaValorDeJogadores(Jogador jogador, ArrayList<Jogador> jogadores, int valor) {
		int valorPagamento = 0;
		jogadores.remove(jogador);
		
		for(Jogador jogadorDebitado : jogadores) {
			jogadorDebitado.debitar(valor);
			valorPagamento+=valor;
		}
		return valorPagamento;
		
		
	}

}
