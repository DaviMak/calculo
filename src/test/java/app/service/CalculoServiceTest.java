package app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

import app.entity.Resultado;
import app.repository.CalculoRepository;

@SpringBootTest
class CalculoServiceTest {

	@Autowired
	CalculoService calculoservice;
	
	//@MockBean
	//CalculoRepository calculoRepository;
	
	
//	@BeforeEach
//	void setup() {
		
//		Resultado resultado = new Resultado();
//		resultado.setNome("João");
//		
//		when(this.calculoRepository.findById(1L)).thenReturn(Optional.of(resultado));
//	}
	
	@Test
	@DisplayName("é pra pegar o maior valor que é 30")
	void MaiorTest(){
		
		List<Integer> lista = new ArrayList<>();
		
		lista.add(5);
		lista.add(9);
		lista.add(28);
		lista.add(30);
		
		double maior = calculoservice.maior(lista);
		
		assertEquals(30, maior);
	}
	
	@Test
	@DisplayName("teste unitario de erro")
	
	void MaiorTest2() {
		List<Integer> lista = new ArrayList<>();
		
		lista.add(5);
		lista.add(9);
		lista.add(28);
		lista.add(null);
		
		assertThrows(Exception.class, () ->{
			double retorno = this.calculoservice.maior(lista);
		});
	}
	
	
//	@Test
//	@DisplayName("TESTE DE INTEGRAÇÃO COM MOCK VERIFICANDO O NOME JOÕAO")
//	void teste() {
//		Optional<Resultado> resultado = this.calculoservice.findById(1);
//		Resultado result = resultado.get();
//	
//		assertEquals("João", result.getNome());
//	}

}
