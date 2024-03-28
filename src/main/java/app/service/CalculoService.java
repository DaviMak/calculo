package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Entrada;
import app.entity.Resultado;
import app.repository.CalculoRepository;


@Service
public class CalculoService {
	
	@Autowired
	private CalculoRepository calculoRepository;
	
	
	public Resultado calcular(Entrada entrada) {
		Resultado resultado = new Resultado();
		resultado.setMaior(maior(entrada.getNumeros()));
		return resultado;
	}
	
	
	public double maior (List<Integer> lista) {
		
		int maior = lista.get(0);
		
		for(int i=0; i<lista.size(); i++) {
			if(maior < lista.get(i)) {
				maior = lista.get(i);
			}
		}
		
		return maior;
	}
	
	public Optional<Resultado> findById(long id) {
		return this.calculoRepository.findById(id);
	}
}
