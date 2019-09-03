package ufpb.rt.pooPrjt.bancoImb.principal;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import ufpb.rt.pooPrjt.bancoImb.exceptions.DinheiroInsuficienteException;
import ufpb.rt.pooPrjt.bancoImb.interfaces.Propriedade;
import ufpb.rt.pooPrjt.bancoImb.logradouros.Companhia;
import ufpb.rt.pooPrjt.bancoImb.logradouros.Terreno;

/**
 * 
 * @version Junity5
 */
class JogadorTest {
	private Jogador jogador;
	private Propriedade terreno;
	private Propriedade companhia;

	
	
	@Mock
	Jogador jogadorMock ;
	 Propriedade terrenoMock;

	
	
	@BeforeEach
	  public void init(){
	    MockitoAnnotations.initMocks(this);
	    
	
	}

	/**
	 * antes de cada teste deve criar um novo jogador
	 */
	@BeforeEach
	void setup() {
		jogador = new Jogador("cleyson", "rosa");
		terreno = new Terreno("Leblon", 100, 6, 30, 90, 270, 400, 500, 50, 50, 0, 6);
		companhia = new Companhia("Companhia de Taxi Aereo", 200, 100, 50);
		List<Propriedade> propriedades = new ArrayList<Propriedade>();
		propriedades.add(companhia);
		propriedades.add(terreno);
		
		
		

	}

	/**
	 * 
	 * @throws DinheiroInsuficienteException caso nao tenha dinheiro sificiente
	 *                                        para comprar
	 * 
	 *                                        teste para saber se estar debitando o
	 *                                        valor correto na proca do terreno
	 */
	@Test
	void testCompraDeTerreno() throws DinheiroInsuficienteException {
		jogador.compraPropriedade(100, terreno);
		assertEquals(1400, jogador.getCarteira());
	}

	/**
	 * 
	 * @throws DinheiroInsuficienteException caso nao tenha dinheiro sificiente
	 *                                        para comprar
	 * 
	 *                                        teste para saber se estar debitando o
	 *                                        valor correto na compra da companhia
	 */
	@Test
	void testCompraDeCompanhia() throws DinheiroInsuficienteException {
		jogador.compraPropriedade(200, companhia);
		assertEquals(1300, jogador.getCarteira());
	}

	/**
	 * @exception caso o jogador nao tenha dinhero sufiente para comprar a casa essa
	 *                 exerption deve ser lançada
	 */
	@Test
	void testCompraDeTerrenoComDinheiroInvalido() {
		Exception compra = assertThrows(DinheiroInsuficienteException.class,
				() -> jogador.compraPropriedade(2000, companhia));
		assertEquals("Jogador não possui dinheiro sufiente para comprar a propriedade", compra.getMessage());

	}
	
	@Test
	public void testAndarCasas() {
		int Dado1 = jogadorMock.lancaDado();
		int Dado2 = jogadorMock.lancaDado();
	Mockito.when(jogadorMock.andarCasas(Dado1 , Dado2)).thenReturn(10);
	
	
	
	assertEquals(10, jogadorMock.andarCasas(Dado1,Dado2));
	Mockito.verify(jogadorMock,Mockito.times(1)).andarCasas(Dado1, Dado2);
	
	
	}
	
	
	@Test
	void testAdicionandoDinehiroNaContaDoJogador() {
	jogador.creditar(100);
	assertEquals(1600, jogador.getCarteira());
	}
	
	@Test
	void testDebitandoDinheiroDaCarteiraDoJogador() {
		jogador.debitar(500);
		assertEquals(1000, jogador.getCarteira());
	}
	
	
	
	
	
	
	
	
	
}
