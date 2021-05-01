/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.jeanbourquj;

import ch.jeanbourquj.Comptage.Counter;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JeanbourquJ
 */
public class CounterTest {

    String[] args;
    Counter counter;
    File file;

    public CounterTest() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    @Test
    public void countLinesTest() {
        file = new File("countLines.txt");
        counter = new Counter(file);
        int count = counter.countLines();
        int lineCountRef = 5;
        Assert.assertEquals("", lineCountRef, count);
    }

    @Test
    public void countCharsTest() {
        file = new File("countChars.txt");
        counter = new Counter(file);
        int count = counter.countChars();
        int lineCountRef = 26;
        Assert.assertEquals("", lineCountRef, count);
    }

    private enum Letters {
        A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z;
    }

    @Test
    public void countFrequencyTest() {
        file = new File("countWordFrequency.txt");
        counter = new Counter(file);
        Map<Character, Integer> listLetters = counter.countFrequency();
        Map<Character, Integer> listRef = new HashMap<Character, Integer>();
        listRef.put('A', 4);
        listRef.put('B', 3);
        listRef.put('C', 3);
        listRef.put('D', 2);
        listRef.put('Z', 0);
        for (Letters l : Letters.values()) {
            if (!l.equals(Letters.A) && !l.equals(Letters.B)
                    && !l.equals(Letters.C) && !l.equals(Letters.D) && !l.equals(Letters.Z)) {
                listRef.put(l.toString().charAt(0), 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : listLetters.entrySet()) {
            Object key = entry.getKey();
            Object val = entry.getValue();
            Assert.assertEquals(String.format("ref %s : %d\nyours %s : %d", 
                    key, listRef.get(key), key, listLetters.get(key)), listRef.get(key), listLetters.get(key));

        }
    }
    
    @Test
    public void countWordsTest(){
        file = new File("countWords.txt");
        counter = new Counter(file);
        
        int numRef = 7;
        int count = counter.countWords();
        
        Assert.assertEquals(numRef, count);
    }
}
