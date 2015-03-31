
import ch.comem.controller.CertificateController;
import ch.comem.controller.WorkerController;
import ch.comem.model.WorkerModel;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Manu
 */
public class InsurranceProgSA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
//        WorkerModel worker = new WorkerModel("Liengme", "Cedric", "clie@ail.com", "garage");
//        System.out.println(worker);
//        ClientModel client = new ClientModel("Liengme", "Cedric", "cliengme@gmail.com", "1988-02-22", "B", "2015-03-31");
//        System.out.println(client);
//        CarModel car = new CarModel("VF7 X2R FVF 7200 5199", "Opel", "Agila", "Break", "BLACK", 89890.0, client);
//        CertificateModel certificat = new CertificateModel("ASS10 5000 5006", "en attente", "2015-03-31", car, worker);
//        
//        System.out.println(CertificateController.createCertificate(certificat).message);
//  
        
//        System.out.println(CertificateController.readAllCertificates().get(1).car.client.lastname);
//        System.out.println(CertificateController.updateState("ASS10 5000 1001", "acceptée").message);
        
        
//        WorkerModel worker = new WorkerModel("Liengme", "Cedric", "cliengme@gmail.com", "direction");
//        System.out.println(WorkerController.createWorker(worker).message);
        
//        System.out.println(CertificateController.readCertificate("ASS10 5000 1001").car.brand);
        System.out.println(WorkerController.readAllWorkers());

    }

}
