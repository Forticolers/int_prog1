package dhu.carnet.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author dominique huguenin (dominique.huguenin at rpn.ch)
 */
public class CarnetTest {

    private static final Logger LOG = Logger.getLogger(CarnetTest.class.getName());

    private Carnet carnetRef;
    private int nombreRef;
    private int npaRef;
    private String localiteRef;
    private String rueRef;
    private Adresse adresseRef;
    private String nomRef;
    private LocalDate dateNaissanceRef;
    private Contact contactRef;
    private Contact contactInconnu;

    public CarnetTest() {
    }

    @Before
    public void setUp() throws CarnetPleinException {

        npaRef = 2010;
        localiteRef = "Localite test";
        rueRef = "rue test";

        adresseRef = new Adresse();
        adresseRef.setNpa(npaRef);
        adresseRef.setLocalite(localiteRef);
        adresseRef.setRue(rueRef);

        nomRef = "nom test";
        dateNaissanceRef = LocalDate.now();
        contactRef = new Contact();
        contactRef.setNom(nomRef);
        contactRef.setDateNaissance(dateNaissanceRef);
        contactRef.setAdresse(adresseRef);

        nombreRef = 26;
        carnetRef = Carnet.getInstanceDeDemo();

        contactInconnu = new Contact(new Identifiant(-666));
    }

    @Test
    public void testGetContacts() {
        List<Contact> contacts = carnetRef.getContacts();

        for (Contact c : contacts) {
            Assert.assertTrue(c instanceof Contact);
        }
    }

    @Test
    public void testAjouter() throws Exception {
        int nombre = carnetRef.getNombre();
        Contact contactNew = carnetRef.ajouter(contactRef);

        Assert.assertEquals(nombre + 1, carnetRef.getNombre());

        Assert.assertNotNull(contactNew.getIdentifiant());
        Assert.assertEquals(contactRef.getNom(), contactNew.getNom());
        Assert.assertEquals(contactRef.getDateNaissance(), contactNew.getDateNaissance());
        Assert.assertEquals(contactRef.getAdresse(), contactNew.getAdresse());

        Contact contact = carnetRef.rechercherContact(contactNew.getIdentifiant());

        Assert.assertEquals(contactNew.getIdentifiant(), contact.getIdentifiant());
        Assert.assertEquals(contactNew.getNom(), contact.getNom());
        Assert.assertEquals(contactNew.getDateNaissance(), contact.getDateNaissance());
        Assert.assertEquals(contactNew.getAdresse(), contact.getAdresse());
    }

    @Ignore
    @Test(expected = CarnetPleinException.class)
    public void testAjouterCarnetPlein() throws Exception {
        Carnet carnet = new Carnet();
        carnet.ajouter(contactRef);
    }

    @Test
    public void testModifier() throws Exception {
        Contact contactNew = carnetRef.ajouter(contactRef);
        Contact contact = carnetRef.rechercherContact(contactNew.getIdentifiant());
        Contact clone = new Contact(contact);
        clone.setNom(clone.getNom() + "modifié");
        clone.setDateNaissance(LocalDate.now().plusYears(1));
        clone.getAdresse().setLocalite(clone.getAdresse().getLocalite() + "modifié");
        clone.getAdresse().setRue(clone.getAdresse().getRue() + "modifié");
        clone.getAdresse().setNpa(clone.getAdresse().getNpa() + 1000);

        carnetRef.modifier(clone);
        contact = carnetRef.rechercherContact(clone.getIdentifiant());

        Assert.assertEquals(clone.getNom(), contact.getNom());
        Assert.assertEquals(clone.getDateNaissance(), contact.getDateNaissance());
        Assert.assertEquals(clone.getAdresse(), contact.getAdresse());

    }

    @Test(expected = ContactInconnuException.class)
    public void testModifierContactInconnu() throws Exception {
        carnetRef.modifier(contactInconnu);
    }

    @Test
    public void testSupprimer() throws Exception {
        Contact contactNew = carnetRef.ajouter(contactRef);
        Contact contact = carnetRef.rechercherContact(contactNew.getIdentifiant());
        Contact clone = new Contact(contact);

        carnetRef.supprimer(clone);
        contact = carnetRef.rechercherContact(clone.getIdentifiant());
        Assert.assertNull(contact);

    }

    @Test
    public void testSupprimerContactInconnu() throws Exception {
        carnetRef.supprimer(contactInconnu);

    }

    @Test
    public void testTrierParIdContact() throws CarnetPleinException {
        carnetRef.ajouter(contactRef);
        carnetRef.ajouter(contactRef);

        carnetRef.trierParIdContact();

        Contact ancien = null;
        for (Contact c : carnetRef.getContacts()) {
            if (ancien != null && c != null) {
                LOG.info(String.format("a: %s, n:%s", ancien, c));
                Assert.assertTrue(ancien.getIdentifiant().getId()
                        < c.getIdentifiant().getId());

            }
            ancien = c;
        }
    }

    @Test
    public void testRechercherContactInconnu() {
        Contact contact = carnetRef.rechercherContact(new Identifiant(-666));
        Assert.assertNull(contact);

    }

}
