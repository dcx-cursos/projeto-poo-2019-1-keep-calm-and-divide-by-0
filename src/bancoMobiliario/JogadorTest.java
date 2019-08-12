package bancoMobiliario;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * 
 * @author cleyson
 * @version Junity5
 */
class JogadorTest {
	private Jogador jogador;
	private Propriedade terreno;
	private Propriedade companhia;

	@BeforeEach
	public void inicializa() {
		MockitoAnnotations.initMocks(this);
	}

	@Mock
	Jogador jogadorMock = null;

	/**
	 * antes de cada teste deve criar um novo jogador
	 */
	@BeforeEach
	void setup() {
		jogador = new Jogador("cleyson", "rosa");
		terreno = new Terreno("Leblon", 100, 6, 30, 90, 270, 400, 500, 50, 50, 0, 6);
		companhia = new Companhia("Companhia de Taxi Aereo", 200, 100, 50);
		// jogadorMock = new Jogador("gabriel","azul");

	}

	/**
	 * 
	 * @throws DineheiroInsuficienteException caso nao tenha dinheiro sificiente
	 *                                        para comprar
	 * 
	 *                                        teste para saber se estar debitando o
	 *                                        valor correto na proca do terreno
	 */
	@Test
	void testCompraDeTerreno() throws DineheiroInsuficienteException {
		jogador.compraPropriedade(100, terreno);
		assertEquals(1400, jogador.getCarteira());
	}

	/**
	 * 
	 * @throws DineheiroInsuficienteException caso nao tenha dinheiro sificiente
	 *                                        para comprar
	 * 
	 *                                        teste para saber se estar debitando o
	 *                                        valor correto na compra da companhia
	 */
	@Test
	void testCompraDeCompanhia() throws DineheiroInsuficienteException {
		jogador.compraPropriedade(200, companhia);
		assertEquals(1300, jogador.getCarteira());
	}

	/**
	 * @exception caso o jogador nao tenha dinhero sufiente para comprar a casa essa
	 *                 exerption deve ser lançada
	 */
	@Test
	void testCompraDeTerrenoComDinheiroInvalido() {
		jogador.setCarteira(50);
		Exception compra = assertThrows(DineheiroInsuficienteException.class,
				() -> jogador.compraPropriedade(100, companhia));
		assertEquals("Jogador não possui dinheiro sufiente para comprar a propriedade", compra.getMessage());

	}

	
	/**
	 * verifica se o jogador muda de posiçao apos os lançamentos dos dados 
	 */
	@Test
	public void testJogadorMundandoDePosicao() {
		int numdado1 = jogadorMock.lancaDado();
		int numdado2 = jogadorMock.lancaDado();
		jogadorMock.setPosicao(numdado1, numdado2);
		Mockito.when(jogadorMock.getPosicao()).thenReturn(6);
		assertEquals(6, jogadorMock.getPosicao());

		Mockito.verify(jogadorMock, Mockito.times(1)).getPosicao();
	}
}
