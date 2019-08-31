package ufpb.rt.pooPrjt.bancoImb.cartas.reves;

import ufpb.rt.pooPrjt.bancoImb.interfaces.SorteOuReves;
import ufpb.rt.pooPrjt.bancoImb.principal.Jogador;

public class PrisaoReves implements SorteOuReves{

	private String descricao = "Vá para prisão";

	@Override
	public void acao(Jogador jogador) {
		jogador.irParaPrisao();
		
	}

	@Override
	public String getDescricao() {
		// TODO Auto-generated method stub
		return this.descricao;
	}

}
