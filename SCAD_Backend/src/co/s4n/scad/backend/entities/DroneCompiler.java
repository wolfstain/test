package co.s4n.scad.backend.entities;

public class DroneCompiler {
    private MoveCommand move ;
    private TurnLeftCommand turnLeft ;
    private TurnRightCommand turnRight ;
    private Drone drone;
    private DroneMovementController controller;
    private String commands;

    public DroneCompiler(Drone drone, String commands){
        this.drone = drone;
        controller = new DroneMovementController();
        this.commands = commands;
        execute();
    }

    private void execute(){
        for(String command: commands.split("")){
            switch(command){
                case("A"):{
                    move = new MoveCommand(drone);
                    controller.Commands.add(move);
                    break;}
                case("I"):{
                    turnLeft = new TurnLeftCommand(drone);
                    controller.Commands.add(turnLeft);
                    break;}
                case("D"):{
                    turnRight = new TurnRightCommand(drone);
                    controller.Commands.add(turnRight);
                    break;}
            }
            controller.ExecuteCommands();
        }
    }
}
