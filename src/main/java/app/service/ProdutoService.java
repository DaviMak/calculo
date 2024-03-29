package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Produto;
import app.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
		@Autowired
		private ProdutoRepository repository;
		
		public String save(Produto obj) {
			this.repository.save(obj);
			return obj.getNome() + "salvo com sucesso.";
		}
		
		public List<Produto> listAll(){
			return this.repository.findAll();
		}
		
		public String update(long id, Produto obj) {
			obj.setId(id);
			this.repository.save(obj);
			return "Sucesso!";
		}
		
		public Produto findById(long id) {
			Produto obj = this.repository.findById(id).get();
			return obj;
		}
		
		public String delete(long id) {
			this.repository.deleteById(id);
			return "Sucesso!";
		}
		public List<Produto> findByLowerPreco(double valor){
			return this.repository.findByLowerPreco(valor);
		}
		public List<Produto> findByValor (double valor){
			return this.repository.findByValor(valor);
		}
		public List<Produto> findByNome (String nome){
			return this.repository.findByNome(nome);
		}
	}
