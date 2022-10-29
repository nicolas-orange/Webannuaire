package fr.imt.webannuaire.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import fr.imt.webannuaire.data.Person;
import fr.imt.webannuaire.itf.DictionnaryItf;

@Service
public class DictionnaryService implements DictionnaryItf {
	
	Map<Integer,Person> hm;
	
	public DictionnaryService() {
		hm = new HashMap<Integer,Person>();
		
		Person Who=new Person("Who", "Doctor", "0606060606", "Lille");
		hm.put(Who.getId(),Who);
		Person Bond=new Person(1007,"Bond", "James", "0606060606", "Londres");
		hm.put(Bond.getId(),Bond);
		Person Georges=new Person(1337,"Abitbol", "Georges", "+33633609805", "Paris");
		hm.put(Georges.getId(),Georges);
	}

	@Override
	public Collection<Person> getAll() {
		return (Collection<Person>) (hm.values());
	}

	@Override
	public Person getFromId(int id) {
		return hm.get(id);
	}

	@Override
	public boolean deleteFromId(int id) {
		if(hm.remove(id) != null) return true;
		return false;
	}

	@Override
	public void addPerson(Person p) {
		hm.put(p.getId(), p);
	}

}
