package br.com.detran.cruddetranspring.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.detran.cruddetranspring.dto.ProprietarioDTO;
import br.com.detran.cruddetranspring.service.ProprietarioService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/Proprietario")
public class ProprietarioController {
	private final ProprietarioService proprietarioService;

	public ProprietarioController(ProprietarioService proprietarioService) {
		super();
		this.proprietarioService = proprietarioService;
	}

	@Operation(description = "Busca um proprietario pelo id")
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getByProprietario(@PathVariable Integer id) {
		return ResponseEntity.ok(proprietarioService.getById(id));
	}

	@Operation(description = "Busca todos o proprietários por nome e cpf")
	@GetMapping("/getNomeCpf/{nomeOrCpf}")
	public ResponseEntity<?> getByProprietarioNomeCpf(@PathVariable String nomeOrCpf) {
		return ResponseEntity.ok(proprietarioService.listProprietarioByNomeAndCpf(nomeOrCpf));

	}

	@Operation(description = "Busca todos o proprietários")
	@GetMapping("/list")
	public ResponseEntity<?> listarProprietarios() {
		return ResponseEntity.ok(proprietarioService.listProprietario());
	}

	@Operation(description = "Criar um proprietário")
	@PostMapping("/create")
	public ResponseEntity<?> createProprietario(@RequestBody @Valid ProprietarioDTO proprietarioDTO) {
		return ResponseEntity.ok(proprietarioService.create(proprietarioDTO));
	}

	@Operation(description = "Atualiza um proprietário")
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateProprietario(@RequestBody ProprietarioDTO dto, @PathVariable Integer id) {
		return ResponseEntity.ok(proprietarioService.update(dto, id));
	}

	@Operation(description = "Deleta um proprietário")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProprietario(@PathVariable Integer id) {
		return ResponseEntity.ok(proprietarioService.delete(id));
	}

}
