/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.jeanbourquj.cifom;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class DataTest {

    /**
     * Test si lors de la création d'un oject Data, l'objet ne deviens pas null
     */
    @Test
    public void createData() {
        Integer i = 10;
        Data d = new Data(i);
        assertNotNull(d);
    }
    /**
     * Test si la veleur est correctement assigné à 10
     */
    @Test
    public void getValeur() {
        Data d = new Data(10);
        assertEquals(d.getValeur(), new Integer(10));
    }
    /**
     * Test si le setvaleur fonctionne correctement
     */
    @Test
    public void setValeur() {
        Integer i = 10;
        Integer j = 15;
        Data d = new Data(i);
        assertEquals(d.getValeur(), i);
        d.setValeur(j);
        assertNotEquals(d, i);
    }
    /**
     * Test si le setvaleur fonctionne correctement
     */
    @Test
    public void updateTest() {
        Integer i = 10;
        Integer j = 15;
        Data d = new Data(i);
        Data d2 = new Data(j);
        assertNotEquals(d, d2);
        d.update(d2);
        assertEquals(d, d2);
    }
     /**
     * Test si le setvaleur fonctionne correctement
     */
    @Test
    public void equalsTest() {
        Integer i = 10;
        Integer j = 15;
        Data d = new Data(i);
        Data d2 = new Data(j);
        assertFalse(d.equals(d2));
        d2 = d;
        assertTrue(d.equals(d2));
    }
    /**
     * Test hashcode
     */
    @Test
    public void hashcode(){
        Integer i = 10;
        Data d = new Data(i);
        Data d2 = new Data(i);
        assertEquals(d.hashCode(), d2.hashCode());
    }
}
