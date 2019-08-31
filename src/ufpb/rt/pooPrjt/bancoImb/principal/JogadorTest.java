package ufpb.rt.pooPrjt.bancoImb.principal;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
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
	Mockito.when(jogadorMock.andarCasas(5,5)).thenReturn(10);
	assertEquals(10, jogadorMock.andarCasas(5,5));
	Mockito.verify(jogadorMock,Mockito.times(1)).lancaDado();
	
	
	}
	
}
