/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.comem.model;

/**
 * Permet de définir l'objet montre
 * @author Manu
 */
public class ExampleModel {
    /**
     * Nom de la montre correspondant à un produit précis (Maximum 50 charactères)
     */
    public final String chain;


    /**
     * Crée l'élément Example
     * @param chain de type String correspondant à la chaine de l'example.
     * Attention : Lance une exception si la chaine de l'example est nulle.
     * Attention : Lance une exception si la longueur des paramètres String est supérieure à 50.
     */
    public ExampleModel(String chain) {
        if (chain == null) throw new RuntimeException("Example not valid");
        if (chain.length() > 50) throw new RuntimeException("Parameter(s) longer than 50");
        this.chain = chain;
    }
}
