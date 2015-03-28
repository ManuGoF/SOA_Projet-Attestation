/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.comem.transport;

/**
 * Permet de définir un objet montre "transportable su le web" (sans logique).
 * @author Manu
 */
public class ExampleTransport {
    private int id_example;
    private String chain;

    /**
     * Permet de récupérer l'id de l'example.
     * @return the id_example de type Integer
     */
    public int getId_example() {
        return id_example;
    }

    /**
     * Permet de définir l'id de l'example
     * @param id_example the id_example to set de type Integer
     */
    public void setId_example(int id_example) {
        this.id_example = id_example;
    }

    /**
     * Permet de récupérer la chaine de l'example.
     * @return the chain de type String
     */
    public String getChain() {
        return chain;
    }

    /**
     * Permet de définir la chaine de l'example.
     * @param chain the chain to set de type String
     */
    public void setChain(String chain) {
        this.chain = chain;
    }
    
}
