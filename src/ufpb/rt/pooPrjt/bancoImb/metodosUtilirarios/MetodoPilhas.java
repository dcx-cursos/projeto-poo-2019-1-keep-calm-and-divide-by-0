package ufpb.rt.pooPrjt.bancoImb.metodosUtilirarios;

import java.util.ArrayList;

public class MetodoPilhas {

	/**
	 * 
	 * @param pilha lista de entrada
	 * @param maxIndex indice máximo da lista
	 * desempiplha determinado objeto do ultimo indice da lista e o coloca no inicio
	 */
	public void desempilharItemDePilha(ArrayList pilha, int maxIndex) {
		Object item = pilha.get(maxIndex);
		for(int j=maxIndex; j>0; j--) {
			pilha.set(j, pilha.get(j-1));
		}
		pilha.set(0, item);
	}

}
