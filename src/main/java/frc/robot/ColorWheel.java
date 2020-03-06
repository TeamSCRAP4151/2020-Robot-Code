package frc.robot;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DriverStation;

import com.revrobotics.ColorSensorV3;


public class ColorWheel {

    Spark colorWheelSpinner = new Spark(RobotMap.ColorWheel);
    I2C.Port i2cPort = I2C.Port.kOnboard;
    ColorSensorV3 sensor = new ColorSensorV3(i2cPort);

    public void spin(){

        colorWheelSpinner.set(0.3);
    }

    public void getColor(){

        SmartDashboard.putNumber("RedValue", sensor.getRed()*1.1494);
        SmartDashboard.putNumber("GreenValue", sensor.getGreen()*1.05263);
        SmartDashboard.putNumber("BlueValue", sensor.getBlue()*1.6393);
    }

    String gameData = DriverStation.getInstance().getGameSpecificMessage();
}