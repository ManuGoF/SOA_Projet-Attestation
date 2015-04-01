/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.comem.transport;

/**
 * Permet de définir un objet Worker "transportable su le web" (sans logique).
 * @author Cedric
 */
public class WorkerTransport {
    private int id;
    private String lastname;
    private String firstname;
    private String email;
    private String position;

    /**
     * Permet de récupérer l'id de l'employé.
     * @return the id de type Integer
     */
    public int getId() {
        return id;
    }

    /**
     * Permet de définir l'id de l'employé.
     * @param id the id to set de type Integer.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Permet de récupérer le nom de l'employé.
     * @return the lastname de type String.
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Permet de définir le nom de l'employé.
     * @param lastname the lastname to set de type String.
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Permet de récupérer le prenom de l'employé.
     * @return the firstname de type String.
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Permet de définir le prenom de l'employé.
     * @param firstname the firstname to set de type String.
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Permet de récupérer l'email de l'employé.
     * @return the email de type String.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Permet de définir l'email de l'employé.
     * @param email the email to set de type String.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Permet de récupérer la position de l'employé.
     * @return the position de type String.
     */
    public String getPosition() {
        return position;
    }

    /**
     * Permet définir la position de l'employé.
     * @param position the position to set de type String.
     */
    public void setPosition(String position) {
        this.position = position;
    }
    

}
