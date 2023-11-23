package br.com.detran.cruddetranspring.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.detran.cruddetranspring.dto.ProprietarioDTO;
import br.com.detran.cruddetranspring.exceptionhandler.BadRequestException;
import br.com.detran.cruddetranspring.model.Proprietario;
import br.com.detran.cruddetranspring.repository.ProprietarioRepository;
import br.com.detran.cruddetranspring.service.ProprietarioService;

@Service
public class ProprietarioServiceImpl implements ProprietarioService {

	private final ProprietarioRepository proprietarioRepository;

	public ProprietarioServiceImpl(ProprietarioRepository proprietarioRepository) {
		super();
		this.proprietarioRepository = proprietarioRepository;
	}

	@Override
	public List<Proprietario> create(ProprietarioDTO dto) {
		Proprietario proprietario = new Proprietario();
		proprietario.setNome(dto.getNome());
		proprietario.setCpfCnpj(dto.getCpfCnpj());
		proprietario.setEndereco(dto.getEndereco());

		proprietarioRepository.save(proprietario);
		return listProprietario();
	}

	@Override
	public List<Proprietario> listProprietario() {
		Sort sort = Sort.by("id").ascending();
		return proprietarioRepository.findAll(sort);

	}

	@Override
	public List<Proprietario> update(ProprietarioDTO dto, Integer id) {
		Proprietario prop = proprietarioRepository.findById(id).get();

		proprietarioRepository.findById(id).ifPresentOrElse((proprietario) -> {
			prop.setNome(dto.getNome());
			prop.setCpfCnpj(dto.getCpfCnpj());
			prop.setEndereco(dto.getEndereco());
		}, () -> {
			throw new BadRequestException("Proprietario não existe");
		});
		return Collections.singletonList(proprietarioRepository.save(prop));

	}

	@Override
	public List<Proprietario> delete(Integer id) {
		proprietarioRepository.findById(id)
				.ifPresentOrElse((proprietario) -> proprietarioRepository.deleteById(proprietario.getId()), () -> {
					throw new RuntimeException("Proprietario não existe");
				});
		return listProprietario();

	}

	@Override
	public Proprietario getById(Integer id) {
		Proprietario proprietario = null;
		if (id != null) {
			proprietario = proprietarioRepository.findById(id).get();
		} else {
			throw new BadRequestException(String.format("O Proprietario do id %d não existe", id));
		}
		return proprietario;
	}

	@Override
	public List<Proprietario> listProprietarioByNomeAndCpf(String nomeOrCpf) {
		List<Proprietario> proprietarios = null;
//		nomeOrCpf = null;
		if (nomeOrCpf != null) {
			proprietarios = proprietarioRepository.findByNomeOrCpfCnpj2(nomeOrCpf, nomeOrCpf);
		} else {
			throw new BadRequestException("O parametro não pode ser nulo");
		}

		return proprietarios;
	}

}
