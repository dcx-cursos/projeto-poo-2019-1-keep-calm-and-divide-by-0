package ufpb.rt.pooPrjt.bancoImb.metodosUtilirarios;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ufpb.rt.pooPrjt.bancoImb.principal.Jogador;

class GravadorTest {
	Gravador gravar = new Gravador();
	Jogador jogador = new Jogador("cleyson","preto");
	Jogador jogador2 = new Jogador("cleyson","rosa");
	Jogador jogador3 = new Jogador("cleyson","azul");
	Jogador jogador4 = new Jogador("cleyson","amarelo");
	ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
		
	
		


	@Test
	void AdicionandoVAriosJogadores() {
		gravar.gravaEmLista(jogadores, jogador);
		gravar.gravaEmLista(jogadores, jogador2);
		gravar.gravaEmLista(jogadores, jogador3);
		gravar.gravaEmLista(jogadores, jogador4);
		assertEquals(4, jogadores.size());
		
	}

}
