/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                             */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class DriveCommand extends Command {

  final double DEADZONE = 0.1;

  //This is the one we want
  public DriveCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    ////
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //  Pushing the joysticks forward gives a negative Y value, whereas pushing them backward gives a positive Y value
    double lSpeed = -Robot.oi.l_joy.getY();
    double rSpeed = -Robot.oi.r_joy.getY();

    if(Math.abs(lSpeed) < DEADZONE) lSpeed = 0;
    if(Math.abs(rSpeed) < DEADZONE) rSpeed = 0;
    /*
    SmartDashboard.putNumber("Left Speed", lSpeed);
    SmartDashboard.putNumber("Right Speed", rSpeed);
    */
    Robot.drivetrain.drive(Math.pow(lSpeed, 3), Math.pow(rSpeed, 3));
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
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