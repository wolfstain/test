package co.s4n.scad.backend.entities;

public class TurnRightCommand extends DroneCommand {

    public TurnRightCommand(Drone drone) {
        super(drone);
    }

    @Override
    public void Execute() {
        drone.turnRight();
    }
}
