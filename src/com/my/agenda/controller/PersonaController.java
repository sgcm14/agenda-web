package com.my.agenda.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.agenda.dao.PersonaDAO;
import com.my.agenda.entity.Persona;

/**
 * Servlet implementation class PersonaController
 */
@WebServlet("/personadb")
public class PersonaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PersonaController() {
    	
    }
    	
    private boolean checkLogeado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	HttpSession sesion = request.getSession();
    	return sesion.getAttribute("usuario") != null; 
    }
    	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		if(this.checkLogeado(request, response)) { 
		
		String opcion = (request.getParameter("opcion") != null) ? request.getParameter("opcion") : "";
		
		switch(opcion) {
		case "registrar": 
			RequestDispatcher dispatcher = request.getRequestDispatcher("/registrar_persona.jsp");
			dispatcher.forward(request, response);
			 break;		
		case "modificar": 
			 this.editarPersona(request, response);
			 break;
		 case "eliminar": 
			 this.eliminarPersona(request, response);
			 break;
		 default: this.listarPersonas(request, response);
		 	break;
			}
		
		} else {
			response.sendRedirect("login");
		}
		
	}


	
	private void eliminarPersona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PersonaDAO daoPersona = new PersonaDAO();
		Persona persona =new Persona();
		String id = request.getParameter("id");
		persona.setId(Integer.parseInt(id));
		daoPersona.deletePersona(persona);
		HttpSession sesion = request.getSession();
		sesion.setAttribute("mensaje", "Contacto eliminado correctamente");
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
		if(this.checkLogeado(request, response)) { 
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
					HttpSession sesion = request.getSession();
					sesion.setAttribute("mensaje", "Contacto añadido correctamente");
					response.sendRedirect("personadb");
					
				} else if(opcion.equals("actualizar")) {
					String id = request.getParameter("id");
					persona.setId(Integer.parseInt(id));
					daoPersona.updatePersona(persona);
					HttpSession sesion = request.getSession();
					sesion.setAttribute("mensaje", "Contacto actualizado correctamente");
					response.sendRedirect("personadb");
					
				} else {
					response.sendRedirect("index.jsp");
				}
				
		} else {
			response.sendRedirect("login");
		}	
				
		
	}
	
	

}
