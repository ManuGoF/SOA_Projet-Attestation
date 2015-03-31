/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.comem.controller;

import ch.comem.model.CertificateModel;
import ch.comem.model.Response;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * Permet de gérer des exemples qui on une chaine de caractères.
 * Ce controlleur permet de faire les actions suivantes:
 * - a
 * - brécupérer une montre de la BD (à partir d'un id).
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
     * données, si les paramètres d'entrée sont valides (cf. methode validateBoat()) et si le tuple n'existe pas encore dans la
     * base de données (par rapport au numéro d'immatriculation).
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
        ResourceBundle r = ResourceBundle.getBundle("resources.variables");
        try {
            con = DriverManager.getConnection(r.getString("Url"), r.getString("Username"), r.getString("Password"));
            Statement requete = con.createStatement();
            ResultSet exist = requete.executeQuery("SELECT * FROM boats WHERE number='" + boat.number.replace("'", "''") + "'");
            if (boat.validateBoat() == null) {
                if (!exist.next()) {
                    requete.executeUpdate(
                            "INSERT INTO boats"
                            + "(name, number) VALUES "
                            + "('" + boat.name.replace("'", "''") + "','" + boat.number.replace("'", "''") + "')", Statement.RETURN_GENERATED_KEYS);
                    ResultSet generatedKey = requete.getGeneratedKeys();
                    generatedKey.next();
                    response = new Response(201, "Created boat", generatedKey.getInt(1));
                } else {
                    response = new Response(400, "Boat already exist", 0);
                }

            } else {
                response = boat.validateBoat();
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
    private CertificateController() {}
    
        
}