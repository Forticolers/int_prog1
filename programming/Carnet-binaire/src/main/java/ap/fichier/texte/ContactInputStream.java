/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ap.fichier.texte;

import carnet.domain.Adresse;
import carnet.domain.Contact;
import carnet.domain.Identifiant;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.logging.Logger;

/**
 *
 * @author JeanbourquJ
 */
public class ContactInputStream implements Closeable {

    private DataInputStream inputStream;
    private ObjectInputStream objectInputStream;
    private static final Logger LOG = Logger.getLogger(ContactInputStream.class.getName());

    @Override
    public void close() throws IOException {
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public ContactInputStream(ObjectInputStream ois) {
        this.objectInputStream = ois;
    }

    public ContactInputStream(DataInputStream is) {
        this.inputStream = is;
    }

    public Contact readBinary() throws EOFException {
        Contact c = null;

        try {
            try {
                Integer id = inputStream.readInt();
                c = new Contact(new Identifiant(id));

                String nom = inputStream.readUTF();
                if (nom != null) {
                    c.setNom(nom);
                }
                String strDate = inputStream.readUTF();
                if (strDate != null) {
                    LocalDate dateNaissance = LocalDate.parse(strDate);
                    c.setDateNaissance(dateNaissance);
                }
                Adresse adresse = null;
                boolean isAdresse = inputStream.readBoolean();
                if (isAdresse) {
                    String strRue = inputStream.readUTF();
                    if (strRue != null) {
                        adresse = new Adresse();
                        adresse.setRue(strRue);
                        Integer npa = inputStream.readInt();

                        adresse.setNpa(npa);
                        String localite = inputStream.readUTF();
                        if (localite != null) {
                            adresse.setLocalite(localite);
                        }

                    }
                }
                c.setAdresse(adresse);
            } catch (EOFException ex) {
                // LOG.severe(String.format("EOFException : %s", ex.getMessage()));
            }

        } catch (IOException ex) {
            LOG.severe(String.format("IOException : %s", ex.getMessage()));
            throw new RuntimeException(ex);
        }
        return c;
    }

    public Contact readObject() throws EOFException {
        Contact c = null;
        try {
            c = (Contact) objectInputStream.readObject();
            LOG.info(String.format("Object file treatment of object %s", c.toString()));
        } catch (EOFException ex) {
            LOG.severe(ex.getMessage());
        } catch (IOException | ClassNotFoundException ex) {
            LOG.severe(ex.getMessage());
            throw new RuntimeException(ex);
        }
        return c;
    }
}
