
public class TestTabuleiro {

	public static void main(String[] args) {

		Tabuleiro tabuleiro = new Tabuleiro();

		tabuleiro.adicionaPosicionavel();

		
		System.out.println(tabuleiro.getCasas());
		
		for (Posicionavel p : tabuleiro.getCasas()) {
			System.out.println(p);
		}
	}

}
