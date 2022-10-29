package fr.imt.webannuaire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class WebannuaireApplication {

public static void main(String[] args) {
SpringApplication.run(WebannuaireApplication.class, args);
System.out.println("démarrage de l'application web");
}

@GetMapping("/greetings")
public String hello(@RequestParam(value = "name", defaultValue = "Papa") String name) {
return String.format("Hello %s!", name);
}
}
