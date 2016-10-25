<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="form-group">
	<label for="nome">Nome</label>
	<div class="input-group">
		<span class="input-group-addon">
			<i class="glyphicon glyphicon-unchecked"></i></span>
		<form:input path='nome' type='text' autofocus="autofocus"/>
		<form:errors path='nome' />

	</div>
</div>

