
package ch.comem.model;

import java.util.Date;

/**
 * Permet de définir l'objet client.
 * @author Cedric
 */
public class CertificateModel {
    
    /**
     * Numero de l'attestation (Maximum 50 caractères).
     */
    public final String number;
    /**
     * Etat de l'attestation (Maximum 20 caractères).
     */
    public final String state;
    
    /**
     * Date de création de l'attestation.
     */
    public final String creation_date;
    
    /**
     * Voiture concernée par l'attestation.
     */
    public final CarModel car;
    
    /**
     * Crée l'élément Certificat
     * @param number de type String correspondant au numero de l'attestation
     * @param state de type String correspondant a l'état de l'attestation
     * @param creation_date de type String correspondant à la date de création de l'attestation ("yyyy-MM-dd").
     * @param car de type CarModel correspondant à la voiture concernée.
     * Attention : Lance une exception si le paramètre String number est plus élevé que 50 caractères.
     * Attention : Lance une exception si le paramètre String state est plus élevé que 20 caractères.
     * Attention : Lance une exception si le paramètre String state est différent que les valeurs admises ("en attente" | "acceptée" | "refusée").
     */
    public CertificateModel(String number, String state, String creation_date, CarModel car) {
        if (number == null || state == null || creation_date == null || car == null) throw new RuntimeException("Certificate parameters not define");
        if (number.length() > 50 || state.length() > 20) throw new RuntimeException("One or more parameters are longer than expected");
        if (!state.equalsIgnoreCase("en attente") && !state.equalsIgnoreCase("non récupérée") && !state.equalsIgnoreCase("non récupérée") && !state.equalsIgnoreCase("non conforme")) throw new RuntimeException("This state doesn't exist");
        if (creation_date.length() > 10) {
            throw new RuntimeException("Date is longer than expected");
        }
        this.number = number;
        this.state = state;
        this.creation_date = creation_date;
        this.car = car;
    }
    
}
