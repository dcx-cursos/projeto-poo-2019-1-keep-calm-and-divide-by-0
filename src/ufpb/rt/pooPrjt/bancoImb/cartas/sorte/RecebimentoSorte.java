package ufpb.rt.pooPrjt.bancoImb.cartas.sorte;

import ufpb.rt.pooPrjt.bancoImb.interfaces.SorteOuReves;
import ufpb.rt.pooPrjt.bancoImb.principal.Jogador;

public class RecebimentoSorte implements SorteOuReves {

	private String descricao;
	private int valor;

	
	/**
	 * 
	 * @param descricao descriçao das cartas
	 * @param valor valor que o jogador deve receber
	 */
	public RecebimentoSorte(String descricao, int valor) {
		this.descricao = descricao;
		this.valor = valor;
	}

	/**
	 * quanto o jogador deve receber
	 */
	public void acao(Jogador jogador) {
		jogador.creditar(valor);
	}

	/**
	 * mostrar a descriçao da carta
	 */
	public String getDescricao() {
		// TODO Auto-generated method stub
		return this.descricao;
	}

}
