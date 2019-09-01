package ufpb.rt.pooPrjt.bancoImb.principal;

import java.util.ArrayList;
import java.util.Random;

import ufpb.rt.pooPrjt.bancoImb.cartas.reves.PagamentoReves;
import ufpb.rt.pooPrjt.bancoImb.cartas.reves.PrisaoReves;
import ufpb.rt.pooPrjt.bancoImb.cartas.sorte.CartaPresenteAniversario;
import ufpb.rt.pooPrjt.bancoImb.cartas.sorte.PrisaoSorte;
import ufpb.rt.pooPrjt.bancoImb.cartas.sorte.RecebimentoSorte;
import ufpb.rt.pooPrjt.bancoImb.interfaces.SorteOuReves;

public class BaralhoCartas {  
	
	private ArrayList<SorteOuReves> baralho = new ArrayList<SorteOuReves>(); // lista de cartas Sorte ou Reves
	
	public BaralhoCartas() {
		this.baralho.add(new PagamentoReves("Sua empresa foi multada por poluir demais , Pague 200",200));//1
		this.baralho.add(new PagamentoReves("ainda não foi implementado",0));//2
		this.baralho.add(new PagamentoReves("Reformou sua casa , pague 50",50));//3
		this.baralho.add(new RecebimentoSorte("Seu livro será publicado por uma grande editora , receba 50" , 50));//4
		this.baralho.add(new PrisaoSorte());//5
		this.baralho.add(new PrisaoReves());//6
		this.baralho.add(new RecebimentoSorte("Vá até o início , receba 100 " , 100));//7
		this.baralho.add(new RecebimentoSorte("Suas ações na bolsa de valores estão em alta , receba 100" , 100));//8
		this.baralho.add(new PagamentoReves("Você vai começar um curso de MBA e ganhou um bom desconto para pagamento a vista, pague 20",20));//9
		this.baralho.add(new PagamentoReves("Férias com a familia , pague 20" , 20));//10
		this.baralho.add(new RecebimentoSorte(" Recebeu o prêmio de profissional do ano e ganhou um carro , receba 10" , 10));//11
		this.baralho.add(new PagamentoReves("ainda nao implementafo ",0));//12
		this.baralho.add(new PagamentoReves("Sua empresa irá patrocinar uma expedição a Antártida , pague 50 " , 50));//13
		this.baralho.add(new RecebimentoSorte("Vendeu a parte de sua empresa para um investidor , receba 75" , 75));//14
		this.baralho.add(new RecebimentoSorte("Apostou no cavalo azarão e ganhou , receba 100 " , 100));//15
		this.baralho.add(new PagamentoReves("A falta de chuva prejudicou a colheita , pague 45" , 45));//16
		this.baralho.add(new RecebimentoSorte("Recebeu uma herança inesperada , receba 75" , 75));//17
		this.baralho.add(new PagamentoReves("Seu filho decidiu fazer intercâmbio , pague 20" , 20));//18
		this.baralho.add(new RecebimentoSorte("Sua casa será desapropriada para a construção de um metro e ganhará uma gordaindenização , receba 60" , 60));//19
		this.baralho.add(new RecebimentoSorte("Venceu licitação para grande obra , receba 150" , 150));//20
		this.baralho.add(new RecebimentoSorte("Seu iate afundou, mas você tinha seguro! , receba 25" , 25));//21
		this.baralho.add(new PagamentoReves("Seus funcionários entraram em greve pague 30" , 30));//22
		this.baralho.add(new PagamentoReves("Comprou obra de arte falsificada , pague 22" , 22));//23
		this.baralho.add(new PagamentoReves("ainda não foi implementado",0));//24
		this.baralho.add(new PagamentoReves("Seu jatinho precisa de manutenção , pague 9 " , 9));//25
		this.baralho.add(new PagamentoReves("Renovou a frota de carros da sua empresa , pague 100 " , 100));//26
		this.baralho.add(new RecebimentoSorte("Ganhou sozinho na loteria , receba 80" , 80));//27
		this.baralho.add(new PagamentoReves("Atualizou os computadores da sua empresa , pague 30" , 30));//28	
		this.baralho.add(new PagamentoReves("Um navio afundou com suas mercadorias (não tinha seguro) , pague 40 " , 40));//29
		this.baralho.add(new PagamentoReves("Produção de leite de suas fazendas ficou abaixo da expectativa , pague 60" , 60));//30
		this.baralho.add(new RecebimentoSorte("Tirou primeiro lugar no torneio de golfe , receba 100" , 100));//31
	}
	
	/**
	 * 
	 * @return uma lista embaralhada de cartas Sorte ou Reves
	 */
	public ArrayList<SorteOuReves> gerarBaralhoEmbaralhado() {
		ArrayList<SorteOuReves> baralhoEmbaralhado = new ArrayList<SorteOuReves>();
		Random r = new Random();
		
		while(baralhoEmbaralhado.size() < 31) {
		
			SorteOuReves carta = this.baralho.get(r.nextInt(31));
			if (baralhoEmbaralhado.contains(carta)!=true) {
				baralhoEmbaralhado.add(carta);
			}
		}
		
		return baralhoEmbaralhado;

	}
	
	/**
	 * 
	 * @param baralhoJogo, lista de Sorte ou Reves de entrada
	 * @return retorna uma carta Sorte ou Reves
	 */
	public SorteOuReves pegaCartaDobaralho(ArrayList<SorteOuReves> baralhoJogo) {
		SorteOuReves carta = baralhoJogo.get(30);
		for(int j=30; j>0; j--) {
			baralho.set(j, baralhoJogo.get(j-1));
		}
		baralho.set(0, carta);
		
		return carta;
	}

	
	
}
