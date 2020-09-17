package com.my.agenda.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private static final String MYSQL_URL = "jdbc:mysql://localhost/agenda";
	private static final String MYSQL_USER = "root";
	private static final String MYSQL_PASSWORD = "root";
	

	public Conexion() {
		// TODO Auto-generated constructor stub
	}
	
	private static Conexion instanciaUnica;

    public static Conexion getInstancia(){
        if(instanciaUnica == null){
            instanciaUnica = new Conexion();
        }
        
        return instanciaUnica;
                    
    }
    
    public Connection  getConexion(){
        Connection cnx = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();            
            cnx = DriverManager.getConnection(MYSQL_URL, MYSQL_USER, MYSQL_PASSWORD);
            
            if(cnx != null) System.out.println("Conectado!");
            
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
        } catch (InstantiationException | IllegalAccessException ex) {
            System.err.println(ex.getMessage());
        }
        
        return cnx;

    }

}
