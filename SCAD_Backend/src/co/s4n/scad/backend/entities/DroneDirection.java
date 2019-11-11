package co.s4n.scad.backend.entities;

import java.awt.Point;
import java.util.ArrayList;

public class DroneDirection {
    // Defines all possible directions the drone can take, as well as the corresponding offsets.

    public static Point NORTH = new Point(0,1);
    public static Point EAST = new Point(1,0);
    public static  Point SOUTH = new Point(0,-1);
    public static Point WEST = new Point(-1,0);

    static ArrayList <Point> ALL_DRON_DIRECTIONS = new ArrayList<Point>() {
        {
            add(NORTH);
            add(EAST);
            add(SOUTH);
            add(WEST);
        }
    };

}
