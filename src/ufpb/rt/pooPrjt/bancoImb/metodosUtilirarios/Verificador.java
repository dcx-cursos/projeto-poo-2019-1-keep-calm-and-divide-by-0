package ufpb.rt.pooPrjt.bancoImb.metodosUtilirarios;

import java.util.ArrayList;

public class Verificador {
	
	
	/**
	 * 
	 * @param lista lista que estar sendo verificada
	 * @param e item que estar sendo pesquisado
	 * @return o intem achado
	 */
	public boolean verificaStringEmLista(ArrayList<String> lista, String e) {
		return lista.contains(e);
		
	}
	
	public boolean verificaDuasStrings(String item1, String item2) {
		return item1.equals(item2);
		
	}
}
