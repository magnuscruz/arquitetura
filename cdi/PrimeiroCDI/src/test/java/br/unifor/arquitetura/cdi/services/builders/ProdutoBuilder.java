package br.unifor.arquitetura.cdi.services.builders;

import br.unifor.arquitetura.cdi.entidades.Produto;

public class ProdutoBuilder {

	private Produto elemento;
	private ProdutoBuilder() {
		
	}
	public static ProdutoBuilder umProduto() {
		ProdutoBuilder builder = new ProdutoBuilder();
		builder.elemento = new Produto();
		return builder;
	}
	
	public ProdutoBuilder comNome() {
		this.elemento.setNome("Carro");
		return this;
	}
	
	public ProdutoBuilder comCodigo() {
		this.elemento.setCodigo(123);
		return this;
	}
	public ProdutoBuilder comPreco() {
		this.elemento.setPreco(123.0);
		return this;
	}

	public Produto agora() {
		return elemento;
	}
}
