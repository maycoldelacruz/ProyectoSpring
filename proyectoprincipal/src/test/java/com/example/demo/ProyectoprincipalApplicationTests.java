package com.example.demo;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Usuario;
import com.example.demo.repository.UsuarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProyectoprincipalApplicationTests {

	@Autowired
	private UsuarioRepository repo;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Test
	public void crearUsuarioTest() {
		Usuario us=new Usuario();
		us.setId(3);
		us.setNombre("Jhon");
		us.setClave(encoder.encode("1234"));
		//us.setClave("123");
		repo.save(us);
		Usuario retorno=repo.save(us);
		assertTrue(retorno.getClave().equals(us.getClave()));
	}

}
