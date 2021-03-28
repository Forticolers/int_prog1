package dhu.carnet.domain;

import dhu.carnet.domain.Adresse;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author dominique huguenin (dominique.huguenin at rpn.ch)
 */
public class AdresseTest {

    private static final Logger LOG 
            = Logger.getLogger(AdresseTest.class.getName());

    private Adresse adresseRef;
    private Integer npaRef;
    private String localiteRef;
    private String rueRef;
    
    public AdresseTest() {
    }
    
    @Before
    public void setUp() {
        
        npaRef = 2010;
        localiteRef="Localite test";
        rueRef="rue test";
        
        adresseRef = new Adresse();
        adresseRef.setNpa(npaRef);
        adresseRef.setLocalite(localiteRef);
        adresseRef.setRue(rueRef);
        
        
    }

    @Test
    public void testGet() {
        Assert.assertEquals(npaRef, adresseRef.getNpa());
        Assert.assertEquals(localiteRef, adresseRef.getLocalite());
        Assert.assertEquals(rueRef, adresseRef.getRue());
    }

    @Test
    public void testEqualsHashCode() {
        Adresse adresse = new Adresse();
        adresse.setNpa(npaRef);
        adresse.setLocalite(localiteRef);
        adresse.setRue(rueRef);
        
        Assert.assertNotSame(adresseRef, adresse);
        Assert.assertEquals(adresseRef, adresse);

    }

    
    @Test
    public void testToString() {
        LOG.info(adresseRef.toString());
    }

    @Test
    public void testUpdate() {
        Adresse adresse = new Adresse();
        adresse.update(adresseRef);

        Assert.assertEquals(npaRef, adresse.getNpa());
        Assert.assertEquals(localiteRef, adresse.getLocalite());
        Assert.assertEquals(rueRef, adresse.getRue());
    }
    
    @Test
    public void testClone() throws CloneNotSupportedException {
        Adresse clone =  new Adresse(adresseRef);
        
        Assert.assertNotSame(adresseRef, clone);
        Assert.assertEquals(adresseRef, clone);
        
        Assert.assertEquals(adresseRef.getNpa(), clone.getNpa());
        Assert.assertEquals(adresseRef.getLocalite(), clone.getLocalite());
        Assert.assertEquals(adresseRef.getRue(), clone.getRue());
    }
    
    @Test
    public void testClone2() throws CloneNotSupportedException {
        Adresse adresse = new Adresse();
        Adresse clone = new Adresse(adresse);
        
        Assert.assertNotSame(adresse, clone);
        Assert.assertEquals(adresse, clone);
        
        Assert.assertEquals(adresse.getNpa(), clone.getNpa());
        Assert.assertEquals(adresse.getLocalite(), clone.getLocalite());
        Assert.assertEquals(adresse.getRue(), clone.getRue());
    }
    
}
