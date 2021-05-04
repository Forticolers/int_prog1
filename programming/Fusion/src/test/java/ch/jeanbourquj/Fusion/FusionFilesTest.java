/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.jeanbourquj.Fusion;

import ch.jeanbourquj.Fusion.files.FusionReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JeanbourquJ
 */
public class FusionFilesTest {

    private File file1;
    private File file2;
    private File fileRef;
    private FusionFiles fusion;
    private List<String> listRef;

    public FusionFilesTest() {
    }

    @Before
    public void setUp() {
        file1 = new File("file1.txt");
        file2 = new File("file2.txt");
        fileRef = new File("file3Ref.txt");

        fusion = new FusionFiles(file1, file2);

        try (FusionReader reader
                = new FusionReader(
                        new BufferedReader(new FileReader(fileRef)))) {
            listRef = reader.readAll();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @After
    public void tearDown() {
    }

    @Test
    public void fusionFiles() {
        List<String> refList = FusionReader.readFile(fileRef);
        fusion.fileFusion("file3.txt");
        List<String> fusionFile = FusionReader.readFile(new File("file3.txt"));
        for(int i = 0; i< refList.size(); i++){
           Assert.assertEquals(String.format("Error for iteration %d, expecting '%s' but got '%s'", i, refList.get(i), fusionFile.get(i))
                   ,refList.get(i), fusionFile.get(i));
        }
    }
}
