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
	
	
	
	@BeforeEach
	void setup() {
		jogo = new SisJogo();
		jogadores = new ArrayList<Jogador>();
		jogador = new Jogador("cleyson","rosa");
		jogador2 = new Jogador("raul","preto");
		
	}

	/**
	 * 
	 * @throws JogadorComACorEscolhidaExiteException verifica se tem algum jogador com a mesma cor
	 * 
	 * metodo para verificar se estar adicionando novos jogadores
	 */
	@Test
	void testAdicionandoJogador() throws JogadorComACorEscolhidaExiteException {
		this.jogadores.add(jogador);
		this.jogadores.add(jogador2);
		assertEquals(2, jogadores.size());

	}

}
