/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

// import frc.robot.commands.StraightGyroDriveCommand;
// import frc.robot.commands.instant.ResetLiftPositionCommand;
// import frc.robot.commands.instant.ToggleClawPositionCommand;
// import frc.robot.commands.instant.IntakeOpenCommand;

import edu.wpi.first.wpilibj.Joystick;
// import frc.robot.XBoxController;
// import frc.robot.XBoxPOVButton;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.instant.ChangeGlowMode;
import frc.robot.subsystems.Glow;

public class OI {

	// input number definitions
	final int L_JOY = 0;
	final int R_JOY = 1;
	final int XBOX = 2;

	// button number definitions

	// right joystick buttons
	// -- final int BUTTON_NAME = number;

	// left joystick buttons

	// controller initialization
	public Joystick l_joy = new Joystick(L_JOY);
	public Joystick r_joy = new Joystick(R_JOY);
	// public XBoxController xbox = new XBoxController(XBOX);

	// button initialization
	// -- public Button buttonName = new JoystickButton(controller, BUTTON_NAME);
	public Button tapeButton = new JoystickButton(l_joy, 2);

	public Button discoButton = new JoystickButton(l_joy, 3);

	public void init() {
		// Inithalise event handling
		// -- buttonName.whenHeld(new Command())
		tapeButton.whileHeld(new TapeDriveCommand());
		discoButton.whenPressed(new ChangeGlowMode(Glow.Mode.DISCO));
	}
}