
import ch.comem.controller.CertificateController;
import ch.comem.controller.ClientController;
import ch.comem.controller.WorkerController;
import ch.comem.model.CertificateModel;
import ch.comem.transport.CertificateTransport;
import ch.comem.transport.Convertisseurs;
import java.util.ArrayList;
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
        List<CertificateTransport> listCt = new ArrayList<>();
        ArrayList<CertificateModel> cert = CertificateController.readAllCertificates();
        for (int i = 0; i < cert.size(); i++) {
            CertificateModel c = cert.get(i);
            int id_client = ClientController.getClientId(c.car.client.email);
            int id_worker = WorkerController.getWorkerId(c.worker.email);
            CertificateTransport certt = Convertisseurs.certificateToCertificateTransport(id_client, id_worker, c);
            listCt.add(certt);
        }

        System.out.println(listCt);
    }

}
