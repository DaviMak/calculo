package entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Resultado {
	
	private Entrada entrada;
	private double maior;
	private double menor;
	private double total;
	private double media;
	
	
	public Entrada getEntrada() {
		return entrada;
	}
	public void setEntrada(Entrada entrada) {
		this.entrada = entrada;
	}
	public double getMaior() {
		return maior;
	}
	public void setMaior(double maior) {
		this.maior = maior;
	}
	public double getMenor() {
		return menor;
	}
	public void setMenor(double menor) {
		this.menor = menor;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getMedia() {
		return media;
	}
	public void setMedia(double media) {
		this.media = media;
	}
	
}
