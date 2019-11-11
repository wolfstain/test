package co.s4n.scad.backend.entities;

import java.awt.Point;
import java.util.ArrayList;

public class Location {
    public Point position;
    public Point direction;
    private ArrayList<Point> directions;
    public Location(Point position, Point direction){
        this.position = position;
        this.direction = direction;
        directions= DroneDirection.ALL_DRON_DIRECTIONS;
    }

    public Point turnLeft(){
        int idx = directions.indexOf(direction);
        direction = directions.get(Math.floorMod(idx-1,4));
        return direction;
    }

    public Point turnRight(){
        int idx = directions.indexOf(direction);
        direction = directions.get(Math.floorMod(idx+1,4));
        return direction;
    }

    public Point move(){
        position.move(position.x+direction.x,position.y+direction.y);
        return position;
    }

    public String getLocation(){
        return "("+position.x+", "+position.y+")";
    }

    public String getDirection(){
        if(direction==DroneDirection.NORTH){
            return "Norte";
        }
        if(direction==DroneDirection.WEST){
            return "Occidente";
        }
        if(direction==DroneDirection.SOUTH){
            return "Sur";
        }
        if(direction==DroneDirection.EAST){
            return "Oriente";
        }
        return "Direction not included: "+direction.toString();
    }

}
