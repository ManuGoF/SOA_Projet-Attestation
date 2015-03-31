/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.comem.controller;

/**
 * Permet de gérer des exemples qui on une chaine de caractères.
 * Ce controlleur permet de faire les actions suivantes:
 * - a
 * - brécupérer une montre de la BD (à partir d'un id).
 * @author Groupe Manu et Cédric
 */
public class ExampleController {
    
    // Chargement du driver odbc une fois pour toute
    static {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    // Efface le consrtucteur vide de la Javadoc
    private ExampleController() {}
    
        
}
