/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.comem.transport;

import ch.comem.model.ClientModel;

/**
 * Permet de définir un objet Client "transportable su le web" (sans logique).
 * @author Manu
 */
public class ClientTransport {
    private int id;
    private String lastname;
    private String firstname;
    private String email;
    private String birthday;
    private String licence_date;
    private String licence_type;

    /**
     * Permet de récupérer l'id du client.
     * @return the id de type Integer
     */
    public int getId() {
        return id;
    }

    /**
     * Permet de définir l'id du client
     * @param id the id to set de type Integer
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Permet de récupérer le nom du client.
     * @return the lastname de type String
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Permet de définir le nom du client
     * @param lastname the lastname to set de type String
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Permet de récupérer le prénom du client.
     * @return the firstname de type String
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Permet de définir le prénom du client
     * @param firstname the firstname to set de type String
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Permet de récupérer l'email du client.
     * @return the email de type String
     */
    public String getEmail() {
        return email;
    }

    /**
     * Permet de définir l'email du client
     * @param email the email to set de type String
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Permet de récupérer la date de naissance du client.
     * @return the birthday de type String
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * Permet de définir la date de naissance du client
     * @param birthday the birthday to set de type String
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * Permet de récupérer la date d'émission du permis du client.
     * @return the licence_date de type String
     */
    public String getLicence_date() {
        return licence_date;
    }

    /**
     * Permet de définir l'émission du permis du client
     * @param licence_date the licence_date to set de type String
     */
    public void setLicence_date(String licence_date) {
        this.licence_date = licence_date;
    }

    /**
     * Permet de récupérer les type de permis que possède le client.
     * @return the licence_type de type String
     */
    public String getLicence_type() {
        return licence_type;
    }

    /**
     * Permet de définir le type de permis que possède le client
     * @param licence_type the licence_type to set de type String
     */
    public void setLicence_type(String licence_type) {
        this.licence_type = licence_type;
    }
}
