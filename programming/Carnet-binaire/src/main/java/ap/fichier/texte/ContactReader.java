package ap.fichier.texte;

import carnet.domain.Adresse;
import carnet.domain.Contact;
import carnet.domain.Identifiant;
import static ap.fichier.texte.ContactWriter.VALEUR_NULL;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.time.LocalDate;
import static ap.fichier.texte.ContactWriter.MARQUE_FIN_CONTACT;

/**
 *
 * @author dominique huguenin (dominique.huguenin at rpn.ch)
 */
public class ContactReader implements Closeable {

    private final BufferedReader reader;

    public ContactReader(BufferedReader br) {
        reader = br;
    }

    @Override
    public void close() throws IOException {
        if (reader != null) {
            reader.close();
        }
    }

    public Contact read() throws IOException {
        Contact c = null;
        String ligne = reader.readLine();
        if (ligne != null) {
            Integer id = Integer.parseInt(ligne);
            c = new Contact(new Identifiant(id));

            String nom = reader.readLine();
            if (nom != null && !VALEUR_NULL.equals(nom)) {
                c.setNom(nom);
            }

            String dateStr = reader.readLine();
            if (dateStr != null && !VALEUR_NULL.equals(dateStr)) {
                LocalDate dateNaissance = LocalDate.parse(dateStr);
                c.setDateNaissance(dateNaissance);
            }

            Adresse adresse = null;
            ligne = reader.readLine();
            if (ligne != null && !MARQUE_FIN_CONTACT.equals(ligne)) {
                adresse = new Adresse();
                if (!VALEUR_NULL.equals(ligne)) {
                    adresse.setRue(ligne);
                }
                ligne = reader.readLine();
                if (!VALEUR_NULL.equals(ligne)) {
                    adresse.setNpa(Integer.parseInt(ligne));
                }
                ligne = reader.readLine();
                if (!VALEUR_NULL.equals(ligne)) {
                    adresse.setLocalite(ligne);
                }
                ligne = reader.readLine();
            }
            c.setAdresse(adresse);
        }
        return c;

    }

}
