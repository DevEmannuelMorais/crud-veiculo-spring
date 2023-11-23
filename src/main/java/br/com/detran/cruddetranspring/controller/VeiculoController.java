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

import br.com.detran.cruddetranspring.dto.VeiculoDTO;
import br.com.detran.cruddetranspring.service.VeiculoService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/Veiculo")
public class VeiculoController {

	private final VeiculoService veiculoService;

	public VeiculoController(VeiculoService veiculoService) {
		super();
		this.veiculoService = veiculoService;
	}

	@Operation(description = "Lista todos os Veiculos")
	@GetMapping("/listar")
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok(veiculoService.listVeiculo());
	}

	@Operation(description = "Busca um Veiculo pelo id")
	@GetMapping("/get/{id}")
	public ResponseEntity<?> get(@PathVariable Integer id) {
		return ResponseEntity.ok(veiculoService.getById(id));
	}

	@Operation(description = "Cria um Veiculo")
	@PostMapping("/criar")
	public ResponseEntity<?> criar(@RequestBody @Valid VeiculoDTO request) {
		return ResponseEntity.ok(veiculoService.create(request));
	}

	@Operation(description = "Atualiza um Veiculo")
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<?> atualizar(@RequestBody @Valid VeiculoDTO request, @PathVariable Integer id) {
		return ResponseEntity.ok(veiculoService.update(request, id));
	}

	@Operation(description = "Deleta um Veiculo")
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id) {
		return ResponseEntity.ok(veiculoService.delete(id));
	}
	
	@GetMapping("/getplaca/{placa}") 
	public ResponseEntity<?> findPlacaVeicProp(@PathVariable String placa){
		return ResponseEntity.ok(veiculoService.findPlaca(placa));
	}
	
}
