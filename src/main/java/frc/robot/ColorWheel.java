package frc.robot;

import edu.wpi.first.wpilibj.Spark;

public class ColorWheel {

    Spark colorWheelSpinner = new Spark(RobotMap.ColorWheel);

    public void spin(){
        colorWheelSpinner.set(0.3);
    }

}