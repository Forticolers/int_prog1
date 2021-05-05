/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ap.fichier.texte;

import carnet.domain.Contact;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author JeanbourquJ
 */
public class ContactOutputStream implements Closeable {

    private DataOutputStream outputStream;

    private ObjectOutputStream objectOutputStream;

    public ContactOutputStream(DataOutputStream os) {
        this.outputStream = os;
    }

    public ContactOutputStream(ObjectOutputStream oos) {
        this.objectOutputStream = oos;
    }

    @Override
    public void close() throws IOException {
        if (outputStream != null) {
            outputStream.close();
        }
    }

    public void writeBinary(Contact c) {
        if (outputStream != null) {
            try {
                Integer id = (c.getIdentifiant().getId() != null ? c.getIdentifiant().getId() : null);
                String nom = (c.getNom() != null ? c.getNom() : null);
                String dateNaissance = (c.getDateNaissance() != null ? c.getDateNaissance().toString() : null);
                outputStream.writeInt(id);
                outputStream.writeUTF(nom);
                outputStream.writeUTF(dateNaissance);
                if (c.getAdresse() != null) {
                    String rue = (c.getAdresse().getRue() != null ? c.getAdresse().getRue() : null);
                    Integer npa = (c.getAdresse().getNpa() != null ? c.getAdresse().getNpa() : null);
                    String localite = (c.getAdresse().getLocalite() != null ? c.getAdresse().getLocalite() : null);
                    outputStream.writeBoolean(true);
                    outputStream.writeUTF(rue);
                    outputStream.writeInt(npa);
                    outputStream.writeUTF(localite);
                } else {
                    outputStream.writeBoolean(false);
                }

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void writeObject(Contact c) {
        if(objectOutputStream != null){
            try{
            objectOutputStream.writeObject(c);
            }catch(IOException ex){
                throw new RuntimeException(ex);
            }
        }
    }
}
