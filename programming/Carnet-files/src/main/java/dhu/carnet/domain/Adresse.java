package dhu.carnet.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author dominique huguenin (dominique.huguenin at rpn.ch)
 */
public class Adresse implements Serializable {

    private Integer npa;
    private String localite;
    private String rue;

    public Adresse() {
    }

    public Adresse(Adresse a) {
        this.localite = a.localite;
        this.npa = a.npa;
        this.rue = a.rue;
    }
    
    /**
     * Get the value of localite
     *
     * @return the value of localite
     */
    public String getLocalite() {
        return localite;
    }

    /**
     * Set the value of localite
     *
     * @param localite new value of localite
     */
    public void setLocalite(String localite) {
        this.localite = localite;
    }

    /**
     * Get the value of rue
     *
     * @return the value of rue
     */
    public String getRue() {
        return rue;
    }

    /**
     * Set the value of rue
     *
     * @param rue new value of rue
     */
    public void setRue(String rue) {
        this.rue = rue;
    }

    /**
     * Get the value of npa
     *
     * @return the value of npa
     */
    public Integer getNpa() {
        return npa;
    }

    /**
     * Set the value of npa
     *
     * @param npa new value of npa
     */
    public void setNpa(Integer npa) {
        this.npa = npa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.npa);
        hash = 97 * hash + Objects.hashCode(this.localite);
        hash = 97 * hash + Objects.hashCode(this.rue);
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
        final Adresse other = (Adresse) obj;
        if (!Objects.equals(this.localite, other.localite)) {
            return false;
        }
        if (!Objects.equals(this.rue, other.rue)) {
            return false;
        }
        if (!Objects.equals(this.npa, other.npa)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Adresse{" + "npa=" + npa
                + ", localite=" + localite
                + ", rue=" + rue + '}';
    }

    void update(Adresse adresse) {
        if( adresse == null){
            return;
        }

        this.npa = adresse.getNpa();
        this.localite = adresse.getLocalite();
        this.rue = adresse.getRue();
    }

}
