package br.com.sweetmanu.service;

import java.util.List;

import br.com.sweetmanu.models.Pedido;
import br.com.sweetmanu.models.Pessoa;

public interface MinhaContaService {

	public void atualizarCadastro(Pessoa pessoa);
	
	public boolean cadastrarNovoUsuario(Pessoa pessoa);

	public boolean recuperarSenha(String email);

	public Pessoa dadosPessoais();

	public List<Pedido> meusPedidos(Integer pessoaId);
	
}
