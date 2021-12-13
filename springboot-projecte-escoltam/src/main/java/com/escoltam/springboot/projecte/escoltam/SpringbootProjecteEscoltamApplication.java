package com.escoltam.springboot.projecte.escoltam;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.escoltam.springboot.projecte.escoltam.models.entity.Icona;
import com.escoltam.springboot.projecte.escoltam.models.entity.PanellPredefinit;
import com.escoltam.springboot.projecte.escoltam.models.services.IIconaService;
import com.escoltam.springboot.projecte.escoltam.models.services.IPanellPredefinitService;


/**
 * Classe del main
 * @author Gemma Rica
 *
 */
@SpringBootApplication
public class SpringbootProjecteEscoltamApplication{

	/**
	 * Mètode main de l'aplicació servidor
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringbootProjecteEscoltamApplication.class, args);
		

	}
	
	@Bean
	public CommandLineRunner loadData(IIconaService iconaRepository, IPanellPredefinitService panellPredefinitRepository) {
	    return (args) -> {
	    	PanellPredefinit panellPredefinit = null;
	    	Path ruta = Paths.get("src/main/resources/static/images").resolve("si.jpg").toAbsolutePath();
	    	byte[] array = Files.readAllBytes(ruta);
	    	System.out.println(ruta);
	    	System.out.println(array);
	    	panellPredefinit = panellPredefinitRepository.findPanellPredefinitById(1L);
	    	iconaRepository.save(new Icona("prova",1,panellPredefinit,array));
	    };
	}
	
}
