/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.comem.ws;

import ch.comem.controller.CarController;
import ch.comem.controller.CertificateController;
import ch.comem.controller.ClientController;
import ch.comem.model.CarModel;
import ch.comem.model.CertificateModel;
import ch.comem.model.ClientModel;
import ch.comem.model.Response;
import ch.comem.transport.CarTransport;
import ch.comem.transport.CertificateTransport;
import ch.comem.transport.ClientTransport;
import ch.comem.transport.Convertisseurs;
import ch.comem.transport.ResponseTransport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author Manu
 */
@WebService(serviceName = "scaWebService")
@Stateless()
public class scaWebService {

    /**
     * Web service operation
     *
     * @param client
     * @return
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
     * Web service operation
     *
     * @param client_id
     * @return
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
     * Web service operation
     *
     * @return
     */
    @WebMethod(operationName = "readAllClients")
    public List<ClientTransport> readAllClients() {
        List<ClientTransport> clientsListWS = new ArrayList<>();
        Map<Integer, ClientModel> clients = ClientController.readAllClients();

        for (Map.Entry<Integer, ClientModel> entry : clients.entrySet()) {
            ClientTransport clientWS = Convertisseurs.clientToClientTransport(entry.getKey(), entry.getValue());
            clientsListWS.add(clientWS);
        }

        return clientsListWS;
    }

    /**
     * Web service operation
     *
     * @param client_id
     * @return
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
     * Web service operation
     *
     * @return
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
     * Web service operation
     *
     * @param car
     * @return
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
     * Web service operation
     *
     * @param serial_number
     * @return
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
     * Web service operation
     *
     * @param serial_number
     * @return
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

//        @WebMethod(operationName = "updateCertificateStatus")
//    public ResponseTransport updateCertificateStatus(@WebParam(name = "serial_number") String serial_number, @WebParam(name = "registration") String registration) {
//        ResponseTransport saResponse = null;
//        if (serial_number != null) {
//            saResponse = Convertisseurs.responseToResponseTransport(CarController.addRegistration(serial_number, registration));
//        }
//        return saResponse;
//    }
    @WebMethod(operationName = "createCertificate")
    public ResponseTransport createCertificate(@WebParam(name = "certificate") CertificateTransport certificateTransport) {
        ResponseTransport saResponse = null;
        if (certificateTransport != null) {
            CertificateModel c = Convertisseurs.certificateTransportToCertificate(certificateTransport);
            saResponse = Convertisseurs.responseToResponseTransport(CertificateController.createCertificate(c));
        }

        return saResponse;
    }

    @WebMethod(operationName = "readAllCertificates")
    public List<CertificateTransport> readAllCertificates() {
        List<CertificateTransport> listCt = new ArrayList<>();
        ArrayList<CertificateModel> cert = CertificateController.readAllCertificates();
        for (int i = 0; i < cert.size(); i++) {
            CertificateModel c = cert.get(i);
            int id_client = ClientController.getClientId(c.car.client.email);
            CertificateTransport certt = Convertisseurs.certificateToCertificateTransport(id_client, c);
            listCt.add(certt);
        }

        return listCt;
    }

    @WebMethod(operationName = "readCertificate")
    public CertificateTransport readCertificate(@WebParam(name = "certificate_id") String certificate_id) {
        CertificateTransport ct = null;
        CertificateModel c = CertificateController.readCertificate(certificate_id);
        int id_client = ClientController.getClientId(c.car.client.email);
        ct = Convertisseurs.certificateToCertificateTransport(id_client, c);
        return ct;
    }

    @WebMethod(operationName = "updateCertificateStatus")
    public ResponseTransport updateCertificateStatus(@WebParam(name = "certificate") String certificate_number, @WebParam(name = "status") String status) {
        ResponseTransport saResponse = null;
        if (certificate_number != null) {
            saResponse = Convertisseurs.responseToResponseTransport(CertificateController.updateState(certificate_number, status));
        }
        return saResponse;
    }

    @WebMethod(operationName = "updateRegistration")
    public ResponseTransport updateRegistration(@WebParam(name = "serial_number") String serial_number, @WebParam(name = "registration") String registration) {
        ResponseTransport saResponse = null;
        if (serial_number != null) {
            saResponse = Convertisseurs.responseToResponseTransport(CarController.updateRegistration(serial_number, registration));
        }
        return saResponse;
    }
}
