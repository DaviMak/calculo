package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {
	
	public List<Venda> findByEnderecoEntrega(String endereco);
	
	public List <Venda> findByValorTotal(double valor);
	
	@Query("FROM Venda WHERE valorTotal < :valor")
	public List<Venda> findByLowerPreco (double valor);
}
