/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.comem.transport;

import ch.comem.model.CarModel;
import ch.comem.model.CertificateModel;
import ch.comem.model.ClientModel;
import ch.comem.model.WorkerModel;

/**
 * Permet de convertir des objets fournis par les services applicatifs en objets transportable (sur le web).
 * Cette classe permet de faire les actions suivantes:
 * - Convertir un exemple de type ExampleModel en type ExampleTransport
 * - Convertir un exemple de type ExampleTransport en type ExampleModel 
 * @author Groupe Manu et Cédric
 */
public class Convertisseurs {
    

        /**
     * Permet de transformer un bateau transport en bateau.
     * @param workerTransport
     * @return b le bateau (Boat)
     */
    public static WorkerModel workerTransportToWorker(WorkerTransport workerTransport) {
        WorkerModel w = null;
        if (workerTransport != null) {
            w = new WorkerModel(workerTransport.getLastname(), workerTransport.getFirstname(), workerTransport.getEmail(), workerTransport.getPosition());
        }
        return w;
    }
    
        /**
     * Permet de transformer un bateau en bateau transport
     * @param id - l'id du bateau (int)
     * @param worker
     * @return bt - le bateau transport (BoatTransport)
     */
    public static WorkerTransport WorkerToWorkerTransport(int id, WorkerModel worker) {
        WorkerTransport wt = null;
        if (worker != null) {
            wt = new WorkerTransport();
            wt.setId(id);
            wt.setLastname(worker.lastname);
            wt.setFirstname(worker.firstname);
            wt.setEmail(worker.email);
            wt.setPosition(worker.position);
        }
        return wt;
    }
    
            /**
     * Permet de transformer un bateau transport en bateau.
     * @param certificateTransport
     * @return b le bateau (Boat)
     */
    public static CertificateModel certificateTransportToCertificate(CertificateTransport certificateTransport) {
        CertificateModel ce = null;
        WorkerModel w = null;
        CarModel c = null;
        if (certificateTransport != null) {
            w = Convertisseurs.workerTransportToWorker(certificateTransport.getWorker_transport());
            c = Convertisseurs.carTransportToCar(certificateTransport.getCar_transport());
            ce = new CertificateModel(certificateTransport.getId(), certificateTransport.getState(), certificateTransport.getCreation_date(), c, w);
        }
        return ce;
    }
    
        /**
     * Permet de transformer un bateau en bateau transport
     * @param id - l'id du bateau (int)
     * @param certificate
     * @return bt - le bateau transport (BoatTransport)
     */
    public static CertificateTransport certificateToCertificateTransport(int id_client, int id_worker, CertificateModel certificate) {
        ClientTransport clit = null;
        CarTransport cart = null;
        WorkerTransport wt = null;
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
            cart.setBrand(certificate.car.brand);
            cart.setModel(certificate.car.model);
            cart.setType(certificate.car.type);
            cart.setColor(certificate.car.color);
            cart.setPrice(certificate.car.price);
            cart.setClient(clit);
            
            wt = new WorkerTransport();
            wt.setLastname(certificate.worker.lastname);
            wt.setFirstname(certificate.worker.firstname);
            wt.setEmail(certificate.worker.email);
            wt.setPosition(certificate.worker.position);
            
            ct = new CertificateTransport();
            ct.setId(certificate.number);
            ct.setState(certificate.state);
            ct.setCreation_date(certificate.creation_date);
            ct.setCar_transport(cart);

        }
        return ct;
    }
    
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
    
}
