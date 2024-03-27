package service;

import java.util.List;

import entity.Entrada;
import entity.Resultado;

public class CalculoService {
	
	public Resultado calcular(Entrada entrada) {
		Resultado resultado = new Resultado();
		resultado.setEntrada(entrada);
	//	resultado.setMaior();
		return resultado;
	}
	
	
	public double maior (List<Integer> lista) {
		
		int maior = 0;
		
		for(int i=0; i<lista.size(); i++) {
		//	if(maior <)
		}
		
		return maior;
	}
}
