package br.com.detran.cruddetranspring.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class VeiculoResponse {
	@NotBlank(message = "O campo placa não pode ser vazio")
	@Size(min = 7, max = 7, message = "${validatedValue} precisa ter {max} caracteres.")
	private String placa;
	@NotBlank(message = "O campo renavam não pode ser vazio")
	@NotNull(message = "O campo renavam não pode está null")
	@Size(max = 11, min = 11, message = "O renavam deve ter {max} caracteres" + " você digitou: " + "${validatedValue}")
	private String renavam;
	private String nome;
	private String cpfCnpj;
	private String endereco;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

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

}
