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
	
	//AFEGIR icones al panell predefinit al aixecar el servidor. 
	//Emmagatzemades a la carpeta resources i es transformen en byte[] i es guarden en la BD
	@Bean
	public CommandLineRunner loadData(IIconaService iconaRepository, IPanellPredefinitService panellPredefinitRepository) {
	    return (args) -> {
	    	PanellPredefinit panellPredefinit = null;
	    	
	    	//ICONA JO
	    	Path rutaJo = Paths.get("src/main/resources/static/images").resolve("jo.png").toAbsolutePath();
	    	byte[] fotoJo = Files.readAllBytes(rutaJo);
	    	panellPredefinit = panellPredefinitRepository.findPanellPredefinitById(0L);
	    	iconaRepository.save(new Icona("Jo",1,panellPredefinit,fotoJo));
	    	
	    	//ICONA TU
	    	Path rutaTu = Paths.get("src/main/resources/static/images").resolve("tu.png").toAbsolutePath();
	    	byte[] fotoTu = Files.readAllBytes(rutaTu);
	    	panellPredefinit = panellPredefinitRepository.findPanellPredefinitById(0L);
	    	iconaRepository.save(new Icona("Tu",2,panellPredefinit,fotoTu));
	    	
	    	//ICONA ELL
	    	Path rutaEll = Paths.get("src/main/resources/static/images").resolve("ell.png").toAbsolutePath();
	    	byte[] fotoEll = Files.readAllBytes(rutaEll);
	    	panellPredefinit = panellPredefinitRepository.findPanellPredefinitById(0L);
	    	iconaRepository.save(new Icona("Ell",3,panellPredefinit,fotoEll));
	    	
	    	//ICONA ELLA
	    	Path rutaElla = Paths.get("src/main/resources/static/images").resolve("ella.png").toAbsolutePath();
	    	byte[] fotoElla = Files.readAllBytes(rutaElla);
	    	panellPredefinit = panellPredefinitRepository.findPanellPredefinitById(0L);
	    	iconaRepository.save(new Icona("Ella",4,panellPredefinit,fotoElla));
	    	
	    	//ICONA NOSALTRES
	    	Path rutaNosaltres = Paths.get("src/main/resources/static/images").resolve("nosaltres.png").toAbsolutePath();
	    	byte[] fotoNosaltres = Files.readAllBytes(rutaNosaltres);
	    	panellPredefinit = panellPredefinitRepository.findPanellPredefinitById(0L);
	    	iconaRepository.save(new Icona("Nosaltres",5,panellPredefinit,fotoNosaltres));
	    	
	    	//ICONA VOSALTRES
	    	Path rutaVosaltres = Paths.get("src/main/resources/static/images").resolve("vosaltres.png").toAbsolutePath();
	    	byte[] fotoVosaltres = Files.readAllBytes(rutaVosaltres);
	    	panellPredefinit = panellPredefinitRepository.findPanellPredefinitById(0L);
	    	iconaRepository.save(new Icona("Vosaltres",6,panellPredefinit,fotoVosaltres));
	    	
	    	//ICONA ELLS
	    	Path rutaElls = Paths.get("src/main/resources/static/images").resolve("ells.png").toAbsolutePath();
	    	byte[] fotoElls = Files.readAllBytes(rutaElls);
	    	panellPredefinit = panellPredefinitRepository.findPanellPredefinitById(0L);
	    	iconaRepository.save(new Icona("Ells",7,panellPredefinit,fotoElls));
	    	
	    	//ICONA ELLES
	    	Path rutaElles = Paths.get("src/main/resources/static/images").resolve("elles.png").toAbsolutePath();
	    	byte[] fotoElles = Files.readAllBytes(rutaElles);
	    	panellPredefinit = panellPredefinitRepository.findPanellPredefinitById(0L);
	    	iconaRepository.save(new Icona("Elles",8,panellPredefinit,fotoElles));
	    	
	    	//ICONA SI
	    	Path rutaSi = Paths.get("src/main/resources/static/images").resolve("si.png").toAbsolutePath();
	    	byte[] fotoSi = Files.readAllBytes(rutaSi);
	    	panellPredefinit = panellPredefinitRepository.findPanellPredefinitById(0L);
	    	iconaRepository.save(new Icona("Si",9,panellPredefinit,fotoSi));
	    	
	    	//ICONA NO
	    	Path rutaNo = Paths.get("src/main/resources/static/images").resolve("no.png").toAbsolutePath();
	    	byte[] fotoNo = Files.readAllBytes(rutaNo);
	    	panellPredefinit = panellPredefinitRepository.findPanellPredefinitById(0L);
	    	iconaRepository.save(new Icona("No",10,panellPredefinit,fotoNo));
	    };
	}
	
}
