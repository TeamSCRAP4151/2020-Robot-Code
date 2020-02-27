package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Limelight {
    Drivetrain driveT = new Drivetrain();

    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");
    NetworkTableEntry tv = table.getEntry("tv");

    double kP = 1;
    double kI = 1;
    double kD = 1;

    double xP = 0;
    double xI = 0;
    double xD = 0;

    double yP = 0;
    double yI = 0;
    double yD = 0;

    double angleP = 0;
    double angleI = 0;
    double angleD = 0;

    double xError;
    double yError;
    double angleError;

    double xPrevError = 0;
    double yPrevError = 0;
    double anglePrevError = 0;

    double validTarget;
    
    public void align() {

        validTarget = tv.getDouble(0);
        xError = -tx.getDouble(0);
        yError = -ty.getDouble(0);

        SmartDashboard.putNumber("LimelightValidTarget?", validTarget);
        SmartDashboard.putNumber("LimelightX", xError);
        SmartDashboard.putNumber("LimelightY", yError);

        if (validTarget == 1) {

            xError = SmartDashboard.getNumber("LimelightX", 0);
            yError = SmartDashboard.getNumber("LimelightY", 0);

            if(xError > 1 || xError < -1 || yError > 1 || yError < -1) {
                driveT.drive(xOutput(), yOutput(), angleOutput());
            } else {
                xI = 0;
                yI = 0;
                //ANGLE EVENTUALLY
            }
            

        }

    }

    public double xOutput() {

        xP = xError;
        xI = xI + (xError * .02);
        xD = ((xError - xPrevError)/.02);

        return (kP * xP) + (kI * xI) + (kD * xD);
    }

    public double yOutput() {

        yP = yError;
        yI = yI + (yError * .02);
        yD = ((yError - yPrevError)/.02);

        return (kP * xP) + (kI * xI) + (kD * xD);
    } 

    public double angleOutput() { //THIS WILL POTENTIALLY NEED A CHANGE DEPENDING ON STARTING 

        angleP = angleError;
        angleI = angleI + (angleError * .02);
        angleD = ((angleError - anglePrevError)/.02);

        return (kP * xP) + (kI * xI) + (kD * xD);
    }
}