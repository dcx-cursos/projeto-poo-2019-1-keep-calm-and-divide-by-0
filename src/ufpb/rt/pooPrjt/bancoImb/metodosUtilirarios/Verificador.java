package ufpb.rt.pooPrjt.bancoImb.metodosUtilirarios;

import java.util.ArrayList;

public class Verificador {
	
	
	/**
	 * 
	 * @param lista lista que estar sendo verificada
	 * @param e item que estar sendo pesquisado
	 * @return true se o item estiver na lista
	 */
	public boolean verificaStringEmLista(ArrayList<String> lista, String e) {
		return lista.contains(e);
		
	}
	
	/**
	 * 
	 * @param item1 item de entrada
	 * @param item2 item de entrada
	 * @return true se os dois são iguais
	 */
	public boolean verificaDuasStrings(String item1, String item2) {
		return item1.equals(item2);
		
	}
	
	/**
	 * 
	 * @param numI inteiro de entrada
	 * @param numII inteiro de entrada
	 * @return true se os dois são iguais
	 */
	public boolean verificaDoisInteirosIguais(int numI,int numII){
		if(numI==numII) {
			return true;
		}
		return false;
	}
}
