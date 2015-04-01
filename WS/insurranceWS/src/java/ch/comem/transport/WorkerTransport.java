/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.comem.transport;

/**
 * Permet de créer un worker transportable.
 * @author Cedric
 */
public class WorkerTransport {
    private int id;
    private String lastname;
    private String firstname;
    private String email;
    private String position;

    /**
     * Permet de récupérer l'id
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Permet de définir l'id
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Permet de récupérer le nom
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Permet de définir le nom
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Permet de récupérer le prenom
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Permet de définir le prenom
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Permet de récupérer l'email
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Permet de définir l'email
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Permet de récupérer la position
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * Permet définir la position
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }
    

}
