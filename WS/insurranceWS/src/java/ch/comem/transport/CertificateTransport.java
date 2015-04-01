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
public class CertificateTransport {
    private String id;
    private String state;
    private String creation_date;
    private CarTransport car_transport;
    private WorkerTransport worker_transport;



    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the creation_date
     */
    public String getCreation_date() {
        return creation_date;
    }

    /**
     * @param creation_date the creation_date to set
     */
    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    /**
     * @return the car_transport
     */
    public CarTransport getCar_transport() {
        return car_transport;
    }

    /**
     * @param car_transport the car_transport to set
     */
    public void setCar_transport(CarTransport car_transport) {
        this.car_transport = car_transport;
    }

    /**
     * @return the worker_transport
     */
    public WorkerTransport getWorker_transport() {
        return worker_transport;
    }

    /**
     * @param worker_transport the worker_transport to set
     */
    public void setWorker_transport(WorkerTransport worker_transport) {
        this.worker_transport = worker_transport;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

  

}
