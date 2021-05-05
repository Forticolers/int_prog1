package carnet.domain;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author dominique huguenin (dominique.huguenin at rpn.ch)
 */
public class Carnet {

    List<Contact> contacts;

    public static final int POSITION_INCONNU = -1;
    private final Random randomValue;

    public Carnet() {
        this.contacts = new ArrayList<>();
        randomValue = new Random(Instant.now().getEpochSecond());
    }

    public Contact[] getContacts() {
        Contact[] retvalue = new Contact[this.getNombre()];
        for(int i= 0; i< this.getNombre(); i+=1){
            retvalue[i] = (Contact) this.contacts.get(i);
        }
        
        return retvalue;
    }

    public int getNombre() {
        return this.contacts.size();
    }

    public Contact ajouter(Contact contact) throws CarnetPleinException {

        Contact retVal = new Contact(this.genererIdContactUnique());
        retVal.update(contact);

        this.contacts.add(retVal);
        return retVal;
    }

    public void modifier(Contact contact) throws ContactInconnuException {
        Contact c = this.rechercherContact(contact.getIdentifiant());
        if (c != null) {
            c.update(contact);
        } else {
            throw new ContactInconnuException(contact.toString());
        }

    }

    public void supprimer(Contact contact) {
        int position = this.rechercherPositionContact(contact.getIdentifiant());

        if (position == POSITION_INCONNU) {
            return;
        }
        
        this.contacts.remove(position);
    }

    public void trierParIdContact() {
        this.trierParId(contacts, 0, this.getNombre() - 1);
    }

    private int rechercherPositionContact(Identifiant id) {
        int position = POSITION_INCONNU;

        int indice = 0;
        boolean trouve = false;
        while (!trouve && (indice < this.getNombre())) {
            Contact c = (Contact)this.contacts.get(indice);
            trouve = c.getIdentifiant().equals(id);
            if (!trouve) {
                indice = indice + 1;
            }
        }

        if (indice < this.getNombre()) {
            position = indice;
        }

        return position;
    }

    public Contact rechercherContact(Identifiant id) {
        int pos = rechercherPositionContact(id);
        if (pos == POSITION_INCONNU) {
            return null;
        }

        return (Contact)this.contacts.get(pos);
    }

    private Identifiant genererIdContactUnique() {
        Identifiant identifiant;
        Boolean unique = false;
        do {
            Integer id = Math.abs(randomValue.nextInt() % 100) + 1;
            identifiant = new Identifiant(id);
            unique = this.rechercherContact(identifiant) == null;

        } while (!unique);

        return identifiant;
    }

    public static Carnet getInstanceDeDemo() throws CarnetPleinException {
        Carnet carnet = new Carnet();
        Adresse adresse;
        Contact contact;

        contact = new Contact();
        contact.setNom("a nom 10");
        contact.setDateNaissance(LocalDate.MIN);

        adresse = new Adresse();
        adresse.setNpa(2010);
        adresse.setLocalite("Localite 10");
        adresse.setRue("rue 10");
        contact.setAdresse(adresse);

        carnet.ajouter(contact);

        contact = new Contact();
        contact.setNom("b nom 20");
        contact.setDateNaissance(LocalDate.MAX);

        adresse = new Adresse();
        adresse.setNpa(2020);
        adresse.setLocalite("Localite 20");
        adresse.setRue("rue 20");
        contact.setAdresse(adresse);

        carnet.ajouter(contact);

        contact = new Contact();
        contact.setNom("c nom 30");
        contact.setDateNaissance(LocalDate.now());

        adresse = new Adresse();
        adresse.setNpa(2030);
        adresse.setLocalite("Localite 30");
        adresse.setRue("rue 30");
        contact.setAdresse(adresse);

        carnet.ajouter(contact);

        contact = new Contact();
        contact.setNom("d nom 40");
        contact.setDateNaissance(LocalDate.MIN);

        adresse = new Adresse();
        adresse.setNpa(2040);
        adresse.setLocalite("Localite 40");
        adresse.setRue("rue 40");
        contact.setAdresse(adresse);

        carnet.ajouter(contact);

        contact = new Contact();
        contact.setNom("e nom 50");
        contact.setDateNaissance(LocalDate.MIN);

        adresse = new Adresse();
        adresse.setNpa(2050);
        adresse.setLocalite("Localite 50");
        adresse.setRue("rue 50");
        contact.setAdresse(adresse);

        carnet.ajouter(contact);

        contact = new Contact();
        contact.setNom("f nom 60");
        contact.setDateNaissance(LocalDate.MIN);

        adresse = new Adresse();
        adresse.setNpa(2060);
        adresse.setLocalite("Localite 60");
        adresse.setRue("rue 60");
        contact.setAdresse(adresse);

        carnet.ajouter(contact);

        contact = new Contact();
        contact.setNom("g nom 70");
        contact.setDateNaissance(LocalDate.MIN);

        adresse = new Adresse();
        adresse.setNpa(2070);
        adresse.setLocalite("Localite 70");
        adresse.setRue("rue 70");
        contact.setAdresse(adresse);

        carnet.ajouter(contact);

        contact = new Contact();
        contact.setNom("h nom 80");
        contact.setDateNaissance(LocalDate.MIN);

        adresse = new Adresse();
        adresse.setNpa(2080);
        adresse.setLocalite("Localite 80");
        adresse.setRue("rue 80");
        contact.setAdresse(adresse);

        carnet.ajouter(contact);

        contact = new Contact();
        contact.setNom("i nom 90");
        contact.setDateNaissance(LocalDate.MIN);

        adresse = new Adresse();
        adresse.setNpa(2090);
        adresse.setLocalite("Localite 90");
        adresse.setRue("rue 90");
        contact.setAdresse(adresse);

        carnet.ajouter(contact);

        contact = new Contact();
        contact.setNom("j nom 100");
        contact.setDateNaissance(LocalDate.MIN);

        adresse = new Adresse();
        adresse.setNpa(2100);
        adresse.setLocalite("Localite 100");
        adresse.setRue("rue 100");
        contact.setAdresse(adresse);

        carnet.ajouter(contact);

        contact = new Contact();
        contact.setNom("k nom 110");
        contact.setDateNaissance(LocalDate.MIN);

        adresse = new Adresse();
        adresse.setNpa(2110);
        adresse.setLocalite("Localite 110");
        adresse.setRue("rue 110");
        contact.setAdresse(adresse);

        carnet.ajouter(contact);

        contact = new Contact();
        contact.setNom("l nom 120");
        contact.setDateNaissance(LocalDate.MIN);

        adresse = new Adresse();
        adresse.setNpa(2120);
        adresse.setLocalite("Localite 120");
        adresse.setRue("rue 120");
        contact.setAdresse(adresse);

        carnet.ajouter(contact);

        contact = new Contact();
        contact.setNom("m nom 130");
        contact.setDateNaissance(LocalDate.MIN);

        adresse = new Adresse();
        adresse.setNpa(2130);
        adresse.setLocalite("Localite 130");
        adresse.setRue("rue 130");
        contact.setAdresse(adresse);

        carnet.ajouter(contact);

        contact = new Contact();
        contact.setNom("n nom 140");
        contact.setDateNaissance(LocalDate.MIN);

        adresse = new Adresse();
        adresse.setNpa(2140);
        adresse.setLocalite("Localite 140");
        adresse.setRue("rue 140");
        contact.setAdresse(adresse);

        carnet.ajouter(contact);

        contact = new Contact();
        contact.setNom("o nom 150");
        contact.setDateNaissance(LocalDate.MIN);

        adresse = new Adresse();
        adresse.setNpa(2150);
        adresse.setLocalite("Localite 150");
        adresse.setRue("rue 150");
        contact.setAdresse(adresse);

        carnet.ajouter(contact);

        contact = new Contact();
        contact.setNom("p nom 160");
        contact.setDateNaissance(LocalDate.MIN);

        adresse = new Adresse();
        adresse.setNpa(2160);
        adresse.setLocalite("Localite 160");
        adresse.setRue("rue 160");
        contact.setAdresse(adresse);

        carnet.ajouter(contact);

        contact = new Contact();
        contact.setNom("q nom 170");
        contact.setDateNaissance(LocalDate.MIN);

        adresse = new Adresse();
        adresse.setNpa(2010);
        adresse.setLocalite("Localite 170");
        adresse.setRue("rue 170");
        contact.setAdresse(adresse);

        carnet.ajouter(contact);

        contact = new Contact();
        contact.setNom("r nom 180");
        contact.setDateNaissance(LocalDate.MIN);

        adresse = new Adresse();
        adresse.setNpa(2180);
        adresse.setLocalite("Localite 180");
        adresse.setRue("rue 180");
        contact.setAdresse(adresse);

        carnet.ajouter(contact);

        contact = new Contact();
        contact.setNom("s nom 190");
        contact.setDateNaissance(LocalDate.MIN);

        adresse = new Adresse();
        adresse.setNpa(2190);
        adresse.setLocalite("Localite 190");
        adresse.setRue("rue 190");
        contact.setAdresse(adresse);

        carnet.ajouter(contact);

        contact = new Contact();
        contact.setNom("t nom 200");
        contact.setDateNaissance(LocalDate.MIN);

        adresse = new Adresse();
        adresse.setNpa(2200);
        adresse.setLocalite("Localite 200");
        adresse.setRue("rue 200");
        contact.setAdresse(adresse);

        carnet.ajouter(contact);

        contact = new Contact();
        contact.setNom("u nom 210");
        contact.setDateNaissance(LocalDate.MIN);

        adresse = new Adresse();
        adresse.setNpa(2210);
        adresse.setLocalite("Localite 210");
        adresse.setRue("rue 210");
        contact.setAdresse(adresse);

        carnet.ajouter(contact);

        contact = new Contact();
        contact.setNom("v nom 220");
        contact.setDateNaissance(LocalDate.MIN);

        adresse = new Adresse();
        adresse.setNpa(2220);
        adresse.setLocalite("Localite 220");
        adresse.setRue("rue 220");
        contact.setAdresse(adresse);

        carnet.ajouter(contact);

        contact = new Contact();
        contact.setNom("w nom 230");
        contact.setDateNaissance(LocalDate.MIN);

        adresse = new Adresse();
        adresse.setNpa(2230);
        adresse.setLocalite("Localite 230");
        adresse.setRue("rue 230");
        contact.setAdresse(adresse);

        carnet.ajouter(contact);

        contact = new Contact();
        contact.setNom("x nom 240");
        contact.setDateNaissance(LocalDate.MIN);

        adresse = new Adresse();
        adresse.setNpa(2240);
        adresse.setLocalite("Localite 240");
        adresse.setRue("rue 240");
        contact.setAdresse(adresse);

        carnet.ajouter(contact);

        contact = new Contact();
        contact.setNom("y nom 250");
        contact.setDateNaissance(LocalDate.MIN);

        adresse = new Adresse();
        adresse.setNpa(2250);
        adresse.setLocalite("Localite 250");
        adresse.setRue("rue 250");
        contact.setAdresse(adresse);

        carnet.ajouter(contact);

        contact = new Contact();
        contact.setNom("z nom 270 adresse null");
        contact.setDateNaissance(LocalDate.now());
        
        carnet.ajouter(contact);
        
        
        contact = new Contact();
        contact.setNom("z nom 260");
        contact.setDateNaissance(LocalDate.MIN);

        adresse = new Adresse();
        adresse.setNpa(2260);
        adresse.setLocalite("Localite 260");
        adresse.setRue("rue 260");
        contact.setAdresse(adresse);

        carnet.ajouter(contact);
        
        
        carnet.trierParIdContact();
        return carnet;
    }

    private int comparerId(Object contact1, Object contact2) {
        return ((Contact)contact1).getIdentifiant().getId().compareTo(
                ((Contact)contact2).getIdentifiant().getId());
    }

    private void permuterContact(List<Contact> contacts, int pos1, int pos2) {
        Contact tmp = contacts.get(pos2);
        contacts.remove(pos2);
        contacts.add(pos2, contacts.get(pos1));
        contacts.remove(pos1);
        contacts.add(pos1, tmp);
    }

    private void trierParId(List<Contact> pContacts,
            int pLimGauche,
            int pLimDroite) {
        int g;
        int d;
        Object pivot;

        g = pLimGauche;
        d = pLimDroite;
        pivot = pContacts.get((g + d) / 2);
        do {
            while (comparerId(pContacts.get(g), pivot) < 0) {
                g = g + 1;
            }
            while (comparerId(pContacts.get(d), pivot) > 0) {
                d = d - 1;
            }
            if (g <= d) {
                permuterContact(pContacts, g, d);
                g = g + 1;
                d = d - 1;
            }
        } while (g <= d);

        if (pLimGauche < d) {
            trierParId(pContacts, pLimGauche, d);
        }

        if (g < pLimDroite) {
            trierParId(pContacts, g, pLimDroite);
        }

    }

}
