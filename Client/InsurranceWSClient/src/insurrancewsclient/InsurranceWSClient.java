/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insurrancewsclient;

import ch.comem.ws.CarTransport;
import ch.comem.ws.CertificateTransport;
import ch.comem.ws.ResponseTransport;
import ch.comem.ws.WorkerTransport;
import java.util.List;

/**
 *
 * @author Manu
 */
public class InsurranceWSClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CarTransport car = readCar("VF7 X2R FVF 7200 1110");
        List<WorkerTransport> worker = readWorker(3001);
        System.out.println(worker.get(0));
        System.out.println(car);
        CertificateTransport ct = new CertificateTransport();
        ct.setCarTransport(car);
        ct.setWorkerTransport(worker.get(0));
        ct.setCreationDate("2015-04-02");
        ct.setState("en attente");
        ct.setId("ASS10 5000 5555");
        System.out.println(createCertificate(ct).getMessage());        
        
    }

    private static ResponseTransport createCertificate(ch.comem.ws.CertificateTransport certificate) {
        ch.comem.ws.InsurranceWebService_Service service = new ch.comem.ws.InsurranceWebService_Service();
        ch.comem.ws.InsurranceWebService port = service.getInsurranceWebServicePort();
        return port.createCertificate(certificate);
    }

    private static java.util.List<ch.comem.ws.WorkerTransport> readWorker(int worker) {
        ch.comem.ws.InsurranceWebService_Service service = new ch.comem.ws.InsurranceWebService_Service();
        ch.comem.ws.InsurranceWebService port = service.getInsurranceWebServicePort();
        return port.readWorker(worker);
    }

    private static CarTransport readCar(java.lang.String serialNumber) {
        ch.comem.ws.InsurranceWebService_Service service = new ch.comem.ws.InsurranceWebService_Service();
        ch.comem.ws.InsurranceWebService port = service.getInsurranceWebServicePort();
        return port.readCar(serialNumber);
    }
    
}
