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
public class FixArrayListTest {

    private int tailleArrayList;
    private FixArrayList fixArray;
    private Data n11;
    private Data n22;
    private Data n33;
    private Data n44;
    private Data n55;
    private Data n66;

    public FixArrayListTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        tailleArrayList = 5;
        fixArray = new FixArrayList(tailleArrayList);

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

    @Test
    public void testCreationArrayList() {
        Assert.assertTrue("ERREUR: La liste devrait être vide!", fixArray.isEmpty());
        Assert.assertEquals(0, fixArray.size());
    }

    @Test
    public void testAddArrayList() {
        Assert.assertTrue("ERREUR: La liste devrait être vide!", fixArray.isEmpty());
        Assert.assertEquals(0, fixArray.size());
        fixArray.add(n11);
        Assert.assertFalse("ERREUR: La liste ne devrait pas être vide!", fixArray.isEmpty());
        Assert.assertEquals(1, fixArray.size());
    }

    @Test
    public void testGetLastArrayList() {
        Assert.assertTrue("ERREUR: La liste devrait être vide!", fixArray.isEmpty());
        Assert.assertEquals(0, fixArray.size());
        fixArray.add(n11);
        Assert.assertFalse("ERREUR: La liste ne devrait pas être vide!", fixArray.isEmpty());
        Assert.assertEquals(n11, fixArray.getLast());
        fixArray.add(n22);
        Assert.assertFalse("ERREUR: La liste ne devrait pas être vide!", fixArray.isEmpty());
        Assert.assertEquals(n22, fixArray.getLast());
    }

    @Test
    public void testAddMultipleArrayList() {
        Assert.assertTrue("ERREUR: La liste devrait être vide!", fixArray.isEmpty());
        Assert.assertEquals(0, fixArray.size());
        fixArray.add(n11);
        fixArray.add(n22);
        fixArray.add(n33);
        fixArray.add(n44);
        fixArray.add(n55);
        Assert.assertFalse("ERREUR: La liste ne devrait pas être vide!", fixArray.isEmpty());
        Assert.assertEquals(5, fixArray.size());
    }

    @Test
    public void testRemoveArrayList() {
        Assert.assertTrue("ERREUR: La liste devrait être vide!", fixArray.isEmpty());
        Assert.assertEquals(0, fixArray.size());
        fixArray.add(n11);
        fixArray.add(n22);
        fixArray.add(n33);
        fixArray.add(n44);
        fixArray.add(n55);
        Assert.assertFalse("ERREUR: La liste ne devrait pas être vide!", fixArray.isEmpty());
        Assert.assertEquals(5, fixArray.size());
        fixArray.remove();
        Assert.assertEquals(4, fixArray.size());
        Assert.assertEquals(n22, fixArray.getFirst());
    }

    @Test
    public void testEqualsArrayList() {
        Assert.assertTrue("ERREUR: La liste devrait être vide!", fixArray.isEmpty());
        Assert.assertEquals(0, fixArray.size());
        fixArray.add(n11);
        fixArray.add(n22);
        FixArrayList array = new FixArrayList(tailleArrayList);
        array.add(n11);
        array.add(n22);
        Assert.assertTrue(fixArray.equals(array));
        array.add(n33);
        Assert.assertFalse(fixArray.equals(array));
    }

    @Test
    public void testClearArrayList() {
        Assert.assertTrue("ERREUR: La liste devrait être vide!", fixArray.isEmpty());
        Assert.assertEquals(0, fixArray.size());
        fixArray.add(n11);
        fixArray.add(n22);
        fixArray.add(n33);
        fixArray.add(n44);
        fixArray.add(n55);
        Assert.assertFalse("ERREUR: La liste ne devrait pas être vide!", fixArray.isEmpty());
        Assert.assertEquals(5, fixArray.size());
        fixArray.clear();
        Assert.assertTrue("ERREUR: La liste devrait être vide!", fixArray.isEmpty());
        Assert.assertEquals(0, fixArray.size());
    }

    @Test
    public void testRemoveIndexArrayList() {
        Assert.assertTrue("ERREUR: La liste devrait être vide!", fixArray.isEmpty());
        Assert.assertEquals(0, fixArray.size());
        fixArray.add(n11);
        fixArray.add(n22);
        fixArray.add(n33);
        fixArray.add(n44);
        fixArray.add(n55);
        Assert.assertFalse("ERREUR: La liste ne devrait pas être vide!", fixArray.isEmpty());
        Assert.assertEquals(5, fixArray.size());
        fixArray.remove(3);
        Assert.assertFalse("ERREUR: La liste devrait être vide!", fixArray.isEmpty());
        Assert.assertEquals(4, fixArray.size());
        Assert.assertNotEquals(n44, fixArray.get(3));
        fixArray.remove(0);
        Assert.assertFalse("ERREUR: La liste devrait être vide!", fixArray.isEmpty());
        Assert.assertEquals(3, fixArray.size());
        Assert.assertNotEquals(n11, fixArray.get(0));
    }

    @Test
    public void testAddIndexArrayList() {
        Assert.assertTrue("ERREUR: La liste devrait être vide!", fixArray.isEmpty());
        Assert.assertEquals(0, fixArray.size());
        fixArray.add(n11);
        fixArray.add(n33);
        fixArray.add(n55);
        Assert.assertFalse("ERREUR: La liste ne devrait pas être vide!", fixArray.isEmpty());
        Assert.assertEquals(3, fixArray.size());
        fixArray.add(2, n44);
        Assert.assertFalse("ERREUR: La liste devrait être vide!", fixArray.isEmpty());
        Assert.assertEquals(4, fixArray.size());
        Assert.assertEquals(n44, fixArray.get(2));
        Assert.assertEquals(n55, fixArray.getLast());
        fixArray.add(1, n22);
        Assert.assertFalse("ERREUR: La liste devrait être vide!", fixArray.isEmpty());
        Assert.assertEquals(5, fixArray.size());
        Assert.assertEquals(n22, fixArray.get(1));
        Assert.assertEquals(n55, fixArray.getLast());
    }
}
