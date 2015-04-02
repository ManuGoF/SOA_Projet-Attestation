
import ch.comem.transport.CarTransport;
import ch.comem.transport.CertificateTransport;
import ch.comem.transport.WorkerTransport;
import ch.comem.ws.insurranceWebService;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Cedric
 */
public class Programme {

    public static void main(String[] args) {
//        CarModel car = CarController.readCar("VF7 X2R FVF 7200 1110");
//        List<WorkerModel> worker = readWorker(3001);
//        System.out.println(worker.get(0));
//        System.out.println(car);
//        CertificateTransport ct = new CertificateTransport();
//        ct.setCarTransport(car);
//        ct.setWorkerTransport(worker.get(0));
//        ct.setCreationDate("2015-04-02");
//        ct.setState("en attente");
//        ResponseTransport saResponse = null;
//        if (certificateTransport != null) {
//            CertificateModel c = Convertisseurs.certificateTransportToCertificate(certificateTransport);
//            saResponse = Convertisseurs.responseToResponseTransport(CertificateController.createCertificate(c));
//        }
//        System.out.println(saResponse);
        
        insurranceWebService ws = new insurranceWebService();
        CertificateTransport ct = new CertificateTransport();
        CarTransport carT = ws.readCar("VF7 X2R FVF 7200 1110");
        List<WorkerTransport> workerT = ws.readWorker(3001);
        ct.setCar_transport(carT);
        ct.setWorker_transport(workerT.get(0));
        ct.setCreation_date("2015-04-02");
        ct.setState("en attente");
        ct.setId("ASS10 5000 2222");
        ws.createCertificate(ct);

    }

}
