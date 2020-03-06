package frc.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.Drivetrain;
import frc.robot.Shooter;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.XboxController;

public class OI {

    Drivetrain driveT = new Drivetrain();
    XboxController xbox = new XboxController(RobotMap.XboxControllerPort);
    Shooter shooter = new Shooter();
    Climber climber = new Climber();
    Indexer indexer = new Indexer();
    AHRS ahrs;
    Limelight limelight = new Limelight();
    ColorWheel spinner = new ColorWheel();

    public OI() {

        try {

            ahrs = new AHRS(SPI.Port.kMXP);

        } catch (RuntimeException e) {

            DriverStation.reportError("Error instantiating with drive system:  " + e.getMessage(), true);
        }
    }

    public void driverInput() {

        driveT.brake(xbox.getTriggerAxis(Hand.kRight));

        spinner.getColor();

        if (xbox.getXButton()) {
            spinner.spin();
        }

        if(xbox.getTriggerAxis(Hand.kLeft) > .25) {
            indexer.index(xbox.getTriggerAxis(Hand.kLeft));
        }

        if (xbox.getBumper(Hand.kRight) || xbox.getBumper(Hand.kLeft)) {
            shooter.shoot();
        }
        else {
            shooter.stop();
        }

        if (xbox.getAButton()) {

            limelight.align();

        } else if(xbox.getX(Hand.kLeft) >.2 || xbox.getX(Hand.kLeft) < -.2) {
        
            driveT.drive(0,0, xbox.getX(Hand.kRight));
        
        } else if(xbox.getY(Hand.kLeft) > .2 || xbox.getY(Hand.kLeft) < -.2) {

            //try {

                driveT.drive(xbox.getX(Hand.kLeft), -xbox.getY(Hand.kLeft), 0); //xbox.getX(Hand.kRight)
    
            //} catch (RuntimeException e) {
    
               // DriverStation.reportError("Error instantiating with drive system:  " + e.getMessage(), true);
            //}

        } else {

            //try {

                driveT.drive(xbox.getX(Hand.kLeft), 0, 0); //xbox.getX(Hand.kRight)
    
            //} catch (RuntimeException e) {
    
                //DriverStation.reportError("Error instantiating with drive system:  " + e.getMessage(), true);
            //}
        }

        if(xbox.getBButtonPressed()) {

            driveT.setHalfSpeed();

        }
        
        if(xbox.getYButtonPressed()) {

            driveT.setFullSpeed();

        }

        //if statement for climber (replaced climber control with indexer)
        


    }

    
}