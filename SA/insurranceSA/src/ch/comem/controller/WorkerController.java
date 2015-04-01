package ch.comem.controller;

import ch.comem.model.Response;
import ch.comem.model.WorkerModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Permet de gérer des employés qui on les paramètres suivants:
 * lastname, firstname, email, birthday, position
 * Ce controlleur permet de faire les actions suivantes:
 * - création d'un employé dans la BD.
 * - récupération d'un employé de la BD à l'aide de son ID.
 * - récupération d'une liste de clé->valeur de tous les employés (ID->Worker).
 * - Récupération de l'ID d'un worker à l'aide de son email.
 * @author Groupe Manu et Cédric
 */
public class WorkerController {

    // Chargement du driver odbc une fois pour toute
    static {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * La methode createWorker permet d'insérer un nouveau worker dans la base de données, 
     * si les paramètres d'entrée sont valides et si le tuple n'existe pas encore dans la base de données 
     * (par rapport a l'adresse email du travailleur).
     * @param worker de type WorkerModel
     * @return response de type Response selon les résultats suivants: 
     * response: -1, OK, Number of the genereted key => OK (l'opération s'est bien déroulée). 
     * response: -2, Worker already exist!, 0 => Le worker existe deja dans la BD.
     */
    public static Response createWorker(WorkerModel worker) {
        Response response = null;
        Connection con = null;
        ResourceBundle r = ResourceBundle.getBundle("ch.comem.ressources.insurranceDBproperties");
        try {
            con = DriverManager.getConnection(r.getString("BDurl"), r.getString("username"), r.getString("password"));
            Statement requete = con.createStatement();
            ResultSet exist = requete.executeQuery("SELECT * FROM workers WHERE email='" + worker.email.replace("'", "''") + "'");
            if (!exist.next()) {

                requete.executeUpdate(
                        "INSERT INTO workers"
                        + "(LASTNAME, FIRSTNAME, EMAIL, POSITION) VALUES "
                        + "('" + worker.lastname.replace("'", "''") + "','" + worker.firstname.replace("'", "''") + "','" + worker.email.replace("'", "''") + "','" + worker.position.replace("'", "''") + "')", Statement.RETURN_GENERATED_KEYS);
                ResultSet generatedKey = requete.getGeneratedKeys();
                generatedKey.next();
                response = new Response(-1, "OK", generatedKey.getInt(1));

            } else {
                response = new Response(-2, "Worker already exist", 0);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return response;
    }

    /**
     * La methode readAllWorkers() permet de récuper tous les employés.
     * @return Map<Integer,WorkerModel> - une liste clé->valeur de workers (ID->WorkerModel).
     * La liste retournée comprends les clients dans la BD de donnée. Si la BD est vide, une liste vide est retournée.
     */
    public static Map<Integer, WorkerModel> readAllWorkers() {
        Connection con = null;
        Map<Integer, WorkerModel> workers = new HashMap();
        ResourceBundle r = ResourceBundle.getBundle("ch.comem.ressources.insurranceDBproperties");

        try {
            con = DriverManager.getConnection(r.getString("BDurl"), r.getString("username"), r.getString("password"));
            Statement requete = con.createStatement();
            ResultSet ensembleResultats = requete.executeQuery("select * from workers");
            while (ensembleResultats.next()) {
                WorkerModel worker = new WorkerModel(ensembleResultats.getString(2), ensembleResultats.getString(3), ensembleResultats.getString(4), ensembleResultats.getString(5));
                workers.put(ensembleResultats.getInt(1), worker);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return workers;
    }

     /**
     * Permet de récupérer un employé de la table Workers de la BD.
     * L'employé est composé des paramètres suivants:
     * lastname, firstname, email, birthday, position
     * Si l'employé n'existe pas (selon son ID), l'objet n'est pas retourné.
     * Si l'employé  ID n'est pas conforme (=< 0), l'objet n'est pas retourné.
     * @param id de type Integer correspondant à l'id de l'employé souhaité.
     * @return Map<Integer,WorkerModel> - une liste clé->valeur de worker (ID->WorkerModel).
     */
    public static Map<Integer, WorkerModel> readWorker(int id) {
        Connection con = null;
        Map<Integer, WorkerModel> workers = new HashMap();
        ResourceBundle r = ResourceBundle.getBundle("ch.comem.ressources.insurranceDBproperties");

        try {
            con = DriverManager.getConnection(r.getString("BDurl"), r.getString("username"), r.getString("password"));
            Statement requete = con.createStatement();
            ResultSet ensembleResultats = requete.executeQuery("select * from workers where id=" + id + "");
            if (ensembleResultats.next()) {
                WorkerModel worker = new WorkerModel(ensembleResultats.getString(2), ensembleResultats.getString(3), ensembleResultats.getString(4), ensembleResultats.getString(5));
                workers.put(ensembleResultats.getInt(1), worker);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return workers;
    }
    
     /**
     * Permet de récupérer un ID d'un employé de la table Workers de la BD.
     * Si l'employé n'existe pas (selon son EMAIL), l'id retourné = 0.
     * Si l'email n'est pas définit, l'id retourné = 0.
     * @param email de type String correspondant à l'email de l'employé souhaité.
     * @return idGet de type Integer correspondant à l'ID de l'emloyé souhaité s'il existe.
     */
    public static int getWorkerId(String email) {
        
        ResourceBundle R = ResourceBundle.getBundle("ch.comem.ressources.insurranceDBproperties");
        
        int idGet = 0;
        
        if (email != null) {
            
            Connection con = null;

            try {
                
                // Connection à la base de données
                con = DriverManager.getConnection(R.getString("BDurl"), R.getString("username"), R.getString("password"));
                Statement requete = con.createStatement();
                
                // Requète de selection du client (Pour vérifier l'existance)
                String requestClientExist = " SELECT "
                            + "*"
                            + " FROM "
                            + "Workers"
                            + " WHERE "
                            + "EMAIL = " + "'" + email + "'";
                ResultSet existClient = requete.executeQuery(requestClientExist);
                
                // Test si le client existe dans la BD.
                if (existClient.next()) {
                    ResultSet clientGet = requete.executeQuery(
                            "SELECT "
                            + "ID"
                            + " FROM "
                            + "Workers"
                            + " WHERE "
                            + "EMAIL = " + "'" + email + "'");

                    while (clientGet.next()) {
                        idGet = clientGet.getInt("ID");
                    }
                }
                else {
                    System.out.println("Le CLIENT EMAIL fourni n'existe pas!");
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
            System.out.println("Le Client EMAIL n'est pas conforme");
        }

        return idGet;
    }

}
