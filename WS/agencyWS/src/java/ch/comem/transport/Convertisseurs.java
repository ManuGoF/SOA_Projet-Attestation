/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.comem.transport;

/**
 * Permet de convertir des objets fournis par les services applicatifs en objets transportable (sur le web).
 * Cette classe permet de faire les actions suivantes:
 * - Convertir un exemple de type ExampleModel en type ExampleTransport
 * - Convertir un exemple de type ExampleTransport en type ExampleModel 
 * @author Groupe Manu et Cédric
 */
public class Convertisseurs {
    
    /**
     * Permet de convertir un exemple de type ExampleModel en type ExampleTransport.
     * Cela permet de convertir l'exemple du SA en exemple transportable (sur le Web) pour le client.
     * Si l'objet passé en paramètre est null, rien n'est retourné.
     * @param example de type exampleTransport correspondant à un exemple transportable (sur le web).
     * @return et de type ExampleTransport correspondant à un exemple "transportable".
     */
    public static ExampleTransport exampleToExampleTransport (int id_example, ExampleModel example) {
        ExampleTransport et = null;
        if (example != null) {
            et = new ExampleTransport();
            et.setId_example(id_example);
            et.setChain(example.chain);
        }
        return et;
    }
    
    /**
     * Permet de convertir un exemple de type ExampleTransport entype ExampleModel.
     * Cela permet de convertir l'exemple du WS transportable (sur le Web) pour le client en exemple SA utilisable par le Web Service.
     * Si l'objet passé en paramètre est null, rien n'est retourné. (Ou null).
     * @param et de type exampleTransport correspondant à un exemple transportable (sur le web)
     * @return example de type ExampleModel correspondant à un exemple du SA.
     */
    public static ExampleModel exampleTransportToExample (ExampleTransport et) {
        ExampleModel example = null;
        if (et != null) {
            example = new ExampleModel(et.getChain(),et.getCollection());
        }
        return example;   
    }
    
}
