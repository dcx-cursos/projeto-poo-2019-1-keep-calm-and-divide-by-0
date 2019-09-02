package ufpb.rt.pooPrjt.bancoImb.logradouros;

import ufpb.rt.pooPrjt.bancoImb.interfaces.Propriedade;
import ufpb.rt.pooPrjt.bancoImb.principal.Jogador;

public class Terreno implements Propriedade {

	private String nome;
	private int precoCompra;
	private int aluguelSemCasa;
	private int aluguelUmaCasa;
	private int aluguelDuasCasas;
	private int aluguelTresCasas;
	private int aluguelQuatroCasas;
	private int aluguelHotel;
	private int hipoteca;
	private int precoCasa;
	private int numCasas;
	private int aluguel;
	private String TIPO = "TERRENO";
	private Jogador dono = null;
	
	/**
	 * 
	 * @param nome nome do terreno
	 * @param precoCompra preço para comprar o terreno
	 * @param aluguelSemCasa preço do aluguel quando ninguém possui a casa
	 * @param aluguelUmaCasa preço do aluguel quando possuir apenas uma casa
	 * @param aluguelDuasCasas preço do aluguem quando possuir duas casas
	 * @param aluguelTresCasas preço do aluguem quando possuir três casas
	 * @param aluguelQuatroCasas preço do aluguel quando possuir quatro casas
	 * @param aluguelHotel preço do aluguel do hotel
	 * @param hipoteca preço da hipoteca
	 * @param precoCasa preço da casa
	 * @param numCasas número de casas
	 * @param aluguel preço do aluguel
	 */
	

	public Terreno(String nome, int precoCompra, int aluguelSemCasa, int aluguelUmaCasa,
			int aluguelDuasCasas, int aluguelTresCasas, int aluguelQuatroCasas, int aluguelHotel, int hipoteca,
			int precoCasa, int numCasas, int aluguel) {
		this.nome = nome;
		this.precoCompra = precoCompra;
		this.aluguelSemCasa = aluguelSemCasa;
		this.aluguelUmaCasa = aluguelUmaCasa;
		this.aluguelDuasCasas = aluguelDuasCasas;
		this.aluguelTresCasas = aluguelTresCasas;
		this.aluguelQuatroCasas = aluguelQuatroCasas;
		this.aluguelHotel = aluguelHotel;
		this.hipoteca = hipoteca;
		this.precoCasa = precoCasa;
		this.numCasas = numCasas;
		this.aluguel = aluguel;
	}
	/**
	 * retorna o nome do terreno
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * retorna o preço da compra do terreno
	 */
	public int getPrecoCompra() {
		return precoCompra;
	}
	/**
	 * 
	 * @param precoCompra modifica o preço da compra do terreno
	 */
	public void setPrecoCompra(int precoCompra) {
		this.precoCompra = precoCompra;
	}
	/**
	 * 
	 * @return retorna o preço do aluguel quando não possuir nenhuma casa
	 */
	public int getAluguelSemCasa() {
		return aluguelSemCasa;
	}
	/**
	 * 
	 * @param aluguelSemCasa modifica o preço do aluguel quando não tiver uma casa
	 */
	public void setAluguelSemCasa(int aluguelSemCasa) {
		this.aluguelSemCasa = aluguelSemCasa;
	}
	/**
	 * 
	 * @return retorna o preço do aluguel de uma casa
	 */
	public int getAluguelUmaCasa() {
		return aluguelUmaCasa;
	}
	/**
	 * 
	 * @param aluguelUmaCasa modifica o preço do aluguel de uma casa
	 */
	public void setAluguelUmaCasa(int aluguelUmaCasa) {
		this.aluguelUmaCasa = aluguelUmaCasa;
	}
	/**
	 * 
	 * @return retorna o preço do aluguel de duas casas
	 */
	public int getAluguelDuasCasas() {
		return aluguelDuasCasas;
	}
	/**
	 * 
	 * @param aluguelDuasCasas modifica o preço do aluguel de duas casas
	 */
	public void setAluguelDuasCasas(int aluguelDuasCasas) {
		this.aluguelDuasCasas = aluguelDuasCasas;
	}
	/**
	 * 
	 * @return retorna o preço do aluguel de três casas
	 */
	public int getAluguelTresCasas() {
		return aluguelTresCasas;
	}
	/**
	 * 
	 * @param aluguelTresCasas modifica o preço do aluguel de três casas
	 */
	public void setAluguelTresCasas(int aluguelTresCasas) {
		this.aluguelTresCasas = aluguelTresCasas;
	}
	/**
	 * 
	 * @return retorna o preço do alguel de quatro casas
	 */
	public int getAluguelQuatroCasas() {
		return aluguelQuatroCasas;
	}
	/**
	 * 
	 * @param aluguelQuatroCasas modifica o preço do aluguel de quatro casas
	 */
	public void setAluguelQuatroCasas(int aluguelQuatroCasas) {
		this.aluguelQuatroCasas = aluguelQuatroCasas;
	}
	/**
	 * 
	 * @return retorna o preço do aluguel do hotel
	 */
	public int getAluguelHotel() {
		return aluguelHotel;
	}
	/**
	 * 
	 * @param aluguelHotel modifica o preço do aluguel do hotel
	 */
	public void setAluguelHotel(int aluguelHotel) {
		this.aluguelHotel = aluguelHotel;
	}
	/**
	 * 
	 * @return retorna o preço da hipoteca
	 */
	public int getHipoteca() {
		return hipoteca;
	}
	/**
	 * 
	 * @param hipoteca modifica o preço da hipoteca
	 */
	public void setHipoteca(int hipoteca) {
		this.hipoteca = hipoteca;
	}
	/**
	 * 
	 * @return retorna o preço da casa
	 */
	public int getPrecoCasa() {
		return precoCasa;
	}
	/**
	 * 
	 * @param precoCasa modifica o preço da casa
	 */
	public void setPrecoCasa(int precoCasa) {
		this.precoCasa = precoCasa;
	}
	/**
	 * 
	 * @return retorna o número de casas
	 */
	public int getNumCasas() {
		return numCasas;
	}
	/**
	 * 
	 * @param numCasas modifica o número de casas
	 */
	public void setNumCasas(int numCasas) {
		this.numCasas = numCasas;
	}
	/**
	 * 
	 * @return retorna o preço do aluguel
 	 */
	public int getAluguel() {
		return aluguel;
	}
	/**
	 * 
	 * @param aluguel modifica o preço do aluguel
	 */
	public void setAluguel(int aluguel) {
		this.aluguel = aluguel;
	}
	/**
	 * retorna o nome do dono do terreno
	 */
	public Jogador getDono() {
		return dono;
	}
	/**
	 * modifica o nome do dono do terreno
	 */
	@Override
	public void setDono(Jogador dono) {
		this.dono = dono;
	}
	/**
	 * retorna o nome do dono do terreno caso o terreno ja esteja comprado
	 */
	@Override
	public boolean existeDono() {
		if(this.dono != null) {
			return true;
		}
		return false;
	}
	/**
	 * mostra as informações do terreno
	 */
	@Override
	public String getInformacoesStatus() {
		return String.valueOf(this.aluguel);
	}
	/**
	 * retorna o tipo do terreno
	 */
	@Override
	public String getTipo() {
		return TIPO;
	}
	/**
	 * método caso o jogador casa numa casa que ja tenha dono, no caso terá que debitar da sua conta o valor do aluguel do terreno
	 */
	@Override
	public void pagamentoDeTaxa(Jogador jogadorVisitante, int aluguel) {
		jogadorVisitante.debitar(aluguel);
		this.dono.creditar(aluguel);
		
	}
	/**
	 * mostra o valor a ser para para o dono do terreno
	 */
	@Override
	public int valorAserPagoParaODonoDoTerreno() {
		return this.aluguel;
	}
	/**
	 * mostra o valor a ser pago para o dono da companhia
	 */
	@Override
	public int valorAserPagoParaODonoDaCompanhia(int numDados) {
		// TODO Auto-generated method stub
		return 0;
	}
}
