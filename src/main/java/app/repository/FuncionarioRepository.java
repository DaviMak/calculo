package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	
	public List<Funcionario> findByNome (String nome);
	
	public List<Funcionario> findByMatricula (String matricula);
	
	@Query("FROM Funcionario WHERE idade > :idade")
	public List<Funcionario> findByOlderFuncionario (int idade);

}
