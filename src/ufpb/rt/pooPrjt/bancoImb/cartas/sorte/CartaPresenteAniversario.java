package ufpb.rt.pooPrjt.bancoImb.cartas.sorte;

import java.util.ArrayList;

import ufpb.rt.pooPrjt.bancoImb.cartas.metodosAuxiliares.MetodosCartasEspeciais;
import ufpb.rt.pooPrjt.bancoImb.interfaces.SorteOuReves;
import ufpb.rt.pooPrjt.bancoImb.principal.Jogador;
import ufpb.rt.pooPrjt.bancoImb.principal.SisJogo;

public class CartaPresenteAniversario implements SorteOuReves{
	
	private String descricao;
	private int valor;
	private ArrayList<Jogador> jogadores;
	MetodosCartasEspeciais metodo = new MetodosCartasEspeciais();

	
	/**
	 * 
	 * @param descricao descriçao da carta 
	 * @param valor o numero de jogador * 50
	 */
	public CartaPresenteAniversario(String descricao, int valor) {
		this.descricao = descricao;
		this.valor = valor;
	}
	
	
	
	/**
	 * açao que o jogador deve realizar
	 */
	public void acao(Jogador jogador) {
		jogador.creditar(metodo.debitaValorDeJogadores(jogador, this.jogadores, valor));
	}
	
	/**
	 * mostar a descriçao da carta
	 */
	public String getDescricao() {
		// TODO Auto-generated method stub
		return this.descricao;
	}

}
