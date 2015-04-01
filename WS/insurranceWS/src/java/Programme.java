
import ch.comem.controller.CertificateController;
import ch.comem.controller.ClientController;
import ch.comem.controller.WorkerController;
import ch.comem.model.CertificateModel;
import ch.comem.model.WorkerModel;
import ch.comem.transport.CertificateTransport;
import ch.comem.transport.Convertisseurs;
import ch.comem.transport.WorkerTransport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        List<WorkerTransport> listWt = new ArrayList<>();
        Map<Integer, WorkerModel> workers = WorkerController.readWorker(2001);
        for (Map.Entry<Integer, WorkerModel> entry : workers.entrySet()) {
            WorkerTransport wt = Convertisseurs.WorkerToWorkerTransport(entry.getKey(), entry.getValue());
            listWt.add(wt);
        }
        System.out.println(listWt);

    }

}
