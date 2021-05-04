/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.jeanbourquj.Fusion.files;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JeanbourquJ
 */
public class FusionReader implements Closeable{

    private final BufferedReader reader;
    
    public FusionReader(BufferedReader br){
        this.reader = br;
    }
    @Override
    public void close() throws IOException {
        if(reader != null){
            reader.close();
        }
    }
    public String read() throws IOException{
        String line = reader.readLine();
        return line;
    }
    public List<String> readAll() throws IOException{
        List<String> returnList = new ArrayList<>();
        String str = read();
        returnList.add(str);
        while(str != null){
            str = read();
            if(str != null){
                returnList.add(str);
            }
        }
        return returnList;
    }
    public static List<String> readFile(File f){
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
}
