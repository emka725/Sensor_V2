/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class AutoStraightDriveCommand extends Command {
    final static double WHEEL_RADIUS = 0.08;                        //  8 cm, or 0.08 m
    final static double RADIANS_TO_ROTATIONS = 1 / (2 * Math.PI);   //  1 rotation has 2π radians
    final static double GEAR_RATIO = 1;                             //  Ratio of wheel rotations to motor rotations
    //  Dividing by wheel radius (in meters) gives angular distance (in radians)
    //  Dividing by 2π gives number of wheel rotations
    //  Dividing by gear ratio gives the number of motor rotations
    final static double LINEAR_TO_ROTATION = 1 / WHEEL_RADIUS * RADIANS_TO_ROTATIONS / GEAR_RATIO;
    
    private double speed;
    private double distance;
    private boolean finished = false;
    private boolean line_stop;

    private double[] initial_encoder_positions;

    public AutoStraightDriveCommand(double speed, double distance, boolean line_stop) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.drivetrain);
        this.speed = speed;
        this.distance = distance * LINEAR_TO_ROTATION;
        this.line_stop = line_stop;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        RobotMap.victor_encoder.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        Object[] auto_drive_output = Robot.drivetrain.getAutoDriveOutput(speed, distance, initial_encoder_positions, timeSinceInitialized(), line_stop);
        Robot.drivetrain.drive((double) auto_drive_output[0], (double) auto_drive_output[1]);
        finished = (boolean) auto_drive_output[2];
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
      return finished;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
