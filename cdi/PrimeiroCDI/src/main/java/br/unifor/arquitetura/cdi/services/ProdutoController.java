package br.unifor.arquitetura.cdi.services;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import br.unifor.arquitetura.cdi.dao.ProdutoDAO;
import br.unifor.arquitetura.cdi.entidades.Produto;
import br.unifor.arquitetura.cdi.util.DAO;
import br.unifor.arquitetura.cdi.util.Geral;

@Geral
public class ProdutoController {
	@Inject
	@DAO
	private ProdutoDAO dao;
	private static ProdutoController instance;

	private ProdutoController() {
	}

	@Produces
	public static ProdutoController getInstance() {
		if (instance==null)
			instance = new ProdutoController();
		return instance;
	}

	public Integer inserir(Produto produto) {
		Integer id = dao.adiciona(produto);
		return id;
	}
}