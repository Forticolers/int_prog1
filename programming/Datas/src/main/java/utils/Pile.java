/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import ch.jeanbourquj.cifom.Data;
import jdk.nashorn.internal.ir.annotations.Ignore;

/**
 *
 * @author JeanbourquJ
 */
public class Pile {

    /**
     * Valeur d'exception pile vide.
     */
    public static final String PILE_VIDE = "La pile est vide.";
    /**
     * Valeur d'exception pile pleine.
     */
    public static final String PILE_PLEINE = "La pile est pleine.";
    /**
     * Taille maximale.
     */
    private Integer tailleMax;
    /**
     * Sommet actuel.
     */
    private Integer sommet;
    /**
     * Tableau de valuer Data.
     */
    private Data[] valeurs;
    /**
     * Valeur contsante de la taille maximale.
     */
    public static final int TAILLE_MAX_PILE = 5;

    /**
     * Une pile a une taille maximale de 5.
     */
    public Pile() {
        this.tailleMax = TAILLE_MAX_PILE;
        this.sommet = -1;
        this.valeurs = new Data[this.tailleMax];
    }

    /**
     * Une pile de taille taillePile.
     *
     * @param taillePile
     */
    Pile(final int taillePile) {
        this.tailleMax = taillePile;
        this.sommet = -1;
        this.valeurs = new Data[this.tailleMax];
    }

    /**
     * Retourne vrai si la pile est vide.
     *
     * @return true if pile is empty.
     */
    public boolean etreVide() {
        return this.sommet == -1;
    }

    /**
     * Ajoute une entrée à la pile.
     *
     * @param d data-
     * @throws Exception if pile is full.
     */
    public void empiler(final Data d) throws RuntimeException {
        if (this.etrePlein()) {
            throw new RuntimeException(PILE_PLEINE);
        }

        this.sommet += 1;
        this.valeurs[this.sommet] = d;
    }

    /**
     * Retire la denière entrée de la pile.
     *
     * @throws Exception if pile is empty.
     */
   /* public void depilerWE() throws Exception {
        if (this.etreVide()) {
            throw new Exception(PILE_VIDE);
        }

        this.valeurs[this.sommet] = null;
        this.sommet -= 1;
    }*/

    /**
     * Retire la denière entrée de la pile.
     *
     */
    public void depiler() {
        if (!this.etreVide()) {
            this.valeurs[this.sommet] = null;
            this.sommet -= 1;
        }
    }

    /**
     * Retourne le sommet de la pile.
     *
     * @return Data.
     * @throws Exception if empty.
     */
    public Data retournerSommet() throws Exception {
        if (this.etreVide()) {
            throw new Exception("La pile est vide.");
        }
        return this.valeurs[this.sommet];
    }

    /**
     * Retourne vrai si la pile est pleine.
     *
     * @return true if pile is full.
     */
    public boolean etrePlein() {
        return this.sommet == this.tailleMax - 1;
    }
}
