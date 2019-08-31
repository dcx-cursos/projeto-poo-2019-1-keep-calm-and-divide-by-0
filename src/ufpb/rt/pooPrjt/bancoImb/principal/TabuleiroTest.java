package ufpb.rt.pooPrjt.bancoImb.principal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TabuleiroTest {
	
	Tabuleiro tabuleiro;
	
	
	@BeforeEach
	void init() {
		tabuleiro = new Tabuleiro();
	}
/**
 * testando se ao criar o tabuleiro é criado com todas as 40 posiçoes do tabuleiro do banco imobiliario
 */
	@Test
void testandoACriacaoDoTabuleiro() {
		System.out.println(tabuleiro.criartabuleiro());
		assertEquals(40,tabuleiro.criartabuleiro().size());
	}

}
