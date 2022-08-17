package com.argentinaprograma.APIBackend.rest;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.argentinaprograma.APIBackend.controller.UsuarioController;
import com.argentinaprograma.APIBackend.model.Usuario;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@RestController
public class UsuarioREST {
	 @Autowired
	 private UsuarioController userController;
	 
	@PostMapping("user")//@RequestParam("email") String mail, @RequestParam("user") String username, @RequestParam("password") String pwd
	public Usuario login(@RequestBody Usuario user) {
	
		Usuario usuario = new Usuario();
		usuario.setEmail(user.getEmail());
		usuario.setUser(user.getUser());
		usuario.setPwd(user.getPwd());
		usuario.setToken(getJWTToken(user.getUser()));		
		userController.save(usuario);
		return usuario;
		
	}

	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("ApiBackend")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				/* SI SE QUIERE HACER QUE EL TOKEN EXPIRE LUEGO DE UN TIEMPO USAMOS LO SIGUIENTE
				 * 900000 = 15 MINUTOS - 1 MINUTO  = 60000 MILISEGUNDOS
				.setExpiration(new Date(System.currentTimeMillis()+900000))
				*/
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
}
