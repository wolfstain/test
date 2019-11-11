package co.s4n.scad.backend.entities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InputFiles {
    private ArrayList<String> deliveries;

    public InputFiles(String folderPath, String fileName){
        BufferedReader reader;
        deliveries = new  ArrayList<String>();
        try {
            reader = new BufferedReader(new FileReader(
                    folderPath+fileName));
            String line = reader.readLine();
            while (line != null ) {
                deliveries.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public InputFiles() throws IOException {
        this(System.getProperty("user.dir")+"/resources/input","/in.txt");
    }

    public ArrayList<String> getDeliveries(){
        return deliveries;
    }

}
