/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.jeanbourquj.Fusion;

import ch.jeanbourquj.Fusion.files.FusionReader;
import ch.jeanbourquj.Fusion.files.FusionWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Collator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JeanbourquJ
 */
public class FusionFiles {

    private final File file1;
    private final File file2;

    public FusionFiles(File f1, File f2) {
        if (f1 == null || f2 == null) {
            throw new RuntimeException("Error: invalid filename.");
        }
        this.file1 = f1;
        this.file2 = f2;
    }

   

    private List<String> extractContentFromFile(File f) {
        List<String> returnValues = new ArrayList<>();
        try (FusionReader reader
                = new FusionReader(
                        new BufferedReader(new FileReader(f)))) {
            returnValues = reader.readAll();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return returnValues;
    }

    private void writeListInFile(List<String> list, File f) {
        try (FusionWriter writer
                = new FusionWriter(
                        new PrintWriter(
                                new FileWriter(f)))) {
            list.forEach(line -> {
                writer.write(line);
            });
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void fileFusion(String fileName) {
        List<String> f1 = extractContentFromFile(file1);
        List<String> f2 = extractContentFromFile(file2);
        List<String> file3List = new ArrayList<>();
        file3List.addAll(f1);
        file3List.addAll(f2);
        java.util.Collections.sort(file3List, Collator.getInstance());
        File file3 = new File(fileName);

        writeListInFile(file3List, file3);

    }
}
