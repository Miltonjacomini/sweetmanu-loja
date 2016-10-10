package br.com.sweetmanu.loja.models;

import javax.persistence.Embeddable;

@Embeddable
public class Foto {

	private String nome;
	private String pathFoto;

	public Foto(){}
	
	public Foto(String nome, String pathFoto){
		this.nome = nome;
		this.pathFoto = pathFoto;
	}
	
	/* GETTERS AND SETTERS */
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPathFoto() {
		return pathFoto;
	}
	public void setPathFoto(String pathFoto) {
		this.pathFoto = pathFoto;
	}
	
}
