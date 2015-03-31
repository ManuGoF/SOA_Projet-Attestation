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
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Permet de gérer des clients qui on les paramètres suivants:
 * lastname, firstname, email, birthday, licence_type, licence_date
 * Ce controlleur permet de faire les actions suivantes:
 * - création d'un client dans la BD.
 * - récupération d'un client de la BD à l'aide de son ID.
 * - suppression d'un client dans la BD et les objets liés en cascade à l'aide de son ID.
 * - récupération d'une liste de clé->valeur de tous les clients (ID->Client).
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
     * response: -4, Parameter isn't congruent!, 0 => Paramètre idn conforme.
     * response: -5, Nothing happened, 0 => Rien ne s'est passé (l'opération n'a eu aucun effet).
     */
    public static Response createClient(ClientModel client) {
        Response response = null;
        ResourceBundle R = ResourceBundle.getBundle("ch.comem.ressources.insurranceDBproperties");
        
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
                    String requestInsertClient = "INSERT INTO clients "
                            + "(LASTNAME, FIRSTNAME, EMAIL, BIRTHDAY, LICENCE_TYPE, LICENCE_DATE) VALUES "
                            + "('" + client.lastname.replace("'", "''") + "', "
                            + "'" + client.firstname.replace("'", "''") + "', "
                            + "'" + client.email.replace("'", "''") + "', "
                            + "'" + client.birthday + "', "
                            + "'" + client.licence_type.replace("'", "''") + "', "
                            + "'" + client.licence_date + "')";
                    int nbClientsAdd = requete.executeUpdate(requestInsertClient, Statement.RETURN_GENERATED_KEYS);
                    System.out.println(nbClientsAdd + " client a été ajouté");
                    ResultSet ensembleTuplesAjoutes = requete.getGeneratedKeys();
                    int idTupleAjoute = 0;
                    // Comme il n'y a eu qu'un seul insert, on peut faire un if au lieu d'un while
                    if (ensembleTuplesAjoutes.next()) {
                        idTupleAjoute = ensembleTuplesAjoutes.getInt(1);
                    }
                    System.out.println("L'id du iduveau tuple est : " + idTupleAjoute);
                    
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
            response = new Response(-4, "Parameter isn't congruent!", 0);
        }
        
        return response;
    }
    
    
    /**
     * Permet de récupérer un client de la table Clients de la BD.
     * Ce client est composée des paramètres suivants:
     * lastname, firstname, email, birthday, licence_type, licence_date
     * Si le client n'existe pas (selon son ID), l'objet n'est pas retourné.
     * Si le client ID n'est pas conforme (=< 0), l'objet n'est pas retourné.
     * @param id_client de type Integer correspondant à l'id du client souhaité.
     * @return client de type ClientModel correspondant au client souhaité si il existe.
     */
    public static ClientModel readClient(int id_client) {
        
        ResourceBundle R = ResourceBundle.getBundle("ch.comem.ressources.insurranceDBproperties");
        
        int idGet = 0;
        String lastnameGet = "";
        String firstnameGet = "";
        String emailGet = "";
        String birthdayGet = "";
        String licenceTypeGet = "";
        String licenceDateGet = "";
        
        if (id_client > 0) {
            
            Connection con = null;

            try {
                
                // Connection à la base de données
                con = DriverManager.getConnection(R.getString("BDurl"), R.getString("username"), R.getString("password"));
                Statement requete = con.createStatement();
                
                // Requète de selection du client (Pour vérifier l'existance)
                String requestClientExist = " SELECT "
                            + "*"
                            + " FROM "
                            + "Clients"
                            + " WHERE "
                            + "ID = " + id_client;
                ResultSet existClient = requete.executeQuery(requestClientExist);
                
                // Test si le client existe dans la BD.
                if (existClient.next()) {
                    ResultSet clientGet = requete.executeQuery(
                            "SELECT "
                            + "*"
                            + " FROM "
                            + "Clients"
                            + " WHERE "
                            + "ID = " + id_client);

                    while (clientGet.next()) {
                        idGet = clientGet.getInt("ID");
                        lastnameGet = clientGet.getString("LASTNAME");
                        firstnameGet = clientGet.getString("FIRSTNAME");
                        emailGet = clientGet.getString("EMAIL");
                        birthdayGet = clientGet.getString("BIRTHDAY");
                        licenceTypeGet = clientGet.getString("LICENCE_TYPE");
                        licenceDateGet = clientGet.getString("LICENCE_DATE");
                    }
                }
                else {
                    System.out.println("Le CLIENT ID fourni n'existe pas!");
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
            
        } else {
            System.out.println("Le Client ID n'est pas conforme");
        }
        
        ClientModel client = new ClientModel(
            lastnameGet, 
            firstnameGet,
            emailGet,
            birthdayGet,
            licenceTypeGet,
            licenceDateGet
        );

        return client;
    }
    
    
    /**
     * Permet de supprimer un client à l'aide de son ID.
     * Cette méthode supprime le client dans la table Clients de la BD.
     * Cette méthode supprime en cascade dans la BD les objets qui sont liés au client supprimé.
     * -> Client -> Cars -> Certifications -> Comments
     * @param id_client de type Integer correspondant à l'id à supprimer.
     * @return response de type Response selon les résultats suivants:
     * response: -1, OK, Number of the deleted client => OK (l'opération s'est bien déroulée).
     * response: -2, The object doesn't exist!, 0 => L'objet correspondant à l'ID passé en paramètre n'existe pas dans la BD.
     * response: -3, The object already exist!, 0 => L'objet correspondant à l'ID passé en paramètre existe déjà.
     * response: -4, Parameter isn't congruent!, 0 => Paramètre idn conforme.
     * response: -5, Nothing happened, 0 => Rien ne s'est passé (l'opération n'a eu aucun effet).
     */
    public static Response deleteClient(int id_client) {
        Response response = null;
        ResourceBundle R = ResourceBundle.getBundle("ch.comem.ressources.insurranceDBproperties");
        
        if (id_client > 0) {
            Connection con = null;
            try {
                // Connection à la base de données
                con = DriverManager.getConnection(R.getString("BDurl"), R.getString("username"), R.getString("password"));
                Statement requete = con.createStatement();
                
                String requestClientExist = " SELECT "
                            + "*"
                            + " FROM "
                            + "Clients"
                            + " WHERE "
                            + "ID = " + id_client;
                
                ResultSet existClient = requete.executeQuery(requestClientExist);
                if (existClient.next()) {
                
                    String requestDeleteClient = "DELETE FROM Clients"
                            + " WHERE "
                            + "ID = " + id_client;
                    int clientDelet = requete.executeUpdate(requestDeleteClient);
                    System.out.println(clientDelet + " client supprimé");
                    response = new Response(-1, "OK", id_client);
                }
                else {
                    response = new Response(-2, "The object doesn't exist!", 0);
                    System.out.println("Le client ID n'existe pas. Rien n'a été supprimé.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            // fermeture de la connection à la base de données ainsi que de toutes les ressources qui lui sont associées ! (ResultSet, Statement)
            try {
                con.close();
            } catch (SQLException e) {
                e.getMessage();
            }
        }
        else {
            response = new Response(-4, "Parameter isn't congruent!", 0);
        }
        
        return response;
    }
    
    
    /**
     * Permet de récupérer tous les clients existants (dans la table Clients de la BD).
     * @return une liste Map<Integer, ClientModel> correspondant à une liste de clé->valeurs (Id->Client).
     * La liste retournée comprends les clients dans la BD de donnée. Si la BD est vide, une liste vide est retournée.
     */
    public static Map<Integer, ClientModel> readAllClients() {
        Map<Integer, ClientModel> clients = new HashMap();
        
        ResourceBundle R = ResourceBundle.getBundle("ch.comem.ressources.insurranceDBproperties");
        
        Connection con = null;

        try {
            // Connection à la base de données
            con = DriverManager.getConnection(R.getString("BDurl"), R.getString("username"), R.getString("password"));
            Statement requete = con.createStatement();
                
            ResultSet allClients = requete.executeQuery("SELECT * FROM Clients");
            // Parcours de l'ensemble de clients et ajoute à la liste avec l'id.
            while (allClients.next()) {
                ClientModel client = new ClientModel(
                    allClients.getString("LASTNAME"), 
                    allClients.getString("FIRSTNAME"),
                    allClients.getString("EMAIL"),
                    allClients.getString("BIRTHDAY"),
                    allClients.getString("LICENCE_TYPE"),
                    allClients.getString("LICENCE_DATE")
                );
                clients.put(allClients.getInt(1), client);
            }
            //System.out.println("Clé->Valeur des clients: " + clients);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // fermeture de la connection à la base de données ainsi que de toutes les ressources qui lui sont associées ! (ResultSet, Statement)
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }     
        return clients;
    }
    
        
}
