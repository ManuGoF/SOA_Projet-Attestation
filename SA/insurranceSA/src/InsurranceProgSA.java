
import ch.comem.controller.ClientController;
import ch.comem.model.ClientModel;
import ch.comem.model.WorkerModel;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
        WorkerModel worker = new WorkerModel("Liengme", "Cedric", "clie@ail.com", "garage");
        System.out.println(worker);

        Date maintenant = new Date(System.currentTimeMillis());
        java.util.Date deuxJanvier1990 = null;
        java.util.Date vingtetunAout2008 = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false); // pour lancer une exception en cas de date non valide
            deuxJanvier1990 = sdf.parse("02/01/1990");
            vingtetunAout2008 = sdf.parse("21/08/2008");

            ClientModel client1 = new ClientModel("Bezencon", "emmanuel", "emmanuel.bezencon@heig-vd.ch", new Date(deuxJanvier1990.getTime()), "B", new Date(vingtetunAout20080.getTime()));
            ClientController.createClient(null);
            
        } catch (ParseException e) {
       }
    }
}
