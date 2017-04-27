package br.unifor.arquitetura.cdi.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.unifor.arquitetura.cdi.entidades.Produto;
import br.unifor.arquitetura.cdi.util.DAO;

@DAO
public class ProdutoDAO {
	@Inject
	@DAO
	private EntityManager entityManager;

	public Integer adiciona(Produto produto) {
		entityManager.persist(produto);
		return produto.getCodigo();
	}
}
