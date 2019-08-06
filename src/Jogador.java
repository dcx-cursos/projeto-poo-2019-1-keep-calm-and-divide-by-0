import java.util.ArrayList;
import java.util.List;

public class Jogador {

	private String nome;
	private String cor;
	private int carteira;
	private int posicao;
	private List<Propriedade> propriedades;

	public Jogador(String nome, String cor) {
		super();
		this.nome = nome;
		this.cor = cor;
		this.carteira = 1500;
		this.posicao = 1;
		this.propriedades = new ArrayList<Propriedade>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getCarteira() {
		return carteira;
	}

	public void setCarteira(int carteira) {
		this.carteira = carteira;
	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

	public List<Propriedade> getPropriedades() {
		return propriedades;
	}

	public void setPropriedades(List<Propriedade> propriedades) {
		this.propriedades = propriedades;
	}

	@Override
	public String toString() {
		return " Jogador : " + nome + ", cor : " + cor;
	}
	

}
