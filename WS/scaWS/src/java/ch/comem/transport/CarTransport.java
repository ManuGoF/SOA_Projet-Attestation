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
public class CarTransport {
    private String serial_number;
    private String registration;
    private String brand;
    private String model;
    private String type;
    private String color;
    private Double price;
    private ClientTransport client;

    /**
     * Permet de récupérer le numéro de sériel du véhicule.
     * @return the serial_number de type String
     */
    public String getSerial_number() {
        return serial_number;
    }

    /**
     * Permet de définir le numéro de série du véhicule
     * @param serial_number the serial_number to set de type String
     */
    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    /**
     * Permet de récupérer la marque du véhicule
     * @return the brand de type String
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Permet de définir la marque véhicule
     * @param brand the brand to set de type String
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Permet de récupérer le modèle du véhicule
     * @return the model de type String
     */
    public String getModel() {
        return model;
    }

    /**
     * Permet de définir le modèle du véhicule
     * @param model the model to set de type String
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Permet de récupérer le type du véhicule
     * @return the type de type String
     */
    public String getType() {
        return type;
    }

    /**
     * Permet de définir le type de véhicule
     * @param type the type to set de type String
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Permet de récupérer la couleur du véhicule
     * @return the color de type String
     */
    public String getColor() {
        return color;
    }

    /**
     * Permet de définir la couleur du véhicule
     * @param color the color to set de type String
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Permet de récupérer le prix du véhicule
     * @return the price de type Double
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Permet de définir la couleur du véhicule
     * @param price the price to set de type Double
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Permet de récupérer le client à qui appartient le véhicule
     * @return the client de type ClientTransport
     */
    public ClientTransport getClient() {
        return client;
    }

    /**
     * Permet de définir le client à qui appartient le véhicule
     * @param client the client to set de type Client Transport
     */
    public void setClient(ClientTransport client) {
        this.client = client;
    }

    /**
     * @return the registration
     */
    public String getRegistration() {
        return registration;
    }

    /**
     * @param registration the registration to set
     */
    public void setRegistration(String registration) {
        this.registration = registration;
    }

}
