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
    private Integer valeur;

    public Data(Integer valeur) {
        this.valeur = valeur;
    }

    public Integer getValeur() {
        return valeur;
    }

    public void setValeur(Integer valeur) {
        this.valeur = valeur;
    }
   
    public void Update(Data d){
        this.setValeur(d.getValeur());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.valeur);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
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

    @Override
    public String toString() {
        return "Data{" + "valeur=" + valeur + '}';
    }
}
