package dhu.carnet.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author dominique huguenin (dominique.huguenin at rpn.ch)
 */
public class Identifiant implements Serializable {

    private final Integer id;

    public Identifiant(Integer id) {
        this.id = id;
    }

    public Identifiant(Identifiant identifiant) {
        if (identifiant != null) {
            this.id = identifiant.getId();
        } else {
            this.id = null;
        }
    }

    public Integer getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Identifiant other = (Identifiant) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Identifiant{" + "id=" + id + '}';
    }

}
