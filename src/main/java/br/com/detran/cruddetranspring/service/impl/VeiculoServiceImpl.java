package br.com.detran.cruddetranspring.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.detran.cruddetranspring.dto.VeiculoDTO;
import br.com.detran.cruddetranspring.dto.VeiculoResponse;
import br.com.detran.cruddetranspring.exceptionhandler.BadRequestException;
import br.com.detran.cruddetranspring.model.Proprietario;
import br.com.detran.cruddetranspring.model.Veiculo;
import br.com.detran.cruddetranspring.repository.ProprietarioRepository;
import br.com.detran.cruddetranspring.repository.VeiculoRepository;
import br.com.detran.cruddetranspring.service.VeiculoService;

@Service
public class VeiculoServiceImpl implements VeiculoService {
	private final VeiculoRepository veiculoRepository;
	private final ProprietarioRepository proprietarioRepository;

	public VeiculoServiceImpl(VeiculoRepository veiculoRepository, ProprietarioRepository proprietarioRepository) {
		super();
		this.veiculoRepository = veiculoRepository;
		this.proprietarioRepository = proprietarioRepository;
	}

	@Override
	public List<Veiculo> create(VeiculoDTO request) {
		Veiculo veiculo = new Veiculo();
		if (request.getPropId() != null) {
			Proprietario proprietario = proprietarioRepository.findById(request.getPropId()).get();
			veiculo.setProprietario(proprietario);
		}
		veiculo.setPlaca(request.getPlaca());
		veiculo.setRenavam(request.getRenavam());

		return Collections.singletonList(veiculoRepository.save(veiculo));
	}

	@Override
	public List<Veiculo> listVeiculo() {
		if (veiculoRepository.findAll() == null) {
			throw new BadRequestException("não existe nenhum veiculo cadastrado");
		}

		return veiculoRepository.findAll();
	}

	@Override
	public List<Veiculo> update(VeiculoDTO dto, Integer id) {
		veiculoRepository.findById(id).ifPresentOrElse((existingVeiculo) -> {
			Veiculo veiculo = veiculoRepository.findById(id).get();
			if (dto.getPropId() != null) {
				proprietarioRepository.findById(dto.getPropId()).ifPresentOrElse((existingProprietario) -> {
					Proprietario proprietario = proprietarioRepository.findById(dto.getPropId()).get();
					veiculo.setProprietario(proprietario);
				}, () -> {
					throw new BadRequestException(String.format("Proprietario do id %d não existe ", dto.getPropId()));
				});
			} else {
				veiculo.setProprietario(null);
			}
			veiculo.setPlaca(dto.getPlaca());
		}, () -> {
			throw new BadRequestException(String.format("Veiculo do id %d não existe ", id));
		});
		return listVeiculo();
	}

	@Override
	public List<Veiculo> delete(Integer id) {
		veiculoRepository.findById(id)
				.ifPresentOrElse((existingVeiculo) -> veiculoRepository.deleteById(existingVeiculo.getId()), () -> {
					throw new BadRequestException(String.format("Veiculo do id %d não existe ", id));
				});
		return listVeiculo();
	}

	@Override
	public List<Veiculo> getById(Integer id) {
//		Integer testId = null;

		List<Veiculo> veiculos = new ArrayList<Veiculo>();

		if (id != null) {
			veiculoRepository.findById(id).ifPresentOrElse((existingVeiculo) -> {
				veiculos.add(veiculoRepository.findById(id).get());

			}, () -> {
				throw new BadRequestException(String.format("Veiculo do id %d não existe ", id));
			});
		} else {
			throw new BadRequestException("Valor invalido, digite novamente");
		}
		return veiculos;

	}

	@Override
	public List<VeiculoResponse> findPlaca(String placa) {
//		List<String> dadosPropVeic = null;

		VeiculoResponse veiculoResponses = null;
		if (placa != null) {
			List<Veiculo> veiculos = veiculoRepository.findByPlaca(placa);
			if (!veiculos.isEmpty()) {
				Veiculo veiculo = veiculos.get(0);
				veiculoResponses = new VeiculoResponse();
				veiculoResponses.setCpfCnpj(veiculo.getProprietario().getCpfCnpj());
				veiculoResponses.setEndereco(veiculo.getProprietario().getEndereco());
				veiculoResponses.setNome(veiculo.getProprietario().getNome());
				veiculoResponses.setPlaca(veiculo.getPlaca());
				veiculoResponses.setRenavam(veiculo.getRenavam());
			} else {
				throw new BadRequestException(String.format("A placa %s não existe", placa));
			}

//			dadosPropVeic = veiculoRepository.findBuscaPlaca(placa);
		} else {
			throw new BadRequestException(String.format("A placa %s não existe", placa));
		}
		return Collections.singletonList(veiculoResponses);

	}

}
