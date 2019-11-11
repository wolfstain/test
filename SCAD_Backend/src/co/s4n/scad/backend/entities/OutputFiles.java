package co.s4n.scad.backend.entities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class OutputFiles {
    private ArrayList<String> text;
    private File outputFile;

    public OutputFiles(String folderPath, String filename){
        text=new ArrayList<>();
        text.add("== Reporte de Entregas ==");
        outputFile = new File(folderPath + filename);
    }

    public OutputFiles(){
        this(System.getProperty("user.dir")+"/resources/output","/out.txt");
    }

    public void addLine(String line){
        text.add(line);
    }

    public void writeFile(){

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))){
            for (String line:text) {
                writer.write(line+"\n");
            }
        }
        catch(IOException e){
            // handle the exception
            e.printStackTrace();
        }
    }
}
