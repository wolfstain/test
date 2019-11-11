package co.s4n.scad.backend.entities;

public abstract class DroneCommand {
        protected Drone drone;
        public DroneCommand(Drone drone){
            this.drone = drone;
        }
        public abstract void Execute();
}
