/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.comem.ws;

import ch.comem.controller.CertificateController;
import ch.comem.controller.ClientController;
import ch.comem.controller.WorkerController;
import ch.comem.model.CertificateModel;
import ch.comem.model.WorkerModel;
import ch.comem.transport.CertificateTransport;
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
 *
 * @author Cedric
 */
@WebService(serviceName = "wsCedric")
@Stateless()
public class wsCedric {

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
            int id_worker = WorkerController.getWorkerId(c.worker.email);
            CertificateTransport certt = Convertisseurs.certificateToCertificateTransport(id_client, id_worker, c);
            listCt.add(certt);
        }

        return listCt;
    }

    @WebMethod(operationName = "readCertificate")
    public CertificateTransport readCertificate(@WebParam(name = "certificate_id") String certificate_id) {
        CertificateTransport ct = null;
        CertificateModel c = CertificateController.readCertificate(certificate_id);
        int id_client = ClientController.getClientId(c.car.client.email);
        int id_worker = WorkerController.getWorkerId(c.worker.email);
        ct = Convertisseurs.certificateToCertificateTransport(id_client, id_worker, c);
        return ct;
    }

    @WebMethod(operationName = "updateCertificateWorker")
    public ResponseTransport updateCertificateWorker(@WebParam(name = "certificate") String certificate_number, @WebParam(name = "worker") int worker_id) {
        ResponseTransport saResponse = null;
        if (certificate_number != null) {
            saResponse = Convertisseurs.responseToResponseTransport(CertificateController.updateWorker(certificate_number, worker_id));
        }
        return saResponse;
    }

    @WebMethod(operationName = "updateCertificateStatus")
    public ResponseTransport updateCertificateStatus(@WebParam(name = "certificate") String certificate_number, @WebParam(name = "status") String status) {
        ResponseTransport saResponse = null;
        if (certificate_number != null) {
            saResponse = Convertisseurs.responseToResponseTransport(CertificateController.updateState(certificate_number, status));
        }
        return saResponse;
    }

    @WebMethod(operationName = "createWorker")
    public ResponseTransport createWorker(@WebParam(name = "worker") WorkerTransport workerTransport) {
        ResponseTransport saResponse = null;
        if (workerTransport != null) {
            WorkerModel w = Convertisseurs.workerTransportToWorker(workerTransport);
            saResponse = Convertisseurs.responseToResponseTransport(WorkerController.createWorker(w));
        }
        return saResponse;
    }

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
