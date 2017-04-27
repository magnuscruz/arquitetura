package br.unifor.arquitetura.cdi.services;

import javax.inject.Inject;

import junit.framework.Assert;

import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

import br.unifor.arquitetura.cdi.dao.ProdutoDAO;
import br.unifor.arquitetura.cdi.entidades.Produto;
import br.unifor.arquitetura.cdi.util.DAO;
import br.unifor.arquitetura.cdi.util.Geral;
import br.unifor.arquitetura.cdi.util.ProdutorEntityManagerUtil;

@RunWith(CdiRunner.class)
// Runs the test with CDI-Unit
@AdditionalClasses({ ProdutoDAO.class, ProdutorEntityManagerUtil.class,
		ProdutoController.class, DAO.class, Geral.class })
public class ProdutoControllerTest {

	@Inject
	@Geral
	private ProdutoController produtoController;

	@Test
	public void test() {
		Produto produto = new Produto();
//		produto.setCodigo(1);
		produto.setNome("IMPRESSORA LASER 1234");
		produto.setPreco(700.99);
		Integer id = produtoController.inserir(produto);
		assertNotNull(id);
	}

}
