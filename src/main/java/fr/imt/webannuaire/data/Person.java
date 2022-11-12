package fr.imt.webannuaire.data;

import org.springframework.stereotype.Component;

// import org.springframework.boot.autoconfigure.domain.EntityScan;
//@EntityScan

@Component
public class Person {
private static int numerotation=1;
private int id;
private String nom;
private String prenom;
private String numtel;
private String ville;

public Person () {
	this.id = numerotation;
	numerotation++;
};

public Person(String name, String surname, String phone, String city) {
	this.id = numerotation;
	numerotation++;
	this.nom = name;
	this.prenom = surname;
	this.numtel = phone;
	this.ville = city;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return nom;
}
public void setName(String name) {
	this.nom = name;
}
public String getSurname() {
	return prenom;
}
public void setSurname(String surname) {
	this.prenom = surname;
}
public String getPhone() {
	return numtel;
}
public void setPhone(String phone) {
	this.numtel = phone;
}
public String getCity() {
	return ville;
}
public void setCity(String city) {
	this.ville = city;
}

@Override
public String toString() {
	return "Person [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", numtel=" + numtel + ", ville=" + ville + "]";
}




}
