/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.jeanbourquj.Comptage;

import ch.jeanbourquj.Comptage.files.FilesReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.jshell.spi.ExecutionControl;

/**
 *
 * @author JeanbourquJ
 */
public class Counter {

    private static final Logger LOG
            = Logger.getLogger(Counter.class.getName());
    private final File file;

    public Counter(File pFile) {
        if (pFile == null) {
            throw new RuntimeException("Error: invalid filename.");
        }
        this.file = pFile;
    }

    public int countChars() {
        int count = 0;
        try (FilesReader reader
                = new FilesReader(
                        new BufferedReader(
                                new FileReader(file)))) {
            char c = reader.readNextChar();
            count++;
            while (c != '\0') {
                c = reader.readNextChar();
                if (Character.isLetterOrDigit(c)) {
                    count++;
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return count;
    }

    public int countLines() {
        int count = 0;
        try (FilesReader reader
                = new FilesReader(
                        new BufferedReader(
                                new FileReader(file)))) {
            String line = reader.readNextLine();
            count++;
            while (line != null) {
                line = reader.readNextLine();
                if (line != null) {
                    count++;
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return count;
    }

    private enum Letters {
        A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z;
    }

    public Map<Character, Integer> countFrequency() {
        Map<Character, Integer> lettersFrequency = new HashMap<Character, Integer>();
        try (FilesReader reader
                = new FilesReader(
                        new BufferedReader(
                                new FileReader(file)))) {
            char c = reader.readNextChar();
            for (Letters l : Letters.values()) {
                if (Character.isLetter(c)) {
                    char lChar = l.toString().charAt(0);
                    if (Character.toUpperCase(c) == lChar) {
                        if (lettersFrequency.containsKey(lChar)) {
                            lettersFrequency.put(lChar, lettersFrequency.get(lChar) + 1);
                        } else {
                            lettersFrequency.put(lChar, 1);
                        }

                    }
                }
            }
            while (c != '\0') {
                c = reader.readNextChar();

                for (Letters l : Letters.values()) {
                    if (Character.isLetter(c)) {
                        char lChar = (Character) l.toString().charAt(0);
                        if (Character.toUpperCase(c) == lChar) {
                            if (lettersFrequency.containsKey(lChar)) {
                                lettersFrequency.put(lChar, lettersFrequency.get(lChar) + 1);
                            } else {
                                lettersFrequency.put(lChar, 1);
                            }

                        }
                    }
                }

            }
            for (Letters l : Letters.values()) {
                if (!lettersFrequency.containsKey(l.toString().charAt(0))) {
                    lettersFrequency.put(l.toString().charAt(0), 0);
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return lettersFrequency;
    }

    private int extractNumWords(String str) {
        return str.split(" ").length;
    }

    public int countWords() {
        int wordCount;
        try (FilesReader reader
                = new FilesReader(
                        new BufferedReader(
                                new FileReader(file)))) {
            wordCount = 0;
            String line = reader.readNextLine();
            wordCount += extractNumWords(line);
            while (line != null) {
                line = reader.readNextLine();
                if (line != null) {
                    wordCount += extractNumWords(line);
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return wordCount;
    }
}
