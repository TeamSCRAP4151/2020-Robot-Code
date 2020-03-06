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

    double RV = sensor.getRed()*1.1494;
    double GV = sensor.getGreen()*1.05263;
    double BV = sensor.getBlue()*1.6393;

    char currentColor;
    String CC;

    public void spin(){

        colorWheelSpinner.set(0.3);
    }

    public void stop() {

        colorWheelSpinner.set(0);
    }

    public void getColor(){

        RV = sensor.getRed()*1.1494;
        GV = sensor.getGreen()*1.05263;
        BV = sensor.getBlue()*1.6393;

        SmartDashboard.putNumber("RedValue", RV); 
        SmartDashboard.putNumber("GreenValue", GV); 
        SmartDashboard.putNumber("BlueValue", BV);



        if (BV > GV && GV > RV) {
            currentColor = 'B';
        }
        else if (GV > BV && BV > RV) {
            currentColor = 'G';
        }
        else if (GV > RV && RV > BV) {
            currentColor = 'Y';
        }
        else if (RV > BV && BV > GV) {
            currentColor = 'R';
        }
        else {
            currentColor = 'F';
        }

        SmartDashboard.putNumber("Current Color", currentColor);


        if (gameData.length() > 0) {
            switch (gameData.charAt(0)) {
                case 'B' : // B > G > R
                    SmartDashboard.putString("Desired Color", "Blue");
                    break;

                case 'G' : // G > B > R
                    SmartDashboard.putString("Desired Color", "Green");
                    break;

                case 'Y' : // G > R > B (Check)
                    SmartDashboard.putString("Desired Color", "Yellow");
                    break;

                case 'R' : // R > B > G
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