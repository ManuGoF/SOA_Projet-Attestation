/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.comem.controller;

import ch.comem.model.CarModel;
import ch.comem.model.ClientModel;
import ch.comem.model.Response;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Permet de gérer des véhicules qui on les paramètres suivants:
 * serial_number, brand, model, type, color, price
 * Ce controlleur permet de faire les actions suivantes:
 * - création d'un véhicule dans la BD.
 * - récupération d'un véhicule de la BD à l'aide de son ID.
 * - suppression d'un véhicule dans la BD et les objets liés en cascade à l'aide de son ID.
 * - récupération d'une liste de clé->valeur de tous les véhicules (ID->Car).
 * @author Groupe Manu et Cédric
 */
public class CarController {
    
    // Chargement du driver odbc une fois pour toute
    static {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    // Efface le consrtucteur vide de la Javadoc
    private CarController() {}
    
    /**
     * Permet d'insérer un véhicule dans la table Cars de la BD.
     * Ce véhicule est composé des paramètres suivants:
     * serial_number, registration, brand, model, type, color, price, client
     * Si le véhicule existe déjà (selon son SERIAL_NUMBER), l'objet n'est pas créé.
     * Si l'id du client à qui appartient le véhicule n'existe pas, l'objet n'est pas créé.
     * @param car de type CarModel
     * @return response de type Response selon les résultats suivants:
     * response: -1, OK: Serial number, 0 => OK (l'opération s'est bien déroulée).
     * response: -2, The client object doesn't exist!, 0 => L'objet correspondant à l'ID client passé dans car n'existe pas dans la BD.
     * response: -3, The object already exist!, 0 => L'objet correspondant à l'ID passé en paramètre existe déjà.
     * response: -4, Parameter isn't congruent!, 0 => Paramètre idn conforme.
     * response: -5, Nothing happened, 0 => Rien ne s'est passé (l'opération n'a eu aucun effet).
     */
    public static Response createCar(CarModel car) {
        Response response = null;
        ResourceBundle R = ResourceBundle.getBundle("ch.comem.ressources.scaDBproperties");
        
        if (car != null) {
            Connection con = null;
            
            try {
                // Connection à la base de données
                con = DriverManager.getConnection(R.getString("BDurl"), R.getString("username"), R.getString("password"));
                Statement requete = con.createStatement();
            
                // Requète de sélection du véhicule (Pour vérifier l'existance)
                String requestCar = " SELECT "
                            + "*"
                            + " FROM "
                            + "Cars"
                            + " WHERE "
                            + "SERIAL_NUMBER = '" + car.serial_number.replace("'", "''") + "'";
                ResultSet exist = requete.executeQuery(requestCar);
               
                // Test si le véhicule existe déjà pour ne pas le créer à double.
                if (!exist.next()) {
                    // Récupération de l'id du client à l'aide de son objet
                    int client_id = ClientController.getClientId(car.client.email);
                    System.out.println("ID client: " + client_id);
                    if (client_id > 0) {
                        // Comme l'id est un champ auto incrémenté il n'est pas nécessaire de le définir.
                        String requestInsertCar = "INSERT INTO cars "
                                + "(SERIAL_NUMBER, BRAND, MODEL, TYPE, COLOR, PRICE, CLIENT_ID) VALUES "
                                + "('" + car.serial_number.replace("'", "''") + "', "
                                + "'" + car.brand.replace("'", "''") + "', "
                                + "'" + car.model.replace("'", "''") + "', "
                                + "'" + car.type.replace("'", "''") + "', "
                                + "'" + car.color.replace("'", "''") + "', "
                                + "" + car.price + ", "
                                + "" + client_id + ")";
                        int nbCarsAdd = requete.executeUpdate(requestInsertCar, Statement.RETURN_GENERATED_KEYS);
                        System.out.println(nbCarsAdd + " véhicule a été ajouté");
                        ResultSet ensembleTuplesAjoutes = requete.getGeneratedKeys();
                        int idTupleAjoute = 0;
                        // Comme il n'y a eu qu'un seul insert, on peut faire un if au lieu d'un while
                        if (ensembleTuplesAjoutes.next()) {
                            idTupleAjoute = ensembleTuplesAjoutes.getInt(1);
                        }
                        System.out.println("L'id du nouuveau tuple est : " + idTupleAjoute);

                        if (idTupleAjoute < 0) {
                            response = new Response(-5, "Nothing happened", 0);
                        } 
                        else {
                            response = new Response(-1, "OK: " + car.serial_number, 0);
                        }
                    }
                    else {
                        response = new Response(-2, "The client object doesn't exist!", 0);
                    }
                    
                    
                }
                else {
                    response = new Response(-3, "The object already exist!", 0);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            // fermeture de la connection à la base de données ainsi que de toutes les ressources qui lui sont associées ! (ResultSet, Statement)
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } 
        }
        else {
            response = new Response(-4, "Parameters isn't congruent!", 0);
        }
        
        return response;
    }
    
    
    /**
     * Permet d'attribuer un numéro de plaque à un véhicule dans la table Cars de la BD.
     * Ce véhicule est composé des paramètres suivants:
     * serial_number, registration, brand, model, type, color, price, client
     * Si le véhicule existe (selon son SERIAL_NUMBER), le champ registration est modifié.
     * Sinon, le véhicule n'est pas modifié.
     * @param serial_number
     * @param registration
     * @return response de type Response selon les résultats suivants:
     * response: -1, OK: Serial number, 0 => OK (l'opération s'est bien déroulée).
     * response: -2, The client object doesn't exist!, 0 => L'objet correspondant à l'ID client passé dans car n'existe pas dans la BD.
     * response: -3, The object already exist!, 0 => L'objet correspondant à l'ID passé en paramètre existe déjà.
     * response: -4, Parameter isn't congruent!, 0 => Paramètre idn conforme.
     * response: -5, Nothing happened, 0 => Rien ne s'est passé (l'opération n'a eu aucun effet).
     */

  public static Response updateRegistration(String serial_number, String registration) {
        Response response = null;
        Connection con = null;
        ResourceBundle r = ResourceBundle.getBundle("ch.comem.ressources.scaDBproperties");
        try {
            con = DriverManager.getConnection(r.getString("BDurl"), r.getString("username"), r.getString("password"));
            Statement requete = con.createStatement();
            ResultSet carExist = requete.executeQuery("SELECT * FROM cars WHERE serial_number='" + serial_number + "'");

            if (carExist.next()) {
                
                
                        String builtString;
                        builtString = "UPDATE cars SET registration = '" + registration + "' WHERE serial_number ='" + serial_number + "'";
                        requete.executeUpdate(builtString, Statement.RETURN_GENERATED_KEYS);
                        response = new Response(-1, "OK new registration : " + registration + "", 0);




            } else {
                response = new Response(-4, "Certificate doesn't exist", 0);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return response;
    }

    
    /**
     * Permet de récupérer un véhicule de la table Cars de la BD.
     * Ce véhicule est composé des paramètres suivants:
     * serial_number, registration, brand, model, type, color, price, client
     * Si le véhicule n'existe pas (selon son SERIAL_NUMBER), l'objet n'est pas retourné.
     * Si le véhicule SERIAL_NUMBER n'est pas conforme, l'objet n'est pas retourné.
     * @param serial_number de type String correspondant au numéro de série du véhicule souhaité.
     * @return car de type CarModel correspondant au véhicule souhaité s'il existe.
     */
    public static CarModel readCar(String serial_number) {
        
        ResourceBundle R = ResourceBundle.getBundle("ch.comem.ressources.scaDBproperties");
        
        String serialNumberGet = "";
        String registrationGet = "";
        String brandGet = "";
        String modelGet = "";
        String typeGet = "";
        String colorGet = "";
        Double priceGet = null;
        ClientModel clientGet = null;
        
        if (serial_number != null) {
            
            Connection con = null;

            try {
                
                // Connection à la base de données
                con = DriverManager.getConnection(R.getString("BDurl"), R.getString("username"), R.getString("password"));
                Statement requete = con.createStatement();
                
                // Requète de selection du car (Pour vérifier l'existance)
                String requestCarExist = " SELECT "
                            + "*"
                            + " FROM "
                            + "Cars"
                            + " WHERE "
                            + "SERIAL_NUMBER = " + "'" + serial_number + "'";
                ResultSet existCar = requete.executeQuery(requestCarExist);
                
                // Test si le véhicule existe dans la BD.
                if (existCar.next()) {
                    ResultSet carGet = requete.executeQuery(
                            "SELECT "
                            + "*"
                            + " FROM "
                            + "Cars"
                            + " WHERE "
                            + "SERIAL_NUMBER = " + "'" + serial_number + "'");

                    while (carGet.next()) {
                        // Récupération du client à qui appartient le véhicule
                        int client_id = carGet.getInt("CLIENT_ID");
                        
                        serialNumberGet = carGet.getString("SERIAL_NUMBER");
                        registrationGet = carGet.getString("REGISTRATION");
                        brandGet = carGet.getString("BRAND");
                        modelGet = carGet.getString("MODEL");
                        typeGet = carGet.getString("TYPE");
                        colorGet = carGet.getString("COLOR");
                        priceGet = carGet.getDouble("PRICE");
                        clientGet = ClientController.readClient(client_id);
                    }
                }
                else {
                    System.out.println("Le Car SERIAL_NUMBER fourni n'existe pas!");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            // fermeture de la connection à la base de données ainsi que de toutes les ressources qui lui sont associées ! (ResultSet, Statement)
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            
        } else {
            System.out.println("Le Car SERIAL_NUMBER n'est pas conforme");
        }
        
        CarModel car = new CarModel(
            serialNumberGet,
            brandGet,
            modelGet,
            typeGet,
            colorGet,
            priceGet,
            clientGet
        );
        car.setRegistration(registrationGet);

        return car;
    }
    
    
    /**
     * Permet de supprimer un véhicule à l'aide de son ID.
     * Cette méthode supprime le véhicule dans la table Cars de la BD.
     * Cette méthode supprime en cascade dans la BD les objets qui sont liés au véhicule supprimé.
     * -> Cars -> Certifications -> Comments
     * @param serial_number de type String correspondant au véhicule à supprimer.
     * @return response de type Response selon les résultats suivants:
     * response: -1, OK: Serial number, 0 => OK (l'opération s'est bien déroulée).
     * response: -2, The object doesn't exist!, 0 => L'objet correspondant à l'ID passé en paramètre n'existe pas dans la BD.
     * response: -3, The object already exist!, 0 => L'objet correspondant à l'ID passé en paramètre existe déjà.
     * response: -4, Parameter isn't congruent!, 0 => Paramètre idn conforme.
     * response: -5, Nothing happened, 0 => Rien ne s'est passé (l'opération n'a eu aucun effet).
     */
    public static Response deleteCar(String serial_number) {
        Response response = null;
        ResourceBundle R = ResourceBundle.getBundle("ch.comem.ressources.scaDBproperties");
        
        if (serial_number != null) {
            Connection con = null;
            try {
                // Connection à la base de données
                con = DriverManager.getConnection(R.getString("BDurl"), R.getString("username"), R.getString("password"));
                Statement requete = con.createStatement();
                
                String requestCarExist = " SELECT "
                            + "*"
                            + " FROM "
                            + "Cars"
                            + " WHERE "
                            + "SERIAL_NUMBER = " + "'" + serial_number + "'";
                
                ResultSet existCar = requete.executeQuery(requestCarExist);
                if (existCar.next()) {
                
                    String requestDeleteCar = "DELETE FROM Cars"
                            + " WHERE "
                            + "SERIAL_NUMBER = " + "'" + serial_number + "'";
                    int carDelete = requete.executeUpdate(requestDeleteCar);
                    System.out.println(carDelete + " véhicule supprimé");
                    response = new Response(-1, "OK: " + serial_number, 0);
                }
                else {
                    response = new Response(-2, "The object doesn't exist!", 0);
                    System.out.println("Le car SERIAL_NUMBER n'existe pas. Rien n'a été supprimé.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            // fermeture de la connection à la base de données ainsi que de toutes les ressources qui lui sont associées ! (ResultSet, Statement)
            try {
                con.close();
            } catch (SQLException e) {
                e.getMessage();
            }
        }
        else {
            response = new Response(-4, "Parameter isn't congruent!", 0);
        }
        
        return response;
    }
    
    
    /**
     * Permet de récupérer tous les véhiculess existants (dans la table Cars de la BD).
     * @return une liste ArrayList<CarModel> correspondant à une liste de véhicule avec le Client à qui appartient le véhicule.
     * La liste retournée comprends les véhicules dans la base de donnée. Si la BD est vide, une liste vide est retournée.
     */
    public static ArrayList<CarModel> readAllCars() {
        ArrayList <CarModel> cars = new ArrayList<>();
        
        ResourceBundle R = ResourceBundle.getBundle("ch.comem.ressources.scaDBproperties");
        
        Connection con = null;

        try {
            // Connection à la base de données
            con = DriverManager.getConnection(R.getString("BDurl"), R.getString("username"), R.getString("password"));
            Statement requete = con.createStatement();
                
            ResultSet allCars = requete.executeQuery("SELECT * FROM Cars");
            // Parcours de l'ensemble de véhicules et ajoute à la liste avec l'id.
            while (allCars.next()) {
                // Récupération du client à qui appartient le véhicule
                int client_id = allCars.getInt("CLIENT_ID");
                ClientModel client = ClientController.readClient(client_id);
                CarModel car = new CarModel(
                    allCars.getString("SERIAL_NUMBER"),
                    allCars.getString("BRAND"), 
                    allCars.getString("MODEL"),
                    allCars.getString("TYPE"),
                    allCars.getString("COLOR"),
                    allCars.getDouble("PRICE"),
                    client
                );
                car.setRegistration(allCars.getString("REGISTRATION"));
                cars.add(car);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // fermeture de la connection à la base de données ainsi que de toutes les ressources qui lui sont associées ! (ResultSet, Statement)
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }     
        return cars;
    }
    
        
}
