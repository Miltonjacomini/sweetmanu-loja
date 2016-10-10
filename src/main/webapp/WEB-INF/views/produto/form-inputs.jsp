<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="form-group">
	<label for="nome">Nome</label>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-unchecked"></i></span>
		<form:input path='nome' type='text' />
		<form:errors path='nome' />
	</div>
</div>
<div class="form-group">
	<label for="descricao">Descrição</label>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-unchecked"></i></span>
		<form:input path='descricao' type='text' />
		<form:errors path='descricao' />
	</div>
</div>
<div class="form-group">
	<label for="valor">Valor</label>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-unchecked"></i></span>
		<form:input path='valor' type='text' />
		<form:errors path='valor' />
	</div>
</div>
<div class="form-group">
	<label for="categoria.id">Categoria</label>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-unchecked"></i></span>
		<form:select path='categoria.id' items='${categoriaList}' itemValue='id'
			itemLabel='nome'>
		</form:select>
		<form:errors path='categoria.id' />
	</div>
</div>
<div class="form-group">
	<label for="foto">Foto</label>
	<div class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-unchecked"></i></span>
		<input type="file" name="foto">
		<form:errors path='foto' />
	</div>
</div>
