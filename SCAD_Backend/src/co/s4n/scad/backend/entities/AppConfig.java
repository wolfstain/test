package co.s4n.scad.backend.entities;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class AppConfig {
    private int numberDrones;
    private int numberOfDeliveries;
    private int range;
    private static Location initLocation;

    public AppConfig() throws IOException {
        //Load the config file
        String configPath = Thread.currentThread().getContextClassLoader().getResource("config").getPath();
        String appConfigPath = configPath +"/config.properties";
        Properties appProps = new Properties();
        appProps.load(new FileInputStream(appConfigPath));

        /*load the constrains related with:
        * numberDrones: operative drones at time,
        * deliveries: number of deliveries per drone
        * and the range of operation of each drone.
        */
        numberDrones = Integer.parseInt(appProps.getProperty("dronesAvailable","1"));
        numberOfDeliveries = Integer.parseInt(appProps.getProperty("deliveries","3"));
        range = Integer.parseInt(appProps.getProperty("radius","3")); ;
        // Load the initial Location
        int initLocX = Integer.parseInt(appProps.getProperty("initialPositionX","0"));
        int initLocY = Integer.parseInt(appProps.getProperty("initialPositionY","0"));
        Point initPosition= new Point(initLocX,initLocY);
        int directionX = Integer.parseInt(appProps.getProperty("initialDirectionX","0"));
        int directionY = Integer.parseInt(appProps.getProperty("initialDirectionY","0"));
        Point initDirection= new Point(directionX,directionY);
        initLocation=new Location(initPosition,initDirection);
    }

    public int getNumberDrones(){
        return this.numberDrones;
    }

    public int getDeliveries(){
        return this.numberOfDeliveries;
    }

    public Location getInitLocation(){
        return this.initLocation;
    }

}
