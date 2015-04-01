/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.comem.transport;

/**
 * Permet de définir un objet Response "transportable su le web" (sans logique).
 * @author Cedric
 */
public class ResponseTransport {
    private int code;
    private String message;
    private int generatedKey;

    /**
     * Permet de récupérer le code de la réponse.
     * @return the code de type Integer.
     */
    public int getCode() {
        return code;
    }

    /**
     * Permet de définir le code de la réponse.
     * @param code the code to set de type Integer.
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Permet de récupérer la clé généréé de la réponse.
     * @return the generatedKey de type Integer
     */
    public int getGeneratedKey() {
        return generatedKey;
    }

    /**
     * Permet de définir la clé généréé de la réponse.
     * @param generatedKey the generatedKey to set de type Integer.
     */
    public void setGeneratedKey(int generatedKey) {
        this.generatedKey = generatedKey;
    }

    /**
     * Permet de récupérer le message de la réponse.
     * @return the message de type String.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Permet de définir le message de la réponse.
     * @param message the message to set type String
     */
    public void setMessage(String message) {
        this.message = message;
    }
    

}
