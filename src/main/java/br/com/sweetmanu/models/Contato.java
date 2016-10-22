package br.com.sweetmanu.models;

import javax.persistence.Embeddable;

@Embeddable
public class Contato {

	private String telefone;
	private String celular;

	/* GETTERS AND SETTERS */

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	@Override
	public String toString() {
		return "[Contato - telefone: " + this.getTelefone() + ", celular: "
				+ this.getCelular();
	}

}
