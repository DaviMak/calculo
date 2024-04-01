package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Produto;
import app.entity.Venda;
import app.repository.VendaRepository;
import jakarta.validation.constraints.NotBlank;

@Service
public class VendaService {
	
		@Autowired
		private VendaRepository repository;
		
		public String save(Venda obj) {
			obj.setValorTotal(this.calcularValorTotal(obj.getProdutos()));
			
			this.repository.save(obj);
			return "Venda salva com sucesso.";
		}
		
		public List<Venda> listAll(){
			return this.repository.findAll();
		}
		
		
		public String update(long id, Venda obj) {
			obj.setId(id);
			obj = this.verificarStatus(obj);
			obj.setValorTotal(this.calcularValorTotal(obj.getProdutos()));
			this.repository.save(obj);
			return "Sucesso!";
		}
		
		
		public Venda findById(long id) {
			Venda obj = this.repository.findById(id).get();
			return obj;
		}
		
		
		public String delete(long id) {
			this.repository.deleteById(id);
			return "Sucesso!";
		}	
		
		
		public List<Venda> findByLowerPreco(double valor){
			return this.repository.findByLowerPreco(valor);
		}
		
		
		public List<Venda> findByValorTotal (double valor){
			return this.repository.findByValorTotal(valor);
		}
		
		
		public List<Venda> findByEnderecoEntrega (String endereco){
			return this.repository.findByEnderecoEntrega(endereco);
		}
		
		public double calcularValorTotal(List<Produto> produto) {
			double soma = 0;
			
			for(int i=0; i<produto.size();i++) {
				soma += produto.get(i).getValor();
			}
			
			return soma;
		}
		
		public Venda verificarStatus(Venda obj) {
			if(obj.getStatus().equals("Cancelado"))
				obj.setProdutos(new ArrayList<>());
				
			return obj;
		}
	}
