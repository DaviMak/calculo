package app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
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
import app.entity.Funcionario;
import app.entity.Produto;
import app.entity.Venda;
import app.repository.VendaRepository;

@SpringBootTest
public class VendaControllerTest {
	@Autowired
	VendaController controller;
	
	@MockBean
	VendaRepository repository;
	
	@BeforeEach
	void setup() {
		List<Venda> list = new ArrayList();
		List<Produto> listProd = new ArrayList<>();
		
		Venda venda = new Venda();
		venda.setCliente(new Cliente());
		venda.setFuncionario(new Funcionario());
		
		Produto produto = new Produto();
		produto.setId(1L);
		produto.setNome("Produto Teste");;
		produto.setValor(9999);
		
		listProd.add(produto);
		
		venda.setProdutos(listProd);
		venda.setValorTotal(9999);

		Optional<Venda> vendaOp = Optional.of(venda);
		
		list.add(venda);
		
		VendaRepository repositoryMock = spy(VendaRepository.class);
		
		when(this.repository.findAll()).thenReturn(list);
		when(this.repository.save(venda)).thenReturn(venda);
		when(this.repository.findById(1L)).thenReturn(vendaOp);
		doNothing().when(repositoryMock).deleteById(1L);
		when(this.repository.findByEnderecoEntrega("Teste")).thenReturn(list);
		when(this.repository.findByValorTotal(100.0)).thenReturn(list);
		when(this.repository.findByLowerPreco(50)).thenReturn(list);
	}
	
	@Test
	@DisplayName("TESTE MÉTODO listAll()")
	void testFindAll() {
		ResponseEntity<List<Venda>> response = this.controller.listAll();
		List<Venda> lista = response.getBody();
		
		assertEquals(1, lista.size());
	}
	
	@Test
	@DisplayName("TESTE MÉTODO save()")
	void testSave() {
		Venda venda = new Venda();
		venda.setId(1L);
		
		Cliente cliente = new Cliente();
		cliente.setCpf("123");
		cliente.setId(1L);
		cliente.setIdade(21);
		cliente.setNome("Teste Client");
		cliente.setTelefone("123123123");
		
		Funcionario funcionario = new Funcionario();
		funcionario.setId(1L);
		funcionario.setIdade(21);
		funcionario.setMatricula("321321");
		funcionario.setNome("Teste Funcionário");
		
		venda.setCliente(cliente);
		venda.setFuncionario(funcionario);
		
		Produto produto = new Produto();
		produto.setId(1L);
		produto.setNome("Produto Teste");;
		produto.setValor(9999);
		
		List<Produto> listProd = new ArrayList<>();
		listProd.add(produto);
		
		venda.setProdutos(listProd);
		venda.setStatus("Pendente");
		venda.setValorTotal(9999);
		
		ResponseEntity<String> response = this.controller.save(venda);
		String msg = response.getBody();
		
		assertEquals("Venda salva com sucesso.", msg);
	}
	
	@Test
	@DisplayName("TESTE MÉTODO update()")
	void testUpdate() {
		Venda venda = new Venda();
		
		Cliente cliente = new Cliente();
		cliente.setCpf("123");
		cliente.setId(1L);
		cliente.setIdade(21);
		cliente.setNome("Teste Client");
		cliente.setTelefone("123123123");
		
		Funcionario funcionario = new Funcionario();
		funcionario.setId(1L);
		funcionario.setIdade(21);
		funcionario.setMatricula("321321");
		funcionario.setNome("Teste Funcionário");
		
		venda.setCliente(cliente);
		venda.setFuncionario(funcionario);
		
		Produto produto = new Produto();
		produto.setId(1L);
		produto.setNome("Produto Teste");;
		produto.setValor(9999);
		
		List<Produto> listProd = new ArrayList<>();
		listProd.add(produto);
		
		venda.setProdutos(listProd);
		venda.setStatus("Pendente");
		
		ResponseEntity<String> response = this.controller.update(venda, 1);
		String msg = response.getBody();
		
		assertEquals("Sucesso!", msg);
	}
	
	@Test
	@DisplayName("TESTE MÉTODO findById()")
	void testFindById() {
		ResponseEntity<Venda> response = this.controller.findById(1L);
		Venda obj = response.getBody();
		
		assertEquals(9999, obj.getValorTotal());
	}
	
	@Test
	@DisplayName("TESTE MÉTODO delete()")
	void testDelete() {
		ResponseEntity<String> response = this.controller.delete(1L);
		String msg = response.getBody();
		
		assertEquals("Sucesso!", msg);
	}
	
	@Test
	@DisplayName("TESTE MÉTODO findByEnderecoEntrega()")
	void testFindByEnderecoEntrega() {
		ResponseEntity<List<Venda>> response = this.controller.findByEnderecoEntrega("Teste");
		List<Venda> lista = response.getBody();
		
		assertEquals(1, lista.size());
	}

	@Test
	@DisplayName("TESTE MÉTODO findByValor()")
	void testFindByValor() {
		ResponseEntity<List<Venda>> response = this.controller.findByValor(100);
		List<Venda> lista = response.getBody();
		
		assertEquals(1, lista.size());
	}
	
	@Test
	@DisplayName("TESTE MÉTODO findByLowerPreco()")
	void testFindByLowerPreco() {
		ResponseEntity<List<Venda>> response = this.controller.findByLowerPreco(50);
		List<Venda> lista = response.getBody();
		
		assertEquals(1, lista.size());
	}
}
