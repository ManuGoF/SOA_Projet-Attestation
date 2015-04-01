
import ch.comem.controller.CarController;
import ch.comem.controller.ClientController;
import ch.comem.model.CarModel;
import ch.comem.model.ClientModel;
import ch.comem.model.Response;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Manu
 */
public class scaProgSA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*ClientModel client1 = new ClientModel("Bezencon", "emmanuel", "emmanuel.bezencon@heig-vd.ch", "1990-02-01", "B", "2008-08-21");
        Response response1 = null;
        response1 = ClientController.createClient(client1);
        System.out.println("Réponse code : "  + response1.code);
        System.out.println("Réponse message : "  + response1.message);
        System.out.println("Réponse clé générée : "  + response1.generatedKey);*/
        
        /*ClientModel client2 = ClientController.readClient(2001);
        System.out.println("Lastname : " + client2.lastname);
        System.out.println("Firstname : " + client2.firstname);
        System.out.println("Email : " + client2.email);
        System.out.println("Birthday : " + client2.birthday);
        System.out.println("Licence type : " + client2.licence_type);
        System.out.println("Licence date : " + client2.licence_date);*/
        
        /*Response response1 = null;
        response1 = ClientController.deleteClient(2001);
        System.out.println("Réponse code : "  + response1.code);
        System.out.println("Réponse message : "  + response1.message);
        System.out.println("Réponse clé suprimée : "  + response1.generatedKey);*/
        
        /*Map<Integer, ClientModel> clients = ClientController.readAllClients();
        System.out.println("Clients : " + clients);*/
        
        /*int IDtest = ClientController.getClientId("bezencon.manu");
        System.out.println(IDtest);*/
        
        /*CarModel car1 = new CarModel("VF7 X2R FVF 7200 9190", "OPEL", "Meriva Cosmos", "Limousine", "Metalic grey", 36000.90, client2);
        Response response2 = null;
        response2 = CarController.createCar(car1);
        System.out.println("Réponse code : "  + response2.code);
        System.out.println("Réponse message : "  + response2.message);
        System.out.println("Réponse clé générée : "  + response2.generatedKey);*/
        
        /*ArrayList<CarModel> cars = CarController.readAllCars();
        System.out.println("Véhicules : " + cars);*/
        
        /*CarModel car2 = CarController.readCar("VF7 X2R FVF 7200 6160");
        System.out.println("Serial number : " + car2.serial_number);
        System.out.println("Brand : " + car2.brand);
        System.out.println("Model : " + car2.model);
        System.out.println("Type : " + car2.type);
        System.out.println("Color : " + car2.color);
        System.out.println("Price : " + car2.price);
        System.out.println("Client firstname : " + car2.client.firstname);
        System.out.println("Client lastname : " + car2.client.lastname);
        System.out.println("Client email : " + car2.client.email);
        System.out.println("Client birthday : " + car2.client.birthday);
        System.out.println("Client licence_type : " + car2.client.licence_type);
        System.out.println("Client licence_date : " + car2.client.licence_date);*/
        
        /*Response response2 = null;
        response2 = CarController.deleteCar("VF7 X2R FVF 7200 9190");
        System.out.println("Réponse code : "  + response2.code);
        System.out.println("Réponse message : "  + response2.message);
        System.out.println("Réponse clé suprimée : "  + response2.generatedKey);*/
        
        //CarController.addRegistration("VF7 X2R FVF 7200 9190", "VD 144 777");
        
        
        
    }
    
}
