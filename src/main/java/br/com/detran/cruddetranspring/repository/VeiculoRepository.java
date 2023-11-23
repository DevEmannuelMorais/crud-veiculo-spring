package br.com.detran.cruddetranspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.detran.cruddetranspring.model.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {
	
	@Query(value = "select * from treinamento.buscar_placa(:placa)", nativeQuery = true)
	List<String> findBuscaPlaca(@Param(value = "placa") String placa);
	
	List<Veiculo> findByPlaca(String placa);
	

}
