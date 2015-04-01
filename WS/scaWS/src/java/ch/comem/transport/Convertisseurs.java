/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.comem.transport;

import ch.comem.model.CarModel;
import ch.comem.model.CertificateModel;
import ch.comem.model.ClientModel;
import ch.comem.model.Response;

/**
 * Permet de convertir des objets fournis par les services applicatifs en objets transportable (sur le web).
 * Cette classe permet de faire les actions suivantes:
 * - Convertir un employé de type CertificateModel en type CertificateTransport.
 * - Convertir un employé de type CertificateTransport en type CertificateModel. 
 * - Convertir un employé de type CarModel en type CarTransport.
 * - Convertir un employé de type CarTransport en type CarModel. 
 * - Convertir un employé de type ClientModel en type ClientTransport.
 * - Convertir un employé de type ClientTransport en type ClientModel. 
 * - Convertir un employé de type ResponseTransport en type ResponseModel. 
 * @author Groupe Manu et Cédric
 */
public class Convertisseurs {
    
    /**
     * Permet de convertir un client de type ClientModel en type ClientTransport.
     * Cela permet de convertir le client du SA en client transportable (sur le Web).
     * Si l'objet passé en paramètre est null ou si l'id du client < 0, rien n'est retourné.
     * @param id_client de type Integer correspondant à l'id du client
     * @param client de type ClientModel correspondant à un client du SA.
     * @return ct de type ClientTransport correspondant à un client "transportable".
     */
    public static ClientTransport clientToClientTransport (int id_client, ClientModel client) {
        ClientTransport ct = null;
        if (id_client > 0 || client != null) {
            ct = new ClientTransport();
            ct.setId(id_client);
            ct.setLastname(client.lastname);
            ct.setFirstname(client.firstname);
            ct.setEmail(client.email);
            ct.setBirthday(client.birthday);
            ct.setLicence_type(client.licence_type);
            ct.setLicence_date(client.licence_date);
        }
        return ct;
    }
    
    /**
     * Permet de convertir un client de type ClientTransport en type ClientModel.
     * Cela permet de convertir le client du WS transportable (sur le Web) en client SA utilisable par le SA.
     * Si l'objet passé en paramètre est null, rien n'est retourné. (Ou null).
     * @param ct de type ClientTransport correspondant à un client transportable (sur le web)
     * @return client de type ClientModel correspondant à un client du SA.
     */
    public static ClientModel clientTransportToClient (ClientTransport ct) {
        ClientModel client = null;
        if (ct != null) {
            client = new ClientModel(
                ct.getLastname(),
                ct.getFirstname(),
                ct.getEmail(),
                ct.getBirthday(),
                ct.getLicence_type(),
                ct.getLicence_date()
            );
        }
        return client;   
    }
    
    /**
     * Permet de convertir un véhicule de type CarModel en type CarTransport.
     * Cela permet de convertir le véhicule du SA en véhicule transportable (sur le Web).
     * Si l'objet passé en paramètre est null ou l'id < 0, rien n'est retourné.
     * @param id_client de type Integer correspondant à l'id du client à qui apprtient le véhicule.
     * @param car de type CarModel correspondant à un véhicule du SA.
     * @return cart de type CarTransport correspondant à un véhicule "transportable".
    */
    public static CarTransport carToCarTransport (int id_client, CarModel car) {
        CarTransport cart = null;
        if (car != null) {
            cart = new CarTransport();
            cart.setSerial_number(car.serial_number);
            cart.setRegistration(car.getRegistration());
            cart.setBrand(car.brand);
            cart.setModel(car.model);
            cart.setType(car.type);
            cart.setColor(car.color);
            cart.setPrice(car.price);
            cart.setClient(Convertisseurs.clientToClientTransport(id_client, car.client));
        }
         
        return cart;
    }
    
    /**
     * Permet de convertir un véhicule de type CarTransport en type CarModel.
     * Cela permet de convertir le véhicule du WS transportable (sur le Web) en véhicule SA utilisable par le SA.
     * Si l'objet passé en paramètre est null, rien n'est retourné. (Ou null).
     * @param cart de type CarTransport correspondant à un véhicule transportable (sur le web)
     * @return car de type CarModel correspondant à un véhicule du SA.
     */
    public static CarModel carTransportToCar (CarTransport cart) {
        CarModel car = null;
        if (cart != null) {
            car = new CarModel(
                cart.getSerial_number(),
                cart.getBrand(),
                cart.getModel(),
                cart.getType(),
                cart.getColor(),
                cart.getPrice(),
                Convertisseurs.clientTransportToClient(cart.getClient())
            );
        }
        return car;   
    }
    
    /**
     * Permet de convertir une réponse de type ResponseModel en type ResponseTransport.
     * Cela permet de convertir la réponse du SA en réponse transportable (sur le Web).
     * Si l'objet passé en paramètre est null ou l'id < 0, rien n'est retourné.
     * @param response de type ResponseModel correspondant à une réponse du SA.
     * @return rt de type ResponseTransport correspondant à une réponse "transportable".
     */
    public static ResponseTransport responseToResponseTransport(Response response) {
        ResponseTransport rt = null;
        if (response != null) {
            rt = new ResponseTransport();
            rt.setCode(response.code);
            rt.setMessage(response.message);
            rt.setGeneratedKey(response.generatedKey);

        }
        return rt;
    }
    
    /**
     * Permet de convertir une attestation de type CertificateTransport en type CertificateModel.
     * Cela permet de convertir l'attestaton du WS transportable (sur le Web) en attestation SA utilisable par le SA.
     * Si l'objet passé en paramètre est null, rien n'est retourné. (Ou null).
     * @param certificateTransport de type CertificateTransport correspondant à l'attestation transportable (sur le web)
     * @return ce de type CertificateModel correspondant à une attestation du SA.
     */
    public static CertificateModel certificateTransportToCertificate(CertificateTransport certificateTransport) {
        CertificateModel ce = null;
        CarModel c = null;
        if (certificateTransport != null) {
            c = Convertisseurs.carTransportToCar(certificateTransport.getCar_transport());
            ce = new CertificateModel(certificateTransport.getId(), certificateTransport.getState(), certificateTransport.getCreation_date(), c);
        }
        return ce;
    }
    
    /**
     * Permet de convertir une attestation de type CertificateModel en type CertificateTransport.
     * Cela permet de convertir l'attestation du SA en attestation transportable (sur le Web).
     * Si l'objet passé en paramètre est null ou si l'id du client ou si l'id du client < 0, rien n'est retourné.
     * @param certificate de type CertificateModel correspondant à l'attestation
     * @param id_client de type Integer correspondant à un Client du SA.
     * @return ct de type CertificateTransport correspondant à une attestation "transportable".
     */
    public static CertificateTransport certificateToCertificateTransport(int id_client, CertificateModel certificate) {
        ClientTransport clit = null;
        CarTransport cart = null;
        CertificateTransport ct = null;
        if (certificate != null) {
            clit = new ClientTransport();
            clit.setId(id_client);
            clit.setLastname(certificate.car.client.lastname);
            clit.setFirstname(certificate.car.client.firstname);
            clit.setEmail(certificate.car.client.email);
            clit.setBirthday(certificate.car.client.birthday);
            clit.setLicence_type(certificate.car.client.licence_type);
            clit.setLicence_date(certificate.car.client.licence_date);
            
            cart = new CarTransport();
            cart.setSerial_number(certificate.car.serial_number);
            cart.setRegistration(certificate.car.getRegistration());
            cart.setBrand(certificate.car.brand);
            cart.setModel(certificate.car.model);
            cart.setType(certificate.car.type);
            cart.setColor(certificate.car.color);
            cart.setPrice(certificate.car.price);
            cart.setClient(clit);
            
            
            ct = new CertificateTransport();
            ct.setId(certificate.number);
            ct.setState(certificate.state);
            ct.setCreation_date(certificate.creation_date);
            ct.setCar_transport(cart);

        }
        return ct;
    }
}
