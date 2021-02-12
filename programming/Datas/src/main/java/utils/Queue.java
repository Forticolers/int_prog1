package utils;

import ch.jeanbourquj.cifom.Data;
import jdk.nashorn.internal.ir.annotations.Ignore;

/**
 * Permet de gérer la structure dynamique Queue/File.
 *
 * @author dominique huguenin (dominique.huguenin at rpn.ch)
 */
public class Queue {

    /**
     * Valeur queue pleine.
     */
    public static final String PILE_PLEINE = "Pile pleine!";
    /**
     * Valeur queue vide.
     */
    public static final String PILE_VIDE = "Pile vide!";
    private Integer tailleMax;
    private Integer fin;
    private Data[] valeurs;

    /**
     *
     * @param taille
     */
    public Queue(final int taille) {
        this.tailleMax = taille;
        this.fin = -1;
        this.valeurs = new Data[this.tailleMax];
    }

    /**
     *
     * @return vrai si la queue est vide
     */
    public boolean etreVide() {
        return this.fin == -1;
    }

    /**
     *
     * @return vrai si la queue est pleine
     */
    public boolean etrePlein() {
        return this.fin == this.tailleMax - 1;
    }

    /**
     *
     * @param valeur
     */
    public void ajouter(final Data valeur) throws RuntimeException {
        if (this.etrePlein()) {
            throw new RuntimeException(PILE_PLEINE);
        }
        this.fin += 1;
        this.valeurs[this.fin] = valeur;
    }

    /**
     *
     */
    public void retirer() {
        if (!this.etreVide()) {
            for (int i = 1; i < this.fin; i++) {
                this.valeurs[i - 1] = this.valeurs[i];
            }
            this.fin -= 1;
        }

    }

    /**
     *
     */
    /*public void retirerWE() throws RuntimeException {
        if (this.etreVide()) {
            throw new RuntimeException(PILE_VIDE);
        }
        for (int i = 1; i < this.fin; i++) {
            this.valeurs[i - 1] = this.valeurs[i];
        }
        this.fin -= 1;
    }*/

    /**
     *
     * @return la valeur
     */
    public Data retournerValeur() throws RuntimeException {
        if (this.etreVide()) {
            throw new RuntimeException(PILE_VIDE);
        }
        return this.valeurs[0];
    }

}
