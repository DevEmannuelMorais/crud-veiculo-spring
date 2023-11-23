package br.com.detran.cruddetranspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.detran.cruddetranspring.model.Proprietario;

@Repository
public interface ProprietarioRepository extends JpaRepository<Proprietario, Integer> {

	@Query("SELECT p FROM Proprietario p WHERE LOWER(p.nome) LIKE LOWER(CONCAT('%', :nome, '%')) OR LOWER(p.cpfCnpj) LIKE LOWER(CONCAT('%', :cpf, '%'))")
	List<Proprietario> findByNomeOrCpfCnpj(@Param("nome") String nome, @Param("cpf") String cpfCnpj);

	@Query(value = "SELECT * FROM treinamento.proprietario WHERE nome ILIKE %:nome% OR cpf_cnpj ILIKE %:cpf%", nativeQuery = true)
	List<Proprietario> findByNomeOrCpfCnpj2(@Param("nome") String nome, @Param("cpf") String cpfCnpj);
	
}
