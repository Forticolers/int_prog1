package dhu.carnet.domain;

import java.time.LocalDate;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dominique huguenin (dominique.huguenin at rpn.ch)
 */
public class ContactTest {

    private static final Logger LOG 
            = Logger.getLogger(ContactTest.class.getName());

    
    
    private int npaRef;
    private String localiteRef;
    private String rueRef;
    private Adresse adresseRef;
    private Contact contactRef;
    private String nomRef;
    private LocalDate dateNaissanceRef;
    private int idRef;
    private Identifiant identifiantRef;
    
    public ContactTest() {
    }
    
    @Before
    public void setUp() {
        
        idRef = 11;
        identifiantRef = new Identifiant(idRef);
        
        npaRef = 2010;
        localiteRef="Localite test";
        rueRef="rue test";
        
        adresseRef = new Adresse();
        adresseRef.setNpa(npaRef);
        adresseRef.setLocalite(localiteRef);
        adresseRef.setRue(rueRef);
        
        nomRef = "nom test";
        dateNaissanceRef = LocalDate.now();
        contactRef = new Contact(identifiantRef);
        contactRef.setNom(nomRef);
        contactRef.setDateNaissance(dateNaissanceRef);
        contactRef.setAdresse(adresseRef);
        
    }

    @Test
    public void testGet() {
        Assert.assertEquals(identifiantRef, contactRef.getIdentifiant());
        Assert.assertEquals(nomRef, contactRef.getNom());
        Assert.assertEquals(dateNaissanceRef, contactRef.getDateNaissance());
        Assert.assertEquals(adresseRef, contactRef.getAdresse());
        
    }

    @Test
    public void testEqualsHashCode() {
        Contact contact = new Contact(identifiantRef);
        contact.setNom(nomRef);
        contact.setDateNaissance(dateNaissanceRef);
        contact.setAdresse(adresseRef);
        
        Assert.assertNotSame(contactRef, contact);
        Assert.assertEquals(contactRef, contact);

    }

    @Test
    public void testToString() {
        LOG.info(contactRef.toString());
        
    }

    @Test
    public void testUpdate() {
        Contact contact = new Contact();
        contact.update(contactRef);

        Assert.assertNull(contact.getIdentifiant());
        Assert.assertEquals(contactRef.getNom(), contact.getNom());
        Assert.assertEquals(contactRef.getDateNaissance(), contact.getDateNaissance());
        Assert.assertEquals(contactRef.getAdresse(), contact.getAdresse());
        
    }
    
    @Test
    public void testUpdateAdresseNulll() {
        contactRef.setAdresse(null);
        
        Contact contact = new Contact();
        contact.update(contactRef);

        Assert.assertNull(contact.getIdentifiant());
        Assert.assertEquals(contactRef.getNom(), contact.getNom());
        Assert.assertEquals(contactRef.getDateNaissance(), contact.getDateNaissance());
        Assert.assertNull(contactRef.getAdresse());
        
    }
    
    
    @Test
    public void testClone() throws CloneNotSupportedException {
        Contact clone = new Contact(contactRef);
        
        Assert.assertNotSame(contactRef, clone);
        Assert.assertEquals(contactRef, clone);
        
        Assert.assertEquals(contactRef.getIdentifiant(), clone.getIdentifiant());
        Assert.assertNotSame(contactRef.getIdentifiant(), clone.getIdentifiant());
        Assert.assertEquals(contactRef.getNom(), clone.getNom());
        Assert.assertEquals(contactRef.getDateNaissance(), clone.getDateNaissance());
        Assert.assertEquals(contactRef.getAdresse(), clone.getAdresse());
        Assert.assertNotSame(contactRef.getAdresse(), clone.getAdresse());
    }
    
    @Test
    public void testClone2() throws CloneNotSupportedException {
        Contact contact = new Contact();
        Contact clone = new Contact(contact);
        
        Assert.assertNotSame(contact, clone);
        Assert.assertEquals(contact, clone);
        
        Assert.assertEquals(contact.getIdentifiant(), clone.getIdentifiant());
        Assert.assertEquals(contact.getNom(), clone.getNom());
        Assert.assertEquals(contact.getDateNaissance(), clone.getDateNaissance());
        Assert.assertEquals(contact.getAdresse(), clone.getAdresse());
    }
    
}
