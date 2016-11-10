package br.com.sweetmanu.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.dbunit.dataset.CompositeDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import br.com.sweetmanu.models.Pedido;
import br.com.sweetmanu.models.PedidoStatus;
import br.com.sweetmanu.models.Pessoa;
import br.com.sweetmanu.models.Produto;
import br.com.sweetmanu.models.ProdutoTipo;
import br.com.sweetmanu.models.Usuario;

public class PedidoDaoTest extends EntityDaoImplTest {

	@Autowired
	PedidoDao pedidoDao;

	@Autowired
	PessoaDao pessoaDao;

	@Autowired
	ProdutoTipoDao produtoTipoDao;

	/*
	 * Caso de mais de um dataSet (mapeando diferentes classes e separando os
	 * xml)
	 */
	@Override
	protected IDataSet getDataSet() throws Exception {
		IDataSet[] dataSets = new IDataSet[] {
				new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Pessoa.xml")),
				new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Produto.xml")),
				new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Pedido.xml")) };
		return new CompositeDataSet(dataSets);
	}

	@Test
	public void findById() {
		Assert.assertNotNull(pedidoDao.findById(1));
		Assert.assertNull(pedidoDao.findById(50));
	}

	@Test
	public void salvarPedido() {
		pedidoDao.salvar(getPedidoExemplo());
		Assert.assertEquals(pedidoDao.all().size(), 4);
	}

	@Test
	public void deletarProduto() {
		pedidoDao.remover(1);
		Assert.assertEquals(pedidoDao.all().size(), 2);
	}

	@Test
	public void findAllPedidos() {
		Assert.assertEquals(pedidoDao.all().size(), 3);
	}

	@Test
	public void enviarPedido() {
		Assert.assertEquals(pedidoDao.findByStatus(PedidoStatus.ENVIADO).size(), 3);
		pedidoDao.enviarPedido(getPedidoExemplo());
		Assert.assertEquals(pedidoDao.findByStatus(PedidoStatus.ENVIADO).size(), 4);
	}

	@Test
	public void confirmarPedido() {
		Assert.assertEquals(pedidoDao.findByStatus(PedidoStatus.ENVIADO).size(), 3);
		pedidoDao.confirmaPedido(1);
		Assert.assertEquals(pedidoDao.findByStatus(PedidoStatus.CONFIRMADO).size(), 1);
		Assert.assertEquals(pedidoDao.findByStatus(PedidoStatus.ENVIADO).size(), 2);
		pedidoDao.confirmaPedido(1);
		Assert.assertEquals(pedidoDao.findByStatus(PedidoStatus.CONFIRMADO).size(), 1);
	}

	@Test
	public void pedidoEmPreparo() {
		Pedido pedidoEmPreparo = pedidoDao.findById(1);
		Assert.assertEquals(pedidoDao.findByStatus(PedidoStatus.ENVIADO).size(), 3);
		pedidoDao.pedidoEmPreparo(pedidoEmPreparo.getId());
		Assert.assertEquals(pedidoDao.findByStatus(PedidoStatus.EM_PREPARO).size(), 0);
		pedidoDao.confirmaPedido(pedidoEmPreparo.getId());
		pedidoDao.pedidoEmPreparo(pedidoEmPreparo.getId());
		Assert.assertEquals(pedidoDao.findByStatus(PedidoStatus.ENVIADO).size(), 2);
		Assert.assertEquals(pedidoDao.findByStatus(PedidoStatus.EM_PREPARO).size(), 1);
		Assert.assertEquals(pedidoEmPreparo.getStatus(), PedidoStatus.EM_PREPARO);
	}

	@Test
	public void pedidoFinalizado() {
		Pedido pedidoAFinalizar = pedidoDao.findById(1);
		pedidoDao.confirmaPedido(pedidoAFinalizar.getId());
		pedidoDao.pedidoFinalizado(pedidoAFinalizar.getId());
		Assert.assertNotEquals(pedidoDao.findById(pedidoAFinalizar.getId()).getStatus(), PedidoStatus.FINALIZADO);
		pedidoDao.pedidoEmPreparo(pedidoAFinalizar.getId());
		pedidoDao.pedidoFinalizado(pedidoAFinalizar.getId());
		Assert.assertEquals(pedidoDao.findByStatus(PedidoStatus.FINALIZADO).size(), 1);
	}

	@Test
	public void pedidoEntregue() {
		Pedido pedidoEntregue = pedidoDao.findById(1);
		pedidoDao.confirmaPedido(pedidoEntregue.getId());
		pedidoDao.pedidoEmPreparo(pedidoEntregue.getId());
		pedidoDao.pedidoEntregue(pedidoEntregue.getId());
		Assert.assertNotEquals(pedidoDao.findById(pedidoEntregue.getId()).getStatus(), PedidoStatus.ENTREGUE);
		pedidoDao.pedidoFinalizado(pedidoEntregue.getId());
		pedidoDao.pedidoEntregue(pedidoEntregue.getId());
		Assert.assertEquals(pedidoDao.findByStatus(PedidoStatus.ENTREGUE).size(), 1);
		Assert.assertEquals(pedidoDao.findById(pedidoEntregue.getId()).getStatus(), PedidoStatus.ENTREGUE);
	}

	public void atualizarPedido() {
	}

	private Pedido getPedidoExemplo() {

		Pedido pedido = new Pedido(getPessoaExemplo());
		pedido.setStatus(PedidoStatus.ENVIADO);
		pedido.getProdutos().addAll(getProdutos());

		return pedido;
	}

	private Pessoa getPessoaExemplo() {

		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Maria T. Da Silva");
		pessoa.setCpfCnpj("22255566665");
		pessoa.setDtNascimento(LocalDate.now());

		Usuario user = new Usuario();
		user.setEmail("maria.tereza@gmail.com");
		user.setSenha("1233121");
		pessoa.setUsuario(user);
		pessoaDao.salvar(pessoa);

		return pessoa;
	}

	private List<Produto> getProdutos() {

		Produto brigGourmet = new Produto();
		brigGourmet.setNome("Brigadeiro Gourmet");
		brigGourmet.setDescricao("Gourmet porque é muito melhor");
		brigGourmet.setValor(new BigDecimal(6.0));
		ProdutoTipo tipoBrigGourmet = new ProdutoTipo();
		tipoBrigGourmet.setNome("Brigadeiro Gourmet");
		produtoTipoDao.salvar(tipoBrigGourmet);
		brigGourmet.setProdutoTipo(tipoBrigGourmet);

		Produto boloDeCoco = new Produto();
		boloDeCoco.setNome("Bolo de coco");
		boloDeCoco.setDescricao("Bolinho de coco delicia");
		boloDeCoco.setValor(new BigDecimal(6.0));
		ProdutoTipo tipo = new ProdutoTipo();
		tipo.setNome("Bolo");
		produtoTipoDao.salvar(tipo);
		boloDeCoco.setProdutoTipo(tipo);

		List<Produto> produtos = new ArrayList<Produto>();
		produtos.add(brigGourmet);
		produtos.add(boloDeCoco);

		return produtos;
	}
}
