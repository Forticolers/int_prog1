/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.jeanbourquj.files;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;

/**
 *
 * @author JeanbourquJ
 */
public class CountReader implements Closeable {

    private final BufferedReader reader;

    public CountReader(BufferedReader br) {
        this.reader = br;
    }

    @Override
    public void close() throws IOException {
        if (reader != null) {
            reader.close();
        }
    }

    public String readAll() throws IOException {
        String fileData = null;
        String currentLine = reader.readLine();
        while (currentLine != null) {
            fileData += currentLine;
            
            currentLine = reader.readLine();
        }
        return fileData;
    }
}
