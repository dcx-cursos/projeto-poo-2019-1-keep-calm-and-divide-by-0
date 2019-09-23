package ufpb.rt.pooPrjt.bancoImb.principal;

import java.util.ArrayList;
import java.util.Random;
import ufpb.rt.pooPrjt.bancoImb.exceptions.DinheiroInsuficienteException;
import ufpb.rt.pooPrjt.bancoImb.exceptions.SemCartasDeSairDaPrisao;
import ufpb.rt.pooPrjt.bancoImb.exceptions.SemCasasParaVendaException;
import ufpb.rt.pooPrjt.bancoImb.interfaces.Propriedade;
import ufpb.rt.pooPrjt.bancoImb.interfaces.SorteOuReves;

public class Jogador {
	private String nome;
	private String cor;
	private int carteira = 1500;
	private int posicao = 0;
	private int diasNaPrisao = 0;
	private int vezesQueTirouDadosIguais = 0;
	private ArrayList<Propriedade> propriedades = new ArrayList<Propriedade>();
	private ArrayList<SorteOuReves> cartaPrisao = new ArrayList<SorteOuReves>();
	private Random r = new Random();

	/**
	 * 
	 * @param nome nome do jogador
	 * @param cor  a cor do jogador
	 */
	public Jogador(String nome, String cor) {
		this.nome = nome;
		this.cor = cor;
	}

	/**
	 * 
	 * @return posiçao atual do jogador
	 */
	public int getPosicao() {
		return this.posicao;
	}

	/**
	 * 
	 * @return cor escolhida pelo jogador
	 */
	public String getCor() {
		return this.cor;
	}

	/**
	 * 
	 * @return nome do jogador
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * 
	 * @return retorna um valor aleatorio de um dado de 6 lados
	 */
	public int lancaDado() {
		return r.nextInt(6) + 1;
	}

	/**
	 * 
	 * @param numDadoUm   valor do primeiro dado jogado
	 * @param numDadoDois valor do segundo dado jogado
	 * 
	 * 
	 *                    metodo para mudar a posiçao do jogador , soma o reultado
	 *                    dos dados e avança o jogador caso a soma dos dados for
	 *                    superior a 40 , diminua 40 , indicando que o jagador deu
	 *                    uma volta completa no tabuleiro quando o jogador conseguir
	 *                    dois números iguais no dado, um contador é incrementado
	 *                    representando as vezes em que isso ocorreu
	 */
	public int andarCasas(int numDadoI, int numDadoII) {
		if (numDadoI == numDadoII && this.diasNaPrisao == 0) {
			vezesQueTirouDadosIguais += 1;
		}

		if ((this.posicao + (numDadoI + numDadoII) > 39)) {
			this.posicao = (this.posicao + (numDadoI + numDadoII)) - 40;
			this.carteira += 200;
		} else {
			this.posicao += numDadoI + numDadoII;
		}
		return this.posicao;
	}

	/**
	 * 
	 * @return uma lista de todas as propriedades que pertence ao jogador
	 */
	public ArrayList<Propriedade> getPropriedades() {
		return propriedades;
	}

	/**
	 *
	 * @param propriedades lista de todas as propriedades
	 */
	public void setPropriedades(ArrayList<Propriedade> propriedades) {
		this.propriedades = propriedades;
	}

	/**
	 * caso o jogador va para prisao ele deve ficar la por 3 dias
	 */
	public void irParaPrisao() {
		this.diasNaPrisao = 3;
		this.posicao = 10;
	}

	public void sairDaPrisao() {
		this.diasNaPrisao = 0;
		setVezesQueTirouDadosIguais(0);

	}

	/**
	 * 
	 * @return dias que o jogador esta preso
	 */
	public int getDiasNaPrisao() {
		return this.diasNaPrisao;
	}

	public void setCartaPrisao(SorteOuReves carta) {
		this.cartaPrisao.add(carta);

	}

	/**
	 * opçao para o jogador sair da prisao
	 * 
	 * @throws SemCartasDeSairDaPrisao caso o jogador nao tenha posse da carta de
	 *                                 passe livre
	 */
	public void usarCartaPrisao() throws SemCartasDeSairDaPrisao {
		if (cartaPrisao == null) {
			throw new SemCartasDeSairDaPrisao("Você não tem cartas para sair da prisão.");
		} else {
			cartaPrisao.get(0).acao(this);
			setVezesQueTirouDadosIguais(0);
			cartaPrisao.remove(0);
		}
	}

	/**
	 * opaçao quando o jogador estar preso , ele pode escolher pagar pagar para sair
	 * 
	 * @param fianca valor que deve ser pago pelo jogador para sair
	 * @throws DinheiroInsuficienteException se o jogador nao tiver dinheiro
	 *                                       suficiente para pagar a fiança
	 */
	public void pagarParaSairDaPrisao(int fianca) throws DinheiroInsuficienteException {
		if (this.carteira < fianca) {
			throw new DinheiroInsuficienteException("Você não tem saldo suficiente.");
		} else {
			debitar(fianca);
			setVezesQueTirouDadosIguais(0);
			sairDaPrisao();
		}

	}

	/**
	 * 
	 * @param num numero que será setado ao parametro 
	 * 			  Se o jogador conseguir sair da
	 *            prisão de alguma forma, e o numero de vezes em que ele tirou
	 *            numeros iguais é um multiplo de 3, o parametro é atualizado
	 */
	private void setVezesQueTirouDadosIguais(int num) {
		if ((this.vezesQueTirouDadosIguais % 3) == 0)
			this.vezesQueTirouDadosIguais = num;
	}
	
	public void zeraVezesQueTirouDadosIguais() {
		this.vezesQueTirouDadosIguais = 0;
	}

	/**
	 * quando dias ele estar preso
	 * 
	 * @param dia quantidade de dias
	 */
	public void setDiaPassadoNaPrisao(int dia) {
		this.diasNaPrisao -= 1;

	}

	/**
	 * 
	 * @param valorCompraPropriedade valor para comprar a propriedade
	 * @param propriedade            propriedade no qual o jogador deseja comprar
	 * 
	 *                               metodo para realizar a compra de uma
	 *                               propriedade no tabuleiro
	 * @throws DineheiroInsuficienteException caso o jogador nao tenha dineheiro
	 *                                        suficiente para comparar a propriedade
	 *                                        este metodo deve realizar a venda de
	 *                                        uma propriedade
	 */
	public void compraPropriedade(int valorCompraPropriedade, Propriedade propriedade)
			throws DinheiroInsuficienteException {
		if (this.carteira < valorCompraPropriedade) {
			throw new DinheiroInsuficienteException("Jogador não possui dinheiro sufiente para comprar a propriedade");
		} else {
			this.carteira -= valorCompraPropriedade;
			this.propriedades.add(propriedade);
			propriedade.setDono(this);

		}

	}

	/**
	 * 
	 * @param valorCompraPropriedade valor para vender sua propriedade
	 * @param propriedade            propriedade no qual o jogador que vender
	 */
	public void vendePropriedade(int valorCompraPropriedade, Propriedade propriedade) {
		this.carteira += valorCompraPropriedade;
		this.propriedades.remove(propriedade);
	}

	/**
	 * 
	 * @return total de dinheiro que o jogador possui
	 */
	public int getCarteira() {
		return this.carteira;
	}

	/**
	 * mosta a situaçao atual do jogador (posiçao ,dinheiro e suas propriedades)
	 * 
	 * @param propriedades recebe a lista de todas as propriedades
	 * @return o status do jogador de acordo com a sua posiçao
	 */
	public String getStatus(ArrayList<Propriedade> propriedades) {
		Propriedade localPropriedade = propriedades.get(this.posicao);// Propriedade do local do jogador
		String propriedadesJogador = "";// Variavel para guardar o nome das propriedades que o jogador possui
		if (this.propriedades.isEmpty()) {// Se o vetor de propriedades do jogador estiver vazio faça...
			propriedadesJogador += "Jogador não tem nenhuma propriedade ainda\n";

		} else {// Se não estiver vazio faça...
			for (int i = 0; i < this.propriedades.size(); i++) {
				Propriedade propriedade = this.propriedades.get(i);// Propriedade da lista de propriedades que o jogador
																	// possui
				if (propriedade.getTipo().equals("TERRENO")) {// Se for fo tipo TERRENO faça
					propriedadesJogador += "[" + propriedade.getNome() + "] - propriedade " + propriedade.getCor() + ", aluguel "
							+ propriedade.getInformacoesStatus()+", numeros de casas construidas : " + propriedade.getNumCasas()+"\n";
				} else {// Se não é então é companhia
					propriedadesJogador += "[" + propriedade.getNome() + "] - multiplicador "
							+ propriedade.getInformacoesStatus() + "\n";
				}
			}
		}

		if (this.posicao == 0) {
			return "O status de " + this.nome + " - " + this.cor + " é o seguinte:\n" + "Situado na posição "
					+ this.posicao + " - Inicio\n" + "Possui " + this.getCarteira() + "$ \n" + "Títulos:\n"
					+ propriedadesJogador;

		} else if (this.posicao == 10) {
			return "O status de " + this.nome + " - " + this.cor + " é o seguinte:\n" + "Situado na posição "
					+ this.posicao + " - Prisão\n" + "Possui " + this.getCarteira() + "$ \n" + "Títulos:\n"
					+ propriedadesJogador;

		} else if ((this.posicao == 2 | this.posicao == 12) | (this.posicao == 16 | this.posicao == 22)
				| (this.posicao == 27 | this.posicao == 37)) {
			return "O status de " + this.nome + " - " + this.cor + " é o seguinte:\n" + "Situado na posição "
					+ this.posicao + " - Sorte ou Reves\n" + "Possui " + this.getCarteira() + "$ \n" + "Títulos:\n"
					+ propriedadesJogador;

		} else if ((this.posicao != 18 && this.posicao != 20) && (this.posicao != 24 && this.posicao != 30)) {// Excluí
																												// todas
																												// as
																												// posições
																												// que
																												// são
																												// null.
																												// Podem
																												// haver
																												// modificações
																												// pra
																												// ela
																												// retornar
																												// somente
																												// o
																												// nome
																												// dessas
																												// posições
			return "O status de " + this.nome + " - " + this.cor + " é o seguinte:\n" + "Situado na posição "
					+ this.posicao + " - " + localPropriedade.getNome() + "\n" + "Possui " + this.getCarteira() + "$ \n"
					+ "Títulos:\n" + propriedadesJogador;
		} else {// Se for uma dessas então retorne...
			return "O status de " + this.nome + " - " + this.cor + " é o seguinte:\n" + "Situado na posição "
					+ this.posicao + "\n" + "Possui " + this.getCarteira() + "$ \n" + "Títulos:\n"
					+ propriedadesJogador;
		}
	}

	/**
	 * retira dinheiro na carteira do jogador
	 * 
	 * @param valor quanto que deve ser retirado da carteira
	 */
	public void debitar(int valor) {
		this.carteira -= valor;

	}

	/**
	 * adiciona dinheiro na carteira do jogador
	 * 
	 * @param valor quanto que deve ser adicionado
	 */
	public void creditar(int valor) {
		this.carteira += valor;

	}

	/**
	 * metodo para alterar a posiçao do jogagor
	 * 
	 * @param posi numeros de casas que sao avançadas
	 */
	public void setPosicao(int posi) {
		this.posicao = posi;

	}
/**
 * verifica quantas tuplas seguidas o jogador tirou
 * @return quantidade de tuplas tiradas
 */
	public int getVezesQueTirouDadosIguais() {
		return this.vezesQueTirouDadosIguais;
	}

	public void zerarVezesQueTirouDadosIguais() {
		this.vezesQueTirouDadosIguais = 0;
	}
	/**
	 * motodo para realizar a construçao de casas em um terreno
	 * @param terrenoDoJogador terreno que pertence ao jogador
	 * @throws DinheiroInsuficienteException caso o jogador tente construir uma casa e esteja sem dinheiro suficiente
	 */
	public void construirCasaEmTerreno(Propriedade terrenoDoJogador) throws DinheiroInsuficienteException {
		if(terrenoDoJogador.getPrecoCasa()>this.carteira) {
			throw new DinheiroInsuficienteException("Jogador não possui dinheiro sufiente para construir a propriedade"); 
		}else {
			terrenoDoJogador.contruirCasa();
			debitar(terrenoDoJogador.getPrecoCasa());
		}
		
	}
	/**
	 * metodo para realizar a venda das casas em uma propriedade
	 * @param terrenoDoJogador terreno que pertence ao jogador
	 * @throws SemCasasParaVendaException caso o jogador tente vender um casa onde o terreno esta sem casa
	 */
	public void venderCasaEmTerreno(Propriedade terrenoDoJogador) throws SemCasasParaVendaException {
		if(terrenoDoJogador.getNumCasas()<=0) {
			throw new SemCasasParaVendaException("Você não possui casas neste terreno ainda. Construa uma casa primeiro.");
		}else {
			terrenoDoJogador.venderCasa();
			creditar(terrenoDoJogador.getPrecoCasa());
		}
	}
}
