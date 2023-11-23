package br.com.detran.cruddetranspring.service;

import java.util.List;

import br.com.detran.cruddetranspring.dto.ProprietarioDTO;
import br.com.detran.cruddetranspring.model.Proprietario;

public interface ProprietarioService {

	List<Proprietario> create(ProprietarioDTO dto);

	List<Proprietario> listProprietario();

	List<Proprietario> update(ProprietarioDTO dto, Integer id);

	List<Proprietario> delete(Integer id);

	List<Proprietario> listProprietarioByNomeAndCpf(String nomeOrCpf);

	Proprietario getById(Integer id);

}
