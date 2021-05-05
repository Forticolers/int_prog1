/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ap.fichier.texte;

import carnet.domain.Carnet;
import carnet.domain.CarnetPleinException;
import carnet.domain.Contact;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JeanbourquJ
 */
public class ContactOutputStreamTest {
    
    private List<Contact> contactsRef;
    private File file;
    private static final Logger LOG = Logger.getLogger(ContactOutputStreamTest.class.getName());
    private File fileObj;
    public ContactOutputStreamTest() {
    }
    
    @Before
    public void setUp() throws CarnetPleinException {
        Carnet carnet = Carnet.getInstanceDeDemo();
        
        contactsRef = Arrays.asList(carnet.getContacts());
        file = new File("target/testContactOutputStream.bin");
        file.delete();
        fileObj = new File("target/testContactOutputStreamObj.obj");
        fileObj.delete();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testWrite() {
        
        try (ContactOutputStream outputStream
                = new ContactOutputStream(
                        new DataOutputStream(
                                new FileOutputStream(file)))) {
            contactsRef.forEach(c -> {
                LOG.info(String.format(
                        "traiter les enregistrements - écrire %s",
                        c.toString())
                );
                outputStream.writeBinary(c);
            });
        } catch (IOException ex) {
            LOG.severe(String.format("IOException : %s",ex.getMessage()));
            throw new RuntimeException(ex);
        }
        
        Assert.assertTrue(file.exists());
        
        List<Contact> contacts = new ArrayList<>();
        try (ContactInputStream inputStream
                = new ContactInputStream(
                        new DataInputStream(
                                new FileInputStream(file)))) {
            try {
                Contact c;
                while (true) {
                    c = inputStream.readBinary();
                    if(c==null){
                        break;
                    }
                    contacts.add(c);
                }
            } catch (EOFException ex) {
                LOG.severe(String.format("EOFException : %s",ex.getMessage()));
            }
        } catch (IOException ex) {
            LOG.severe(String.format("IOException : %s",ex.getMessage()));
            throw new RuntimeException(ex);
        }
        org.junit.Assert.assertEquals(contactsRef, contacts);
        int index = 0;
        while (index < contacts.size()) {
            Assert.assertEquals(contactsRef.get(index).getIdentifiant(), contacts.get(index).getIdentifiant());
            Assert.assertEquals(contactsRef.get(index).getNom(), contacts.get(index).getNom());
            Assert.assertEquals(contactsRef.get(index).getDateNaissance(), contacts.get(index).getDateNaissance());
            Assert.assertEquals(contactsRef.get(index).getAdresse(), contacts.get(index).getAdresse());
            
            index += 1;
        }
    }
    @Test
    public void testReadObject() {
        try (ContactOutputStream outputStream
                = new ContactOutputStream(
                        new ObjectOutputStream(
                                new FileOutputStream(fileObj)))) {
            contactsRef.forEach(c -> {
                outputStream.writeObject(c);
            });
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        Assert.assertTrue(fileObj.exists());

        List<Contact> contacts = new ArrayList<>();
        
        try (ContactInputStream inputStream
                = new ContactInputStream(
                        new ObjectInputStream(
                                new FileInputStream(fileObj)))) {
            try{
                Contact c = null;
                while(true){
                    c = inputStream.readObject();;
                    if(c == null){
                        break;
                    }
                    contacts.add(c);
                }
                
            }catch(EOFException ex){
                
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        
        org.junit.Assert.assertEquals(contactsRef, contacts);
        int index = 0;
        while (index < contacts.size()) {
            Assert.assertEquals(contactsRef.get(index).getIdentifiant(), contacts.get(index).getIdentifiant());
            Assert.assertEquals(contactsRef.get(index).getNom(), contacts.get(index).getNom());
            Assert.assertEquals(contactsRef.get(index).getDateNaissance(), contacts.get(index).getDateNaissance());
            Assert.assertEquals(contactsRef.get(index).getAdresse(), contacts.get(index).getAdresse());

            index += 1;
        }
    }

    /**
     * Test of write method, of class ContactOutputStream.
     */
}
