/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.comem.ws;

import ch.comem.controller.CertificateController;
import ch.comem.model.CertificateModel;
import ch.comem.transport.CertificateTransport;
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
 * @author Cedric
 */
@WebService(serviceName = "wsCedric")
@Stateless()
public class wsCedric {

    /**
     * Permet de céer un nouveau bateau.
     *
     * @param certificateTransport
     * @return saResponse la réponse du ws (ResponseTransport)
     */
    @WebMethod(operationName = "createCertificate")
    public ResponseTransport createBoat(@WebParam(name = "certificate") CertificateTransport certificateTransport) {
        ResponseTransport saResponse = null;
        if (certificateTransport != null) {
            CertificateModel c = Convertisseurs.certificateTransportToCertificate(certificateTransport);
            saResponse = Convertisseurs.responseToResponseTransport(CertificateController.createCertificate(c));
        }

        return saResponse;
    }
    

}
