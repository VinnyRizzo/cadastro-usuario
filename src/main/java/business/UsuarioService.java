package business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import infrastructure.entities.Usuario;
import infrastructure.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public void salvarUsuario(Usuario usuario) {
		repository.saveAndFlush(usuario);
	}
	
	public Usuario buscarUsuarioPorEmail(String email) {
		return repository.findByEmail(email).orElseThrow(
				() -> new RuntimeException("Email não encontrado"));
	}
	
	public void deleteUsuarioPorEmail(String email) {
		 repository.deleteByEmail(email);
	}

}
