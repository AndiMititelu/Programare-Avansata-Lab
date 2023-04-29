package org.example;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class AlbumImporter {
    public static void importAlbum() {
        try(CSVReader reader = new CSVReader(new FileReader("src/main/resources/albumlist.csv"))){
            String[] line;
            //Skip header row
            reader.readNext();
            while ((line = reader.readNext()) != null){
                String title = line[2];
                String artist = line[3];
                int releaseYear = Integer.parseInt(line[1]);
                String genre = line[4];
                Album album = new Album(releaseYear, title, artist, genre);
                AlbumDAO albumDAO = new AlbumDAO();
                albumDAO.create(album);
                System.out.println("Importing...");
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
