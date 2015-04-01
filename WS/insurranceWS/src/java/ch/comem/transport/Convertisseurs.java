/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.comem.transport;

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
    public static WorkerModel boatTransportToBoat(WorkerTransport workerTransport) {
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
    
}
