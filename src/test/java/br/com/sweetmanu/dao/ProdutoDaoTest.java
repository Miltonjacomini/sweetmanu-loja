package br.com.sweetmanu.dao;

import java.math.BigDecimal;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import br.com.sweetmanu.models.Produto;
import br.com.sweetmanu.models.ProdutoTipo;

public class ProdutoDaoTest extends EntityDaoImplTest {

	@Autowired
	ProdutoDao produtoDao;
	
	@Autowired
	ProdutoTipoDao produtoTipoDao;
	
	@Override
	protected IDataSet getDataSet() throws Exception {
		IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Produto.xml"));
		return dataSet;
	}

	/* Caso de mais de um dataSet (mapeando diferentes classes e separando os xml)
	@Override
	protected IDataSet getDataSet() throws Exception {
		IDataSet[] dataSets = new IDataSet[] {
			FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Produto.xml")),
			FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("ProdutoTipo.xml"))
		};
		return new CompositeDataSet(dataSets);
	}
	*/
	@Test
	public void findById(){
		Assert.assertNotNull(produtoDao.findById(1));
		Assert.assertNull(produtoDao.findById(5));
	}
	
	@Test
	public void salvarProduto(){
		produtoDao.salvar(getProdutoExemplo());
		Assert.assertEquals(produtoDao.all().size(), 4);
	}

	@Test
	public void deletarProduto(){
		produtoDao.remover(1);
		Assert.assertEquals(produtoDao.all().size(), 2);
	}
	
	@Test
	public void findAllProdutos(){
		Assert.assertEquals(produtoDao.all().size(), 3);
	}
	
	public void atualizarProduto(){
		Produto produto = produtoDao.findById(2);
		Assert.assertEquals(produto.getNome(), "Bem casado");
		produto.setNome("Bem casado delicinha");
		produtoDao.atualizar(produto);
		Assert.assertEquals(produtoDao.findById(2).getNome(), "Bem casado delicinha");
	}
	
	private Produto getProdutoExemplo() {
		
		Produto produto = new Produto();
		produto.setNome("Brigadeiro Gourmet");
		produto.setDescricao("Gourmet porque é muito melhor");
		produto.setValor(new BigDecimal(6.0));
		
		ProdutoTipo tipo = new ProdutoTipo();
		tipo.setNome("Brigadeiro Gourmet");
		produtoTipoDao.salvar(tipo);
		
		produto.setProdutoTipo(tipo);

		return produto;
	}
	
	
}
