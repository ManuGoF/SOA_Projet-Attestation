/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.comem.model;

/**
 * La classe Response permet de définir l'objet reponse
 * @author Cedric
 */
public class Response {

    /**
     * Le code d'erreur
     */
    public final int code;

    /**
     * Le message retourné
     */
    public final String message;
    
    /**
     * La clé générée
     */
    public final int generatedKey;
    


    /**
     * Crée un objet réponse avec un code d'erreur, un message et un clé générée.
     *
     * @param code le code d'erreur (int)
     * @param generatedKey la clé générée (int)
     * @param message le message retourné (String)
     */
    public Response(int code, String message, int generatedKey) {
        if (code == 0 || message == null) {
            throw new RuntimeException("Unvalid response");
        }
        this.code = code;
        this.message = message;
        this.generatedKey = generatedKey;
    }



}