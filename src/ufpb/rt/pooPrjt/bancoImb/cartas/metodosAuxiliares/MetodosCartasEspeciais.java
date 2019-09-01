package ufpb.rt.pooPrjt.bancoImb.cartas.metodosAuxiliares;

import java.util.ArrayList;

import ufpb.rt.pooPrjt.bancoImb.principal.Jogador;

public class MetodosCartasEspeciais {
	
	public int debitaValorDeJogadores(Jogador jogador, ArrayList<Jogador> jogadores, int valor) {
		int valorPagamento = 0;
		ArrayList<Jogador> jogadoresDebitados = new ArrayList<Jogador>();
		jogadoresDebitados.remove(jogador);
		
		for(Jogador jogadorDebitado:jogadoresDebitados) {
			jogadorDebitado.debitar(valor);
			valorPagamento+=valor;
		}
		return valorPagamento;
		
		
	}

}
