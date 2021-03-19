/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.jeanbourquj.cifom.utils;

import ch.jeanbourquj.cifom.domain.Data;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author JeanbourquJ
 */
public class SingleDoubleEntryLinkedListTest {

    private static final Logger LOG
            = Logger.getLogger(SingleLinkedListTest.class.getName());
    private List listRef;
    private Data[] elementsRef;

    public SingleDoubleEntryLinkedListTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
         listRef = new SingleDoubleEntryLinkedList();
        elementsRef = new Data[]{new Data(10),
            new Data(20),
            new Data(30)};
    }

    /**
     * Test of size method, of class FixArrayList.
     */
    @Test
    public void testSize() {
    }

    @Test
    public void testCreationListe() throws Exception {
        Assert.assertEquals("Erreur:La Liste devrait contenir 0 élément!",
                0, listRef.size());
    }

    @Ignore
    @Test(expected = IndexOutOfBoundsException.class)
    public void testMauvaiseCreationListe() throws Exception {
        List list = new SingleLinkedList();
        Assert.fail("Erreur:La création devrait générer une exception!");
    }

    @Test
    public void testAdd() throws Exception {

        Data element = new Data(10);
        listRef.add(element);

        Assert.assertEquals("Erreur:La Liste devrait contenir 1 élément!",
                1, listRef.size());

        Assert.assertEquals(element, listRef.getLast());

    }

    @Ignore
    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddListPlein() throws Exception {
        List arrayList = new SingleLinkedList();

        arrayList.add(elementsRef[0]);

        arrayList.add(elementsRef[1]);
        Assert.fail("Erreur:La Liste devrait être plein!");
    }

    @Test
    public void testAddEnPosition() throws Exception {

        listRef.add(elementsRef[0]);
        listRef.add(elementsRef[1]);

        int position = 1;
        listRef.add(position, elementsRef[2]);

        Assert.assertEquals("Erreur:La Liste devrait contenir 3 élément!",
                3, listRef.size());

        Assert.assertEquals(elementsRef[2], listRef.get(position));
        Assert.assertEquals(elementsRef[1], listRef.get(position + 1));

    }

    @Test
    public void testAddEnPosition2() throws Exception {
        listRef.add(0, elementsRef[0]);
        listRef.add(1, elementsRef[1]);

        int position = 1;
        listRef.add(position, elementsRef[2]);

        Assert.assertEquals("Erreur:La Liste devrait contenir 3 élément!",
                3, listRef.size());

        Assert.assertEquals(elementsRef[2], listRef.get(position));

    }

    @Test
    public void testRemove() throws Exception {
        for (int i = 0; i < 3; i++) {
            listRef.add(elementsRef[i]);
        }

        int size = listRef.size();

        listRef.remove();

        Assert.assertEquals(
                size - 1, listRef.size());

        Assert.assertEquals(elementsRef[1], listRef.getLast());

    }

    @Test
    public void testRemovePosition0() throws Exception {
        for (int i = 0; i < 3; i++) {
            listRef.add(elementsRef[i]);
        }

        int size = listRef.size();

        listRef.remove(0);

        Assert.assertEquals(
                size - 1, listRef.size());

        Assert.assertEquals(elementsRef[1], listRef.getFirst());
        Assert.assertEquals(elementsRef[2], listRef.getLast());

    }

    @Test
    public void testRemove0() throws Exception {
        listRef.add(elementsRef[0]);

        int size = listRef.size();

        listRef.remove();

        Assert.assertEquals(
                size - 1, listRef.size());
    }

    @Test
    public void testRemoveEnPosition() throws Exception {
        for (int i = 0; i < 3; i++) {
            listRef.add(elementsRef[i]);
        }

        int size = listRef.size();

        int position = 1;
        listRef.remove(position);

        Assert.assertEquals(
                size - 1, listRef.size());

        Assert.assertEquals(elementsRef[2], listRef.get(position));
    }

    @Test
    public void testGetFirst() throws Exception {
        for (int i = 0; i < 3; i++) {
            listRef.add(elementsRef[i]);
        }

        Assert.assertEquals("Erreur:La Liste devrait contenir 3 élément!",
                3, listRef.size());

        Assert.assertEquals(elementsRef[0], listRef.getFirst());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetFirstListVide() throws Exception {
        listRef.getFirst();
        Assert.fail("Erreur:La Liste devrait être vide!");
    }

    @Test
    public void testGetLast() throws Exception {
        for (int i = 0; i < 3; i++) {
            listRef.add(elementsRef[i]);
        }

        Assert.assertEquals("Erreur:La Liste devrait contenir 3 élément!",
                3, listRef.size());

        Assert.assertEquals(elementsRef[2], listRef.getLast());

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetLastListVide() throws Exception {
        listRef.getLast();
        Assert.fail("Erreur: Liste devrait retourner une erreur de liste vide");
    }

    @Test
    public void testGet() throws Exception {
        for (int i = 0; i < 3; i++) {
            listRef.add(elementsRef[i]);
        }

        Assert.assertEquals("Erreur:La Liste devrait contenir 3 élément!",
                3, listRef.size());

        int position = 1;
        Assert.assertEquals(elementsRef[position], listRef.get(position));

    }

    @Test
    public void testToString() throws Exception {
        for (int i = 0; i < 3; i++) {
            listRef.add(elementsRef[i]);
        }

        LOG.info(listRef.toString());

    }

    @Test
    public void testClear() throws Exception {
        for (int i = 0; i < 3; i++) {
            listRef.add(elementsRef[i]);
        }

        Assert.assertEquals("Erreur:La Liste devrait contenir 3 éléments!",
                3, listRef.size());

        listRef.clear();

        Assert.assertEquals("Erreur:La Liste devrait contenir 0 élément!",
                0, listRef.size());

    }

    @Test
    public void testClone() throws Exception {
        for (int i = 0; i < 3; i++) {
            listRef.add(elementsRef[i]);
        }

        List clone = new SingleDoubleEntryLinkedList(listRef);

        Assert.assertEquals("Erreur:La Liste devrait contenir 3 éléments!",
                3, clone.size());

        Assert.assertNotSame(elementsRef, clone);
        Assert.assertEquals(listRef.size(), clone.size());

        for (int i = 0; i < clone.size(); i++) {
            Assert.assertEquals(listRef.get(i), clone.get(i));
            Assert.assertSame(listRef.get(i), clone.get(i));
        }

        clone.add(new Data(55));
        Assert.assertEquals(listRef.size() + 1, clone.size());

    }

    @Test
    public void testClone2() throws Exception {
        for (int i = 0; i < 3; i++) {
            listRef.add(elementsRef[i]);
        }

        List clone = new SingleDoubleEntryLinkedList(listRef);

        clone.remove();
        Assert.assertEquals(elementsRef[2], listRef.get(2));
        Assert.assertEquals(elementsRef[1], clone.get(1));
        Assert.assertEquals(elementsRef[1], clone.getLast());
    }

    @Test
    public void testEquals() throws Exception {
        List arrayList = new SingleDoubleEntryLinkedList();

        for (int i = 0; i < 3; i++) {
            arrayList.add(elementsRef[i]);
            listRef.add(elementsRef[i]);
        }

        Assert.assertEquals(listRef, arrayList);
    }

    @Test
    public void testIsEmpty() throws Exception {
        Assert.assertTrue("Erreur:La liste n'est pas le vide!",
                listRef.isEmpty());
    }

    @Test
    public void testNotIsEmpty() throws Exception {
        for (int i = 0; i < 3; i++) {
            listRef.add(elementsRef[i]);
        }

        Assert.assertFalse("Erreur:La liste est le vide!",
                listRef.isEmpty());
    }
}
