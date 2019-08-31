package ufpb.rt.pooPrjt.bancoImb.metodosUtilirarios;

import java.util.ArrayList;

public class Verificador {
	
	public boolean verificaStringEmLista(ArrayList lista, String e) {
		if(lista.contains(e)) {
			return true;
		}
		return false;
	}
}
