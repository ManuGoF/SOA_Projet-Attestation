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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Permet de gérer les attestations qui on les paramètres suivants: 
 * number,state, creation_date, car, worker 
 * Ce controlleur permet de faire les actions suivantes: 
 * - création d'une attestation dans la BD. 
 * - récupération d'une attestation de la BD à l'aide de son ID. 
 * - récupération d'une liste de toutes les attestations.
 * - modification de l'état d'une attestation déjà existante.
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
     * Permet d'insérer une attestation dans la table Certificates de la BD. 
     * Cette attestation est composée des paramètres suivants: 
     * number, state, creation_date, car, worker 
     * Si le certificat existe déjà (selon son numero), l'objet n'est pas créé.
     * @param certificate de type CertificatModel
     * @return response de type Response selon les résultats suivants: 
     * response: -1, OK, 0 => OK (l'opération s'est bien déroulée).
     * response: -2, The object doesn't exist!, 0 => L'objet correspondant à l'objet fourni n'existe pas dans la BD.
     * response: -3, The object already exist!, 0 => L'objet correspondant à l'ID passé en paramètre existe déjà.
     * response: -4, Parameter isn't congruent!, 0 => Paramètre id non conforme.
     * response: -5, Nothing happened, 0 => Rien ne s'est passé (l'opération n'a eu aucun effet).
     */
    public static Response createCertificate(CertificateModel certificate) {
        Response response = null;
        Connection con = null;
        ResourceBundle r = ResourceBundle.getBundle("ch.comem.ressources.scaDBproperties");
        try {
            con = DriverManager.getConnection(r.getString("BDurl"), r.getString("username"), r.getString("password"));
            Statement requete = con.createStatement();
            ResultSet exist = requete.executeQuery("SELECT * FROM certificates WHERE number='" + certificate.number.replace("'", "''") + "'");
            if (!exist.next()) {
                ResultSet carExist = requete.executeQuery("SELECT * FROM cars WHERE serial_number='" + certificate.car.serial_number.replace("'", "''") + "'");
                if (carExist.next()) {
                    int carId = carExist.getInt(1);

                    requete.executeUpdate(
                            "INSERT INTO certificates"
                            + "(NUMBER, STATE, CREATION_DATE, CAR_SERIAL_NUMBER) VALUES "
                            + "('" + certificate.number.replace("'", "''") + "','" + certificate.state.replace("'", "''") + "','" + certificate.creation_date.replace("'", "''") + "','" + carId + "')", Statement.RETURN_GENERATED_KEYS);
                    ResultSet generatedKey = requete.getGeneratedKeys();
                    generatedKey.next();
                    response = new Response(-1, "OK", generatedKey.getInt(1));

                } else {
                    response = new Response(-2, "Car doesn't exist", 0);
                }

            } else {
                response = new Response(-3, "The object already exist!", 0);
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
     * Permet de récupérer toutes les attestations existantes (dans la table Certificates de la BD).
     * @return une liste ArrayList<CertificateModel> correspondant à une liste d'attestations avec le véhicule correspondant.
     * La liste retournée comprends les attestation dans la base de donnée. Si la BD est vide, une liste vide est retournée.
     */
    public static ArrayList<CertificateModel> readAllCertificates() {
        Connection con = null;
        ArrayList<CertificateModel> certificates = new ArrayList<>();
        ResourceBundle r = ResourceBundle.getBundle("ch.comem.ressources.scaDBproperties");

        try {
            con = DriverManager.getConnection(r.getString("BDurl"), r.getString("username"), r.getString("password"));
            Statement requete = con.createStatement();
            ResultSet ensembleResultats = requete.executeQuery("select * from certificates inner join cars on certificates.car_serial_number = cars.serial_number inner join clients on cars.client_id = clients.id");
            while (ensembleResultats.next()) {
                ClientModel client = new ClientModel(ensembleResultats.getString(14), ensembleResultats.getString(15), ensembleResultats.getString(16), ensembleResultats.getString(17), ensembleResultats.getString(18), ensembleResultats.getString(19));
                CarModel car = new CarModel(ensembleResultats.getString(5), ensembleResultats.getString(7), ensembleResultats.getString(8), ensembleResultats.getString(9), ensembleResultats.getString(10), ensembleResultats.getDouble(11), client);
                car.setRegistration(ensembleResultats.getString(6));
                CertificateModel certificate = new CertificateModel(ensembleResultats.getString(1), ensembleResultats.getString(2), ensembleResultats.getString(3), car);
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
     * Permet de récupérer un certificat de la table Certificates de la BD. 
     * Cette attesttaion est composée des paramètres suivants: 
     * number, state, creation_date, car, worker 
     * Si le certificat n'existe pas (selon son numéro) l'objet n'est pas retourné. 
     * Si le certificate number n'est pas conforme (=< 0), l'objet n'est pas retourné. 
     * @param number @return certificaate de type CertificateModel correspondant au certificat souhaité si il existe.
     */
    public static CertificateModel readCertificate(String number) {
        Connection con = null;
        CertificateModel certificate = null;
        ResourceBundle r = ResourceBundle.getBundle("ch.comem.ressources.scaDBproperties");

        try {
            con = DriverManager.getConnection(r.getString("BDurl"), r.getString("username"), r.getString("password"));
            Statement requete = con.createStatement();
            ResultSet ensembleResultats = requete.executeQuery("select * from certificates inner join cars on certificates.car_serial_number = cars.serial_number inner join workers on certificates.worker_id = workers.id inner join clients on cars.client_id = clients.id where certificates.number='" + number + "'");
            ensembleResultats.next();
            ClientModel client = new ClientModel(ensembleResultats.getString(14), ensembleResultats.getString(15), ensembleResultats.getString(16), ensembleResultats.getString(17), ensembleResultats.getString(18), ensembleResultats.getString(19));
            CarModel car = new CarModel(ensembleResultats.getString(5), ensembleResultats.getString(7), ensembleResultats.getString(8), ensembleResultats.getString(9), ensembleResultats.getString(10), ensembleResultats.getDouble(11), client);
            car.setRegistration(ensembleResultats.getString(6));
            certificate = new CertificateModel(ensembleResultats.getString(1), ensembleResultats.getString(2), ensembleResultats.getString(3), car);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return certificate;
    }

    /**
     * La methode updateState permet de modifier l'état d'un certificat s'il existe et si l'état entré est conforme.
     * @param certificate_number de type Certificat correspondant au certificat à modifier.
     * @param state de type String correspondant au nouvel état.
     * @return response de Type Response correspondant à la réponse du service.
     * response: -1, OK new state : state, 0 => OK (l'opération s'est bien déroulée). 
     * response: -2, State is already : state, 0 => L'état est deja celui defini. 
     * response: -3, State is not correct, 0 => L'état n'est pas correct. 
     * response: -4, Certificate doesn't exist, 0 =>Le certificat n'existe pas.
     */
    public static Response updateState(String certificate_number, String state) {
        Response response = null;
        Connection con = null;
        ResourceBundle r = ResourceBundle.getBundle("ch.comem.ressources.scaDBproperties");
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
                        response = new Response(-1, "OK new state : " + state + "", 0);
                    } else {
                        response = new Response(-2, "State is already : " + state + "", 0);
                    }

                } else {
                    response = new Response(-3, "State is not correct", 0);
                }

            } else {
                response = new Response(-4, "Certificate doesn't exist", 0);
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
