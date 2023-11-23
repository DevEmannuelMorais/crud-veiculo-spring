package br.com.detran.cruddetranspring.service;

import java.util.List;

import br.com.detran.cruddetranspring.dto.VeiculoDTO;
import br.com.detran.cruddetranspring.dto.VeiculoResponse;
import br.com.detran.cruddetranspring.model.Veiculo;

public interface VeiculoService {

	List<Veiculo> create(VeiculoDTO dto);

	List<Veiculo> listVeiculo();

	List<Veiculo> update(VeiculoDTO dto, Integer id);

	List<Veiculo> delete(Integer id);

	List<Veiculo> getById(Integer id);
	
	List<VeiculoResponse> findPlaca(String placa);

}
