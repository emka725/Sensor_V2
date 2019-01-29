package frc.robot.commands.instant;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

public class Stop extends InstantCommand {

    public Stop() {
        super();
        requires(Robot.drivetrain);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.drivetrain.drive(0, 0);
    }
}
