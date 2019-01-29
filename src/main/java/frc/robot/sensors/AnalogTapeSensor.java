//  OPB732WZ Reflective Optical Sensor

package frc.robot.sensors;

import edu.wpi.first.wpilibj.AnalogInput;

/**
 * WIRE MAPPING
 * Blue (from green): Analog Signal
 * White: 5 V
 * Black (from green): Ground
 * 
 * Red: 5 V
 * Black: Ground
 */

public class AnalogTapeSensor extends AnalogInput {
    //  Minimum raw value required for the sensor to have "detected" the tape
    public final static int RAW_DETECTION_THRESHOLD = 3900;
    //  Minimum voltage required for the sensor to have "detected" the tape
    public final static double VOLTAGE_DETECTION_THRESHOLD = 4.8;

    public AnalogTapeSensor(int channel) {
        super(channel);
    }

    public boolean isTapeDetected_R() {
        return this.getValue() >= RAW_DETECTION_THRESHOLD;
    }
    public boolean isTapeDetected_V() {
        return this.getVoltage() >= VOLTAGE_DETECTION_THRESHOLD;
    }
}
