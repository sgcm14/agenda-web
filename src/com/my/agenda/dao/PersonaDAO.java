package com.my.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.my.agenda.entity.Persona;

public class PersonaDAO {

	public List<Persona> getPersonas() {
		
		List<Persona> personas = Collections.emptyList();
		
		Connection conn = Conexion.getInstancia().getConexion();
		
		String query = "SELECT * FROM persona";
		
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			personas = new ArrayList<>();
			
			while(rs.next()) {
				Persona persona = new Persona();
				persona.setId(rs.getInt("id"));
				persona.setNombres(rs.getString("nombres"));
				persona.setApellidos(rs.getString("apellidos"));
				persona.setEmail(rs.getString("email"));
				persona.setCelular(rs.getString("celular"));
				personas.add(persona);
			}
			
			rs.close();
			ps.close();
			
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		
		return personas;
		
	}
	
	
	public void savePersona (Persona persona){
		Connection conn = Conexion.getInstancia().getConexion();
		
		String query = "INSERT into persona(nombres,apellidos,email,celular) VALUES(?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, persona.getNombres());
			ps.setString(2, persona.getApellidos());
			ps.setString(3, persona.getEmail());
			ps.setString(4, persona.getCelular());
			ps.executeUpdate();
			
			ps.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
	
	public void updatePersona (Persona persona){
		Connection conn = Conexion.getInstancia().getConexion();
		
		String query = "UPDATE persona SET nombres=?,apellidos=?,email=?,celular=? WHERE id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, persona.getNombres());
			ps.setString(2, persona.getApellidos());
			ps.setString(3, persona.getEmail());
			ps.setString(4, persona.getCelular());
			ps.setInt(5, persona.getId());
			ps.executeUpdate();
			
			ps.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
	
	public void deletePersona (Persona persona){
		Connection conn = Conexion.getInstancia().getConexion();
		
		String query = "DELETE FROM persona WHERE id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, persona.getId());
			ps.executeUpdate();
			
			ps.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
	
	
public Persona getPersona(Persona persona) {
		
	
		Connection conn = Conexion.getInstancia().getConexion();
		
		String query = "SELECT * FROM persona WHERE id=?";
		Persona personaEncontrado = null;
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, persona.getId());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				personaEncontrado = new Persona();
				personaEncontrado.setId(rs.getInt("id"));
				personaEncontrado.setNombres(rs.getString("nombres"));
				personaEncontrado.setApellidos(rs.getString("apellidos"));
				personaEncontrado.setEmail(rs.getString("email"));
				personaEncontrado.setCelular(rs.getString("celular"));
			}
			
			rs.close();
			ps.close();
			
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		
		return personaEncontrado;
		
	}
}

