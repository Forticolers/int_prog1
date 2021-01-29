/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.jeanbourquj.cifom;

import java.util.Objects;

/**
 *
 * @author JeanbourquJ
 */
public class Data {
    /**
     * Paramètre Integer valeur.
     */
    private Integer valeur;
    /**
     * @param v Valeure Integer
     */
    public Data(final Integer v) {
        this.valeur = v;
    }
    /**
     * @return Integer
     */
    public Integer getValeur() {
        return valeur;
    }
    /**
     * @param v
     */
    public void setValeur(final Integer v) {
        this.valeur = v;
    }
    /**
     * @param d Data object
     */
    public void update(final Data d) {
        this.setValeur(d.getValeur());
    }
    /**
     * @return hashcode
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.valeur);
        return hash;
    }
    /**
     * @param obj
     * @return True si les contenus de l'objet en paramètre sont identique.
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Data other = (Data) obj;
        if (!Objects.equals(this.valeur, other.valeur)) {
            return false;
        }
        return true;
    }
    /**
     * @return Une String affichant la valeur
     */
    @Override
    public String toString() {
        return "Data{" + "valeur=" + valeur + '}';
    }
}
