package frc.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import frc.robot.sensors.*;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	public static final int PID_MODE = 0;  //0 for closed loop 1 for cascaded closed loop

	/**
	 * Declaring pins
	 */
	private static final int LEFT_VICTOR_1 = 1;
	private static final int RIGHT_VICTOR_1 = 0;
    
    private static final int DISTANCE_SENSOR = 0;
	private static final int ANALOG_TAPE_SENSOR = 1;
	private static final int DIGITAL_TAPE_SENSOR = 9;

	private static final int SPARK = 2;

	private static final int ENCODER_A = 7;
	private static final int ENCODER_B = 8;
	/**
	 * Creating motor controller objects
	 */
	public static Victor left_drive_victor_1 = new Victor(LEFT_VICTOR_1);
	public static Victor right_drive_victor_1 = new Victor(RIGHT_VICTOR_1);

	public static CANSparkMax spark = new CANSparkMax(SPARK, MotorType.kBrushless);
	public static CANPIDController spark_pid_controller= spark.getPIDController();
	public static CANEncoder spark_encoder = spark.getEncoder();
	
	/**
	 * Creating sensor objects
	 */	
	public static final DistanceSensor distance_sensor = new DistanceSensor(DISTANCE_SENSOR);
	public static final AnalogTapeSensor analog_tape_sensor = new AnalogTapeSensor(ANALOG_TAPE_SENSOR);
	public static final DigitalTapeSensor digital_tape_sensor = new DigitalTapeSensor(DIGITAL_TAPE_SENSOR);
	
	/**
	 * Creating encoder objects
	 */
	public static final Encoder victor_encoder = new Encoder(ENCODER_A,ENCODER_B);

	public static void init() {
		spark_pid_controller.setP(1);
		spark_pid_controller.setOutputRange(-1, 1);
		spark_pid_controller.setReference(0, ControlType.kPosition);  //  Permanently sets the sensor to the specified position (measured in rotations relative to starting position)
	}
}