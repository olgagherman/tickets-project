package md.utm.fi.model.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person {
	private String name;
	private String surname;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

}
