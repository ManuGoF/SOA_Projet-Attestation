/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.comem.model;


/**
 * Permet de définir l'objet Client.
 * @author Manu
 */
public class ClientModel {
    /**
     * Nom du client (Maximum 50 charactères).
     */
    public final String lastname;
            
    /**
     * Prénom du client (Maximum 50 charactères).
     */
    public final String firstname;
    
    /**
     * Email du client (Maximum 80 charactères)
     */
    public final String email;
    
    /**
     * Date de naissance du client.
     */
    public final String birthday;
    
    /**
     * Type de permis que possède le client (Maximum 50 charactères).
     * (Exemple B, C1, D1, BE, C1E, D1E, etc.)
     */
    public final String licence_type;
    
    /**
     * Date d'émission du permis.
     */
    public final String licence_date;


    /**
     * Crée l'élément Client
     * @param lastname de type String correspondant au nom du client.
     * @param firstname de type String correspondant au prénom du client.
     * @param email de type String correspondant à l'email du client.
     * @param birthday de type String correspondant à la date de naissance du client.
     * @param licence_type de type String correspondant au permis du client.
     * @param licence_date de type String correspondant à la date d'émission du permis du client.
     * Attention : Lance une exception si les paramètres ne sont pas définis.
     * Attention : Lance une exception si les paramètres String sont plus élevé que 50 caractères.
     * Attention : Lance une exception si le paramètre String email est plus élevé que 80 caractères.
     * Attention : Lance une exception si les paramètre String birthday et licence_date sont plus élevés que 10 caractères.
     */
    public ClientModel(String lastname, String firstname, String email, String birthday, String licence_type, String licence_date) {
        // Contrôle si les paramètres d'entrée sont fournis
        if (lastname == null || firstname == null || email == null || birthday == null || licence_type == null || licence_date == null) throw new RuntimeException("Client parameters not define");
        // Contrôle de la longueur des paramètres String fournis
        if (lastname.length() > 50 || firstname.length() > 50 || licence_type.length() > 50) throw new RuntimeException("One or more parameters are longer than 50");
        if (email.length() > 80) throw new RuntimeException("Email parameter are longer than 80");
        if (birthday.length() > 10 || licence_date.length() > 10) throw new RuntimeException("Birthday or licence_date parameter are longer than 10");
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.birthday = birthday;
        this.licence_type = licence_type;
        this.licence_date = licence_date;
    }
    
}
