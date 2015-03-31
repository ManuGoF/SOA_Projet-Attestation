
import ch.comem.model.CarModel;
import ch.comem.model.ClientModel;
import ch.comem.model.WorkerModel;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        ClientModel client = new ClientModel("Liengme", "Cedric", "cliengme@gmail.com", new Date(""), "B", new Date(""));
//        CarModel car = new CarModel("VF7 X2R FVF 7200 5199", "Opel", "Agila", "Break", "BLACK", 89890.0, 2006);

    }

}
