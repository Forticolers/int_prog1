package dhu.carnet.domain;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author dominique huguenin (dominique.huguenin at rpn.ch)
 */
public class Contact {

    private Identifiant identifiant;

    private String nom;

    private LocalDate dateNaissance;

    private Adresse adresse;

    public Contact(Identifiant id) {
        this.identifiant = id;
    }

    public Contact() {
    }

    public Contact(Contact c) {
        if (c != null) {
            this.identifiant = c.getIdentifiant() != null
                    ? new Identifiant(c.getIdentifiant()) : null;
            this.nom = c.getNom();
            this.dateNaissance = c.getDateNaissance();
            this.adresse = c.getAdresse() != null
                    ? new Adresse(c.getAdresse()) : null;
        }
    }

    public Identifiant getIdentifiant() {
        return identifiant;
    }

    /**
     * Get the value of dateNaissance
     *
     * @return the value of dateNaissance
     */
    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    /**
     * Set the value of dateNaissance
     *
     * @param dateNaissance new value of dateNaissance
     */
    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    /**
     * Get the value of nom
     *
     * @return the value of nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Set the value of nom
     *
     * @param nom new value of nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.identifiant);
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
        final Contact other = (Contact) obj;
        if (!Objects.equals(this.identifiant, other.identifiant)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Contact{" + "identifiant=" + identifiant
                + ", nom=" + nom
                + ", dateNaissance=" + dateNaissance
                + ", adresse=" + adresse + '}';
    }

    void update(Contact contact) {
        this.nom = contact.getNom();
        this.dateNaissance = contact.getDateNaissance();
        
        if (contact.getAdresse() != null) {
            if (this.adresse == null) {
                this.adresse = new Adresse();
            }
            this.adresse.update(contact.getAdresse());
        } else {
            this.adresse = null;
        }

    }

}
