package bancoMobiliario;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SisJogoTest {
	private SisJogo jogo;
	private ArrayList<Jogador> jogadores ;
	private Jogador jogador;
	private Jogador jogador2;
	private Jogador jogador3;
	
	
	
	@BeforeEach
	void setup() {
		jogo = new SisJogo();
		jogadores = new ArrayList<Jogador>();
		jogador = new Jogador("cleyson","rosa");
		jogador2 = new Jogador("raul","preto");
		jogador3 = new Jogador("biel","lilas");
	}

	/**
	 * 
	 * @throws JogadorComACorEscolhidaExiteException verifica se tem algum jogador com a mesma cor
	 * 
	 * metodo para verificar se estar adicionando novos jogadores
	 */
	@Test
	void testAdicionandoJogador() throws JogadorComACorEscolhidaExisteException {
		this.jogadores.add(jogador);
		this.jogadores.add(jogador2);
		assertEquals(2, jogadores.size());

	}
	/**
	 * testa quando um jogador digita uma cor que nao esta na lista de cor validas para sua escolha , deve lançar uma exception e mostar a mensagem de err0
	 */
	
	@Test
	void testComJogadorEscolhendoCorInvalida()  {
		Exception CorInvalida = assertThrows(CorInvalidaException.class, () -> jogo.gravaJogador(jogador3));
		assertEquals("Esta cor é invlálida. Porfavor tente denovo.",CorInvalida.getMessage() );

	}

}
