package com.algaworks.algalog.controller;

import java.util.List;
import java.util.Optional;

import com.algaworks.algalog.ClienteRepository;
import com.algaworks.algalog.domain.model.Cliente;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class ClienteController {

	private ClienteRepository clienteRepository;
	
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		
		return clienteRepository.findAll();
	}
	
	@GetMapping("/clientes/{clienteId}")
	public Cliente buscar(@PathVariable Long clienteId) {
		Optional<Cliente> cliente = clienteRepository.findById(clienteId);
		return cliente.orElse(null);
	}
}
