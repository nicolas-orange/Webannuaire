package fr.imt.webannuaire.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import fr.imt.webannuaire.data.Person;
import fr.imt.webannuaire.itf.DictionnaryItf;

@Service(value="annuaireservice")
public class AnnuaireService implements DictionnaryItf {
	
	Map<Integer,Person> hm;
	
	public AnnuaireService() {
		hm = new HashMap<Integer,Person>();
		
		Person Who=new Person("Who", "Doctor", "0606060606", "Lille");
		hm.put(Who.getId(),Who);
		Person Bond=new Person("Bond", "James", "0606060606", "Londres");
		Bond.setId(1007);
		hm.put(Bond.getId(),Bond);
		Person Georges=new Person("Abitbol", "Georges", "+33633609805", "Paris");
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
	/**
	@Override
	public Person getFromName(String name) {
		for  in hm.values {
			if p.name==name {
				return hm.get(p.name}
		}
		return hm.get(name);
	}**/
	// Print keys
	@Override
	public Person getFromName(String name) {
		for (int i : hm.keySet()) {
		  if (hm.get(i).getName() == name) {
			  return hm.get(i);
		  }
		}
		return null;
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
