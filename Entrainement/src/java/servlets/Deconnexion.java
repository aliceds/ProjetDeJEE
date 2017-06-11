/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alice
 */
public class Deconnexion extends HttpServlet {
    public static final String URL_REDIRECTION = "http://www.facebook.com";
    public static final String VUE = "/connexion";
    
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Récupération et destruction de la session en cours */
        HttpSession session = request.getSession();
        session.invalidate();
        
        // affichage de la page de connexion --> forwarding
        // this.getServletContext().getRequestDispatcher(VUE).forward(request, response);

        /* Redirection vers le Site du Zéro ! */
        response.sendRedirect(URL_REDIRECTION);
    }

}
