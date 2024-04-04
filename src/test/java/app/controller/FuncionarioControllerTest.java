package app.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import app.entity.Funcionario;
import app.repository.FuncionarioRepository;

@SpringBootTest
public class FuncionarioControllerTest {

	@Autowired
	FuncionarioController controller;
	
	@MockBean
	FuncionarioRepository repository;
	
	@BeforeEach
	void setup() {
		List<Funcionario> list = new ArrayList<Funcionario>();
		Funcionario funcionario = new Funcionario();
		
		funcionario.setId(null);
	}
}
