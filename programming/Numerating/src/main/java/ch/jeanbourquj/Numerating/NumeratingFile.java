/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.jeanbourquj.Numerating;

import ch.jeanbourquj.Numerating.files.NumeratinWriter;
import ch.jeanbourquj.Numerating.files.NumeratingReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author JeanbourquJ
 */
public class NumeratingFile {

    private File file1;

    public NumeratingFile(File f) {
        this.file1 = f;
    }
    
    private void writeListInFileNumerating(List<String> list, File f) {
        try (NumeratinWriter writer
                = new NumeratinWriter(
                        new PrintWriter(
                                new FileWriter(f)))) {            
            String numListTemplate = "%d - %s";
            String lineStr;
            for (int i = 0; i < list.size(); i++) {
                lineStr = String.format(numListTemplate, i + 1, list.get(i));
                writer.write(lineStr);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    private List<String> extractContentFromFile(File f) {
        List<String> returnValues = new ArrayList<>();
        try (NumeratingReader reader
                = new NumeratingReader(
                        new BufferedReader(new FileReader(f)))) {
            returnValues = reader.readAll();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return returnValues;
    }

    public File numerateFile(){
        List<String> f1 = extractContentFromFile(file1);
        
        File fileNumerated = new File(String.format("Numerated-%s", this.file1.getName()));
        
        writeListInFileNumerating(f1, fileNumerated);
        return fileNumerated;
    }
    
}
