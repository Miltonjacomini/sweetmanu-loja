<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="form-group">
	<label for="nome">Nome</label>
	<div class="input-group">
		<span class="input-group-addon">
			<i class="glyphicon glyphicon-unchecked"></i>
		</span>
		<form:input path='nome' type='text' autofocus="autofocus"/>
		<form:errors path='nome' />
	</div>
</div>
<div class="form-group">
	<label for="descricao">Descrição</label>
	<div class="input-group">
		<span class="input-group-addon">
			<i class="glyphicon glyphicon-unchecked"></i>
		</span>
		<form:input path='descricao' type='text' />
		<form:errors path='descricao' />
	</div>
</div>
<div class="form-group">
	<label for="valor">Valor</label>
	<div class="input-group">
		<span class="input-group-addon">
			<i class="glyphicon glyphicon-unchecked"></i>
		</span>
		<form:input path='valor' type='text' />
		<form:errors path='valor' />
	</div>
</div>
<div class="form-group">
	<label for="produtoTipo.id">Produto tipo</label>
	<div class="input-group">
		<span class="input-group-addon">
			<i class="glyphicon glyphicon-unchecked"></i>
		</span>
		<form:select path='produtoTipo.id' items='${tipoProdutoList}' 
					 itemValue='id' itemLabel='nome'>
		</form:select>
		<form:errors path='produtoTipo.id' />
	</div>
</div>
<div class="form-group">
	<label for="foto">Foto</label>
	<div class="input-group">
		<span class="input-group-addon">
			<i class="glyphicon glyphicon-unchecked"></i>
		</span>
		<input name="foto" type="file">
	</div>
</div>
