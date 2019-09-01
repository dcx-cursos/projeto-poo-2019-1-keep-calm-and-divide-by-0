package ufpb.rt.pooPrjt.bancoImb.cartas.reves;

import ufpb.rt.pooPrjt.bancoImb.interfaces.SorteOuReves;
import ufpb.rt.pooPrjt.bancoImb.principal.Jogador;

public class PagamentoReves implements SorteOuReves{
	
	private String descricao;
	private int valor;

	public PagamentoReves(String descricao, int valor) {
		this.descricao = descricao;
		this.valor = valor;
	}
	
	@Override
	public void acao(Jogador jogador) {
		jogador.debitar(valor);
	}

	@Override
	public String getDescricao() {
		// TODO Auto-generated method stub
		return this.descricao;
	}

}
