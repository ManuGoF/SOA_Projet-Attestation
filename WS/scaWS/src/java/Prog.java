
import ch.comem.controller.CarController;
import ch.comem.controller.CertificateController;
import ch.comem.controller.ClientController;
import ch.comem.model.ClientModel;
import ch.comem.transport.ClientTransport;
import ch.comem.transport.Convertisseurs;
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
 * @author Manu
 */
public class Prog {
    public static void main(String[] args) {
        System.out.println(CarController.updateRegistration("VF7 X2R FVF 7200 9190", "vd 1234").message);
        System.out.println(CertificateController.readAllCertificates().get(0).car.getRegistration());
    }
        
}
