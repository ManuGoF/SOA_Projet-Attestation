/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.comem.transport;

/**
 *
 * @author Cedric
 */
public class ResponseTransport {
    private int code;
    private String message;
    private int generatedKey;

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @return the description
     */


    /**
     * @return the generatedKey
     */
    public int getGeneratedKey() {
        return generatedKey;
    }

    /**
     * @param generatedKey the generatedKey to set
     */
    public void setGeneratedKey(int generatedKey) {
        this.generatedKey = generatedKey;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
    

}
