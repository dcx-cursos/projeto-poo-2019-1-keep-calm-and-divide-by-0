package ufpb.rt.pooPrjt.bancoImb.interfaces;

import ufpb.rt.pooPrjt.bancoImb.principal.Jogador;

public interface Propriedade {
	
	public String getNome();
	
	public Jogador getDono();
	
	public void setDono(Jogador newJogador);
	
	public int getPrecoCompra();
	
	public boolean existeDono();
	
	public String getInformacoesStatus();
	
	public String getTipo();
	
	public void pagamentoDeTaxa(Jogador jogador, int infPagamento);

}
