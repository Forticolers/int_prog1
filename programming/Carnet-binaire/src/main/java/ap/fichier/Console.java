package ap.fichier;

import carnet.domain.Carnet;
import carnet.domain.CarnetPleinException;
import carnet.domain.Contact;
import ap.fichier.FichierContacts.Format;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe principal permettant de gérer la lignes de commandes pour l'écriture
 * d'un fichier contenant des contacts ou lire un fichier contenant des contacts.
 * 
 * <br/>
 * Usage:
 * <pre>
 *java -cp ./293-fichier-constats.jar dhu.fichier.Console [--action (lire | ecrire) ] 
 *               --fichier <nomFichier> --format (texte|binaire)
 * 
 *               --format texte par defaut"
 *               --action lire par défaut.";
 *</pre>
 * 
 * @author dominique huguenin <dominique.huguenin at rpn.ch>
 */
public class Console {

    private static final String MESSAGE_USAGE
            = "usage :  java -cp ./293-fichier-constats.jar dhu.fichier.Console [--action (lire | ecrire) ] "
            + "--fichier <nomFichier> --format (texte|binaire|objet)\n"
            + "--format texte par defaut"
            + "--action lire par défaut.";

    private final String nomFichier;
    private final Action action;
    private final Action DEFAUT_ACTION = Action.LIRE;
    private final Format DEFAUT_FORMAT = Format.TEXTE;
    private final Format format;
    public static final String PARAM_ACTION = "--action";
    public static final String PARAM_NOM_FICHIER = "--fichier";
    public static final String PARAM_FORMAT = "--format";
    private static final Logger LOG = Logger.getLogger(Console.class.getName());

    private Console(List<String> args) {
        action = extractAction(args);
        nomFichier = extractParametre(args, PARAM_NOM_FICHIER);
        format = extractFormat(args);

        if (nomFichier == null) {
            usage();
            System.exit(1);
        }

    }

    private void usage() {
        System.err.println(MESSAGE_USAGE);
    }

    /**
     * Méthode principale recevant les arguments de la ligne de commandes.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> argList = Arrays.asList(args);

        Console console = new Console(argList);
        console.run();

    }

    private void run() {

        FichierContacts fichier
                = new FichierContacts(new File(this.nomFichier),
                        this.format);
        List<Contact> contacts;
        switch (action) {
            case LIRE:
                contacts = fichier.lire();
                for (Contact c : contacts) {
                    System.out.println(c.toString());
                }
                break;
            case ECRIRE: {
                try {
                    contacts = Arrays.asList(Carnet.getInstanceDeDemo().getContacts());
                    fichier.ecrire(contacts);
                } catch (CarnetPleinException ex) {
                    LOG.log(Level.SEVERE, null, ex);
                    System.exit(1);
                }
            }
            break;

        }
    }

    private Action extractAction(List<String> args) {
        String arg = extractParametre(args, PARAM_ACTION);

        if (arg == null) {
            return DEFAUT_ACTION;
        }

        Action act = DEFAUT_ACTION;
        try {
            act = Action.valueOf(arg.toUpperCase());
        } catch (Exception ex) {
            //ne fait rien conserve la valeur par défaut.
        }
        return act;
    }

    private String extractParametre(List<String> args, String nomParametre) {
        String arg = null;
        int pos = args.indexOf(nomParametre);
        if (pos >= 0 && pos + 1 < args.size()) {
            arg = args.get(pos + 1);
        }
        return arg;
    }

    private Format extractFormat(List<String> args) {
        String arg = extractParametre(args, PARAM_FORMAT);

        if (arg == null) {
            return DEFAUT_FORMAT;
        }

        Format format = DEFAUT_FORMAT;
        try {
            format = Format.valueOf(arg.toUpperCase());
        } catch (Exception ex) {
            //ne fait rien conserve la valeur par défaut.
        }
        return format;
    }

    private enum Action {
        LIRE, ECRIRE;
    }

}
