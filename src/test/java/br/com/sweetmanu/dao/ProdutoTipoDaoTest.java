package br.com.sweetmanu.dao;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import br.com.sweetmanu.models.ProdutoTipo;

public class ProdutoTipoDaoTest extends EntityDaoImplTest {

	@Autowired
	ProdutoTipoDao produtoTipoDao;

	@Override
	protected IDataSet getDataSet() throws Exception {
		IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("ProdutoTipo.xml"));
		return dataSet;
	}

	@Test
	public void findById() {
		Assert.assertNotNull(produtoTipoDao.findById(1));
		Assert.assertNull(produtoTipoDao.findById(50));
	}

	@Test
	public void salvarProdutoTipo() {
		produtoTipoDao.salvar(getProdutoExemplo());
		Assert.assertEquals(produtoTipoDao.all().size(), 4);
	}

	public void deletarProdutoTipo() {
		produtoTipoDao.remover(4);
		Assert.assertEquals(produtoTipoDao.all().size(), 2);
	}

	@Test
	public void findAllTipos() {
		Assert.assertEquals(produtoTipoDao.all().size(), 3);
	}

	public void atualizarProdutoTipo() {
		ProdutoTipo tipo = produtoTipoDao.findById(2);
		Assert.assertEquals(tipo.getNome(), "Bem casado");
		tipo.setNome("Bem casado delicinha");
		produtoTipoDao.atualizar(tipo);
		Assert.assertEquals(produtoTipoDao.findById(2).getNome(), "Bem casado delicinha");
	}

	private ProdutoTipo getProdutoExemplo() {

		ProdutoTipo tipo = new ProdutoTipo();
		tipo.setNome("Brigadeiro Gourmet");

		return tipo;
	}

}
