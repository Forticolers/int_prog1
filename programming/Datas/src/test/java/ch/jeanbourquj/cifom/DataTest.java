package ch.jeanbourquj.cifom;

import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author dominique huguenin (dominique.huguenin at rpn.ch)
 */
public class DataTest {

    private Data dataRef;
    private Integer valeurRef;
    
    private static final Logger LOG = Logger.getLogger(DataTest.class.getName());

    /**
     *
     */
    public DataTest() {
    }

    /**
     *
     */
    @Before
    public void setUp() {
        valeurRef = 11;
        dataRef = new Data(valeurRef);
    }

    /**
     * Test of getValeur method, of class Data.
     */
    @Test
    public void testGetValeur() {
        Assert.assertEquals(valeurRef, dataRef.getValeur());
    }

    /**
     * Test of setValeur method, of class Data.
     */
    @Test
    public void testSetGetValeur() {
        Integer valeur = 22;
        dataRef.setValeur(valeur);

        Assert.assertEquals(valeur, dataRef.getValeur());

    }

    /**
     * Test of hashCode method, of class Data.
     */
    @Test
    public void testEqualsHashCode() {
        Data data = new Data(valeurRef);
        Assert.assertNotSame(dataRef, data);
        Assert.assertEquals(dataRef, data);
        
        Assert.assertEquals(dataRef.hashCode(),
                data.hashCode());

    }
    
    @Test
    public void testNotEqualsHashCode() {
        Data data = new Data(123456);
        Assert.assertNotSame(dataRef, data);
        Assert.assertNotEquals(dataRef, data);
        
        Assert.assertNotEquals(dataRef.hashCode(),
                data.hashCode());

    }
    
    @Test
    public void testEqualsSameObject() {
        Assert.assertSame(dataRef, dataRef);
        Assert.assertEquals(dataRef, dataRef);
        
        Assert.assertEquals(dataRef.hashCode(),
                dataRef.hashCode());

    }
    
    @Test
    public void testEqualsNullObj() {
        Data data = null;
        Assert.assertNotEquals(dataRef, data);
    }
    
    @Test
    public void testEqualsObj() {
        Object data = new Object();
        Assert.assertNotEquals(dataRef, data);
    }

    /**
     * Test of equals method, of class Data.
     */
    @Test
    public void testUpdate() {
        Integer valeur = 22;
        Data data = new Data(valeur);

        dataRef.update(data);

        Assert.assertNotSame(data, dataRef);
        Assert.assertEquals(data.getValeur(), dataRef.getValeur());

    }

    /**
     * Test of toString method, of class Data.
     */
    @Test
    public void testToString() {
        LOG.info(dataRef.toString());
        
    }

}
