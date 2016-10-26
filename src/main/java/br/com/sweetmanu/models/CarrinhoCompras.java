package br.com.sweetmanu.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CarrinhoCompras implements Serializable {

	private static final long serialVersionUID = 1L;

	Map<Produto, Integer> itens = new LinkedHashMap<Produto, Integer>();

	public void adicionar(Produto item) {
		itens.put(item, getQuantidade(item) + 1);
	}

	public int getQuantidade(Produto item) {

		if (!itens.containsKey(item)) {
			itens.put(item, 0);
		}

		return itens.get(item);
	}

	public int getQuantidade() {
		return itens.values().stream().reduce(0, (proximo, acumulador) -> (proximo + acumulador));
	}

	public Collection<Produto> getItens() {
		return itens.keySet();
	}

	public BigDecimal getTotal(Produto item) {
		return item.getTotal(getQuantidade(item));
	}

	public BigDecimal getTotal() {
		BigDecimal total = BigDecimal.ZERO;
		for (Produto item : itens.keySet()) {
			total = total.add(getTotal(item));
		}
		return total;
	}

	public void remover(Produto item) {
		if (itens.containsKey(item)) {
			if (itens.get(item) > 1)
				itens.put(item, itens.get(item) - 1);
			else
				itens.remove(item);
		}
	}
}
