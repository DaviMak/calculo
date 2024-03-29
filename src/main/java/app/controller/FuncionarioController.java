package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Funcionario;
import app.service.FuncionarioService;



@RestController
@RequestMapping("/api/funcionario")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService service;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Funcionario obj){
		try {
			String msg = this.service.save(obj);
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("Aconteceu algo de errado: "+ e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Funcionario obj, @PathVariable int id){
		try {
			String msg = this.service.update(id, obj);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Não foi possivel atualizar a lista. "+e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/listAll")
	public ResponseEntity<List<Funcionario>> listAll(){
		try {
			List<Funcionario> lista = this.service.listAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Funcionario>findById(@PathVariable long id){
		try {
			Funcionario obj = this.service.findById(id);
			return new ResponseEntity<Funcionario>(obj, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){
		try {
			String msg = this.service.delete(id);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/findByNome/{nome}")
	public ResponseEntity<List<Funcionario>> findByNome(@PathVariable String nome){
		try {
			List<Funcionario> lista = this.service.findByNome(nome);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/findByMatricula/{matricula}")
	public ResponseEntity<List<Funcionario>> findByMatricula(@PathVariable String matricula){
		try {
			List<Funcionario> lista = this.service.findByMatricula(matricula);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/findByOlderFuncionario/{idade}")
	public ResponseEntity<List<Funcionario>> findByOlderFuncionario(@PathVariable int idade){
		try {
			List<Funcionario> lista = this.service.findByOlderFuncionario(idade);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
}
