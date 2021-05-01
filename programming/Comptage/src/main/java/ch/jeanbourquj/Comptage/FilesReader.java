/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.jeanbourquj.Comptage.files;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;

/**
 *
 * @author JeanbourquJ
 */
public class FilesReader implements Closeable {

    private final BufferedReader reader;

    public FilesReader(BufferedReader br) {
        this.reader = br;
    }

    @Override
    public void close() throws IOException {
        if (reader != null) {
            reader.close();
        }
    }

    public String readNextLine() throws IOException {
        String currentLine = reader.readLine();
        return currentLine;
    }

    public char readNextChar() throws IOException {
        int charInt = reader.read();
        char currChar;
        if (charInt != -1) {
            currChar = (char) charInt;

        } else {
            currChar = '\0';
        }
        return currChar;
    }
}
