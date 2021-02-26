package utils;

import ch.jeanbourquj.cifom.utils.FixArrayList;
import ch.jeanbourquj.cifom.domain.Data;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author dominique huguenin (dominique.huguenin at rpn.ch)
 */
public class FixArrayListTest2 {

    
    private int tailleRef;
    private FixArrayList listRef;
    private Data[] elementsRef;
    private static final Logger LOG = Logger.getLogger(FixArrayListTest2.class.getName());

    public FixArrayListTest2() {
    }

    @Before
    public void setUp() {
        tailleRef = 5;
        listRef = new FixArrayList(tailleRef);
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

    @Test(expected = IndexOutOfBoundsException.class)
    public void testMauvaiseCreationListe() throws Exception {
        FixArrayList arrayList = new FixArrayList(-1);
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

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddListPlein() throws Exception {
        FixArrayList arrayList = new FixArrayList(0);

        arrayList.add(elementsRef[1]);
        Assert.fail("Erreur:La Liste devrait être plein!");
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddListPlein2() throws Exception {
        FixArrayList arrayList = new FixArrayList(0);

        arrayList.add(0,elementsRef[1]);
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
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddEnMauvaisePosition() throws Exception {

        listRef.add(elementsRef[0]);
        listRef.add(elementsRef[1]);

        int position = -1;
        listRef.add(position, elementsRef[2]);

    }
    

    @Test
    public void testAddEnPosition2() throws Exception {
        listRef.add(0, elementsRef[0]);
        listRef.add(1, elementsRef[1]);

        int position = 2;
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
    
    @Test(expected= IndexOutOfBoundsException.class)
    public void testRemoveEnMauvaisePosition() throws Exception {
        for (int i = 0; i < 3; i++) {
            listRef.add(elementsRef[i]);
        }

        int size = listRef.size();

        int position = -1;
        listRef.remove(position);
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
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetEnMauvaisePosition() throws Exception {
        for (int i = 0; i < 3; i++) {
            listRef.add(elementsRef[i]);
        }
        int position = -1;
        listRef.get(position);

    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetSurListVide() throws Exception {
        FixArrayList list = new FixArrayList(10);
        int position = 0;
        list.get(position);

    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveSurListVide() throws Exception {
        FixArrayList list = new FixArrayList(10);
        int position = 0;
        list.remove(position);

    }
    

    @Test
    public void testToString() throws Exception {
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

        FixArrayList clone = new FixArrayList(listRef);

        Assert.assertEquals("Erreur:La Liste devrait contenir 3 éléments!",
                3, clone.size());

        Assert.assertNotSame(elementsRef, clone);
        Assert.assertEquals(listRef.size(), clone.size());

        for (int i = 0; i < clone.size(); i++) {
            Assert.assertEquals(listRef.get(i), clone.get(i));
            Assert.assertSame(listRef.get(i), clone.get(i));
            
        }
        
        clone.add(new Data(55));
        Assert.assertEquals(listRef.size()+1, clone.size());
        
    }
    
    @Test
    public void testClone2() throws Exception {
        for (int i = 0; i < 3; i++) {
            listRef.add(elementsRef[i]);
        }

        FixArrayList clone = new FixArrayList(listRef);

        
        Data data_111 = new Data(111);
        Data data_222 = new Data(222);        
        
        listRef.add(data_111);
        clone.add(data_222);
        
        Assert.assertNotEquals(data_222, listRef.getLast());
        Assert.assertEquals(data_111, listRef.getLast());
        Assert.assertEquals(data_222, clone.getLast());

    }
    
    
    @Test
    public void testEquals() throws Exception {
        FixArrayList arrayList = new FixArrayList(5);

        for (int i = 0; i < 3; i++) {
            arrayList.add(elementsRef[i]);
            listRef.add(elementsRef[i]);
        }

        Assert.assertEquals(listRef, arrayList);
        Assert.assertEquals(listRef.hashCode(), arrayList.hashCode());
    }
    
    @Test
    public void testEqualsSameObjet() throws Exception {
        Assert.assertTrue(listRef.equals(listRef));
    }
    
    @Test
    public void testEqualsNullObject() throws Exception {
        FixArrayList arrayList = null;

        Assert.assertNotEquals(listRef, arrayList);
    }
    
    @Test
    public void testEqualsObject() throws Exception {
        Object object = new Object();

        Assert.assertNotEquals(listRef, object);
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
