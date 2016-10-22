package br.com.sweetmanu.models;

import javax.persistence.Embeddable;

@Embeddable
public enum PedidoStatus {

	ENVIADO,
	CONFIRMADO,
	EM_PREPARO,
	FINALIZADO,
	ENTREGUE;
	
}
