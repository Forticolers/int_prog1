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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JeanbourquJ
 */
public class FusionFiles {
    
    private final File file1;
    private final File file2;
    
    public FusionFiles(File f1, File f2){
        if(f1 == null || f2 == null){
            throw new RuntimeException("Error: invalid filename.");
        }
        this.file1 = f1;
        this.file2 = f2;
    }
    private void sortArrays(){
        
    }
    private List<String> extractContentFromFile(File f){
        List<String> returnValues = new ArrayList<>();
        try(FusionReader reader 
                = new FusionReader(
                    new BufferedReader(new FileReader(f)))){
            String line = reader.read();
            returnValues.add(line);
            while(line != null){
                line = reader.read();
                if(line != null){
                    returnValues.add(line);
                }
            }
        }catch(IOException ex){
            throw new RuntimeException(ex);
        }
        return returnValues;
    }
    public void fileFusion(){
        
    }
}
