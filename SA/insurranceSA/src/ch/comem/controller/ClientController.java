/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.comem.controller;

import ch.comem.model.ClientModel;
import ch.comem.model.Response;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * Permet de gérer des clients qui on les paramètres suivants:
 * lastname, firstname, email, birthday, licence_type, licence_date
 * Ce controlleur permet de faire les actions suivantes:
 * - création d'un client dans la BD
 * - 
 * - brécupérer un client de la BD (à partir d'un id).
 * @author Groupe Manu et Cédric
 */
public class ClientController {
    
    // Chargement du driver odbc une fois pour toute
    static {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    // Efface le consrtucteur vide de la Javadoc
    private ClientController() {}
    
    /**
     * Permet d'insérer un client dans la table Clients de la BD.
     * Ce client est composée des paramètres suivants:
     * lastname, firstname, email, birthday, licence_type, licence_date
     * Si le client existe déjà (selon son email), l'objet n'est pas créé.
     * @param client de type ClientModel
     * @return response de type Response selon les résultats suivants:
     * response: -1, OK, Number of the genereted key => OK (l'opération s'est bien déroulée).
     * response: -2, The object doesn't exist!, 0 => L'objet correspondant à l'ID passé en paramètre n'existe pas dans la BD.
     * response: -3, The object already exist!, 0 => L'objet correspondant à l'ID passé en paramètre existe déjà.
     * response: -4, Parameter not congruent!, 0 => Paramètre non conforme.
     * response: -5, Nothing happened, 0 => Rien ne s'est passé (l'opération n'a eu aucun effet).
     */
    public static Response createClient(ClientModel client) {
        Response response = null;
        ResourceBundle R = ResourceBundle.getBundle("ch.comem.ressources.DBproperties");
        
        if (client != null) {
            Connection con = null;
            
            try {
                // Connection à la base de données
                con = DriverManager.getConnection(R.getString("BDurl"), R.getString("username"), R.getString("password"));
                Statement requete = con.createStatement();
            
                // Requète de sélection du client (Pour vérifier l'existance)
                String requestClient = " SELECT "
                            + "ID"
                            + " FROM "
                            + "Clients"
                            + " WHERE "
                            + "EMAIL = '" + client.email.replace("'", "''") + "'";
                ResultSet exist = requete.executeQuery(requestClient);
                
                // Test si le client existe déjà pour ne pas le créer à double.
                if (!exist.next()) {
                    
                    // Comme l'id est un champ auto incrémenté il n'est pas nécessaire de le définir.
                    int nbClientsAdd = requete.executeUpdate(
                            "INSERT INTO clients"
                            + "(LASTNAME, FIRSTNAME, EMAIL, BIRTHDAY, LICENCE_TYPE, LICENCE_DATE) VALUES "
                            + "('" + client.lastname.replace("'", "''") + "', "
                            + "('" + client.firstname.replace("'", "''") + "', "
                            + "('" + client.email.replace("'", "''") + "', "
                            + "('" + client.birthday + "', "
                            + "('" + client.licence_type.replace("'", "''") + "', "
                            + "('" + client.licence_date + "')", Statement.RETURN_GENERATED_KEYS);
                    System.out.println(nbClientsAdd + " client a été ajouté");
                    ResultSet ensembleTuplesAjoutes = requete.getGeneratedKeys();
                    int idTupleAjoute = 0;
                    
                    // Comme il n'y a eu qu'un seul insert, on peut faire un if au lieu d'un while
                    if (ensembleTuplesAjoutes.next()) {
                        idTupleAjoute = ensembleTuplesAjoutes.getInt(1);
                    }
                    System.out.println("L'id du nouveau tuple est : " + idTupleAjoute);
                    
                    if (idTupleAjoute < 0) {
                        response = new Response(-5, "Nothing happened", 0);
                    } 
                    else {
                        response = new Response(-1, "OK", idTupleAjoute);
                    }
                    
                }
                else {
                    response = new Response(-3, "The object already exist!", 0);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            // fermeture de la connection à la base de données ainsi que de toutes les ressources qui lui sont associées ! (ResultSet, Statement)
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } 
        }
        else {
            response = new Response(-4, "Parameter not congruent!", 0);
        }
        
        return response;
    }
    
        
}
