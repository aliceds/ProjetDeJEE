/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import accesauxdonnees.CreationConnexion;
import static accesauxdonnees.CreationConnexion.creerConnexion;
import accesauxdonnees.DaoUtilisateur;
import beans.Utilisateur;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.ModeleUtilisateur;

/**
 *
 * @author Alice
 */
public class Accueil extends HttpServlet {

    public static final String VUE = "/WEB-INF/index.jsp";
    private ModeleUtilisateur leModeleUtilisateur;
    private Utilisateur utilisateur;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int erreur = creerConnexion();
//        out.println("<!DOCTYPE html>");
//        out.println("<html>");
//        out.println("<head>");
//        out.println("<title>Servlet NewServlet</title>");            
//        out.println("</head>");
//        out.println("<body>");
//        out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
//        out.println("</body>");
//        out.println("</html>");
        
        request.setAttribute("erreur", erreur);
        
        leModeleUtilisateur = new ModeleUtilisateur();
        try {
            leModeleUtilisateur.chargerLesUtilisateurs();
        } catch (SQLException ex) {
            System.out.println("Erreur au chargement : " + ex.getMessage());
        }
        
        utilisateur = new Utilisateur("email@email.com","mdp","Madame","Monsieur","060102030",LocalDate.now());
        
        try {
            leModeleUtilisateur.insererUtilisateur(utilisateur);
        } catch (SQLException ex) {
            Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("user",utilisateur);

        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
