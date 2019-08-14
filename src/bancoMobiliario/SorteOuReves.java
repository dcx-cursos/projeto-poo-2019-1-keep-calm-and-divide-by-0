package bancoMobiliario;

import java.util.Random;

public class SorteOuReves {
	
	//Ainda a ser acrescentado na classe main
	
	
	
	public static void main (String[] args) {
		
	String [] sorteReves;
				
	sorteReves = new String [30];
	Random random = new Random();
	
	
	sorteReves[0] = ("Sua empresa foi multada por poluir demais, Pague 200");
	sorteReves[1] = ("O dia do seu casamento chegou, receba os presentes, Receba 50 de cada jogador");
	sorteReves[2] = ("Reformou sua casa, Pague 50");
	sorteReves[3] = ("Seu livro será publicado por uma grande editora, Receba 50");
	sorteReves[4] = ("Utilize este cartão para se livrar da prisão");
	sorteReves[5] = ("Vá para a prisão, Receba 200");
	sorteReves[6] = ("Vá até o início, Receba 100");
	sorteReves[7] = ("Suas ações na bolsa de valores estão em alta");
	sorteReves[8] = ("Você vai começar um curso de MBA e ganhou um bom desconto para\n" + 
			"\n" + 
			"pagamento a vista, Pague 20");
	sorteReves[9] = ("Férias com a familia pague, Pague 20");
	sorteReves[10] = ("Recebeu o prêmio de profissional do ano e ganhou um carro, Receba 10");
	sorteReves[11] = ("Jogue os dados novamente");
	sorteReves[12] = ("Sua empresa irá patrocinar uma expedição a Antártida, Pague 50");
	sorteReves[13] = ("Vendeu a parte de sua empresa para um investidor, Receba 75");
	sorteReves[14] = ("Apostou no cavalo azarão e ganhou, Receba 100");
	sorteReves[15] = ("Recebeu uma herança inesperada, Receba 45");
	sorteReves[16] = ("Seu filho decidiu fazer intercâmbio, Pague 20");
	sorteReves[17] = ("Sua casa será desapropriada para a construção de um metro e ganhará uma gorda indenização, Receba 60");
	sorteReves[18] = ("A falta de chuva prejudicou a colheita, Pague 45");
	sorteReves[19] = ("Venceu licitação para grande obra, Receba 150");
	sorteReves[20] = ("Seu iate afundou, mas você tinha seguro!, Receba 25");
	sorteReves[21] = ("Seus funcionários entraram em greve, Pague 45");
	sorteReves[22] = ("Comprou obra de arte falsificada, Pague 22");
	sorteReves[23] = ("Sorte se tirou o número par da soma dos dados e revés caso contrário, Receba 100 ou Pague 100");
	sorteReves[24] = ("Seu jatinho precisa de manutenção, Pague 9");
	sorteReves[25] = ("Renovou a frota de carros da sua empresa, Pague 100");
	sorteReves[26] = ("Ganhou sozinho na loteria, Receba 80");
	sorteReves[27] = ("Um navio afundou com suas mercadorias (não tinha seguro), Pague 40");
	sorteReves[28] = ("Produção de leite de suas fazendas ficou abaixo da expectativa, Pague 60");
	sorteReves[29] = ("Tirou primeiro lugar no torneio de golfe, Receba 100");
	sorteReves[30] = ("Atualizou os computadores da sua empresa, Receba 30");
	
	for (int i=0; i<sorteReves.length; i++) {
        sorteReves[i] = random.nextInt(i);
        System.out.println(sorteReves[i]);
		
	}
	
	}

}

