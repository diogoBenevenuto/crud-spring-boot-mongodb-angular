package com.diogobenevenuto.cadastroCliente.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.diogobenevenuto.cadastroCliente.model.Clientes;
import com.diogobenevenuto.cadastroCliente.service.ClienteService;

@RestController
@RequestMapping(value = "/api/clientes")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {
	
	private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Clientes> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Clientes findById(@PathVariable String id) {
        return service.findById(id).orElse(null);
    }

    @PostMapping
    public Clientes save(@RequestBody Clientes cliente) {
        return service.insert(cliente);
    }

    @PutMapping("/{id}")
    public Clientes update(@PathVariable String id, @RequestBody Clientes cliente) {
        cliente.setId(id);
        return service.update(cliente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.deleteById(id);
    }

}
