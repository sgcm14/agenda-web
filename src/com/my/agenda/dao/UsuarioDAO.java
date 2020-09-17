package com.my.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.my.agenda.entity.Usuario;

public class UsuarioDAO {
	public Usuario verificarLogin(Usuario usuario){
		Connection conn = Conexion.getInstancia().getConexion();
		String query = "SELECT * FROM usuario WHERE email=? and clave=?";
		Usuario usuarioEncontrado = null;
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,usuario.getEmail());
			ps.setString(2,usuario.getClave());
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				usuarioEncontrado = new Usuario();
				usuarioEncontrado.setId(rs.getInt("id"));
				usuarioEncontrado.setNombres(rs.getString("nombres"));
				usuarioEncontrado.setApellidos(rs.getString("apellidos"));
				//usuarioEncontrado.setEmail(rs.getString("email"));
				//usuarioEncontrado.setClave(rs.getString("clave"));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return usuarioEncontrado;
	}

}
