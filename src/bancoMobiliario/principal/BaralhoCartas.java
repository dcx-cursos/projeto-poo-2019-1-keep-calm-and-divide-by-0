package ufpb.rt.pooPrjt.bancoImb.principal;

import java.util.ArrayList;
import java.util.Random;

import ufpb.rt.pooPrjt.bancoImb.interfaces.SorteOuReves;

public class BaralhoCartas {
	
	private ArrayList<SorteOuReves> baralho = new ArrayList<SorteOuReves>();
	
	public BaralhoCartas() {
		this.baralho.add(new );
		this.baralho.add(new );
		this.baralho.add(new );
		this.baralho.add(new );
		this.baralho.add(new );
		this.baralho.add(new );
		this.baralho.add(new );
		this.baralho.add(new );
		this.baralho.add(new );
		this.baralho.add(new );
		this.baralho.add(new );
		this.baralho.add(new );
		this.baralho.add(new );
		this.baralho.add(new );
		this.baralho.add(new );
		this.baralho.add(new );
		this.baralho.add(new );
		this.baralho.add(new );
		this.baralho.add(new );
		this.baralho.add(new );
		this.baralho.add(new );
		this.baralho.add(new );
		this.baralho.add(new );
		this.baralho.add(new );
		this.baralho.add(new );
		this.baralho.add(new );
		this.baralho.add(new );
		this.baralho.add(new );
		this.baralho.add(new );
		this.baralho.add(new );
		this.baralho.add(new );
	}
	
	public ArrayList<SorteOuReves> gerarBaralhoEmbaralhado() {
		ArrayList<SorteOuReves> baralhoEmbaralhado = new ArrayList<SorteOuReves>();
		Random r = new Random();
		
		while(baralhoEmbaralhado.size()<31) {
			SorteOuReves carta = this.baralho.get(r.nextInt(31));
			if (baralhoEmbaralhado.contains(carta)!=true) {
				baralhoEmbaralhado.add(carta);
			}
		}
		
		return baralhoEmbaralhado;

	}
}
