/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.jeanbourquj.Numerating;

import ch.jeanbourquj.Numerating.files.NumeratingReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JeanbourquJ
 */
public class NumeratingFileTest {
    private File file1;
    private File fileRef;
    private NumeratingFile numerating;
    private List<String> listRef;
    public NumeratingFileTest() {
    }
    
    @Before
    public void setUp() {
        file1 = new File("file.txt");
        fileRef = new File("fileRef.txt");
        numerating = new NumeratingFile(file1);
        
        listRef = NumeratingReader.readFile(fileRef);

    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of numerateFile method, of class NumeratingFile.
     */
    @Test
    public void testNumerateFile() {
        File fileReturn = numerating.numerateFile();
        
        List<String> numeratedFileList = NumeratingReader.readFile(fileReturn);
        for(int i = 0; i< listRef.size(); i++){
           Assert.assertEquals(String.format("Error for iteration %d, expecting '%s' but got '%s'", i, listRef.get(i), numeratedFileList.get(i))
                   ,listRef.get(i), numeratedFileList.get(i));
        }

    }
    
}
