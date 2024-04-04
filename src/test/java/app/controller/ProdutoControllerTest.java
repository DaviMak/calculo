package app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import app.entity.Produto;
import app.repository.ProdutoRepository;

@SpringBootTest
public class ProdutoControllerTest {
	@Autowired
	ProdutoController controller;
	
	@MockBean
	ProdutoRepository repository;
	
	@BeforeEach
	void setup() {
		List<Produto> list = new ArrayList<Produto>();
		Produto produto = new Produto();
		
		produto.setId(1L);
		produto.setNome("Produto Teste");;
		produto.setValor(9999);
		
		Optional<Produto> produtoOp = Optional.of(produto);
		
		list.add(produto);
		
		ProdutoRepository repositoryMock = spy(ProdutoRepository.class);
		
		when(this.repository.findAll()).thenReturn(list);
		when(this.repository.save(produto)).thenReturn(produto);
		when(this.repository.findById(1L)).thenReturn(produtoOp);
		doNothing().when(repositoryMock).deleteById(1L);
		when(this.repository.findByNome("Teste")).thenReturn(list);
		when(this.repository.findByValor(100.0)).thenReturn(list);
		when(this.repository.findByLowerPreco(50)).thenReturn(list);
	}
	
	@Test
	@DisplayName("TESTE MÉTODO listAll()")
	void testFindAll() {
		ResponseEntity<List<Produto>> response = this.controller.listAll();
		List<Produto> lista = response.getBody();
		
		assertEquals(1, lista.size());
	}
	
	@Test
	@DisplayName("TESTE MÉTODO save()")
	void testSave() {
		Produto produto = new Produto();
		produto.setId(1L);
		produto.setNome("Produto Teste");;
		produto.setValor(9999);
		
		ResponseEntity<String> response = this.controller.save(produto);
		String msg = response.getBody();
		
		assertEquals(produto.getNome() + "salvo com sucesso.", msg);
	}
	
	@Test
	@DisplayName("TESTE MÉTODO update()")
	void testUpdate() {
		Produto produto = new Produto();
		produto.setId(1L);
		produto.setNome("Produto Teste");;
		produto.setValor(9999);
		
		ResponseEntity<String> response = this.controller.update(produto, 1);
		String msg = response.getBody();
		
		assertEquals("Sucesso!", msg);
	}
	
	@Test
	@DisplayName("TESTE MÉTODO findById()")
	void testFindById() {
		ResponseEntity<Produto> response = this.controller.findById(1L);
		Produto obj = response.getBody();
		
		assertEquals(9999, obj.getValor());
	}
	
	@Test
	@DisplayName("TESTE MÉTODO delete()")
	void testDelete() {
		ResponseEntity<String> response = this.controller.delete(1L);
		String msg = response.getBody();
		
		assertEquals("Sucesso!", msg);
	}
	
	@Test
	@DisplayName("TESTE MÉTODO findByNome()")
	void testFindByEnderecoEntrega() {
		ResponseEntity<List<Produto>> response = this.controller.findByNome("Teste");
		List<Produto> lista = response.getBody();
		
		assertEquals(1, lista.size());
	}

	@Test
	@DisplayName("TESTE MÉTODO findByValor()")
	void testFindByValor() {
		ResponseEntity<List<Produto>> response = this.controller.findByValor(100);
		List<Produto> lista = response.getBody();
		
		assertEquals(1, lista.size());
	}
	
	@Test
	@DisplayName("TESTE MÉTODO findByLowerPreco()")
	void testFindByLowerPreco() {
		ResponseEntity<List<Produto>> response = this.controller.findByLowerPreco(50);
		List<Produto> lista = response.getBody();
		
		assertEquals(1, lista.size());
	}
}
