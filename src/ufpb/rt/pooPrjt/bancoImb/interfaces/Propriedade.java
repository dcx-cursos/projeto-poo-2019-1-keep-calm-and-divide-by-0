package ufpb.rt.pooPrjt.bancoImb.interfaces;

import ufpb.rt.pooPrjt.bancoImb.exceptions.SemCasasParaVendaException;
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
	
    public int valorAserPagoParaODonoDoTerreno();
    
    public int valorAserPagoParaODonoDaCompanhia(int numDados);
    
    public String getCor();

	public int getNumCasas();
	
	public void contruirCasa();
	
	public void venderCasa();
	
	public int getPrecoCasa();
}
