package ufpb.rt.pooPrjt.bancoImb.cartas.sorte;

import ufpb.rt.pooPrjt.bancoImb.interfaces.SorteOuReves;
import ufpb.rt.pooPrjt.bancoImb.principal.Jogador;

public class PrisaoSorte implements SorteOuReves{
	
	private String descricao = "Utilize este cartão para se livrar da prisão";

	@Override
	public void acao(Jogador jogador) {
		jogador.sairDaPrisao();
		
	}

	@Override
	public String getDescricao() {
		// TODO Auto-generated method stub
		return this.descricao;
	}
		
	

}
