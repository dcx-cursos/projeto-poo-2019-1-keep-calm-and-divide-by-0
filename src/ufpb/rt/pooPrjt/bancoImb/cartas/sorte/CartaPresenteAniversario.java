package ufpb.rt.pooPrjt.bancoImb.cartas.sorte;

import java.util.ArrayList;

import ufpb.rt.pooPrjt.bancoImb.cartas.metodosAuxiliares.MetodosCartasEspeciais;
import ufpb.rt.pooPrjt.bancoImb.interfaces.SorteOuReves;
import ufpb.rt.pooPrjt.bancoImb.principal.Jogador;
import ufpb.rt.pooPrjt.bancoImb.principal.SisJogo;

public class CartaPresenteAniversario implements SorteOuReves{
	
	private String descricao;
	private int valor;
	private SisJogo sis = new SisJogo();
	MetodosCartasEspeciais metodo = new MetodosCartasEspeciais();

	public CartaPresenteAniversario(String descricao, int valor) {
		this.descricao = descricao;
		this.valor = valor;
	}
	
	@Override
	public void acao(Jogador jogador) {
		jogador.creditar(metodo.debitaValorDeJogadores(jogador, sis.getJogadores(), valor));
	}

	@Override
	public String getDescricao() {
		// TODO Auto-generated method stub
		return this.descricao;
	}

}
