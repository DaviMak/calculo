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

import app.entity.Cliente;
import app.repository.ClienteRepository;

@SpringBootTest
public class ClienteControllerTest {
	@Autowired
	ClienteController controller;
	
	@MockBean
	ClienteRepository repository;
	
	@BeforeEach
	void setup() {
		List<Cliente> list = new ArrayList<Cliente>();
		Cliente cliente = new Cliente();
		cliente.setCpf("123");
		cliente.setId(1L);
		cliente.setIdade(21);
		cliente.setNome("Teste Client");
		cliente.setTelefone("123123123");
		
		Optional<Cliente> clienteOp = Optional.of(cliente);
		
		list.add(cliente);
		
		ClienteRepository repositoryMock = spy(ClienteRepository.class);
		
		when(this.repository.findAll()).thenReturn(list);
		when(this.repository.save(cliente)).thenReturn(cliente);
		when(this.repository.findById(1L)).thenReturn(clienteOp);
		doNothing().when(repositoryMock).deleteById(1L);
		when(this.repository.findByNome("Teste")).thenReturn(list);
		when(this.repository.findOlderClient(40)).thenReturn(list);
		when(this.repository.findByCpf("123")).thenReturn(list);
	}
	
	@Test
	@DisplayName("TESTE MÉTODO listAll()")
	void testFindAll() {
		ResponseEntity<List<Cliente>> response = this.controller.listAll();
		List<Cliente> lista = response.getBody();
		
		assertEquals(1, lista.size());
	}
	
	@Test
	@DisplayName("TESTE MÉTODO save()")
	void testSave() {
		Cliente cliente = new Cliente();
		cliente.setCpf("123");
		cliente.setId(1L);
		cliente.setIdade(21);
		cliente.setNome("Teste Client");
		cliente.setTelefone("123123123");
		
		ResponseEntity<String> response = this.controller.save(cliente);
		String msg = response.getBody();
		
		assertEquals(cliente.getNome() + " Cliente salvo com sucesso.", msg);
	}
	
	@Test
	@DisplayName("TESTE MÉTODO update()")
	void testUpdate() {
		Cliente cliente = new Cliente();
		cliente.setCpf("123");
		cliente.setId(1L);
		cliente.setIdade(21);
		cliente.setNome("Teste Client");
		cliente.setTelefone("123123123");
		
		ResponseEntity<String> response = this.controller.update(cliente, 1);
		String msg = response.getBody();
		
		assertEquals("Sucesso!", msg);
	}
	
	@Test
	@DisplayName("TESTE MÉTODO findById()")
	void testFindById() {
		ResponseEntity<Cliente> response = this.controller.findById(1L);
		Cliente obj = response.getBody();
		
		assertEquals("123", obj.getCpf());
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
		ResponseEntity<List<Cliente>> response = this.controller.findByNome("Teste");
		List<Cliente> lista = response.getBody();
		
		assertEquals(1, lista.size());
	}

	@Test
	@DisplayName("TESTE MÉTODO findOlderClient()")
	void testFindByValor() {
		ResponseEntity<List<Cliente>> response = this.controller.findOlderClient(40);
		List<Cliente> lista = response.getBody();
		
		assertEquals(1, lista.size());
	}
	
	@Test
	@DisplayName("TESTE MÉTODO findByCpf()")
	void testFindByLowerPreco() {
		ResponseEntity<List<Cliente>> response = this.controller.findByCpf("123");
		List<Cliente> lista = response.getBody();
		
		assertEquals(1, lista.size());
	}
}
