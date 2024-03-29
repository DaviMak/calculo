//package service;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import app.entity.Cliente;
//import app.repository.ClienteRepository;
//import app.service.ClienteService;
//
//@SpringBootTest
//public class ClienteServiceTest {
//	
//	@Autowired
//	ClienteService clienteservice;
//	
//	@MockBean
//	ClienteRepository clienterepository;
//	
//	@BeforeEach
//	void setup() {
//		List<Cliente> lista = new ArrayList<>();
//	//	Cliente cliente = new Cliente();
//	//	cliente.setNome("clebinho");
//	//	lista.add(cliente);
//		
//    	//when(this.clienterepository.findByNome("clebinho")).thenReturn(Optional.of(lista).get());	
//		Cliente cliente = new Cliente();
//		cliente.setNome("clebinho");
//		
//		when(this.clienterepository.findByNome("clebinho")).thenReturn(Optional.of(cliente));
//	}
//	
//	@Test
//	@DisplayName("teste para ver e ele acha pelo nome dado")
//	void findByNomeTest() {
//		List<Cliente> list = clienteservice.findByNome("clebinho");
//		
//		assertEquals(1, list.size());
//		assertEquals("clebinho", list.get(0).getNome());
//	}
//}
