package carnet.domain;

import carnet.domain.Identifiant;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author dominique huguenin (dominique.huguenin at rpn.ch)
 */
public class IdentifiantTest {

    private static final Logger LOG
            = Logger.getLogger(IdentifiantTest.class.getName());

    private Integer idRef;
    private Identifiant identifiantRef;

    public IdentifiantTest() {
    }

    @Before
    public void setUp() {
        idRef = 11;
        identifiantRef = new Identifiant(idRef);
    }

    @Test
    public void testGetId() {
        Assert.assertEquals(idRef, identifiantRef.getId());
    }

    @Test
    public void testEqualsHashCode() {
        Identifiant identifiant = new Identifiant(idRef);
        Assert.assertNotSame(identifiantRef, identifiant);
        Assert.assertEquals(identifiantRef, identifiant);

    }

    @Test
    public void testToString() {
        LOG.info(identifiantRef.toString());
    }
    
    @Test
    public void testClone() throws CloneNotSupportedException {
        Identifiant clone = new Identifiant(identifiantRef);
        
        Assert.assertNotSame(identifiantRef, clone);
        Assert.assertEquals(identifiantRef, clone);
        Assert.assertEquals(identifiantRef.getId(), clone.getId());
    }
    
    @Test
    public void testCloneNull() throws CloneNotSupportedException {
        Identifiant identifiant = new Identifiant((Integer)null);
        Identifiant clone = new Identifiant(identifiant);
        
        Assert.assertNotSame(identifiant, clone);
        Assert.assertEquals(identifiant, clone);
        Assert.assertEquals(identifiant.getId(), clone.getId());
    }

}
