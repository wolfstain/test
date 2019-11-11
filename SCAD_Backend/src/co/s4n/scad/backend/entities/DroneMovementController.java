package co.s4n.scad.backend.entities;

import java.util.LinkedList;
import java.util.Queue;

public class DroneMovementController {
    public Queue<DroneCommand> Commands;

    public DroneMovementController(){
        Commands = new LinkedList<DroneCommand>();
    }

    public void ExecuteCommands(){
        while (Commands.size() > 0){
            DroneCommand command = Commands.remove();
            command.Execute();
        }
    }
}
