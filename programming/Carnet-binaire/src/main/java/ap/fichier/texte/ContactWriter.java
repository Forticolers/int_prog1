package ap.fichier.texte;

import carnet.domain.Contact;
import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author dominique huguenin (dominique.huguenin at rpn.ch)
 */
public class ContactWriter implements Closeable {

    private final PrintWriter writer;

    public ContactWriter(PrintWriter pw) {
        writer = pw;
    }

    @Override
    public void close() throws IOException {
        if (writer != null) {
            writer.close();
        }
    }

    public void write(Contact c) {
        writer.printf("%d\n", c.getIdentifiant().getId());
        writer.printf("%s\n", c.getNom() != null
                ? c.getNom() : VALEUR_NULL);
        writer.printf("%s\n", c.getDateNaissance() != null
                ? c.getDateNaissance().toString() : VALEUR_NULL);

        //Ecrire l'adresse
        if (c.getAdresse() != null) {
            writer.printf("%s\n", c.getAdresse().getRue() != null
                    ? c.getAdresse().getRue() : VALEUR_NULL);
            writer.printf("%s\n", c.getAdresse().getNpa() != null
                    ? c.getAdresse().getNpa().toString() : VALEUR_NULL);
            writer.printf("%s\n", c.getAdresse().getLocalite() != null
                    ? c.getAdresse().getLocalite() : VALEUR_NULL);
        }
        writer.println(MARQUE_FIN_CONTACT);
    }
    public static final String VALEUR_NULL = "NULL";
    public static final String MARQUE_FIN_CONTACT = "@FIN-CONTACT";

}
