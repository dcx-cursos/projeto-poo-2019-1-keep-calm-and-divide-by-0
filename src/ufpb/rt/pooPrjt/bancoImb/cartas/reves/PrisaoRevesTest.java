package ufpb.rt.pooPrjt.bancoImb.cartas.reves;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ufpb.rt.pooPrjt.bancoImb.principal.Jogador;

class PrisaoRevesTest {

	
	PrisaoReves prisao = new PrisaoReves();
	Jogador jogador = new Jogador("cleyson","rosa");
	
	
	/**
	 * garantir que ao tirar a carta o jogador va direto para a prisao
	 */
	@Test
	void testJOgadorIndoParaPrisao() {
		jogador.setPosicao(20);
		assertEquals(20, jogador.getPosicao());
		prisao.acao(jogador);
		assertEquals(10, jogador.getPosicao());
		
	}

}
