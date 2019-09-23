package ufpb.rt.pooPrjt.bancoImb.cartas.metodosAuxiliares;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ufpb.rt.pooPrjt.bancoImb.principal.Jogador;

class MetodosCartasEspeciaisTest   {
	MetodosCartasEspeciais casamento = new MetodosCartasEspeciais() ;
	Jogador jogador1 = new Jogador("jogador1","rosa");
	Jogador jogador2 = new Jogador("jogador2","preto");
	Jogador jogador3 = new Jogador("jogador3","azul");
	ArrayList<Jogador> Jogadores = new ArrayList<Jogador>();
		
	
	@BeforeEach
	void init() {
		Jogadores.add(jogador1);
		Jogadores.add(jogador2);
		Jogadores.add(jogador3);
	}
	
/**
 * verifica que todos que deve pagar ao jogador tenha o dinheiro debitado
 */
	@Test
	void VerificaSeRetiraOdinheiroDetodosOsJogadores() {
		System.out.println(jogador1.getCarteira());
		casamento.debitaValorDeJogadores(jogador1, Jogadores, 50);
		for (int k=0 ; k < Jogadores.size() ; k++ ) { // mostra quanto os outros jogadores ficaram apos usar a carta
		System.out.println(Jogadores.get(k).getCarteira() + Jogadores.get(k).getNome());
		}
		assertEquals(1500, jogador1.getCarteira());
		assertEquals(1450, jogador2.getCarteira());
		assertEquals(1450, jogador3.getCarteira());
	}

}
