package br.unifor.arquitetura.cdi.services;

import static br.unifor.arquitetura.cdi.services.builders.ProdutoBuilder.*;
import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.unifor.arquitetura.cdi.dao.ProdutoDAO;
import br.unifor.arquitetura.cdi.entidades.Produto;
import br.unifor.arquitetura.cdi.util.DAO;
import br.unifor.arquitetura.cdi.util.Geral;
import br.unifor.arquitetura.cdi.util.ProdutorEntityManagerUtil;
import br.unifor.arquitetura.cdi.util.Transacional;
import br.unifor.arquitetura.cdi.util.TransacionalInterceptor;

@RunWith(CdiRunner.class)
// Runs the test with CDI-Unit
@AdditionalClasses({ ProdutoDAO.class, ProdutorEntityManagerUtil.class,
		ProdutoController.class, TransacionalInterceptor.class, Geral.class,
		DAO.class, Transacional.class })
public class ProdutoControllerTest {

	@Inject
	@Geral
	private ProdutoController produtoController;

	@Test
	public void test() {
		Produto produto = umProduto().comNome().comPreco().agora();
		Integer id = produtoController.inserir(produto);
		assertNotNull(id);
	}

}
