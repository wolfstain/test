package co.s4n.scad.backend.entities;

import java.awt.Point;

public class RouteAnalyzer {
    private int radius;
    private Location loc;
    private boolean valid;

    public RouteAnalyzer(Location loc,String commands){
        valid=true;
        radius=10;
        this.loc=new Location(new Point(loc.position),new Point(loc.direction));
        for(String command: commands.split("")){
            //System.out.println(command);
            analyze(command);
            if(!validateRoute()){
                break;
            }
        }
    }
    private boolean validateRoute(){
        if(Math.abs(loc.position.x)>radius/2 ||Math.abs(loc.position.y)>radius/2 ){
            valid = false;
            System.out.println(loc.position+" fuera del barrio");
            return false;
        }
        return true;
    }

    private void analyze(String command){
        switch (command){
            case "A":{
                loc.move();
                break;}
            case "I":{
                loc.turnLeft();
                break;}
            case "D":{
                loc.turnRight();
                break;}
        }
    }

    public boolean isValid(){
        return valid;
    };

}
