package br.com.sweetmanu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sweetmanu.dao.PedidoDao;
import br.com.sweetmanu.dao.PessoaDao;
import br.com.sweetmanu.dao.UsuarioDao;
import br.com.sweetmanu.infra.EmailSender;
import br.com.sweetmanu.infra.RandomString;
import br.com.sweetmanu.models.Pedido;
import br.com.sweetmanu.models.Pessoa;
import br.com.sweetmanu.models.Role;
import br.com.sweetmanu.models.Usuario;
import br.com.sweetmanu.service.MinhaContaService;

@Transactional
@Service(value = "minhaContaService")
public class MinhaContaServiceImpl implements MinhaContaService {

	@Autowired
	private PessoaDao pessoaDao;

	@Autowired
	private UsuarioDao usuarioDao;

	@Autowired
	private PedidoDao pedidoDao;

	@Autowired
	private EmailSender enviadorEmail;

	@Override
	public void atualizarCadastro(Pessoa pessoa) {
		pessoaDao.atualizar(pessoa);
	}

	@Override
	public boolean cadastrarNovoUsuario(Pessoa pessoa) {
		usuarioDao.salvarUsuario(new Usuario(pessoa.getUsuario(), Role.ROLE_CLIENTE));
		pessoaDao.salvar(pessoa);
		return enviadorEmail.emailCadastroUsuario(pessoa.getUsuario().getEmail(), pessoa.getNome(),
				pessoa.getUsuario().getSenhaConfirma());
	}

	@Override
	public boolean recuperarSenha(String email) {
		Usuario usuario = usuarioDao.loadUserByUsername(email);
		if (usuario != null) {
			String senhaReset = RandomString.generateString();
			usuario.setSenha(senhaReset);
			enviadorEmail.emailRecuperarSenha(usuario);
			usuarioDao.salvarUsuario(usuario);
			return true;
		}

		return false;
	}

	@Override
	public Pessoa dadosPessoais() {
		Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Pessoa pessoa = pessoaDao.findByEmail(usuario.getEmail());
		if (pessoa != null)
			return pessoa;

		throw new RuntimeException("Não localizamos um cadastro com seu e-mail!! :(");
	}

	@Override
	public List<Pedido> meusPedidos(Integer pessoaId) {
		return pedidoDao.findByPessoa(pessoaId);
	}

}
