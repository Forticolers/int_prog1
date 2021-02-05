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
public class PileTest {

    private Data data_11;
    private Data data_22;
    private Data data_33;
    private Data data_44;
    private Data data_55;
    
    public PileTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        data_11 = new Data(11);
        data_22 = new Data(22);
        data_33 = new Data(33);
    }
    @Test
    public void test1() throws Exception{
        Pile p = new Pile();
        Assert.assertTrue(p.etreVide());
        p.empiler(data_11);
        Assert.assertFalse(p.etreVide());
        p.depiler();
        Assert.assertTrue(p.etreVide());
    }
    @Test
    public void test2() throws Exception{
        Pile p = new Pile();
        p.empiler(data_11);
        p.empiler(data_22);
        p.empiler(data_33);
        Assert.assertEquals(p.retournerSommet(), data_33);
        
        p.depiler();
        Assert.assertEquals(p.retournerSommet(), data_22);
    }
    @Test
    public void test3() throws Exception{
        Pile p = new Pile();
        p.empiler(data_11);
        p.empiler(data_22);
        p.empiler(data_33);
        p.empiler(data_44);
        p.empiler(data_55);
       Assert.assertTrue(p.etrePlein());
    }
    @After
    public void tearDown() {
    }

   
    
}
