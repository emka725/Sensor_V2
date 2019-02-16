/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCommandGroup extends CommandGroup {
  final static double SPEED = 0.5;
  
  public AutonomousCommandGroup() {
    addSequential(new AutoTapeDriveCommand(SPEED));
    addSequential(new AutoStraightDriveCommand(SPEED, 0.3, false));
  }
}
