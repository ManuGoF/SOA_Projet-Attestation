
import ch.comem.controller.CertificateController;
import ch.comem.controller.WorkerController;
import ch.comem.model.WorkerModel;
import ch.comem.controller.CarController;
import ch.comem.controller.ClientController;
import ch.comem.model.CarModel;
import ch.comem.model.ClientModel;
import java.util.ArrayList;



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
       
        /*WorkerModel worker = new WorkerModel("Liengme", "Cedric", "clie@ail.com", "garage");
        System.out.println(worker);
        ClientModel client = new ClientModel("Liengme", "Cedric", "cliengme@gmail.com", "1988-02-22", "B", "2015-03-31");
        System.out.println(client);
        CarModel car = new CarModel("VF7 X2R FVF 7200 5199", "Opel", "Agila", "Break", "BLACK", 89890.0, client);
        CertificateModel certificat = new CertificateModel("ASS10 5000 5006", "en attente", "2015-03-31", car, worker);
        
        System.out.println(CertificateController.createCertificate(certificat).message);


        System.out.println(CertificateController.readAllCertificates().get(1).car.client.lastname);
        System.out.println(CertificateController.updateState("ASS10 5000 1001", "acceptée").message);
        WorkerModel worker = new WorkerModel("Liengme", "Cedric", "clie@ail.com", "garage");
        System.out.println(worker);
        CarModel car = new CarModel("VF7 X2R FVF 7200 5199", "Opel", "Agila", "Break", "BLACK", 89890.0, 2006);*/
        
        /*ClientModel client1 = new ClientModel("Bezencon", "emmanuel", "emmanuel.bezencon@heig-vd.ch", "1990-02-01", "B", "2008-08-21");
        Response response1 = null;
        response1 = ClientController.createClient(client1);
        System.out.println("Réponse code : "  + response1.code);
        System.out.println("Réponse message : "  + response1.message);
        System.out.println("Réponse clé générée : "  + response1.generatedKey);*/
        
        /*ClientModel client2 = ClientController.readClient(2004);
        System.out.println("Lastname : " + client2.lastname);
        System.out.println("Firstname : " + client2.firstname);
        System.out.println("Email : " + client2.email);
        System.out.println("Birthday : " + client2.birthday);
        System.out.println("Licence type : " + client2.licence_type);
        System.out.println("Licence date : " + client2.licence_date);*/
        
        /*Response response1 = null;
        response1 = ClientController.deleteClient(2005);
        System.out.println("Réponse code : "  + response1.code);
        System.out.println("Réponse message : "  + response1.message);
        System.out.println("Réponse clé suprimée : "  + response1.generatedKey);*/
        
        /*Map<Integer, ClientModel> clients = ClientController.readAllClients();
        System.out.println("Clients : " + clients);*/
        
        /*int IDtest = ClientController.getClientId("bezencon.manu");
        System.out.println(IDtest);*/
        
        /*CarModel car1 = new CarModel("VF7 X2R FVF 7200 6160", "OPEL", "Meriva Cosmos", "Limousine", "Metalic grey", 36000.90, client2);
        Response response2 = null;
        response2 = CarController.createCar(car1);
        System.out.println("Réponse code : "  + response2.code);
        System.out.println("Réponse message : "  + response2.message);
        System.out.println("Réponse clé générée : "  + response2.generatedKey);*/
        
        /*ArrayList<CarModel> cars = CarController.readAllCars();
        System.out.println("Véhicules : " + cars);*/
        
        

    }

}
