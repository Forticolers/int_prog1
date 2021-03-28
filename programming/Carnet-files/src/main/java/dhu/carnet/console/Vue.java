package dhu.carnet.console;

import dhu.carnet.domain.Adresse;
import dhu.carnet.domain.Carnet;
import dhu.carnet.domain.Contact;
import dhu.carnet.domain.Identifiant;
import java.util.List;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 *
 * @author dominique huguenin (dominique.huguenin at rpn.ch)
 */
class Vue {

    public static final String MENU_QUITTER = "0-Quitter";
    public static final String MENU_AFFICHER = "1-Afficher tous les contacts";
    public static final String MENU_AJOUTER = "2-Ajouter un contact";
    public static final String MENU_MODIFIER = "3-Modifier un contact existant";
    public static final String MENU_SUPPRIMER = "4-Supprimer un contact";
    public static final String[] MENU = new String[]{
        MENU_QUITTER,
        MENU_AFFICHER,
        MENU_AJOUTER,
        MENU_MODIFIER,
        MENU_SUPPRIMER};

    private static final String TEMPLATE_INVITE_CHOIX = "Choix (0..%d): ";
    private static final String TEMPLATE_MESSAGE_ERREUR_SAISI_CHOIX
            = "Erreur: le choix saisi est inconnu! (choix : 0..%d)%n";
    public static final String TITRE_AFFICHER = "Afficher le carnet";
    public static final String TITRE_AJOUTER = "Ajouter un contact";
    public static final String TITRE_MODIFIER = "Modifier un contact";
    public static final String TITRE_SUPPRIMER = "Supprimer un contact";
    public static final String TEMPLATE_TITRE = "%n%n%s%n====================";

    private static final String TEMPLATE_AFFICHAGE_RUE = "rue : %s%n";
    private static final String TEMPLATE_AFFICHAGE_LOCALITE = "localité : %s%n";
    private static final String TEMPLATE_AFFICHAGE_NPA = "npa : %d%n";
    private static final String TEMPLATE_AFFICHAGE_DATE_DE_NAISSANCE
            = "date de naissance : %s%n";
    private static final String TEMPLATE_AFFICHAGE_NOM = "nom : %s%n";
    private static final String TEMPLATE_AFFICHAGE_ID = "id : %d%n";
    private final Scanner scanner;
    private final PrintStream out;

    private static final String INVITE_SAISIR_ID
            = "saisir l'id à rechercher : ";
    private static final String TEMPLATE_MESSAGE_ERREUR_SAISI_ENTIER
            = "Erreur: l'entier (%s) saisi n'est pas valide!%n";
    private static final String TEMPLATE_MESSAGE_ERREUR_SAISI_DATE
            = "Erreur: la date (%s) saisi n'est pas valide!%n";
    private static final String INVITE_ACCEPTER_MODIFICATION
            = "Voulez-vous accepter la modification? (o/n) ";
    private static final String TEMPLATE_MESSAGE_ERREUR_SAISI_OUI_NON
            = "Erreur: la choix (%s) saisi n'est pas valide!%n";

    private static final String TEMPLATE_INVITE_SAISIR_NOM = "nom (%s): ";
    private static final String TEMPLATE_INVITE_SAISIR_DATE_DE_NAISSANCE
            = "date de naissance (%s): ";
    private static final String TEMPLATE_INVITE_SAISIR_NPA = "npa (%d): ";
    private static final String TEMPLATE_INVITE_SAISIR_LOCALITE
            = "localité (%s): ";
    private static final String TEMPLATE_INVITE_SAISIR_RUE = "rue (%s): ";

    public Vue() {
        scanner = new Scanner(System.in);
        out = System.out;
    }

    void afficherMenu() {
        out.println();
        for (String item : MENU) {
            out.println(item);
        }

    }

    public void afficherCarnet(Carnet carnet) {
        
        for (int indice = 0 ; indice < carnet.getNombre(); indice = indice +1) {
            this.afficher(carnet.getContacts().get(indice));
        }
    }
    
    public void afficherCarnetV2(Carnet carnet) {
        
        List<Contact> contacts = carnet.getContacts();
        for (int indice = 0 ; indice < carnet.getNombre(); indice = indice +1) {
            
            Contact contact = contacts.get(indice);
            this.afficher(contact);
        }
    }
    

    public void afficher(Contact contact) {
        out.println();
        if (contact.getIdentifiant() != null) {
            out.format(TEMPLATE_AFFICHAGE_ID, contact.getIdentifiant().getId());
        }
        out.format(TEMPLATE_AFFICHAGE_NOM, contact.getNom());
        out.format(TEMPLATE_AFFICHAGE_DATE_DE_NAISSANCE,
                contact.getDateNaissance());
        if (contact.getAdresse() != null) {
            out.format(TEMPLATE_AFFICHAGE_NPA, contact.getAdresse().getNpa());
            out.format(TEMPLATE_AFFICHAGE_LOCALITE,
                    contact.getAdresse().getLocalite());
            out.format(TEMPLATE_AFFICHAGE_RUE, contact.getAdresse().getRue());
        }
    }

    private String saisirTexte(String invite) {
        out.print(invite);
        String ligne = scanner.nextLine();
        if (ligne.length() == 0) {
            ligne = null;
        }
        return ligne;
    }

    private Integer saisirEntier(String invite) {
        Integer entier = null;
        String entierStr = null;
        boolean estFormatValide;
        do {
            try {
                entierStr = this.saisirTexte(invite);
                if (entierStr != null) {
                    entier = Integer.parseInt(entierStr);
                }
                estFormatValide = true;
            } catch (NumberFormatException ex) {
                out.format(TEMPLATE_MESSAGE_ERREUR_SAISI_ENTIER, entierStr);
                estFormatValide = false;
            }
        } while (!estFormatValide);
        return entier;
    }

    public Action saisirAction() {
        this.afficherMenu();

        int nbrChoix = Action.values().length - 1;
        String invite_choix = String.format(TEMPLATE_INVITE_CHOIX,
                nbrChoix-2);

        int action = saisirEntier(invite_choix);
        while (action < 0 || Action.values().length <= action) {
            this.afficherMessage(
                    String.format(TEMPLATE_MESSAGE_ERREUR_SAISI_CHOIX,
                            nbrChoix));
            action = saisirEntier(invite_choix);
        }
        return Action.values()[action];
    }

    public Identifiant saisirIdentifiant() {
        Integer id = saisirEntier(INVITE_SAISIR_ID);
        if (id == null) {
            return null;
        }
        return new Identifiant(id);
    }

    private LocalDate saisirDate(String invite) {
        LocalDate date = null;
        String dateStr = null;
        boolean estFormatValide;
        do {
            try {
                dateStr = this.saisirTexte(invite);
                if (dateStr != null) {
                    date = LocalDate.parse(dateStr);
                }
                estFormatValide = true;
            } catch (DateTimeParseException ex) {
                out.format(TEMPLATE_MESSAGE_ERREUR_SAISI_DATE, dateStr);
                estFormatValide = false;
            }
        } while (!estFormatValide);

        return date;
    }

    private boolean saisirOuiNon(String invite) {
        String choixStr = null;
        boolean choix = false;
        boolean estFormatValide = false;
        do {
            try {
                choixStr = this.saisirTexte(invite);
                if (choixStr != null) {
                    choix = ChoixOuiNon.valueOf(choixStr).isChoix();
                    estFormatValide = true;
                }
            } catch (IllegalArgumentException ex) {
                out.format(TEMPLATE_MESSAGE_ERREUR_SAISI_OUI_NON, choixStr);
            }
        } while (!estFormatValide);
        return choix;
    }

    public Contact saisirContact(Contact contact) {
        if (contact.getIdentifiant() != null) {
            out.format("id : %d%n", contact.getIdentifiant().getId());
        } else {
        }

        String nom = saisirTexte(
                String.format(TEMPLATE_INVITE_SAISIR_NOM,
                        contact.getNom()));
        if (nom == null) {
            nom = contact.getNom();
        }

        LocalDate dateNaissance = saisirDate(
                String.format(TEMPLATE_INVITE_SAISIR_DATE_DE_NAISSANCE,
                        contact.getDateNaissance()));
        if (dateNaissance == null) {
            dateNaissance = contact.getDateNaissance();
        }

        Integer npaCourant = null;
        String localiteCourante = null;
        String rueCourante = null;
        if (contact.getAdresse() != null) {
            npaCourant = contact.getAdresse().getNpa();
            localiteCourante = contact.getAdresse().getLocalite();
            rueCourante = contact.getAdresse().getRue();
        }

        String inviteNpa
                = String.format(TEMPLATE_INVITE_SAISIR_NPA,
                        npaCourant);
        Integer npa = saisirEntier(inviteNpa);
        if (npa == null) {
            npa = npaCourant;
        }

        String localite = saisirTexte(
                String.format(TEMPLATE_INVITE_SAISIR_LOCALITE,
                        localiteCourante));
        if (localite == null) {
            localite = localiteCourante;
        }

        String rue = saisirTexte(
                String.format(TEMPLATE_INVITE_SAISIR_RUE,
                        rueCourante));
        if (rue == null) {
            rue = rueCourante;
        }

        Contact retVal;
        retVal = new Contact(contact.getIdentifiant());
        retVal.setNom(nom);
        retVal.setDateNaissance(dateNaissance);
        if (npa != null || localite != null || rue != null) {
            Adresse adresse = new Adresse();
            adresse.setNpa(npa);
            adresse.setLocalite(localite);
            adresse.setRue(rue);
            retVal.setAdresse(adresse);
        }

        return retVal;
    }

    public void afficherMessage(String message) {
        out.println(message);
    }

    public void afficherTitre(String titre) {
        System.out.println(String.format(TEMPLATE_TITRE, titre));
    }

    public boolean accepterModification() {
        return saisirOuiNon(INVITE_ACCEPTER_MODIFICATION);
    }

    private enum ChoixOuiNon {
        oui(true),
        non(false),
        n(false),
        o(true);
        private boolean choix;

        ChoixOuiNon(boolean choix) {
            this.choix = choix;
        }

        public boolean isChoix() {
            return choix;
        }

    }
}
