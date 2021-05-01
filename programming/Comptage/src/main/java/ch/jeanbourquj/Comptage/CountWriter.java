/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.jeanbourquj.Comptage.files;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author JeanbourquJ
 */
public class CountWriter implements Closeable {

    private final PrintWriter writer;

    public CountWriter(PrintWriter pw) {
        this.writer = pw;
    }

    @Override
    public void close() throws IOException {
        if(writer != null){
            writer.close();
        }
    }

    
}
