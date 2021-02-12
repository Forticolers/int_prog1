package utils;

import ch.jeanbourquj.cifom.Data;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author dominique huguenin (dominique.huguenin at rpn.ch)
 */
public class PileTest {

    private int taillePile;
    private Pile pileRef;

    /**
     *
     */
    public PileTest() {
    }

    /**
     *
     */
    @Before
    public void setUp() {
        taillePile = 5;
        pileRef = new Pile(taillePile);
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void testCreationPile() throws Exception {
        Assert.assertTrue("Erreur:La pile devrait etre vide!",
                pileRef.etreVide());
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void testEmpiler() throws Exception {
        pileRef.empiler(new Data(11));
        Assert.assertFalse("Erreur:La pile ne devrait pas etre vide!",
                pileRef.etreVide());
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void testDepiler() throws Exception {
        pileRef.empiler(new Data(11));
        pileRef.depiler();

        Assert.assertTrue("Erreur:La pile ne devrait pas etre vide!",
                pileRef.etreVide());
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void testSommet() throws Exception {
        pileRef.empiler(new Data(11));
        pileRef.empiler(new Data(22));

        Data n33 = new Data(33);
        pileRef.empiler(n33);
        Data n33bis = pileRef.retournerSommet();

        Assert.assertEquals(n33, n33bis);
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void testDepilerSommet() throws Exception {
        Data n11 = new Data(11);
        Data n22 = new Data(22);
        Data n33 = new Data(33);

        pileRef.empiler(n11);
        pileRef.empiler(n22);
        pileRef.empiler(n33);
        pileRef.depiler();

        Data n22bis = pileRef.retournerSommet();

        Assert.assertEquals(n22, n22bis);

    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void testPilePleine() throws Exception {
        Data n11 = new Data(11);
        Data n22 = new Data(22);
        Data n33 = new Data(33);
        Data n44 = new Data(44);
        Data n55 = new Data(55);

        pileRef.empiler(n11);
        pileRef.empiler(n22);
        pileRef.empiler(n33);
        pileRef.empiler(n44);
        pileRef.empiler(n55);

        Assert.assertTrue("Erreur:La pile devrait etre pleine!", pileRef.etrePlein());
    }

    /**
     *
     * @throws Exception
     */
    @Test(expected = RuntimeException.class)
    public void testEmpilerPilePleine() throws Exception {
        Data n11 = new Data(11);
        Data n22 = new Data(22);
        Data n33 = new Data(33);
        Data n44 = new Data(44);
        Data n55 = new Data(55);
        Data n66 = new Data(66);

        pileRef.empiler(n11);
        pileRef.empiler(n22);
        pileRef.empiler(n33);
        pileRef.empiler(n44);
        pileRef.empiler(n55);

        pileRef.empiler(n66);
        Assert.fail();
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void testPileVide() throws Exception {
        pileRef.depiler();
        pileRef.depiler();
        pileRef.depiler();

        pileRef.empiler(new Data(11));
        
        Assert.assertFalse("Erreur:La pile ne devrait pas etre vide!",
                pileRef.etreVide());

    }

}
