package com.my.personas.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.personas.dao.PersonaDAO;
import com.my.personas.entity.Persona;

/**
 * Servlet implementation class PersonaController
 */
@WebServlet("/personadb")
public class PersonaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PersonaController() {
        super();
    }
    	
    	
    	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		String opcion = (request.getParameter("opcion") != null) ? request.getParameter("opcion") : "";
		
		switch(opcion) {
		 case "modificar": 
			 this.editarPersona(request, response);
			 break;
		 case "eliminar": 
			 this.eliminarPersona(request, response);
			 break;
		 default: this.listarPersonas(request, response);
		 	break;
			}
		
		
	}


	
	private void eliminarPersona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PersonaDAO daoPersona = new PersonaDAO();
		Persona persona =new Persona();
		String id = request.getParameter("id");
		persona.setId(Integer.parseInt(id));
		daoPersona.deletePersona(persona);
		response.sendRedirect("personadb");
	}
	
	private void editarPersona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PersonaDAO daoPersona = new PersonaDAO();
		Persona persona =new Persona();
		String id = request.getParameter("id");
		persona.setId(Integer.parseInt(id));
		Persona datospersona=daoPersona.getPersona(persona);
			
		request.setAttribute("Persona", datospersona);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/modificar_persona.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void listarPersonas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PersonaDAO daoPersona = new PersonaDAO();
		List<Persona> personas = daoPersona.getPersonas();
		
		request.setAttribute("listaPersonas", personas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/lista_personas.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
				PersonaDAO daoPersona = new PersonaDAO();
				Persona persona=new Persona();
				String opcion = request.getParameter("opcion");
				String nombre = request.getParameter("nombres");
				String apellido = request.getParameter("apellidos");
				String correo = request.getParameter("email");
				String celular = request.getParameter("celular");
				
				persona.setNombres(nombre);
				persona.setApellidos(apellido);
				persona.setEmail(correo);
				persona.setCelular(celular);
				
				if(opcion.equals("insertar")) {
					daoPersona.savePersona(persona);
					response.sendRedirect("personadb");
					
				} else if(opcion.equals("actualizar")) {
					String id = request.getParameter("id");
					persona.setId(Integer.parseInt(id));
					daoPersona.updatePersona(persona);
					response.sendRedirect("personadb");
					
				} else {
					response.sendRedirect("index.jsp");
				}
				
				
				
		
	}
	
	

}
