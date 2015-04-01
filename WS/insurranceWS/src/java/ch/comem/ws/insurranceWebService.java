/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.comem.ws;

import ch.comem.controller.CarController;
import ch.comem.controller.CertificateController;
import ch.comem.controller.ClientController;
import ch.comem.controller.WorkerController;
import ch.comem.model.CarModel;
import ch.comem.model.CertificateModel;
import ch.comem.model.ClientModel;
import ch.comem.model.Response;
import ch.comem.model.WorkerModel;
import ch.comem.transport.CarTransport;
import ch.comem.transport.CertificateTransport;
import ch.comem.transport.ClientTransport;
import ch.comem.transport.Convertisseurs;
import ch.comem.transport.ResponseTransport;
import ch.comem.transport.WorkerTransport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 * Permet de gérer des attestations, véhicules, client et employés de l'assurance.
 * Ce web service permet de faire les actions suivantes:
 * - Création d'un client dans la BD.
 * - Récupération d'un client de la BD à l'aide de son ID.
 * - Suppression d'un client dans la BD et les objets liés en cascade à l'aide de son ID.
 * - Récupération d'une liste de de tous les clients.
 * - Création d'un véhicule dans la BD.
 * - Récupération d'un véhicule de la BD à l'aide de son ID.
 * - Suppression d'un véhicule dans la BD et les objets liés en cascade à l'aide de son ID.
 * - Récupération d'une liste de tous les véhicules Car.
 * - Création d'une attestation dans la BD. 
 * - Récupération d'une attestation de la BD à l'aide de son ID. 
 * - Récupération d'une liste de de toutes les attestations.
 * - Modification de l'état d'une attestation.
 * - Modification de l'employé responsable (worker).
 * - Création d'un employé dans la BD.
 * - Récupération d'un employé de la BD à l'aide de son ID.
 * - Récupération d'une liste de tous les employés.
 * @author Groupe Manu et Cédric
 */
@WebService(serviceName = "insurranceWebService")
@Stateless()
public class insurranceWebService {

    /**
     * Web service operation de l'assurance.
     * Permet d'insérer un client dans la table Clients de la BD.
     * Ce client est composée des paramètres suivants:
     * id, lastname, firstname, email, birthday, licence_type, licence_date
     * Si le client existe déjà (selon son email), l'objet n'est pas créé.
     * @param client de type ClientTransport
     * @return response de type ResponseTransport selon les résultats suivants:
     * response: -1, OK, Number of the genereted key => OK (l'opération s'est bien déroulée).
     * response: -2, The object doesn't exist!, 0 => L'objet correspondant à l'ID passé en paramètre n'existe pas dans la BD.
     * response: -3, The object already exist!, 0 => L'objet correspondant à l'ID passé en paramètre existe déjà.
     * response: -4, Parameter isn't congruent!, 0 => Paramètre idn conforme.
     * response: -5, Nothing happened, 0 => Rien ne s'est passé (l'opération n'a eu aucun effet).
     */
    @WebMethod(operationName = "createClient")
    public ResponseTransport createClient(@WebParam(name = "client") ClientTransport client) {
        ResponseTransport responseWS = null;
        if (client != null) {
            ClientModel clientSA = Convertisseurs.clientTransportToClient(client);
            Response responseSA = ClientController.createClient(clientSA);
            responseWS = Convertisseurs.responseToResponseTransport(responseSA);
        }
        return responseWS;
    }

    /**
     * Web service operation de l'assurance.
     * Permet de récupérer un client de la table Clients de la BD.
     * Ce client est composée des paramètres suivants:
     * id, lastname, firstname, email, birthday, licence_type, licence_date
     * Si le client n'existe pas (selon son ID), l'objet n'est pas retourné.
     * Si le client ID n'est pas conforme (=< 0), l'objet n'est pas retourné.
     * @param client_id de type Integer correspondant à l'id du client souhaité.
     * @return client de type ClientTransport correspondant au client souhaité si il existe.
     */
    @WebMethod(operationName = "readClient")
    public ClientTransport readClient(@WebParam(name = "client_id") int client_id) {
        ClientTransport clientWS = new ClientTransport();
        if (client_id >= 0) {
            ClientModel clientSA = ClientController.readClient(client_id);
            clientWS = Convertisseurs.clientToClientTransport(client_id, clientSA);
        }
        return clientWS;
    }

    /**
     * Web service operation de l'assurance.
     * Permet de récupérer tous les clients existants (dans la table Clients de la BD).
     * @return une liste <ClientTransport> correspondant à une liste de clients.
     * La liste retournée comprends les clients dans la BD de donnée. Si la BD est vide, une liste vide est retournée.
     */
    @WebMethod(operationName = "readAllClients")
    public List<ClientTransport> readAllClients() {
        List<ClientTransport> clientsListWS = new ArrayList<>();
        Map<Integer, ClientModel> clients = ClientController.readAllClients();
        
        for (Map.Entry<Integer, ClientModel> entry: clients.entrySet()) {
            ClientTransport clientWS = Convertisseurs.clientToClientTransport(entry.getKey(),entry.getValue());
            clientsListWS.add(clientWS);
        }

        return clientsListWS;
    }

    /**
     * Web service operation de l'assurance.
     * Permet de supprimer un client à l'aide de son ID.
     * Cette méthode supprime le client dans la table Clients de la BD.
     * Cette méthode supprime en cascade dans la BD les objets qui sont liés au client supprimé.
     * -> Client -> Cars -> Certifications -> Comments
     * @param client_id de type Integer correspondant à l'id à supprimer.
     * @return response de type ResponseTransport selon les résultats suivants:
     * response: -1, OK, Number of the deleted client => OK (l'opération s'est bien déroulée).
     * response: -2, The object doesn't exist!, 0 => L'objet correspondant à l'ID passé en paramètre n'existe pas dans la BD.
     * response: -3, The object already exist!, 0 => L'objet correspondant à l'ID passé en paramètre existe déjà.
     * response: -4, Parameter isn't congruent!, 0 => Paramètre idn conforme.
     * response: -5, Nothing happened, 0 => Rien ne s'est passé (l'opération n'a eu aucun effet).
     */
    @WebMethod(operationName = "deleteClient")
    public ResponseTransport deleteClient(@WebParam(name = "client_id") int client_id) {
        ResponseTransport responseWS = null;
        if (client_id > 0) {
            Response responseSA = ClientController.deleteClient(client_id);
            responseWS = Convertisseurs.responseToResponseTransport(responseSA);
        }
        return responseWS;
    }

    /**
     * Web service operation de l'assurance.
     * Permet de récupérer tous les véhiculess existants (dans la table Cars de la BD).
     * @return une liste List<CarTransport> correspondant à une liste de véhicule avec le Client à qui appartient le véhicule.
     * La liste retournée comprends les véhicules dans la base de donnée. Si la BD est vide, une liste vide est retournée.
     */
    @WebMethod(operationName = "readAllCars")
    public List<CarTransport> readAllCars() {
        List<CarModel> cars;
        List<CarTransport> carsListWS = new ArrayList<>();
        cars = CarController.readAllCars();
        
        for (CarModel car : cars) {
            int client_id = ClientController.getClientId(car.client.email);
            CarTransport carWS = Convertisseurs.carToCarTransport(client_id, car);
            carsListWS.add(carWS);
        }

        return carsListWS;
    }

    /**
     * Web service operation de l'assurance.
     * Permet d'insérer un véhicule dans la table Cars de la BD.
     * Ce véhicule est composé des paramètres suivants:
     * serial_number, brand, model, type, color, price, client
     * Si le véhicule existe déjà (selon son SERIAL_NUMBER), l'objet n'est pas créé.
     * Si l'id du client à qui appartient le véhicule n'existe pas, l'objet n'est pas créé.
     * @param car de type CarTransport
     * @return response de type ResponseTransport selon les résultats suivants:
     * response: -1, OK: Serial number, 0 => OK (l'opération s'est bien déroulée).
     * response: -2, The client object doesn't exist!, 0 => L'objet correspondant à l'ID client passé dans car n'existe pas dans la BD.
     * response: -3, The object already exist!, 0 => L'objet correspondant à l'ID passé en paramètre existe déjà.
     * response: -4, Parameter isn't congruent!, 0 => Paramètre idn conforme.
     * response: -5, Nothing happened, 0 => Rien ne s'est passé (l'opération n'a eu aucun effet).
     */
    @WebMethod(operationName = "createCar")
    public ResponseTransport createCar(@WebParam(name = "car") CarTransport car) {
        ResponseTransport responseWS = null;
        if (car != null) {
            CarModel carSA = Convertisseurs.carTransportToCar(car);
            Response responseSA = CarController.createCar(carSA);
            responseWS = Convertisseurs.responseToResponseTransport(responseSA);
        }
        return responseWS;
    }

    /**
     * Web service operation de l'assurance.
     * Permet de récupérer un véhicule de la table Cars de la BD.
     * Ce véhicule est composé des paramètres suivants:
     * serial_number, brand, model, type, color, price, client
     * Si le véhicule n'existe pas (selon son SERIAL_NUMBER), l'objet n'est pas retourné.
     * Si le véhicule SERIAL_NUMBER n'est pas conforme, l'objet n'est pas retourné.
     * @param serial_number de type String correspondant au numéro de série du véhicule souhaité.
     * @return car de type CarTransport correspondant au véhicule souhaité s'il existe.
     */
    @WebMethod(operationName = "readCar")
    public CarTransport readCar(@WebParam(name = "serial_number") String serial_number) {
        CarTransport carWS = new CarTransport();        
        if (serial_number.length() > 0 && serial_number.length() <= 50) { 
            CarModel carSA = CarController.readCar(serial_number);
            int client_id = ClientController.getClientId(carSA.client.email);
            carWS = Convertisseurs.carToCarTransport(client_id, carSA);
        }
        return carWS;
    }

    /**
     * Web service operation de l'assurance.
     * Permet de supprimer un véhicule à l'aide de son ID.
     * Cette méthode supprime le véhicule dans la table Cars de la BD.
     * Cette méthode supprime en cascade dans la BD les objets qui sont liés au véhicule supprimé.
     * -> Cars -> Certifications -> Comments
     * @param serial_number de type String correspondant au véhicule à supprimer.
     * @return response de type Response selon les résultats suivants:
     * response: -1, OK: Serial number, 0 => OK (l'opération s'est bien déroulée).
     * response: -2, The object doesn't exist!, 0 => L'objet correspondant à l'ID passé en paramètre n'existe pas dans la BD.
     * response: -3, The object already exist!, 0 => L'objet correspondant à l'ID passé en paramètre existe déjà.
     * response: -4, Parameter isn't congruent!, 0 => Paramètre idn conforme.
     * response: -5, Nothing happened, 0 => Rien ne s'est passé (l'opération n'a eu aucun effet).
     */
    @WebMethod(operationName = "deleteCar")
    public ResponseTransport deleteCar(@WebParam(name = "serial_number") String serial_number) {
        ResponseTransport responseWS = null;
        if (serial_number.length() > 0 && serial_number.length() <= 50) {
            Response responseSA = CarController.deleteCar(serial_number);
            responseWS = Convertisseurs.responseToResponseTransport(responseSA);
        }
        return responseWS;
    }
    
        
    /**
     * Web service operation de l'assurance.
     * Permet d'insérer une attestation dans la table Certificats de la BD. 
     * Cette attestation est composée des paramètres suivants: 
     * number, state, creation_date, car, worker 
     * Si l'attestation existe déjà (selon son numero), l'objet n'est pas créé.
     * @param certificateTransport de type CertificatTransport
     * @return response de type ResponseTransport selon les résultats suivants: 
     * response: -1, OK, 0 => OK (l'opération s'est bien déroulée).
     * response: -2, The object doesn't exist!, 0 => L'objet correspondant à l'objet fourni n'existe pas dans la BD.
     * response: -3, The object already exist!, 0 => L'objet correspondant à l'ID passé en paramètre existe déjà.
     * response: -4, Parameter isn't congruent!, 0 => Paramètre id non conforme.
     * response: -5, Nothing happened, 0 => Rien ne s'est passé (l'opération n'a eu aucun effet).
     */
    @WebMethod(operationName = "createCertificate")
    public ResponseTransport createCertificate(@WebParam(name = "certificate") CertificateTransport certificateTransport) {
        ResponseTransport saResponse = null;
        if (certificateTransport != null) {
            CertificateModel c = Convertisseurs.certificateTransportToCertificate(certificateTransport);
            saResponse = Convertisseurs.responseToResponseTransport(CertificateController.createCertificate(c));
        }

        return saResponse;
    }

    /**
     * Web service operation de l'assurance.
     * Permet de récupérer toutes les attestations existantes (dans la table Certificates de la BD).
     * @return une liste List<CertificateTransport> correspondant à une liste d'attestations avec le véhicule correspondant.
     * La liste retournée comprends les attestation dans la base de donnée. Si la BD est vide, une liste vide est retournée.
     */
    @WebMethod(operationName = "readAllCertificates")
    public List<CertificateTransport> readAllCertificates() {
        List<CertificateTransport> listCt = new ArrayList<>();
        ArrayList<CertificateModel> cert = CertificateController.readAllCertificates();
        for (int i = 0; i < cert.size(); i++) {
            CertificateModel c = cert.get(i);
            int id_client = ClientController.getClientId(c.car.client.email);
            int id_worker = WorkerController.getWorkerId(c.worker.email);
            CertificateTransport certt = Convertisseurs.certificateToCertificateTransport(id_client, id_worker, c);
            listCt.add(certt);
        }

        return listCt;
    }

    /**
     * Web service operation de l'assurance.
     * Permet de récupérer une attestation de la table Certificates de la BD. 
     * Cette attestation est composée des paramètres suivants: 
     * number, state, creation_date, car, worker 
     * Si l'attestation n'existe pas (selon son numéro) l'objet n'est pas retourné. 
     * Si l'attestation number n'est pas conforme (=< 0), l'objet n'est pas retourné. 
     * @param certificate_id @return certificaate de type CertificateTransport correspondant au certificat souhaité si il existe.
     */
    @WebMethod(operationName = "readCertificate")
    public CertificateTransport readCertificate(@WebParam(name = "certificate_id") String certificate_id) {
        CertificateTransport ct = null;
        CertificateModel c = CertificateController.readCertificate(certificate_id);
        int id_client = ClientController.getClientId(c.car.client.email);
        int id_worker = WorkerController.getWorkerId(c.worker.email);
        ct = Convertisseurs.certificateToCertificateTransport(id_client, id_worker, c);
        return ct;
    }

    /**
     * Web service operation
     * Permet de modifier l'état d'une attestation s'il existe et si l'état entré est conforme.
     * @param certificate_number de type String correspondant au certificat à modifier.
     * @param worker_id de type int correspondant au nouveau travailleur.
     * @return response de Type ResponseTransport correspondant à la réponse du service.
     * response: -1, OK, 0 => OK (l'opération s'est bien déroulée). 
     * response: -2, Worker doesn't exist, 0 => Le travailleur n'existe pas. 
     * response: -3, Certificate doesn't exist, 0 =>Le certificat n'existe pas.
     */
    @WebMethod(operationName = "updateCertificateWorker")
    public ResponseTransport updateCertificateWorker(@WebParam(name = "certificate") String certificate_number, @WebParam(name = "worker") int worker_id) {
        ResponseTransport saResponse = null;
        if (certificate_number != null) {
            saResponse = Convertisseurs.responseToResponseTransport(CertificateController.updateWorker(certificate_number, worker_id));
        }
        return saResponse;
    }

    /**
     * Web service operation de l'assurance.
     * Permet de modifier l'état d'une attestation s'il existe et si l'état entré est conforme.
     * @param certificate_number de type String correspondant au certificat à modifier.
     * @param status de type String correspondant au nouvel état.
     * @return response de Type Responseransport correspondant à la réponse du service.
     * response: -1, OK new state : state, 0 => OK (l'opération s'est bien déroulée). 
     * response: -2, State is already : state, 0 => L'état est deja celui defini. 
     * response: -3, State is not correct, 0 => L'état n'est pas correct. 
     * response: -4, Certificate doesn't exist, 0 =>Le certificat n'existe pas.
     */
    @WebMethod(operationName = "updateCertificateStatus")
    public ResponseTransport updateCertificateStatus(@WebParam(name = "certificate") String certificate_number, @WebParam(name = "status") String status) {
        ResponseTransport saResponse = null;
        if (certificate_number != null) {
            saResponse = Convertisseurs.responseToResponseTransport(CertificateController.updateState(certificate_number, status));
        }
        return saResponse;
    }

    /**
     * Web service operation de l'assurance.
     * Permet d'insérer un nouveau worker dans la base de données, 
     * si les paramètres d'entrée sont valides et si le tuple n'existe pas encore dans la base de données 
     * (par rapport a l'adresse email du travailleur).
     * @param workerTransport de type WorkerTransport
     * @return response de type ResponseTransport selon les résultats suivants: 
     * response: -1, OK, Number of the genereted key => OK (l'opération s'est bien déroulée). 
     * response: -2, Worker already exist!, 0 => Le worker existe deja dans la BD.
     */
    @WebMethod(operationName = "createWorker")
    public ResponseTransport createWorker(@WebParam(name = "worker") WorkerTransport workerTransport) {
        ResponseTransport saResponse = null;
        if (workerTransport != null) {
            WorkerModel w = Convertisseurs.workerTransportToWorker(workerTransport);
            saResponse = Convertisseurs.responseToResponseTransport(WorkerController.createWorker(w));
        }
        return saResponse;
    }

    /**
     * Web service operation de l'assurance.
     * La methode readAllWorkers() permet de récuper tous les employés.
     * @return List<WorkerTransport> - une liste  de workers.
     * La liste retournée comprends les clients dans la BD de donnée. Si la BD est vide, une liste vide est retournée.
     */
    @WebMethod(operationName = "readAllWorkers")
    public List<WorkerTransport> readAllWorkers() {
        List<WorkerTransport> listWt = new ArrayList<>();
        Map<Integer, WorkerModel> workers = WorkerController.readAllWorkers();
        for (Map.Entry<Integer, WorkerModel> entry : workers.entrySet()) {
            WorkerTransport wt = Convertisseurs.WorkerToWorkerTransport(entry.getKey(), entry.getValue());
            listWt.add(wt);
        }
        return listWt;
    }

    /**
     * Web service operation de l'assurance.
     * Permet de récupérer un employé de la table Workers de la BD.
     * L'employé est composé des paramètres suivants:
     * id, lastname, firstname, email, birthday, position
     * Si l'employé n'existe pas (selon son ID), l'objet n'est pas retourné.
     * Si l'employé  ID n'est pas conforme (=< 0), l'objet n'est pas retourné.
     * @param id de type Integer correspondant à l'id de l'employé souhaité.
     * @return List<WorkerTransport> - une liste de worker.
     */
    @WebMethod(operationName = "readWorker")
    public List<WorkerTransport> readWorker(@WebParam(name = "worker") int worker_id) {
        List<WorkerTransport> listWt = new ArrayList<>();
        Map<Integer, WorkerModel> workers = WorkerController.readWorker(worker_id);
        for (Map.Entry<Integer, WorkerModel> entry : workers.entrySet()) {
            WorkerTransport wt = Convertisseurs.WorkerToWorkerTransport(entry.getKey(), entry.getValue());
            listWt.add(wt);
        }
        return listWt;
    }
}
