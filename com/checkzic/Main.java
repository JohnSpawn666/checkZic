package com.checkzic;

import com.checkzic.file.FileReader;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    /**
     * Programme principal
     *
     * @param args Arguments java
     */
    public static void main(String[] args) {

        // Récupère les données du fichier
        FileReader fileReader = new FileReader();
        try {
            List<String[]> strings = fileReader.readAllLines();
            System.out.println(strings);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
