/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.comem.ws;

import ch.comem.controller.ClientController;
import ch.comem.model.ClientModel;
import ch.comem.model.Response;
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
@WebService(serviceName = "inssuranceManuWS")
@Stateless()
public class inssuranceManuWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
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
     * @return 
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
     * Web service operation
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
}
