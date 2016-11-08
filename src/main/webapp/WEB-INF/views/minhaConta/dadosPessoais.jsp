<div class="row">
	<div class="col-lg-12">
			
		<form:form role="form" commandName="pessoa" servletRelativeAction="/minhaConta/${pessoa.id}" method="POST">
			
			<div class="col-lg-4">
				<div class="form-group">
					<label for="nome">Nome</label>
					<input type="text" value="${pessoa.nome}" name="nome" class="form-control" placeholder="Nome"  required>
				</div>
				<div class="form-group">
					<label for="cpfCnpj">Cpf/Cnpj</label>
					<input id="cpfCnpj" type="text" value="${pessoa.cpfCnpj}" name="cpfCnpj" class="form-control" placeholder="Cpf/Cnpj" required>
				</div>
			</div>		
			<div class="col-lg-4">	
				<div class="form-group">
					<label for="usuario.email">E-mail</label>
					<input type="email" value="${pessoa.usuario.email}" name="usuario.email" class="form-control" placeholder="E-mail" required>
				</div>
				<div class="form-group">
					<label for="dtNascimento">Dt. Nascimento</label>
					<input id="dtNascimento" type="text" value="${pessoa.dtNascimentoFormatada}" name="dtNascimento" class="form-control" placeholder="Data Nascimento" required>
				</div>
			</div>
			
			<div class="col-lg-4">	
				<div class="form-group">
					<label for="contato.telefone">Telefone</label>
					<input id="telefone" type="text" value="${pessoa.contato.telefone}" name="contato.telefone" class="form-control telefoneECelular" placeholder="ex: (DDD) 1234-4567">
				</div>
				<div class="form-group">
					<label for="contato.celular">Celular</label>
					<input id="celular" type="text" value="${pessoa.contato.celular}" name="contato.celular" class="form-control telefoneECelular" placeholder="ex: (DDD) 999 985 245" required>
				</div>
			</div>
			
			<div class="col-lg-6">	
				<div class="form-group">
					<label for="endereco.logradouro">Endereço</label>
					<input type="text" value="${pessoa.endereco.logradouro}" name="endereco.logradouro" class="form-control" placeholder="ex: Av. Paulista, 2087">
				</div>
				<div class="form-group">
					<label for="endereco.cidade">Cidade</label>
					<input type="text" value="${pessoa.endereco.cidade}" name="endereco.cidade" class="form-control" placeholder="ex: São Paulo" >
				</div>
			</div>
			<div class="col-lg-6">	
				<div class="form-group">
					<label for="endereco.bairro">Bairro</label>
					<input type="text" value="${pessoa.endereco.bairro}" name="endereco.bairro" class="form-control" placeholder="ex: Jardim Paulista">
				</div>
				<div class="form-group">
					<label for="endereco.estado">Estado</label>
					<input id="celular" type="text" value="São Paulo" class="form-control" disabled="disabled">
				</div>
			</div>
			
			<div class="col-lg-offset-5 col-lg-4">
				<input type="submit" class="btn btn-default btn-circle btn-sweetmanu btn-xl" value="Salvar">
			</div>
			
		</form:form>
	</div>
</div>
