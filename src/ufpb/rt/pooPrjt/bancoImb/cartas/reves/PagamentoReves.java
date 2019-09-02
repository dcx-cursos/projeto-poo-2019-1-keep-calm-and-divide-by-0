package ufpb.rt.pooPrjt.bancoImb.cartas.reves;

import ufpb.rt.pooPrjt.bancoImb.interfaces.SorteOuReves;
import ufpb.rt.pooPrjt.bancoImb.principal.Jogador;

public class PagamentoReves implements SorteOuReves{
	
	private String descricao;
	private int valor;
/**
 * 
 * @param descricao oque deve ser feito quando o jogador pega a carta
 * @param valor oque deve ser retirado em sua carteira
 */
	public PagamentoReves(String descricao, int valor) {
		this.descricao = descricao;
		this.valor = valor;
	}
	
	
	/**
	 * quando o jogador deve pagar
	 */
	public void acao(Jogador jogador) {
		jogador.debitar(valor);
	}

	
	
	/**
	 * mosta a descriçao da carta
	 */
	public String getDescricao() {
		// TODO Auto-generated method stub
		return this.descricao;
	}

}
