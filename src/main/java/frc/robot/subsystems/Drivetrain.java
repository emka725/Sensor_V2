/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.TestPIDCommand;
import frc.robot.commands.DriveCommand;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new DriveCommand());
	}
	
	public void drive(double l, double r) {
		//	Other motors are followers
		RobotMap.left_drive_victor_1.setSpeed(l);
		RobotMap.right_drive_victor_1.setSpeed(-r);  //  r is inverted because the left and right motors are oriented in opposite directions
	}
	
	public Object[] getAutoDriveOutput(double speed, double distance, double[] initial_encoder_positions, double time, boolean line_stop) {
		final double SLOW_DOWN_THRESHOLD = 0.4;
    	final double MIN_SPEED = 0.2;
		final double FINISHED_TOLERANCE = 0.05;
		
    	boolean finished = false;
    	double l = 0;
    	double r = 0;
		
		//	double average_encoder_position = time;	//	Unsure as to why time is being used in place of the encoders; perhaps because it's a good approximation? 
		double average_encoder_position = RobotMap.victor_encoder.getDistance();
		double distance_left = distance - average_encoder_position;
    	if (distance_left > SLOW_DOWN_THRESHOLD) {
    		l = speed;
    	} else if (distance_left < -SLOW_DOWN_THRESHOLD) {
    		l = -speed;
		} else if (distance_left > 0) {
    		l = speed * (distance_left / SLOW_DOWN_THRESHOLD);
    	} else {
			l = -speed * (distance_left / SLOW_DOWN_THRESHOLD);
		}
		
    	if (l < MIN_SPEED && l > 0) {
    		l = MIN_SPEED;
    	} else if (l < -MIN_SPEED && l < 0) {
    		l = -MIN_SPEED;
		}
		
    	//	I'll re-add the line stop conditional once we get the light sensors on the 2019 -Shawn
    	//	if (Math.abs(distance_left) < FINISHED_TOLERANCE || (Robot.distance_sensors.isOverLine() && line_stop)) {
		if (Math.abs(distance_left) < FINISHED_TOLERANCE) {
			finished = true;
    	}
    	
    	r = l;
    	
    	return new Object[] {l, r, finished};
	}
}
