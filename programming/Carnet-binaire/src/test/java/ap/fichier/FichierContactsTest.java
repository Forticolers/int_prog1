package ap.fichier;

import ap.fichier.FichierContacts;
import carnet.domain.Carnet;
import carnet.domain.CarnetPleinException;
import carnet.domain.Contact;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author dominique huguenin <dominique.huguenin at rpn.ch>
 */
public class FichierContactsTest {

    public FichierContactsTest() {
    }

    private List<Contact> contactsRef;

    @Before
    public void setUp() throws CarnetPleinException {
        Carnet carnet = Carnet.getInstanceDeDemo();

        contactsRef = Arrays.asList(carnet.getContacts());
    }

    @Test
    public void testGenererTexte() {
        File fichier = new File("target/testContacts.txt");
        FichierContacts generateur = new FichierContacts(fichier,
                FichierContacts.Format.TEXTE);
        generateur.ecrire(contactsRef);

        Assert.assertTrue(fichier.exists());
        List<Contact> contacts = generateur.lire();

        Assert.assertEquals(contactsRef, contacts);
        int index = 0;
        while (index < contacts.size()) {
            Assert.assertEquals(contactsRef.get(index).getIdentifiant(), 
                    contacts.get(index).getIdentifiant());
            Assert.assertEquals(contactsRef.get(index).getNom(), 
                    contacts.get(index).getNom());
            Assert.assertEquals(contactsRef.get(index).getDateNaissance(), 
                    contacts.get(index).getDateNaissance());
            Assert.assertEquals(contactsRef.get(index).getAdresse(), 
                    contacts.get(index).getAdresse());

            index += 1;
        }

    }

    @Test(expected = RuntimeException.class)
    public void testGenererFichierNull() {
        File fichier = null;
        FichierContacts generateur = new FichierContacts(fichier,
                FichierContacts.Format.TEXTE);
    }

    
    
}
