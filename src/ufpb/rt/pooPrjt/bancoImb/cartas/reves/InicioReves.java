package ufpb.rt.pooPrjt.bancoImb.cartas.reves;

import ufpb.rt.pooPrjt.bancoImb.interfaces.SorteOuReves;
import ufpb.rt.pooPrjt.bancoImb.principal.Jogador;

public class InicioReves implements SorteOuReves{
	
	private String descricao = "Vá para o início";

	/**
	 * faz o jogador voltar para o inicio do tabuleiro
	 */
	public void acao(Jogador jogador) {
		jogador.setPosicao(0);
	}

	/**
	 * mostra a descriçao da carta
	 */
	public String getDescricao() {
		// TODO Auto-generated method stub
		return descricao;
	}
	
	
}
