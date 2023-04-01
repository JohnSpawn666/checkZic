package com.checkzic.file;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

/**
 * Classe gérant la gestion des fichiers
 */
public class FileReader {

    private static final String PROPERTIES_FILE = "file.properties";
    private static final String PROPERTY_FILE_PATH = "pathCsv";

    /**
     * Lit les données du fichier CSV
     *
     * @return Données du fichier
     */
    public List<String[]> readAllLines() {
        try (Reader reader = Files.newBufferedReader(
                Paths.get(FileReader.getFileProperties().getProperty(PROPERTY_FILE_PATH)));
             CSVReader csvReader = new CSVReaderBuilder(reader).withCSVParser(
                     new CSVParserBuilder().withSeparator(';').build()).build()) {
            return csvReader.readAll();
        } catch (IOException | CsvException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Récupère les propriétés du fichier file.properties
     *
     * @return Propriétés du fichier
     */
    public static Properties getFileProperties(){
        ClassLoader loader = FileReader.class.getClassLoader();
        try(InputStream inputStream = loader.getResourceAsStream(PROPERTIES_FILE)){
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
