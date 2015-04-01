/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.comem.model;

/**
 * La classe Response permet de définir l'objet Response
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
     * La clé générée (dans le cas d'une création d'objet, 0 et le message sinon).
     */
    public final int generatedKey;
    

    /**
     * Crée un objet réponse avec un code d'erreur, un message et un clé.
     * @param code le code d'erreur (int)
     * @param generatedKey la clé générée (int)
     * @param message le message retourné (String)
     * Attention renvoie une exception si les paramètres ne sont pas définis.
     * response: -1, OK, Number of the genereted key => OK (l'opération s'est bien déroulée).
     * response: -2, The object doesn't exist!, 0 => L'objet correspondant à l'ID passé en paramètre n'existe pas dans la BD.
     * response: -3, The object already exist!, 0 => L'objet correspondant à l'ID passé en paramètre existe déjà.
     * response: -4, Parameter isn't congruent!, 0 => Paramètre idn conforme.
     * response: -5, Nothing happened, 0 => Rien ne s'est passé (l'opération n'a eu aucun effet).
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