package ap.fichier;

import ap.fichier.texte.ContactInputStream;
import ap.fichier.texte.ContactOutputStream;
import carnet.domain.Contact;
import ap.fichier.texte.ContactReader;
import ap.fichier.texte.ContactWriter;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author dominique huguenin <dominique.huguenin at rpn.ch>
 */
public class FichierContacts {

    private static final Logger LOG
            = Logger.getLogger(FichierContacts.class.getName());

    private final File fichier;
    private final Format format;

    public FichierContacts(File fichier, Format format) {
        if (fichier == null) {
            throw new RuntimeException("Erreur: nom de fichier inconnue!");
        }

        if (format == null) {
            throw new RuntimeException("Erreur: format de fichier inconnue!");
        }

        this.fichier = fichier;
        this.format = format;
    }

    public void ecrire(List<Contact> contacts) {

        switch (format) {
            case TEXTE:
                ecrireFichierTexte1(contacts);
                break;
            case BINAIRE:
                ecrireFichierBinaire(contacts);
            case OBJET:
                ecrireFichierObjet(contacts);
            default:
                throw new RuntimeException("Erreur: format de fichier non taité!");
        }
    }

    public List<Contact> lire() {
        List<Contact> contacts = new ArrayList<>();
        switch (format) {
            case TEXTE:
                contacts = lireFichierTexte1();
                break;
            case BINAIRE:
                contacts = lireFichierBinaire();
            case OBJET:
                contacts = lireFichierObjet();
            default:
                throw new RuntimeException("Erreur: format de fichier non taité!");
        }
        return contacts;
    }

    private List<Contact> lireFichierObjet() {
        List<Contact> contacts = new ArrayList<>();
        try (ContactInputStream inputStream
                = new ContactInputStream(
                        new ObjectInputStream(
                                new FileInputStream(fichier)))) {
            try {
                Contact c = null;
                while (true) {
                    c = inputStream.readObject();;
                    if (c == null) {
                        break;
                    }
                    contacts.add(c);
                }

            } catch (EOFException ex) {

            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return contacts;
    }

    private void ecrireFichierObjet(List<Contact> contacts) {
        try (ContactOutputStream outputStream
                = new ContactOutputStream(
                        new ObjectOutputStream(
                                new FileOutputStream(fichier)))) {
            contacts.forEach(c -> {
                outputStream.writeObject(c);
            });
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private List<Contact> lireFichierBinaire() {
        List<Contact> contacts = new ArrayList<>();
        try (ContactInputStream inputStream
                = new ContactInputStream(
                        new DataInputStream(
                                new FileInputStream(fichier)))) {
            try {
                Contact c;
                while (true) {
                    c = inputStream.readBinary();
                    if (c == null) {
                        break;
                    }
                    contacts.add(c);
                }
            } catch (EOFException ex) {

            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return contacts;
    }

    private void ecrireFichierBinaire(List<Contact> contacts) {
        try (ContactOutputStream outputStream
                = new ContactOutputStream(
                        new DataOutputStream(
                                new FileOutputStream(fichier)))) {
            contacts.forEach(c -> {
                outputStream.writeBinary(c);
            });
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void ecrireFichierTexte1(List<Contact> contacts) {
        try (ContactWriter writer
                = new ContactWriter(
                        new PrintWriter(
                                new FileWriter(fichier)))) {
            for (Contact c : contacts) {
                writer.write(c);
            }

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private List<Contact> lireFichierTexte1() {
        List<Contact> contacts = new ArrayList<>();
        try (ContactReader reader
                = new ContactReader(
                        new BufferedReader(
                                new FileReader(fichier)))) {
            Contact c = reader.read();
            while (c != null) {
                contacts.add(c);
                c = reader.read();
            }

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return contacts;
    }

    public enum Format {
        TEXTE,
        BINAIRE,
        OBJET;
    }

}
