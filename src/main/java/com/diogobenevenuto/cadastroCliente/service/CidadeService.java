package com.diogobenevenuto.cadastroCliente.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.diogobenevenuto.cadastroCliente.model.Cidade;
import com.diogobenevenuto.cadastroCliente.repository.CidadeRepository;

@Service
public class CidadeService {

	private final CidadeRepository repository;
	
	public CidadeService(CidadeRepository repository) {
		this.repository = repository;
	}
	
	public List<Cidade> findAll(){
		return repository.findAll();
	}
	
	public Optional<Cidade> findById(String id){
		return repository.findById(id);
		
	}
	
	public Cidade insert(Cidade cidade) {
		return repository.insert(cidade);
	}
	
	public void deleteById(String id) {
		repository.deleteById(id);
	}
	
	public Cidade update(Cidade cidade) {
		Cidade newObj = repository.findById(cidade.getId()).get();
		udpateData(newObj, cidade);
		return repository.save(newObj);
	}

	private void udpateData(Cidade newObj, Cidade cidade) {
		newObj.setName(cidade.getName());
		newObj.setState(cidade.getState());
		
	}
	
}
