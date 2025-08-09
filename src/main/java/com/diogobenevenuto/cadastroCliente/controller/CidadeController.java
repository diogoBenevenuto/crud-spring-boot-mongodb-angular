package com.diogobenevenuto.cadastroCliente.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diogobenevenuto.cadastroCliente.model.Cidade;
import com.diogobenevenuto.cadastroCliente.model.Clientes;
import com.diogobenevenuto.cadastroCliente.repository.ClienteRepository;
import com.diogobenevenuto.cadastroCliente.service.CidadeService;

@RestController
@RequestMapping(value="/api/cidades")
@CrossOrigin(origins = "http://localhost:4200")
public class CidadeController {

	private final CidadeService service;
	private final ClienteRepository clienteRepository;
	
	public CidadeController(CidadeService service, ClienteRepository clienteRepository) {
		this.service = service;
		this.clienteRepository = clienteRepository;
	}
	
	@GetMapping
	public List<Cidade> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Map<String, Object> findByIdWithClientes(@PathVariable String id){
		Map<String, Object> resp = new HashMap<>();
		
		Cidade cidade = service.findById(id).orElse(null);
		if(cidade == null) {
			resp.put("erro", "Cidade não encontrada");
			return resp;
		}
		
		List<Clientes> clientes = clienteRepository.findByCityId(id);
		
		resp.put("Cidade", cidade);
		resp.put("Clientes", clientes);
		
		return resp;
	}
	
	@PostMapping
	public Cidade insert(@RequestBody Cidade cidade) {
		return service.insert(cidade);
	}
	
	@PutMapping("/{id}")
	public Cidade update(@PathVariable String id, @RequestBody Cidade cidade) {
		cidade.setId(id);
		return service.update(cidade);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		service.deleteById(id);
	}
	
}
