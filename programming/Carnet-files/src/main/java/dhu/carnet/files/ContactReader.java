/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhu.carnet.files;

import dhu.carnet.domain.Adresse;
import dhu.carnet.domain.Carnet;
import dhu.carnet.domain.CarnetPleinException;
import dhu.carnet.domain.Contact;
import dhu.carnet.domain.Identifiant;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JeanbourquJ
 */
public class ContactReader {

    private String pathFile;
    private File file;
    private Carnet carnet;

    public ContactReader(String vPathFile) {
        this.pathFile = vPathFile;
        file = new File(this.pathFile);
        if (!new File(this.pathFile).exists()) {
            try {
                file.createNewFile();
                
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

    }

    private void read() {
        this.carnet = new Carnet();
        try (BufferedReader reader
                = new BufferedReader(new FileReader(this.file))) {

            Adresse adresse;
            Identifiant id;
            Contact contact;
            System.out.println("Lecture du fichier");
            String currLine = reader.readLine();
            while (currLine != null) {
                id = new Identifiant(Integer.parseInt(currLine));
                contact = new Contact(id);
                String nom = reader.readLine();
                String dateString = reader.readLine();
                String localite = reader.readLine();
                String npa = reader.readLine();
                String rue = reader.readLine();

                LocalDate dateNaissance = LocalDate.parse(dateString);
                contact.setNom(nom);

                contact.setDateNaissance(dateNaissance);
                adresse = new Adresse();
                adresse.setLocalite(localite);
                adresse.setNpa(Integer.parseInt(npa));
                adresse.setRue(rue);
                contact.setAdresse(adresse);
                this.carnet.ajouter(contact);
                currLine = reader.readLine();
            }
        } catch (CarnetPleinException | IOException ex) {
            throw new RuntimeException(ex);
        } finally {
            System.out.println("Fin de la lecture du fichier");
        }
    }

    public Carnet readFile() {
        read();
        return this.carnet;
    }
}
