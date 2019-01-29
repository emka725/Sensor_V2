//  URM37 V4.0 Ultrasonic Sensor

package frc.robot.sensors;

import edu.wpi.first.wpilibj.AnalogInput;

/**
 * WIRE MAPPING
 * Yellow: Analog Signal
 * Red: 5 V
 * Black: Ground
 * 
 * Green: PWM Signal (Channel 3 in the manual)
 * White: PWM Signal (Channel 4 in the manual)
 */

public class DistanceSensor extends AnalogInput {
    public DistanceSensor(int channel) {
        super(channel);
    }

    //  Returns the distance measured by the sensor, in meters. Accurate between 5 cm to 5 m. 
    public double getDistance() {
        return 1.5 * this.getAverageVoltage();
    }
}