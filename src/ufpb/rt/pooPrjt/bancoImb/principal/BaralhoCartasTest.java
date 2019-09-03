package ufpb.rt.pooPrjt.bancoImb.principal;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import ufpb.rt.pooPrjt.bancoImb.cartas.reves.PagamentoReves;
import ufpb.rt.pooPrjt.bancoImb.interfaces.SorteOuReves;

class BaralhoCartasTest {
	BaralhoCartas baralho;

	
	
	
	@BeforeEach
	void init() {
		baralho = new BaralhoCartas();
		
	}
	
	
	@Test
	void testCriacaoDoBaralho() {
		baralho.gerarBaralhoEmbaralhado();
		assertEquals(31, baralho.gerarBaralhoEmbaralhado().size());
		
	}
	
	
	

}
