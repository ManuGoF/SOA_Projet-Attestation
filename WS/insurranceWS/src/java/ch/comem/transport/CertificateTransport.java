/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.comem.transport;

/**
 * Permet de définir un objet attestation "transportable su le web" (sans logique).
 * @author Cedric
 */
public class CertificateTransport {
    private String id;
    private String state;
    private String creation_date;
    private CarTransport car_transport;
    private WorkerTransport worker_transport;



    /**
     * Permet de récupérer l'état de l'attestation.
     * @return the state de type String
     */
    public String getState() {
        return state;
    }

    /**
     * Permet de définir l'état de l'attestation.
     * @param state the state to set de type String
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Permet de récupérer la date de création de l'attestation.
     * @return the creation_date de type String
     */
    public String getCreation_date() {
        return creation_date;
    }

    /**
     * Permet de définir la date de création de l'attestation.
     * @param creation_date the creation_date to set de type String
     */
    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    /**
     * Permet de récupérer la voiture concernée par l'attestation.
     * @return the car_transport de type CarTransport
     */
    public CarTransport getCar_transport() {
        return car_transport;
    }

    /**
     * Permet de définir la voiture concernée par l'attestation.
     * @param car_transport the car_transport to set de type CarTransport
     */
    public void setCar_transport(CarTransport car_transport) {
        this.car_transport = car_transport;
    }

    /**
     * Permet de récupérer l'employé concerné par l'attestation.
     * @return the worker_transport de type WorkerTransport
     */
    public WorkerTransport getWorker_transport() {
        return worker_transport;
    }

    /**
     * Permet de définir l'employé concerné par l'attestation.
     * @param worker_transport the worker_transport to set de type WorkerTransport
     */
    public void setWorker_transport(WorkerTransport worker_transport) {
        this.worker_transport = worker_transport;
    }

    /**
     * Permet de récupérer l'id l'attestation.
     * @return the id de type Integer
     */
    public String getId() {
        return id;
    }

    /**
     * Permet de définir l'id l'attestation.
     * @param id the id to set de type Integer
     */
    public void setId(String id) {
        this.id = id;
    }

  

}
