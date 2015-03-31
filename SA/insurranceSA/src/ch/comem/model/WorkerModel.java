/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.comem.model;

/**
 *
 * @author Cedric
 */
public class WorkerModel {

    /**
     * Prenom de l'employé (Maximum 50 charactères).
     */
    public final String lastname;

    /**
     * Nom de l'employé (Maximum 50 charactères).
     */
    public final String firstname;

        /**
     * Email de l'employé (Maximum 80 charactères).
     */
    public final String email;

        /**
     * Position de l'employé (Maximum 20 charactères).
     */
    public final String position;
    

    /**
     * Crée l'objet worker.
     * @param lastname de type String correspondant au nom du l'employé.
     * @param firstname de type String correspondant au prénom de l'employé.
     * @param email de type String correspondant à l'email de l'employé.
     * @param position de type String correspondant à la postition de l'employé ("garage"|"agence"|"siege"|"direction").
     * Attention renvoie une exception si les paramètres ne sont pas définis.
     * Attention renvoie une exception si le nom ou le prénom est plus long que 50 characteres.
     * Attention renvoie une exception si l'email est plus long que 80 characteres.
     * Attention renvoie une exception si la position est différente que les valeurs admises.
     */
    public WorkerModel(String lastname, String firstname, String email, String position) {
        System.out.println(email.length());
        if (lastname == null || firstname == null || email == null || position == null) {
            throw new RuntimeException("Worker parameters not define");
        }
        if (lastname.length() > 50 || firstname.length() > 50) {
            throw new RuntimeException("One or more parameters are longer than expected");
        }
        if (email.length() > 80) {
            throw new RuntimeException("Email is longer than expected");
        }
        if (!position.equalsIgnoreCase("garage") || !position.equalsIgnoreCase("agence") || !position.equalsIgnoreCase("siege") || !position.equalsIgnoreCase("direction")) {
            throw new RuntimeException("Position doesn't exist");
        }

        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.position = position;

    }

}
