package frc.robot;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

public final class Drivetrain {

    Spark frontLeftWheel = new Spark(0);
    Spark backLeftWheel = new Spark(1);
    Spark frontRightWheel = new Spark(2);
    Spark backRightWheel = new Spark(3);

    MecanumDrive driveT = new MecanumDrive(frontLeftWheel, backLeftWheel, frontRightWheel, backRightWheel);

    public void drive(double strafeAxis, double forwardAxis, double rotateAxis, double gryoAngle) {

        driveT.driveCartesian(strafeAxis, forwardAxis, rotateAxis, gryoAngle);

    }

    public void brake(double breakAxis) {

        driveT.setMaxOutput(1 - breakAxis);
    }

	
    
}