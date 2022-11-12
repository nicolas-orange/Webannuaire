package fr.imt.webannuaire.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.imt.webannuaire.data.Person;
import fr.imt.webannuaire.itf.DictionnaryItf;

@RestController
public class RestControl {
	
	@Autowired
	DictionnaryItf dict;
	
	@GetMapping("/annuaire")
	public Collection<Person> getAll() {
		return dict.getAll();
	}
	
	@PostMapping("/annuaire")
	public ResponseEntity<String> add(@RequestBody Person newPerson) {
		if (dict.getFromName(newPerson.getName()) != null){
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Personne deja existante");
		}
		dict.addPerson(newPerson);
		return ResponseEntity.status(HttpStatus.CREATED).body("http://localhost:8080/rechercher/"+newPerson.getId());
	}
	
	@GetMapping("/annuaire/{id}")
	public ResponseEntity<?> getOne(@PathVariable int id) {
		if (dict.getFromId(id) == null){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pas de personne trouvee avec cet ID");
		}
		return ResponseEntity.status(HttpStatus.OK).body(dict.getFromId(id));
	}
	
	@DeleteMapping("/annuaire/{id}")
	public ResponseEntity<?> removeOne(@PathVariable int id) {
		
		if (dict.getFromId(id) == null){
			return new ResponseEntity<>("Pas de personne a supprimer avec cet ID", HttpStatus.NOT_FOUND);
		}
		dict.deleteFromId(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();	
	}
	
	@PutMapping("/annuaire")
	public ResponseEntity<?> remplace(@RequestBody Person updatedPerson) {		
		if (dict.getFromId(updatedPerson.getId()) == null){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pas de personne a mettre a jour avec cet ID");
		}
		dict.addPerson(updatedPerson);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();		
	}
	
	

}
