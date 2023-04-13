package br.com.desafioGrupoWL.desafioUnidac.model;

import java.util.Calendar;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
public class Colaborador {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	private String nome;
	@CPF
	private String cpf;
	@NotBlank
	private String cafe;
	@NotNull
	private Calendar data;
	
	public Colaborador() {
		
	}
	
	public Colaborador(long id, String nome, String cpf, String cafe, Calendar data) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.cafe = cafe;
		this.data = data;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getcafe() {
		return cafe;
	}
	public void setcafe(String cafe) {
		this.cafe = cafe;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	
}
