/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.comem.model;

import com.sun.security.ntlm.Client;

/**
 * Permet de définir l'objet Car.
 * @author Manu
 */
public class CarModel {
    /**
     * Numéro de série du véhicule (Maximum 50 charactères).
     */
    public final String serial_number;
    
    /**
     * Numéro de plaque du véhicule (Maximum 20 charactères).
     */
    public final String registration;
    
    /**
     * Marque du véhicule (Maximum 20 charactères).
     */
    public final String brand;
    
    /**
     * Modèle du véhicule (Maximum 50 charactères).
     */
    public final String model;
    
    /**
     * Type de véhicule (Maximum 50 charactères).
     * (Exemple Limousine, Cabriolet, 2 roues, etc.)
     */
    public final String type;
    
    /**
     * Couleur du véhicule (Maximum 20 charactères).
     */
    public final String color;
    
    /**
     * Prix du véhicule. 
     */
    public final Double price;
    
    /**
     * Client propriétaire du véhicule.
     */
    public final Client client;
    
    /**
     * Crée l'élément Car.
     * @param serial_number de type String correspondant au numéro de série du véhicule.
     * @param registration de type String correspondant au numéro de plaque du véhicule.
     * @param brand de type String correspondant à la marque du véhicule.
     * @param model de type String correspondant au modèle du véhicule.
     * @param type de type String correspondant au type de véhicule.
     * @param color de type String correspondant à la couleur du véhicule.
     * @param price de type Double correspondant au prix du véhicule.
     * @param client de type Client correspondant au client à qui appartient le véhicule.
     * Attention : Lance une exception si les paramètres ne sont pas définis.
     * Attention : Lance une exception si certains paramètres String sont plus élevé que 50 caractères.
     * Attention : Lance une exception si certains paramètre String sont plus élevé que 20 caractères.
     */
    public CarModel(String serial_number, String registration, String brand, String model, String type, String color, Double price, Client client) {
        // Contrôle si les paramètres d'entrée sont fournis
        if (serial_number == null || registration == null || brand == null || model == null || type == null || color == null || price == 0 || client == null) throw new RuntimeException("Car parameters not define");
        // Contrôle de la longueur des paramètres String fournis
        if (serial_number.length() > 50 || model.length() > 50 || type.length() > 50) throw new RuntimeException("One or more parameters are longer than 50");
        if (registration.length() > 20 || brand.length() > 20 || color.length() > 20) throw new RuntimeException("One or more parameters are longer than 20");
        this.serial_number = serial_number;
        this.registration = registration;
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.color = color;
        this.price = price;
        this.client = client;
    }
    
}
