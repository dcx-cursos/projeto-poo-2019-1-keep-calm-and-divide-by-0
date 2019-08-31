package ufpb.rt.pooPrjt.bancoImb.logradouros;

import ufpb.rt.pooPrjt.bancoImb.interfaces.Propriedade;
import ufpb.rt.pooPrjt.bancoImb.principal.Jogador;

public class Companhia implements Propriedade {
	
	private String nome;
	private int precoCompra;
	private int hipoteca;
	private int multiplicador;
	private Jogador dono = null;
	private String TIPO = "COMPANHIA";

	public Companhia(String nome, int precoCompra, int hipoteca, int multiplicador ) {
		this.nome = nome;
		this.precoCompra = precoCompra;
		hipoteca = hipoteca;
		multiplicador = multiplicador;

	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPrecoCompra() {
		return precoCompra;
	}

	public void setPrecoCompra(int precoCompra) {
		this.precoCompra = precoCompra;
	}

	public int gethipoteca() {
		return hipoteca;
	}

	public int getMultiplicador() {
		return multiplicador;
	}
	
	public void pagamentoDeTaxa(Jogador jogadorVisitante, int numDados) {
		int valorPagamento = getMultiplicador()*numDados;
		jogadorVisitante.debitar(valorPagamento);
		this.dono.creditar(valorPagamento);
	}

	public Jogador getDono() {
		return dono;
	}

	public void setDono(Jogador dono) {
		this.dono = dono;
	}

	@Override
	public String toString() {
		return "Companhia :" + nome + ", preco para compra=" + precoCompra + ", hipoteca :"
				+ hipoteca + ", multiplicador : " + multiplicador + ", dono : " + dono ;
	}


	@Override
	public boolean existeDono() {
		if(this.dono != null) {
			return true;
		}
		return false;
	}
	
	@Override
	public String getInformacoesStatus() {
		return String.valueOf(this.multiplicador);
	}


	@Override
	public String getTipo() {
		return TIPO;
	}

}
