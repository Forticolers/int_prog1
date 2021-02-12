/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import ch.jeanbourquj.cifom.Data;

/**
 *
 * @author JeanbourquJ
 */
public class QueueCirculaire {

    private Integer tailleMax;
    private Integer number;
    private Integer tete;
    private Integer fin;
    private Data[] valeurs;
    public static final String PILE_PLEINE = "Pile pleine!";
    public static final String PILE_VIDE = "Pile vide!";

    public QueueCirculaire(int tailleQueue) {
        this.tailleMax = tailleQueue;
        this.number = 0;
        this.tete = -1;
        this.fin = -1;
        this.valeurs = new Data[this.tailleMax];
    }

    public void ajouter(Data data) throws RuntimeException {
        if (this.etrePlein()) {
            throw new RuntimeException(PILE_PLEINE);
        }
        if (this.number == 0) {
            this.tete = 0;
            this.fin = 0;
        }
        else{
            this.fin += 1;
            if(this.fin >= this.tailleMax){
                this.fin = 0;
            }
        }
        this.number += 1;
        this.valeurs[this.fin] = data;
    }

    public void retirer() {
        if(!this.etreVide()){
            this.number -=1;
            this.tete +=1;
            if(this.tete >= this.tailleMax){
                this.tete = 0;
            }
        }
    }

    public Data retournerValeur() throws RuntimeException{
        if(this.etreVide()){
            throw new RuntimeException(PILE_VIDE);
        }
        return this.valeurs[this.tete];
    }

    public boolean etrePlein() {
        return this.number == this.tailleMax;
    }

    public boolean etreVide() {
        return this.number == 0;
    }
}
