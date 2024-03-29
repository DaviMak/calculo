package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Cliente;
import app.repository.ClienteRepository;

@Service
public class ClienteService {
	
		@Autowired
		private ClienteRepository repository;
		
		public String save(Cliente obj) {
			this.repository.save(obj);
			return obj.getNome() + " Cliente salvo com sucesso.";
		}
		
		public List<Cliente> listAll(){
			return this.repository.findAll();
		}
		
		public String update(long id, Cliente obj) {
			obj.setId(id);
			this.repository.save(obj);
			return "Sucesso!";
		}
		
		public Cliente findById(long id) {
			Cliente obj = this.repository.findById(id).get();
			return obj;
		}
		
		public String delete(long id) {
			this.repository.deleteById(id);
			return "Sucesso!";
		}
		
		public List<Cliente> findByNome(String nome){
			return this.repository.findByNome(nome);
		}
		
		public List<Cliente> findByCpf(String cpf){
			return this.repository.findByCpf(cpf);
		}
		
		public List<Cliente> findOlderClient(int idade){
			return this.repository.findOlderClient(idade);
		}
	}
