/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhu.carnet.files;

import dhu.carnet.domain.Contact;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author JeanbourquJ
 */
public class ContactWriter {

    private List<Contact> contacts;
    private String fileName;
    private String pathFile;
    private File file;

    public ContactWriter(final List<Contact> vContacts, final String vPathFile) {
        this.pathFile = vPathFile;
        this.contacts = vContacts;
        file = new File(this.pathFile);
    }

    public void writeInFile() {
        this.writeInFile(true);
    }
    private void write() {
        try (PrintWriter writer 
                = new PrintWriter(new FileWriter(this.file), true)) {
            System.out.println("\nEnregistrement des contacts");
            for (Contact contact : this.contacts) {
                writer.println(contact.getIdentifiant().getId());
                writer.println(contact.getNom());
                writer.println(contact.getDateNaissance());
                writer.println(contact.getAdresse().getLocalite());
                writer.println(contact.getAdresse().getNpa());
                writer.println(contact.getAdresse().getRue());
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } finally {
            System.out.println("Fin de l'enregistrement des contacts");
        }
    }
    public void writeInFile(boolean bOverWrite) {
        if (!file.exists()) {
            write();
        } else {
            if (bOverWrite) {
                file.delete();
                write();
            } else {
                write();
            }
        }
    }

}
