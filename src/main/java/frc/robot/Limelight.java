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

    double kConstant = .1;
    double axisMod = .03;
    double x;
    double y;
    double v;
    
    public void align() {

        v = tv.getDouble(0);
        x = -tx.getDouble(0);
        y = -ty.getDouble(0);

        SmartDashboard.putNumber("LimelightValidTarget?", v);
        SmartDashboard.putNumber("LimelightX", x);
        SmartDashboard.putNumber("LimelightY", y);

        if (v == 1) {

            x = SmartDashboard.getNumber("LimelightX", 0);
            y = SmartDashboard.getNumber("LimelightY", 0);

            double xSpeed = -x * axisMod;
            double ySpeed = -y * axisMod;

            if((x > 1.0 || x < -1.0) && (y > 1.0 || y < -1.0)) {

                driveT.drive(xSpeed, ySpeed,0);

            } else if(x > 1.0 || x < -1.0) {

                driveT.drive(xSpeed, 0, 0);

            } if(y > 1.0 || y < -1.0) {

                driveT.drive(0, ySpeed, 0);

            } 

        }

    }
}