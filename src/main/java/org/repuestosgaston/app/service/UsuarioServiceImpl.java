package org.repuestosgaston.app.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.repuestosgaston.app.model.Usuario;
import org.repuestosgaston.app.repository.IUsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements IUsuarioService,UserDetailsService{

	private Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);
	
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	private String saludo() {
		return "Hola Mundo!";
	}
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioRepository.findByUsername(username);
		
		//Manejo de error
		if (usuario == null) {
			logger.error("Usuario inexistente: "+username);
			//Lanzamos la exepcion
			throw new UsernameNotFoundException("Usuario inexistente: "+username);
		}
		
		List<GrantedAuthority> authorities = usuario.getRoles()
				.stream()
				.map(roles -> new SimpleGrantedAuthority(roles.getName()))
				.peek(authoritiy -> logger.info("Role: "+ authoritiy.getAuthority()))
				.collect(Collectors.toList());
		
		
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.isEnabled(),true,true,true,authorities);
	}

}
