package app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import app.entity.Produto;
import app.entity.Venda;

@SpringBootTest
public class VendaServiceTest {
	@Autowired
	VendaService service;
	
	@Test
	@DisplayName("TESTE UNITÁRIO DE CÁLCULO DO VALOR TOTAL DA VENDA")
	void testeCalculoVlTotalVenda() {
		List<Produto> lista = new ArrayList<>();
		
		Produto produto = new Produto();
		produto.setId(1L);
		produto.setNome("Produto Teste");;
		produto.setValor(10);
		
		lista.add(produto);
		lista.add(produto);

		double retorno = this.service.calcularValorTotal(lista);

		assertEquals(20, retorno);
	}
	
	@Test
	@DisplayName("TESTE UNITÁRIO DE EXCEPTION DE CÁLCULO DO VALOR TOTAL DA VENDA")
	void testeExceptionVlTotalVenda() {
		assertThrows(Exception.class, () -> {
			double retorno = this.service.calcularValorTotal(null);;
		});
	}
	
	@Test
	@DisplayName("TESTE UNITÁRIO DE VALIDAÇÃO DA VENDA")
	void testeValidacaoVenda() {
		Venda venda = new Venda();
		venda.setProdutos(null);
		venda.setValorTotal(0);
		venda.setStatus("Cancelado");
		
		venda = this.service.verificarStatus(venda);

		assertEquals(0, this.service.calcularValorTotal(venda.getProdutos()));
	}
	
	@Test
	@DisplayName("TESTE UNITÁRIO DE EXCEPCTION VALIDAÇÃO DA VENDA")
	void testeExceptionValidacaoVenda() {
		Venda venda = new Venda();
		venda.setStatus(null);
		
		assertThrows(Exception.class, () -> {
			Venda obj = this.service.verificarStatus(venda);
		});
	}
}
