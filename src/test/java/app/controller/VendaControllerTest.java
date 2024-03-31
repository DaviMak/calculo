package app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import app.entity.Resultado;
import app.repository.VendaRepository;

@SpringBootTest
public class VendaControllerTest {

	@Autowired
	VendaController vendacontroller;
	
	@MockBean
	VendaRepository vendarepository;
	
	@BeforeEach
	void setup() {
		List<Resultado> lista = new ArrayList<>();
		
	//	problemas nessa parte
		
	//	lista.add(new Resultado(1, 10, 1, 15, 5, "joao"));
	//	lista.add(new Resultado(1, 10, 1, 15, 5, "joao"));
		
	//	when(vendarepository.findAll()).thenReturn(lista); // devo estar passando a lista errada
	}
	@Test
	@DisplayName("super teste")
	
	void cenario1() {
	//	ResponseEntity<List<Resultado>> response = this.vendacontroller.listAll(); //cu cu cu cu
	//	List<Resultado> lista = response.getBody();
		
	//	assertEquals(2, lista.size());
	}
}
