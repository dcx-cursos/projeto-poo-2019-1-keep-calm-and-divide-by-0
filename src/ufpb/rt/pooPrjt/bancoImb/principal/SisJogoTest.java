package ufpb.rt.pooPrjt.bancoImb.principal;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ufpb.rt.pooPrjt.bancoImb.exceptions.CorInvalidaException;
import ufpb.rt.pooPrjt.bancoImb.exceptions.JogadorComCorEscolhidaExisteException;
import ufpb.rt.pooPrjt.bancoImb.metodosUtilirarios.Gravador;
import ufpb.rt.pooPrjt.bancoImb.metodosUtilirarios.Removedor;

class SisJogoTest {
	private SisJogo jogo;
	private ArrayList<Jogador> jogadores;
	private Jogador jogador;
	private Jogador jogador2;
	private Jogador jogador3;
	private Gravador gravador;
	private Removedor remover;

	@BeforeEach
	void setup() {
		jogo = new SisJogo();
		jogo.carregaCores();
		jogadores = new ArrayList<Jogador>();
		jogador = new Jogador("cleyson", "rosa");
		jogador2 = new Jogador("raul", "preto");
		jogador3 = new Jogador("biel", "lilas");
		gravador = new Gravador();
		remover = new Removedor();
	}

	/**
	 * 
	 * @throws CorInvalidaException 
	 * @throws JogadorComACorEscolhidaExiteException verifica se tem algum jogador
	 *                                               com a mesma cor
	 * 
	 *                                               metodo para verificar se estar
	 *                                               adicionando novos jogadores
	 */
	@Test
	void testAdicionandoJogador() throws JogadorComCorEscolhidaExisteException, CorInvalidaException {
		gravador.gravaEmLista(jogadores, jogador);
		gravador.gravaEmLista(jogadores, jogador2);
		assertEquals(2, jogadores.size());
		

	}

	/**
	 * testa quando um jogador digita uma cor que nao esta na lista de cor validas
	 * para sua escolha , deve lançar uma exception e mostar a mensagem de err0
	 */
	@Test
	void testComJogadorEscolhendoCorInvalida() {
		Exception CorInvalida = assertThrows(CorInvalidaException.class, () -> jogo.gravaJogador(jogador3));
		assertEquals("Esta cor é invlálida.", CorInvalida.getMessage());

	}

	/**
	 * teste para saber se as cores estao sendo adicionadas corretamente , e mostra
	 * quais sao cores adicionadas
	 */
	@Test
	void conferirAsCoresValidas() {
		System.out.println(jogo.getCores());
		assertEquals(8, jogo.getCores().size());

	}

	@Test
	void removendoUmaCorDoJogo() {
		jogo.removerCorQueJaFoiEscolhida("rosa");
		assertEquals(7, jogo.getCores().size());

	}
	
	
	@Test
	void removendoJogadorDaLista() {
		gravador.gravaEmLista(jogadores, jogador);
		gravador.gravaEmLista(jogadores, jogador2);
		remover.removeDeLista(jogadores, jogador2);
		
		assertEquals(1, jogadores.size());
		
	}
	
	
	

}
