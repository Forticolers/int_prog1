/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.jeanbourquj.Fusion.files;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;

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
}
