
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
     * La methode createBoat permet d'insérer un nouveau bateau dans la base de
     * données, si les paramètres d'entrée sont valides (cf. methode
     * validateBoat()) et si le tuple n'existe pas encore dans la base de
     * données (par rapport au numéro d'immatriculation).
     *
     * @param boat le bateau a ajouter (Boat)
     * @return <code>response</code> - la réponse générée (Response)<br><br>
     * <b>Si le tuple a été ajouté</b><br>
     * Code : 201, Message : Created boat, GeneratedKey : the generated key <br>
     * <b>Si le nom saisi est trop long</b><br>
     * Code : 400, Message : Name is too long, GeneratedKey : 0 <br>
     * <b>Si le numero saisi est trop long</b><br>
     * Code : 400, Message : Number is too long, GeneratedKey : 0 <br>
     * <b>Si le tuple existe déjà</b><br>
     * Code : 400, Message : Boat already exist, GeneratedKey : 0 <br>
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
                response = new Response(201, "Created worker", generatedKey.getInt(1));

            } else {
                response = new Response(400, "Worker already exist", 0);
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
     * La methode readBoatsHavingKits() permet de récuper tous les bateaux ayant un kit attribué
     *
     * @return boats - une hash map de bateaux disposant d'un kit (Map<Integer, Boat>) 
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
                WorkerModel worker = new WorkerModel(ensembleResultats.getString(2), ensembleResultats.getString(3), ensembleResultats.getString(4),ensembleResultats.getString(5));
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
    



}
