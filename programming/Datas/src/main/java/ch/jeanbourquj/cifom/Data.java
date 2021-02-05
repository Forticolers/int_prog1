package ch.jeanbourquj.cifom;

import java.util.Objects;

/**
 * Classe simple permettant de d'illustrer les concepts.
 *
 * @author dominique huguenin (dominique.huguenin at rpn.ch)
 */
public class Data {

    /**
     * Valeur.
     */
    private Integer valeur;

    /**
     * Data containes an integer value.
     * @param pValeur
     */
    public Data(final Integer pValeur) {
        this.valeur = pValeur;
    }

    /**
     * Get the value of valeur.
     *
     * @return the value of valeur
     */
    public Integer getValeur() {
        return valeur;
    }

    /**
     * Set the value of valeur.
     *
     * @param pValeur new value of valeur
     */
    public void setValeur(final Integer pValeur) {
        this.valeur = pValeur;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = HASH_CODE_1;
        hash = HASH_CODE_2 * hash + Objects.hashCode(this.valeur);
        return hash;
    }
    /**
     * hashcode 2.
     */
    private static final int HASH_CODE_2 = 59;
    /**
     * hashcode 1.
     */
    private static final int HASH_CODE_1 = 3;

    /**
     *
     * @param obj
     * @return
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
        if (!Objects.equals(this.valeur,
                other.valeur)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Data{" + "valeur=" + valeur + '}';
    }

    /**
     *
     * @param data
     */
    public void update(final Data data) {
        this.valeur = data.valeur;
    }

}
