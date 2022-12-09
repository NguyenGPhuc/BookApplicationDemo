package com.cst438;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="patrons")
public class Patron {
	@Id
	private int patron_id;
	private String name;
	private int fines;
	
	public int getPatron_id() {
		return patron_id;
	}
	public void setPatron_id(Integer patron_id) {
		this.patron_id = patron_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getFines() {
		return fines;
	}
	public void setFines(int fines) {
		this.fines = fines;
	}
	
	@Override
	public String toString() {
		return "Patron [patron_id=" + patron_id + ", name=" + name + ", fines=" + fines + "]";
	}
	
}
