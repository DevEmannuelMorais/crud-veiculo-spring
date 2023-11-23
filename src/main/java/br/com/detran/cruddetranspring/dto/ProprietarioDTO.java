package br.com.detran.cruddetranspring.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

public class ProprietarioDTO {
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@NotNull(message = "O campo '${validatedValue}' não pode ser null")
	@NotEmpty(message = "O campo '${validatedValue}' não pode ser vazio")
	@Size(min = 3, max = 20, message = "'${validatedValue}' precisa estar  entre {min} e {max} caracteres.")
	private String nome;

	@NotNull(message = "O campo cpf não pode está null")
	@Size(max = 11, min = 11, message = "\"O cpf deve ter no máximo {max} caracteres e no minimo"
			+ "{min} caracteres. Você digitou: " + "${validatedValue}")
	@CPF(message = "'${validatedValue}' é inválido!")
	private String cpfCnpj;
	private String endereco;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public ProprietarioDTO() {

	}

}
