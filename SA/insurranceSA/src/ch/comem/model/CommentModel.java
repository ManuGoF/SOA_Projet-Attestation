/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.comem.model;

/**
 * Permet de définir l'objet Comment.
 * @author Cedric
 */
public class CommentModel {
    
    /**
     * Le texte du commentaire (Maximum 100 caractères).
     */
    public final String text;
    
     /**
     * Le certificat commenté.
     */
    public final CertificateModel certificate;
    
     /**
     * L'employé ayant rédigé le commentaire.
     */
    public final WorkerModel worker;
    
    /**
     * Crée l'objet comment.
     * @param text de type String correspondant au texte du commentaire.
     * @param certificate de type CertificateModel correspondant au cerfificat commenté.
     * @param worker de type WorkerModel correspondant à l'employé ayant rédigé le commentaire.
     * Attention renvoie une exception si les paramètres ne sont pas définis.
     * Attention renvoie une exception si la longueur du texte est plus longue que 100 caracteres.
     */
    public CommentModel(String text, CertificateModel certificate, WorkerModel worker) {
      if (text == null || certificate == null || worker == null) throw new RuntimeException("Comment parameters not define");
        if (text.length() > 100) throw new RuntimeException("Comment is longer than expected");   
        this.text = text;
        this.certificate = certificate;
        this.worker = worker;
    }
    
}
