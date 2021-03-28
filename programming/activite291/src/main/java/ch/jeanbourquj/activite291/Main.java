/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.jeanbourquj.activite291;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author JeanbourquJ
 */
public class Main {
    private static String str_dir = System.getProperty("user.dir");
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File[] filesName;
        File filesDir = new File(str_dir);
        filesName = filesDir.listFiles();
        System.out.format("Contenu du répertoire : %s\n", str_dir);
        for (File f : filesName){
           Date d = new Date(f.lastModified());
           DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm");
           System.out.printf("%s %s %s\t%s %s %s\n", 
                   (f.canRead() ? "R": " "), 
                   (f.canWrite() ? "W" : " "), 
                   (f.canExecute() ? "X" : " "),
                   (f.isDirectory() ? "<REP>": "     "), 
                   dateFormat.format(d),
                   f.getName());
        }
    }
    
}
