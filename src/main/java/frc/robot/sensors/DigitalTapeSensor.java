//  OPB732WZ Reflective Optical Sensor
//  This thing will switch from LOW to HIGH at 1.3 V. 

package frc.robot.sensors;

import edu.wpi.first.wpilibj.DigitalInput;

/**
 * WIRE MAPPING
 * Blue (from green): Analog Signal
 * White: 5 V
 * Black (from green): Ground
 * 
 * Red: 5 V
 * Black: Ground
 */

public class DigitalTapeSensor extends DigitalInput {
    public DigitalTapeSensor(int channel) {
        super(channel);
    }
}
