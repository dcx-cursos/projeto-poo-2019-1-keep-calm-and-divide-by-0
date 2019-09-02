package ufpb.rt.pooPrjt.bancoImb.cartas.sorte;

import ufpb.rt.pooPrjt.bancoImb.interfaces.SorteOuReves;
import ufpb.rt.pooPrjt.bancoImb.principal.Jogador;

public class PrisaoSorte implements SorteOuReves{
	
	private String descricao = "Utilize este cartão para se livrar da prisão";

	/**
	 * faz o jogador sair da prisao com esta carta
	 */
	public void acao(Jogador jogador) {
		jogador.sairDaPrisao();
		
	}

	/**
	 * mostra a descriçao da carta
	 */
	public String getDescricao() {
		// TODO Auto-generated method stub
		return this.descricao;
	}
		
	

}
