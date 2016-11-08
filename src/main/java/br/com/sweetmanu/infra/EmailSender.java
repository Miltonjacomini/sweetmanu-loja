package br.com.sweetmanu.infra;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.amazonaws.util.StringUtils;

import br.com.sweetmanu.models.Pedido;
import br.com.sweetmanu.models.Usuario;

@Service("emailSender")
public class EmailSender {

	@Autowired
	private JavaMailSenderImpl sender;

	public boolean emailCadastroUsuario(String emailDestino, String nomeCliente, String senhaCliente) {

		try {

			MimeMessage message = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);
			helper.setTo(emailDestino);
			message.setContent(getCorpoEmailHTML(nomeCliente, senhaCliente), "text/html");
			message.setSubject("[SweetManu - Bem vindo]");
			/*
			 * Para mandar com Anexo FileSystemResource res = new
			 * FileSystemResource(new File("/caminhoDoArquivo.jpg"));
			 * helper.addInline("arquivo", res);
			 */
			sender.send(message);
			return true;

		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
	}

	private String getCorpoEmailHTML(String nomeCliente, String senhaCliente) {
		StringBuilder texto = new StringBuilder();
		texto.append("<html><body><h2>Seja bem vindo ao SweetManu, " + nomeCliente + "</h2><br/>");
		texto.append("<p>Estou muito feliz com o seu cadastro.</p><br/>");
		texto.append("<p>Antes de me enviar encomendas é legal que você complete seu cadastro,<br/>");
		texto.append("para que eu consiga saber seu endereço para a entrega, são poucas coisas pra preencher<br/>");
		texto.append("é só acessar o <a href='www.sweetmanu.com.br'>Nosso site</a> <<< nesse link.<br/>");
		texto.append(
				"depois o link MINHA CONTA no topo do site e digitar seu E-mail cadastrado, este aqui mesmo.</p><br/>");
		texto.append("<p> :)<br/>");
		texto.append("<p>a senha que você cadastrou é essa aqui:</p>");
		texto.append("<h3></br> " + senhaCliente + "</h3><br/>");
		texto.append("<p>Bom é isso ai, fico por aqui e é claro esperando você me enviar vários pedidos!! hehehe!</p>");
		texto.append("<p>Te espero lá!!</p>");
		texto.append("<p>Beijãooo!!</p></body></html>");

		// Se fosse enviar o anexo
		// texto.append("<img src='cid:arquivo' >");

		return texto.toString();
	}

	public boolean emailRecuperarSenha(Usuario usuario) {
		try {

			MimeMessage message = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);
			helper.setTo(usuario.getEmail());
			message.setContent(getCorpoEmailRecuperarHTML(usuario), "text/html");
			message.setSubject("[SweetManu - Recuperação de senha]");
			/*
			 * Para mandar com Anexo FileSystemResource res = new
			 * FileSystemResource(new File("/caminhoDoArquivo.jpg"));
			 * helper.addInline("arquivo", res);
			 */
			sender.send(message);
			return true;

		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
	}

	private Object getCorpoEmailRecuperarHTML(Usuario usuario) {
		StringBuilder texto = new StringBuilder();
		texto.append("<html><body><h2>Olá, tudo bom??</h2><br/>");
		texto.append("<p>Você esqueceu sua senha mas nós te ajudamos, fica sussa... :)</p><br/>");
		texto.append("<p>a senha que você cadastrou é essa aqui:</p>");
		texto.append("<h3></br> " + usuario.getSenha() + "</h3><br/>");
		texto.append("<p>Bom é isso ai, se você ainda tiver dificuldades para se logar é só me mandar um e-mail!!</p>");
		texto.append("<p>Te espero lá, Boas compras!!</p>");
		texto.append("<p>Beijãooo!!</p></body></html>");

		// Se fosse enviar o anexo
		// texto.append("<img src='cid:arquivo' >");

		return texto.toString();
	}

	public boolean emailPedidoEnviado(Pedido pedido) {
		try {

			MimeMessage message = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);
			// helper.setTo("contato@sweetmanu.com.br");
			helper.setTo("miltonjacomini@gmail.com");
			message.setContent(getEmailPedidoRealizado(pedido), "text/html");
			message.setSubject("[SweetManu - Novo pedido realizado]");
			/*
			 * Para mandar com Anexo FileSystemResource res = new
			 * FileSystemResource(new File("/caminhoDoArquivo.jpg"));
			 * helper.addInline("arquivo", res);
			 */
			sender.send(message);
			return true;

		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
	}

	private Object getEmailPedidoRealizado(Pedido pedido) {
		StringBuilder texto = new StringBuilder();
		texto.append("<html><body><h2>Boas novas, você tem um novo pedido!</h2><br/>");
		texto.append("<p>Lembre-se que o prazo para confirmação dele é de 3 dias, aqui vai");
		texto.append("algumas informações sobre ele :</p>");
		texto.append("<p>Quem solicitou: </p><h3>" + pedido.getPessoa().getNome() + "</h3><br/>");
		texto.append("<p>E-mail:</p> " + pedido.getPessoa().getUsuario().getEmail() + "<br/>");
		texto.append("<p>Telefone:</p> " + !StringUtils.isNullOrEmpty(pedido.getPessoa().getContato().getTelefone()) + "<br/>");
		texto.append("<p>Celular:</p> " + !StringUtils.isNullOrEmpty(pedido.getPessoa().getContato().getCelular()) + "<br/>");
		texto.append("<p>Todas as informações do pedido estarão no seu espaço de administrador do site: http://sweetmanu.com.br/indexAdmin</p>");
		texto.append("<p>Bora lá verificar e confirmar o pedido!!</p>");
		// Se fosse enviar o anexo
		// texto.append("<img src='cid:arquivo' >");

		return texto.toString();
	}

	public void emailPedidoCancelado(Pedido pedido) {
		try {

			MimeMessage message = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);
			// helper.setTo("contato@sweetmanu.com.br");
			helper.setTo("miltonjacomini@gmail.com");
			message.setContent(getEmailPedidoCancelado(pedido), "text/html");
			message.setSubject("[SweetManu - Pedido Cancelado]");
			/*
			 * Para mandar com Anexo FileSystemResource res = new
			 * FileSystemResource(new File("/caminhoDoArquivo.jpg"));
			 * helper.addInline("arquivo", res);
			 */
			sender.send(message);

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	private Object getEmailPedidoCancelado(Pedido pedido) {
		StringBuilder texto = new StringBuilder();
		texto.append("<html><body><h2>PEDIDO CANCELADO!!!</h2><br/>");
		texto.append("Algumas informações sobre ele:</p>");
		texto.append("<p>Quem solicitou: </p><h3>" + pedido.getPessoa().getNome() + "</h3><br/>");
		texto.append("<p>E-mail:</p> " + pedido.getPessoa().getUsuario().getEmail() + "<br/>");
		texto.append("<p>Telefone:</p> " + pedido.getPessoa().getContato().getTelefone() + "<br/>");
		texto.append("<p>Celular:</p> " + pedido.getPessoa().getContato().getCelular() + "<br/>");
		texto.append("<p>Todas as informações do pedido estarão no seu espaço de administrador do site: http://sweetmanu.com.br/indexAdmin</p>");
		texto.append("<p>Bora lá verificar!!</p>");
		// Se fosse enviar o anexo
		// texto.append("<img src='cid:arquivo' >");

		return texto.toString();
	}

}
