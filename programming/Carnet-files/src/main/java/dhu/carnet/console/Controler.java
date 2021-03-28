package dhu.carnet.console;

import dhu.carnet.domain.Carnet;
import dhu.carnet.domain.CarnetPleinException;
import dhu.carnet.domain.Contact;
import dhu.carnet.domain.ContactInconnuException;
import dhu.carnet.domain.Identifiant;
import dhu.carnet.files.ContactReader;
import dhu.carnet.files.ContactWriter;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dominique huguenin (dominique.huguenin at rpn.ch)
 */
public class Controler {

    private Vue vue;
    private Carnet carnet;
    private String filePath;
    private boolean bRead;

    public Controler() {
        this(new Carnet());
    }

    public Controler(Carnet carnet) {
        this(carnet, DEFAULT_FILEPATH);
    }
    public static final String DEFAULT_FILEPATH = "contacts.txt";

    public Controler(Carnet carnet, String vPathfile) {
        this(carnet, vPathfile, false);
    }

    public Controler(Carnet carnet, boolean vRead) {
        this(carnet, DEFAULT_FILEPATH, vRead);
    }

    public Controler(Carnet carnet, String vPathFile, boolean vRead) {
        this.carnet = carnet;
        this.vue = new Vue();
        this.filePath = vPathFile;
        this.bRead = vRead;
    }

    private void writeFile() {
        ContactWriter writer = new ContactWriter(carnet.getContacts(), filePath);
        writer.writeInFile();
    }

    public void execute() {
        Contact contact;
        Action action;
        boolean bNotQuit = false;

        if (bRead) {
            ContactReader reader = new ContactReader(this.filePath);
            this.carnet = reader.readFile();
        }

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
                case QUITTER:
                    writeFile();
                    bNotQuit = true;
                    break;
                case DEMO: {
                    try {
                        this.carnet = Carnet.getInstanceDeDemo();
                    } catch (CarnetPleinException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                }
                case WRITE:{
                    writeFile();
                }
            }
        } while (!bNotQuit);
    }

}
