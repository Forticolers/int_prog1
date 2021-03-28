package dhu.carnet.console;

import dhu.carnet.domain.Carnet;
import dhu.carnet.domain.CarnetPleinException;
import dhu.carnet.domain.Contact;
import dhu.carnet.domain.ContactInconnuException;
import dhu.carnet.domain.Identifiant;

/**
 *
 * @author dominique huguenin (dominique.huguenin at rpn.ch)
 */
public class Controler {

    private Vue vue;
    private Carnet carnet;

    public Controler() {
    }

    public Controler(Carnet carnet) {
        this.carnet = carnet;
        this.vue = new Vue();
    }

    public void execute() {
        Contact contact;
        Action action;
        do {
            action = vue.saisirAction();

            switch (action) {
                case AFFICHER:
                    vue.afficherTitre(Vue.TITRE_AFFICHER);
                    vue.afficherCarnet(carnet);
                    break;

                case AJOUTER:
                    vue.afficherTitre(Vue.TITRE_AJOUTER);
                    contact = vue.saisirContact(new Contact());
                    vue.afficher(contact);
                    if (vue.accepterModification()) {
                        try {
                            contact = carnet.ajouter(contact);
                            vue.afficher(contact);
                        } catch (CarnetPleinException ex) {
                            vue.afficherMessage("Erreur: le carnet est plein!");
                        }
                    }
                    break;

                case MODIFIER:
                    vue.afficherTitre(Vue.TITRE_MODIFIER);
                    try {
                        Identifiant identifiant = vue.saisirIdentifiant();
                        contact = carnet.rechercherContact(identifiant);
                        if (contact != null) {
                            contact = vue.saisirContact(contact);
                            vue.afficher(contact);
                            if (vue.accepterModification()) {
                                carnet.modifier(contact);
                            }
                        }
                    } catch (ContactInconnuException ex) {
                        vue.afficherMessage(ex.getMessage());
                    }
                    break;
                case SUPPRIMER:
                    vue.afficherTitre(Vue.TITRE_SUPPRIMER);
                    Identifiant identifiant = vue.saisirIdentifiant();
                    contact = carnet.rechercherContact(identifiant);
                    if (contact != null) {
                        vue.afficher(contact);
                        if (vue.accepterModification()) {
                            carnet.supprimer(contact);
                        }
                    }
                    break;
            }
        } while (!Action.QUITTER.equals(action));
    }

}
