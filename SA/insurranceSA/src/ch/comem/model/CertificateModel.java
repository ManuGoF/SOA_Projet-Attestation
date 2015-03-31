package ch.comem.model;

import java.util.Date;

/**
 * Permet de définir l'objet certificate.
 *
 * @author Cedric
 */
public class CertificateModel {

    /**
     * Numero du certificat (Maximum 50 charactères).
     */
    public final String number;
    /**
     * Etat du certificat (Maximum 20 charactères).
     */
    public final String state;

    /**
     * Date de création du certificat.
     */
    public final String creation_date;

    /**
     * Voiture concernée par le certificat.
     */
    public final CarModel car;

    /**
     * Employé ayant crée le certificat.
     */
    public final WorkerModel worker;

    /**
     * Crée l'élément Client
     *
     * @param number de type String correspondant au numero du certificat.
     * @param state de type String correspondant a l'état du certificat.
     * @param creation_date de type String correspondant à la date de création du
     * certificat ("2015-02-10").
     * @param car de type CarModel correspondant à la voiture concernée.
     * @param worker de type WorkerModel correspondant à l'employé ayant crée le
     * cerficat. Attention : Lance une exception si le paramètre String number
     * est plus élevé que 50 caractères. Attention : Lance une exception si le
     * paramètre String state est plus élevé que 20 caractères. Attention :
     * Lance une exception si le paramètre String state est différent que les
     * valeurs admises ("en attente" | "acceptée" | "refusée").
     */
    public CertificateModel(String number, String state, String creation_date, CarModel car, WorkerModel worker) {
        // Contrôle si les paramètres d'entrée sont fournis
        if (number == null || state == null || creation_date == null || car == null || worker == null) {
            throw new RuntimeException("Certificate parameters not define");
        }
        if (number.length() > 50 || state.length() > 20) {
            throw new RuntimeException("One or more parameters are longer than expected");
        }
        if (!state.equalsIgnoreCase("en attente") || !state.equalsIgnoreCase("acceptée") || !state.equalsIgnoreCase("refusée")) {
            throw new RuntimeException("This state doesn't exist");
        }
        this.number = number;
        this.state = state;
        this.creation_date = creation_date;
        this.car = car;
        this.worker = worker;
    }

}
