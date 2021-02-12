/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import ch.jeanbourquj.cifom.Data;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JeanbourquJ
 */
public class QueueCirculaireTest {

    private int tailleQueueRef;
    private QueueCirculaire queueRef;
    private Data n11;
    private Data n22;
    private Data n33;
    private Data n44;
    private Data n55;
    private Data n66;

    public QueueCirculaireTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     *
     */
    @Before
    public void setUp() {
        tailleQueueRef = 5;
        queueRef = new QueueCirculaire(tailleQueueRef);

        n11 = new Data(11);
        n22 = new Data(22);
        n33 = new Data(33);
        n44 = new Data(44);
        n55 = new Data(55);
        n66 = new Data(66);

    }

    @After
    public void tearDown() {
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void testCreationQueue() throws Exception {
        Assert.assertTrue("Erreur:La queue devrait etre vide!",
                queueRef.etreVide());
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void testAjouter() throws Exception {
        queueRef.ajouter(new Data(11));

        Assert.assertFalse("Erreur:La queue ne devrait pas etre vide!",
                queueRef.etreVide());
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void testRetirer() throws Exception {
        queueRef.ajouter(new Data(11));
        queueRef.retirer();

        Assert.assertTrue("Erreur:La queue devrait etre vide!",
                queueRef.etreVide());
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void testRetournerValeur() throws Exception {
        queueRef.ajouter(n11);
        queueRef.ajouter(n22);
        queueRef.ajouter(n33);
        Data n11bis = queueRef.retournerValeur();

        Assert.assertEquals(n11, n11bis);
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void testRetirerValeur() throws Exception {
        queueRef.ajouter(n11);
        queueRef.ajouter(n22);
        queueRef.ajouter(n33);
        queueRef.retirer();

        Data n22bis = queueRef.retournerValeur();

        Assert.assertEquals(n22, n22bis);
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void testQueuePleine() throws Exception {

        queueRef.ajouter(n11);
        queueRef.ajouter(n22);
        queueRef.ajouter(n33);
        queueRef.ajouter(n44);
        queueRef.ajouter(n55);

        Assert.assertTrue("Erreur:La queue devrait etre pleine!", queueRef.etrePlein());

    }

    /**
     *
     * @throws Exception
     */
    @Test(expected = RuntimeException.class)
    public void testAjouterQueuePleine() throws Exception {

        queueRef.ajouter(n11);
        queueRef.ajouter(n22);
        queueRef.ajouter(n33);
        queueRef.ajouter(n44);
        queueRef.ajouter(n55);

        queueRef.ajouter(n66);
        Assert.fail();
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void testQueueVide() throws Exception {

        queueRef.retirer();
        queueRef.retirer();
        queueRef.retirer();

        queueRef.ajouter(new Data(11));

        Assert.assertFalse("Erreur:La queue ne devrait pas etre vide!",
                queueRef.etreVide());

    }
}
