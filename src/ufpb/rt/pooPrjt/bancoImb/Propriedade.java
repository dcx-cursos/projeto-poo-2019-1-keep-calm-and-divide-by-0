package bancoMobiliario;

public interface Propriedade {
	
	public String getNome();
	
	public Jogador getDono();
	
	public void setDono(Jogador newJogador);
	
	public int getPrecoCompra();
	
	public boolean existeDono();
	
	public String getInformacoesStatus();
	
	public String getTipo();

}
