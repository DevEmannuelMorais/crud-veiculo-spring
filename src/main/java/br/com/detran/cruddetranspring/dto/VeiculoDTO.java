package br.com.detran.cruddetranspring.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class VeiculoDTO {
	@NotBlank(message = "O campo placa não pode ser vazio")
	@Size(min = 7, max = 7, message = "${validatedValue} precisa ter {max} caracteres.")
	private String placa;
	@NotBlank(message = "O campo renavam não pode ser vazio")
	@NotNull(message = "O campo renavam não pode está null")
	@Size(max = 11, min = 11, message = "O renavam deve ter {max} caracteres" + " você digitou: " + "${validatedValue}")
	private String renavam;
	private Integer propId;

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

	public Integer getPropId() {
		return propId;
	}

	public void setPropId(Integer propId) {
		this.propId = propId;
	}

}
