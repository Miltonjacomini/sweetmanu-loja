package br.com.sweetmanu.dao;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import br.com.sweetmanu.models.Pessoa;
import br.com.sweetmanu.models.Usuario;

public class PessoaDaoTest extends EntityDaoImplTest {

	@Autowired
	PessoaDao pessoaDao;
	
	@Override
	protected IDataSet getDataSet() throws Exception {
		IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Pessoa.xml"));
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
		Assert.assertNotNull(pessoaDao.findById(1));
		Assert.assertNull(pessoaDao.findById(50));
	}
	
	@Test
	public void salvarPessoa(){
		pessoaDao.salvar(getPessoaExemplo());
		Assert.assertEquals(pessoaDao.all().size(), 2);
	}

	@Test
	public void deletarPessoa(){
		pessoaDao.remover(1);
		Assert.assertEquals(pessoaDao.all().size(), 0);
	}
	
	@Test
	public void findAllPessoas(){
		Assert.assertEquals(pessoaDao.all().size(), 1);
	}
	
	public void atualizarPessoas(){
		Pessoa pessoa = pessoaDao.findById(1);
		Assert.assertEquals(pessoa.getNome(), "Milton J. Neto");
		pessoa.setNome("Milton Jacomini");
		pessoaDao.atualizar(pessoa);
		Assert.assertEquals(pessoaDao.findById(1).getNome(), "Milton Jacomini");
	}
	
	private Pessoa getPessoaExemplo() {
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Maria T. Da Silva");
		pessoa.setCpfCnpj("22255566665");
		pessoa.setDtNascimento(new LocalDate());
		
		Usuario user = new Usuario();
		user.setEmail("maria.tereza@gmail.com");
		user.setSenha("1233121");
		pessoa.setUsuario(user);

		return pessoa;
	}
	
	
}
