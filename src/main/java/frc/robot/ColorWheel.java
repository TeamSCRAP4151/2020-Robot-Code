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

    String gameData = DriverStation.getInstance().getGameSpecificMessage();
 
    public void spin(){

        colorWheelSpinner.set(0.3);
    }

    public void getColor(){

        SmartDashboard.putNumber("RedValue", sensor.getRed()*1.1494);
        SmartDashboard.putNumber("GreenValue", sensor.getGreen()*1.05263);
        SmartDashboard.putNumber("BlueValue", sensor.getBlue()*1.6393);

        if (gameData.length() > 0) {
            switch (gameData.charAt(0)) {
                case 'B' :
                    SmartDashboard.putString("Desired Color", "Blue");
                    break;

                case 'G' :
                    SmartDashboard.putString("Desired Color", "Green");
                    break;

                case 'Y' :
                    SmartDashboard.putString("Desired Color", "Yellow");
                    break;

                case 'R' :
                    SmartDashboard.putString("Desired Color", "Red");
                    break;

                 default :
                    SmartDashboard.putString("Desired Color", "ERROR; CONTACT REF");
            }
        }
        else {
            SmartDashboard.putString("Desired Color", "NOT YET RECEIVED; TRY GETTING MORE POINTS");
        }
    }


}