package com.diogobenevenuto.cadastroCliente.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.diogobenevenuto.cadastroCliente.model.Clientes;
import com.diogobenevenuto.cadastroCliente.repository.ClienteRepository;

@Service
public class ClienteService {

	private final ClienteRepository repository;
	
	public ClienteService(ClienteRepository repository) {
		this.repository = repository;
	}
	
	public List<Clientes> findAll(){
		return repository.findAll();
	}
	
	public Optional<Clientes> findById(String id){
		return repository.findById(id);
		
	}
	
	public Clientes insert(Clientes clientes) {
		return repository.insert(clientes);
	}
	
	public void deleteById(String id) {
		repository.deleteById(id);
	}
	
	public Clientes update(Clientes clientes) {
		Clientes newObj = repository.findById(clientes.getId()).get();
		udpateData(newObj, clientes);
		return repository.save(newObj);
	}

	private void udpateData(Clientes newObj, Clientes clientes) {
		newObj.setName(clientes.getName());
		newObj.setEmail(clientes.getEmail());
		newObj.setNumber(clientes.getNumber());
		
	}
	
}
