/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import accesauxdonnees.CreationConnexion;
import accesauxdonnees.DaoUtilisateur;
import Beans.Utilisateur;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alice
 */
public class ModeleUtilisateur {

    // le conteneur de données
    private final List<Utilisateur> leConteneurUtilisateurs;
    // le titre des champs du conteneur
    //private final String[] titres;
    // l'objet DAO pour mettre à jour le conteneur
    private final DaoUtilisateur leDaoUtilisateur;

    public ModeleUtilisateur() {
        // définition du conteneur d'étudiants
        this.leConteneurUtilisateurs = new ArrayList<>();
        // définition des noms du champ
        //this.titres = new String[]{"Num", "Nom", "Prénom", "Civilité", "Date de naissance", "Lieu de naissance", "Role", "Statut", "Pays"};
        // récupération de l'objet DAO utilisé
        this.leDaoUtilisateur = CreationConnexion.getDaoUtilisateur();
    }

    public void insererUtilisateur(Utilisateur user) throws SQLException {
        // on tente d'insérer l'employé dans la base
        leConteneurUtilisateurs.clear();
        leDaoUtilisateur.ajouterUtilisateur(user);
        // si c'est OK on l'ajoute au conteneur du modèle
        chargerLesUtilisateurs();
        //leConteneurVIP.add(vip);
        // on rafraichit la vue par une notification de modification des données  
        //this.fireTableDataChanged();
    }

    public void chargerLesUtilisateurs() throws SQLException {
        // chargement de tous les employés dans la base dans le conteneur du modèle
        leDaoUtilisateur.recupererUtilisateurs(leConteneurUtilisateurs);
        // si c'est OK on rafraichit la vue par une notification  
        //this.fireTableDataChanged();
    }
}
