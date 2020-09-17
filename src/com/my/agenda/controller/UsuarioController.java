package com.my.agenda.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.agenda.dao.UsuarioDAO;
import com.my.agenda.entity.Usuario;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/login")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UsuarioController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = (request.getParameter("opcion") != null) ? request.getParameter("opcion") : "";
		HttpSession sesion = request.getSession();
		
		switch(opcion) {
		 case "salir": 
			 sesion.invalidate();
			 response.sendRedirect("login");
			 break;
		 default: 
		 	RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		 	break;
			}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		UsuarioDAO daoUsuario = new UsuarioDAO();
		String email = request.getParameter("email");
		String clave = request.getParameter("clave");
		Usuario usuarioLogin = daoUsuario.verificarLogin(new Usuario(email, clave));
		HttpSession sesion = request.getSession();
		
		if(usuarioLogin != null) {
			sesion.setAttribute("usuario", usuarioLogin);
			response.sendRedirect("personadb");
		}
		else {
			//enviar mensaje de error
			request.setAttribute("mensaje", "Email y/o clave incorrecto");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
			//response.sendRedirect("usuariodb");
		}
				
		
		
		
	}

}
