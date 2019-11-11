package co.s4n.scad.backend.entities;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class DroneOS {

    //default constructor
    public DroneOS() throws IOException {
        this(null,null);
    }

    public DroneOS(InputFiles inpFile,OutputFiles outFile) throws IOException {

        RouteAnalyzer check;
        DroneCompiler dr ;
        //get the current configuration of the system
        AppConfig appConf= new AppConfig();
        //load the current inputs
        if(inpFile==null)
            inpFile = new InputFiles();
        if(outFile==null){
            outFile= new OutputFiles();}

        ArrayList<String> deliverCommands=inpFile.getDeliveries();
        //Config the Drone
        System.out.println(appConf.getInitLocation().direction);
        Drone drone = new Drone(appConf.getInitLocation());
        System.out.println("start:"+drone.getLocation().position+" "+drone.getLocation().direction);

        for(String commands: deliverCommands){
             System.out.println("***Checking Route: "+commands+" ***");
             check = new RouteAnalyzer(drone.getLocation(),commands);
             if(check.isValid()){
                 drone = new Drone(drone.getLocation());
                 new DroneCompiler(drone,commands);
                 System.out.println(drone.getLocationMessage());
                 outFile.addLine(drone.getLocationMessage());
             }else{
                 outFile.writeFile();
                 break;
             }
        }
        outFile.writeFile();
    }

}
