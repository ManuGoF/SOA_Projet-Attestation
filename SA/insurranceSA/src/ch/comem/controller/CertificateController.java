/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.comem.controller;

import ch.comem.model.CarModel;
import ch.comem.model.CertificateModel;
import ch.comem.model.ClientModel;
import ch.comem.model.Response;
import ch.comem.model.WorkerModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Permet de gérer des exemples qui on une chaine de caractères. Ce controlleur
 * permet de faire les actions suivantes: - a - brécupérer une montre de la BD
 * (à partir d'un id).
 *
 * @author Groupe Manu et Cédric
 */
public class CertificateController {

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
    public static Response createCertificate(CertificateModel certificate) {
        Response response = null;
        Connection con = null;
        ResourceBundle r = ResourceBundle.getBundle("ch.comem.ressources.insurranceDBproperties");
        try {
            con = DriverManager.getConnection(r.getString("BDurl"), r.getString("username"), r.getString("password"));
            Statement requete = con.createStatement();
            ResultSet exist = requete.executeQuery("SELECT * FROM certificates WHERE number='" + certificate.number.replace("'", "''") + "'");
            if (!exist.next()) {
                ResultSet carExist = requete.executeQuery("SELECT * FROM cars WHERE serial_number='" + certificate.car.serial_number.replace("'", "''") + "'");
                if (carExist.next()) {
                    int carId = carExist.getInt(1);
                    ResultSet workerExist = requete.executeQuery("SELECT * FROM workers WHERE email='" + certificate.worker.email.replace("'", "''") + "'");
                    if (workerExist.next()) {
                        int workerId = workerExist.getInt(1);
                        requete.executeUpdate(
                                "INSERT INTO certificates"
                                + "(NUMBER, STATE, CREATION_DATE, CAR_SERIAL_NUMBER, WORKER_ID) VALUES "
                                + "('" + certificate.number.replace("'", "''") + "','" + certificate.state.replace("'", "''") + "','" + certificate.creation_date.replace("'", "''") + "','" + carId + "'," + workerId + ")", Statement.RETURN_GENERATED_KEYS);
                        ResultSet generatedKey = requete.getGeneratedKeys();
                        generatedKey.next();
                        response = new Response(201, "Created certificate", generatedKey.getInt(1));
                    } else {
                        response = new Response(400, "Worker doesn't exist", 0);
                    }

                } else {
                    response = new Response(400, "Car doesn't exist", 0);
                }

            } else {
                response = new Response(400, "Certificate already exist", 0);
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
     * La methode readBoatsHavingKits() permet de récuper tous les bateaux ayant
     * un kit attribué
     *
     * @return boats - une hash map de bateaux disposant d'un kit
     * (Map<Integer, Boat>)
     */
    public static ArrayList<CertificateModel> readAllCertificates() {
        Connection con = null;
        ArrayList<CertificateModel> certificates = new ArrayList<>();
        ResourceBundle r = ResourceBundle.getBundle("ch.comem.ressources.insurranceDBproperties");

        try {
            con = DriverManager.getConnection(r.getString("BDurl"), r.getString("username"), r.getString("password"));
            Statement requete = con.createStatement();
            ResultSet ensembleResultats = requete.executeQuery("select * from certificates inner join cars on certificates.car_serial_number = cars.serial_number inner join workers on certificates.worker_id = workers.id inner join clients on cars.client_id = clients.id");
            while (ensembleResultats.next()) {
                ClientModel client = new ClientModel(ensembleResultats.getString(19), ensembleResultats.getString(20), ensembleResultats.getString(21), ensembleResultats.getString(22), ensembleResultats.getString(23), ensembleResultats.getString(24));
                CarModel car = new CarModel(ensembleResultats.getString(6), ensembleResultats.getString(7), ensembleResultats.getString(8), ensembleResultats.getString(9), ensembleResultats.getString(10), ensembleResultats.getDouble(11), client);
                WorkerModel worker = new WorkerModel(ensembleResultats.getString(14), ensembleResultats.getString(15), ensembleResultats.getString(16), ensembleResultats.getString(17));
                CertificateModel certificate = new CertificateModel(ensembleResultats.getString(1), ensembleResultats.getString(2), ensembleResultats.getString(3), car, worker);
                certificates.add(certificate);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return certificates;
    }

    /**
     * La methode removeKitFromBoat permet de retirer un kit a un bateau si le
     * bateau existe, le kit existe et si le kit est deja attribué.
     *
     * @param kit_id l'id du kit a reprendre (int)
     * @param boat_id l'id du bateau auquel reprendre le kit (int)
     * @param date la date de retour (String) ex. "2015-03-27 00:12:00"
     * @return <code>response</code> - la réponse générée (Response)<br><br>
     * <b>Si le kit a été retiré</b><br>
     * Code : 200, Message : Kit correctly returned, GeneratedKey : the
     * generated key <br>
     * <b>Si le kit est deja attribué</b><br>
     * Code : 400, Message : Kit is not yet attributed, GeneratedKey : 0 <br>
     * <b>Si le bateau n'existe pas</b><br>
     * Code : 400, Message : Boat doesn't exist, GeneratedKey : 0 <br>
     * <b>Si le kit n'existe pas</b><br>
     * Code : 400, Message : Kit doesn't exist, GeneratedKey : 0 <br>
     */
    public static Response updateState(String certificate_number, String state) {
        Response response = null;
        Connection con = null;
        ResourceBundle r = ResourceBundle.getBundle("ch.comem.ressources.insurranceDBproperties");
        try {
            con = DriverManager.getConnection(r.getString("BDurl"), r.getString("username"), r.getString("password"));
            Statement requete = con.createStatement();
            ResultSet certificateExist = requete.executeQuery("SELECT * FROM certificates WHERE number='" + certificate_number + "'");

            if (certificateExist.next()) {
                if (state.equalsIgnoreCase("en attente") || state.equalsIgnoreCase("refusée") || state.equalsIgnoreCase("acceptée")) {
                    if (!state.equalsIgnoreCase(certificateExist.getString(2))) {
                        String builtString;
                        builtString = "UPDATE certificates SET state = '" + state + "' WHERE number ='" + certificate_number + "'";
                        requete.executeUpdate(builtString, Statement.RETURN_GENERATED_KEYS);
                        response = new Response(200, "State correctly updated to " + state + "", 0);
                    } else {
                        response = new Response(400, "State is already "+state+"", 0);
                    }

                } else {
                    response = new Response(400, "State is not correct", 0);
                }

            } else {
                response = new Response(400, "Certificate doesn't exist", 0);
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

    // Efface le consrtucteur vide de la Javadoc
    private CertificateController() {
    }

}
