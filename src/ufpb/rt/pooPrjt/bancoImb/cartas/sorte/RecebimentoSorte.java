package ufpb.rt.pooPrjt.bancoImb.cartas.sorte;

import ufpb.rt.pooPrjt.bancoImb.interfaces.SorteOuReves;
import ufpb.rt.pooPrjt.bancoImb.principal.Jogador;

public class RecebimentoSorte implements SorteOuReves {

	private String descricao;
	private int valor;

	public RecebimentoSorte(String descricao, int valor) {
		this.descricao = descricao;
		this.valor = valor;
	}

	@Override
	public void acao(Jogador jogador) {
		jogador.creditar(valor);
	}

	@Override
	public String getDescricao() {
		// TODO Auto-generated method stub
		return this.descricao;
	}

}
