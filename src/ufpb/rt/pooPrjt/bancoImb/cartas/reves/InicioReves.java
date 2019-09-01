package ufpb.rt.pooPrjt.bancoImb.cartas.reves;

import ufpb.rt.pooPrjt.bancoImb.interfaces.SorteOuReves;
import ufpb.rt.pooPrjt.bancoImb.principal.Jogador;

public class InicioReves implements SorteOuReves{
	
	private String descricao = "Vá para o início";

	@Override
	public void acao(Jogador jogador) {
		jogador.setPosicao(0);
		
	}

	@Override
	public String getDescricao() {
		// TODO Auto-generated method stub
		return descricao;
	}
	
	
}
