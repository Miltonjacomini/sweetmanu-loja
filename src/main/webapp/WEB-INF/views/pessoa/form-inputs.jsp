<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="form-group">
	<label for="nome">Nome</label>
	<div class="input-group">
		<span class="input-group-addon">
			<i class="glyphicon glyphicon-unchecked"></i></span>
		<form:input path='nome' type='text' />
		<form:errors path='nome' />
	</div>
</div>
<div class="form-group">
	<label for="cpfCnpj">Cpf/Cnpj</label>
	<div class="input-group">
		<span class="input-group-addon">
			<i class="glyphicon glyphicon-unchecked"></i></span>
		<form:input path='cpfCnpj' type='text' />
		<form:errors path='cpfCnpj' />

	</div>
</div>
<div class="form-group">
	<label for="dtNascimento">Data Nasc.</label>
	<div class="input-group">
		<span class="input-group-addon">
			<i class="glyphicon glyphicon-unchecked"></i></span>
		<form:input path='dtNascimento' type='text' />
		<form:errors path='dtNascimento' />

	</div>
</div>
<div class="form-group">
	<label for="contato.email">E-mail</label>
	<div class="input-group">
		<span class="input-group-addon">
			<i class="glyphicon glyphicon-unchecked"></i></span>
		<form:input path='usuario.email' />
		<form:errors path='usuario.email' />

	</div>
</div>
<div class="form-group">
	<label for="senha">Senha</label>
	<div class="input-group">
		<span class="input-group-addon">
			<i class="glyphicon glyphicon-unchecked"></i></span>
		<form:password path='usuario.senha' />
		<form:errors path='usuario.senha' />

	</div>
</div>
<div class="form-group">
	<label for="contato.telefone">Telefone</label>
	<div class="input-group">
		<span class="input-group-addon">
			<i class="glyphicon glyphicon-unchecked"></i></span>
		<form:input path='contato.telefone' />
		<form:errors path='contato.telefone' />

	</div>
</div>
<div class="form-group">
	<label for="contato.celular">Celular</label>
	<div class="input-group">
		<span class="input-group-addon">
			<i class="glyphicon glyphicon-unchecked"></i></span>
		<form:input path='contato.celular' />
		<form:errors path='contato.celular' />

	</div>
</div>