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
}
