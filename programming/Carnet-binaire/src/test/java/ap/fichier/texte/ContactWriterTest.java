package ap.fichier.texte;

import ap.fichier.texte.ContactReader;
import ap.fichier.texte.ContactWriter;
import carnet.domain.Carnet;
import carnet.domain.CarnetPleinException;
import carnet.domain.Contact;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author dominique huguenin (dominique.huguenin at rpn.ch)
 */
public class ContactWriterTest {

    private List<Contact> contactsRef;
    private File fichier;

    public ContactWriterTest() {
    }

    @Before
    public void setUp() throws CarnetPleinException {
        Carnet carnet = Carnet.getInstanceDeDemo();

        contactsRef = Arrays.asList(carnet.getContacts());
        fichier = new File("target/testContactWriter.txt");
        fichier.delete();

    }

    @Test
    public void testWriter() throws IOException {
        try (ContactWriter writer
                = new ContactWriter(
                        new PrintWriter(
                                new FileWriter(fichier)))) {
            for (Contact c : contactsRef) {
                writer.write(c);
            }
        }

        Assert.assertTrue(fichier.exists());
        
        List<Contact> contacts = new ArrayList<>();
        
        try (ContactReader reader = new ContactReader(
                new BufferedReader(new FileReader(fichier)))){
            Contact c = reader.read();
            while(c!= null){
                contacts.add(c);
                c = reader.read();
            }
        }
        
        Assert.assertEquals(contactsRef, contacts);
        int index =0;
        while(index < contacts.size()){
            Assert.assertEquals(contactsRef.get(index).getIdentifiant(),contacts.get(index).getIdentifiant());
            Assert.assertEquals(contactsRef.get(index).getNom(),contacts.get(index).getNom());
            Assert.assertEquals(contactsRef.get(index).getDateNaissance(),contacts.get(index).getDateNaissance());
            Assert.assertEquals(contactsRef.get(index).getAdresse(),contacts.get(index).getAdresse());
            
            index += 1;
        }
    }

}
