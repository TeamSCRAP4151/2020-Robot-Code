package frc.robot;

import edu.wpi.first.wpilibj.drive.MecanumDrive;

import com.ctre.phoenix.motorcontrol.can.*;

public final class Drivetrain {

    WPI_TalonFX frontLeftWheel = new WPI_TalonFX(2); //LEFT SIDE NEEDS TO BE INVERTED BY IDs
    WPI_TalonFX backLeftWheel = new WPI_TalonFX(1); 
    WPI_TalonFX frontRightWheel = new WPI_TalonFX(3); 
    WPI_TalonFX backRightWheel = new WPI_TalonFX(4); 

    MecanumDrive driveT = new MecanumDrive(frontLeftWheel, backLeftWheel, frontRightWheel, backRightWheel);

    public void drive(double strafeAxis, double forwardAxis, double rotateAxis) {

        driveT.driveCartesian(strafeAxis, forwardAxis, rotateAxis);

    }

    public void drive(double strafeAxis, double forwardAxis, double rotateAxis, double gryoAngle) {

        driveT.driveCartesian(strafeAxis, forwardAxis, rotateAxis, gryoAngle);

    }

    public void brake(double breakAxis) {

        driveT.setMaxOutput(1 - breakAxis);
    }

	
    
}