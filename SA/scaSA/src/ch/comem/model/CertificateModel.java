
package ch.comem.model;

import java.util.Date;

/**
 * Permet de définir l'objet client.
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
    public final Date creation_date;
    
    /**
     * Voiture concernée par le certificat.
     */
    public final CarModel car;
    
    /**
     * Crée l'élément Client
     * @param number de type String correspondant au numero du certificat.
     * @param state de type String correspondant a l'état du certificat.
     * @param creation_date de type Date correspondant à la date de création du certificat.
     * @param car de type CarModel correspondant à la voiture concernée.
     * Attention : Lance une exception si le paramètre String number est plus élevé que 50 caractères.
     * Attention : Lance une exception si le paramètre String state est plus élevé que 20 caractères.
     * Attention : Lance une exception si le paramètre String state est différent que les valeurs admises ("en attente" | "acceptée" | "refusée").
     */
    public CertificateModel(String number, String state, Date creation_date, CarModel car) {
        if (number == null || state == null || creation_date == null || car == null) throw new RuntimeException("Certificate parameters not define");
        if (number.length() > 50 || state.length() > 20) throw new RuntimeException("One or more parameters are longer than expected");
        if (state != "en attente" || state != "non récupérée" || state != "non récupérée" || state != "non conforme") throw new RuntimeException("This state doesn't exist");
        this.number = number;
        this.state = state;
        this.creation_date = creation_date;
        this.car = car;
    }
    
}
