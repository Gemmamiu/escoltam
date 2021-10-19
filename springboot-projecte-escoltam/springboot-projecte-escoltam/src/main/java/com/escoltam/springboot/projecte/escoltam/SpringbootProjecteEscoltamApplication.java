package com.escoltam.springboot.projecte.escoltam;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/**
 * Classe del main
 * @author Gemma Rica
 *
 */
@SpringBootApplication
public class SpringbootProjecteEscoltamApplication /*implements CommandLineRunner*/{

	/*@Autowired
	private BCryptPasswordEncoder passwordEncoder;*/
	/**
	 * Mètode main de l'aplicació servidor
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringbootProjecteEscoltamApplication.class, args);
	}

	/*//Crear contrasenyes
	@Override
	public void run(String... args) throws Exception {
		String password = "12345";
		
		for(int i = 0; i < 4; i++) {
			String passwordBcrypt = passwordEncoder.encode(password);
			System.out.println(passwordBcrypt);
		}
	}*/

}
