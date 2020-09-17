package com.my.agenda.entity;

import java.util.Date;

public class Persona {
	
	public Persona() {
	}
	
	private int id;
	private String nombres;
	private String apellidos;
	private String email;
	private String celular;
	private Date fechaCrea;
	
	
	public Persona(int id, String nombres, String apellidos, String email, String celular, Date fechaCrea) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.email = email;
		this.celular = celular;
		this.fechaCrea = fechaCrea;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCelular() {
		return celular;
	}
	
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public Date getFechaCrea() {
		return fechaCrea;
	}
	public void setFechaCrea(Date fechaCrea) {
		this.fechaCrea = fechaCrea;
	}


	@Override
	public String toString() {
		return "Persona [nombres=" + nombres + ", apellidos=" + apellidos + ", email=" + email + ", celular=" + celular + ", fechaCrea="
				+ fechaCrea + "]";
	}
	
	
}
