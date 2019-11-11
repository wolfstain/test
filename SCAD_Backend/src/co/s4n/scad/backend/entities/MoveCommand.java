package co.s4n.scad.backend.entities;

public class MoveCommand extends DroneCommand {

    public MoveCommand(Drone drone) {
        super(drone);
    }

    @Override
    public void Execute() {
        drone.move();
    }
}
