package com.aulateste.aulateste.controlles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aulateste.aulateste.entities.Usuario;
import com.aulateste.aulateste.repositories.UsuarioRepository;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public List<Usuario> findAll(){
		List<Usuario> result = usuarioRepository.findAll();
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public Usuario findById(@PathVariable Long id) {
		Usuario result = usuarioRepository.findById(id).get();
		return result;
	}
	
	@PostMapping
	public Usuario insert(@RequestBody Usuario usuario) {
		Usuario result = usuarioRepository.save(usuario);
		return result;
	}
}
