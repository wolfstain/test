package co.s4n.scad.backend.entities;

import java.awt.Point;
import java.util.ArrayList;

public class Drone {

    private Location dronLoc;
    private ArrayList <Point> directions;

    public Drone(Location dronLoc){
        this.dronLoc=dronLoc;
    }

    public void turnLeft(){
        // At the next step, take a left turn relative to the current direction.
        dronLoc.turnLeft();
    }

    public void turnRight(){
        // At the next step, take a right turn relative to the current direction.
        dronLoc.turnRight();
    }

    public void move(){
        // Move the dron by one step
        dronLoc.move();
    }

    public Location getLocation(){
        return dronLoc;
    }

    public String getDirection(){
        return dronLoc.getDirection();
    }

    public String getLocationMessage(){
        return dronLoc.getLocation()+" dirección "+dronLoc.getDirection();
    }

}
