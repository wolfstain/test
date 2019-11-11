package co.s4n.scad.backend.entities;

public class TurnLeftCommand extends DroneCommand {

    public TurnLeftCommand(Drone drone) {
        super(drone);
    }

    @Override
    public void Execute() {
        drone.turnLeft();
    }
}
