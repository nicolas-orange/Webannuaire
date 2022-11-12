package fr.imt.webannuaire;

import fr.imt.webannuaire.data.Person;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class WebannuaireApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebannuaireApplication.class, args);
		System.out.println("démarrage de l'application web");

		// Création d'une instance
		Person pers1 = new Person();
		pers1.setName("Paul");
		pers1.setId(12);
		pers1.setPhone("+336336180");
		System.out.println(pers1);
		// Création du JSON
		//jsonb jsonb = JsonArrayBuilder.create();
		//String result = jsonb.toJson(pers1);
		//System.out.println(result);
		
		
		try {
			String message;
			JSONObject json = new JSONObject();
			JSONArray array = new JSONArray();
			JSONObject item = new JSONObject();
			item.put("information", "test");
			item.put("id", 3);
			item.put("name", "course1");
			array.put(item);

			json.put("course", array);

			message = json.toString();
			System.out.println(message);
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
				
	}

}
