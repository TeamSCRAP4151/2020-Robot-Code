package frc.robot;

import com.kauailabs.navx.frc.AHRS;

//import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.Drivetrain;
import frc.robot.Shooter;
//import edu.wpi.first.wpilibj.SPI;
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


    public void driverInput() {

        //Control Panel Manipulation
        spinner.getColor();

        if (xbox.getXButton()) {

            spinner.spin();

        } else {

            spinner.stop();
        }

        //Speed Suggestion
        driveT.brake(xbox.getTriggerAxis(Hand.kRight));

        //Indexer Control
        if (xbox.getTriggerAxis(Hand.kLeft) > .25) {

            indexer.index(-.1);

        } else {

            indexer.stop();
        }

        //Shooter Control
        if (xbox.getBumper(Hand.kRight) || xbox.getBumper(Hand.kLeft)) {

            shooter.shoot();

        } else {

            shooter.stop();
        }

        //Vision
        if (xbox.getAButton()) {

            limelight.align();

        }

        //Chassis Control
        else if(xbox.getX(Hand.kLeft) >.2 || xbox.getX(Hand.kLeft) < -.2) { //if trying to rotate, only allow rotation
        
            driveT.drive(0,0, xbox.getX(Hand.kRight));
        
        }
        else if(xbox.getY(Hand.kLeft) > .2 || xbox.getY(Hand.kLeft) < -.2) { //if driving forward, do not allow rotation
                
            driveT.drive(xbox.getX(Hand.kLeft), -xbox.getY(Hand.kLeft), 0); 
        }
        else { //if not trying to rotate or drive forward, only allow strafe

            //try {

                driveT.drive(xbox.getX(Hand.kLeft), 0, 0); //xbox.getX(Hand.kRight)
    
            //} catch (RuntimeException e) {
    
                //DriverStation.reportError("Error instantiating with drive system:  " + e.getMessage(), true);
            //}
        }

        //Speed Suggestions
        if(xbox.getBButtonPressed()) {

            driveT.setHalfSpeed();

        }
        
        if(xbox.getYButtonPressed()) {

            driveT.setFullSpeed();

        }

        //if statement for climber (replaced climber control with indexer)
        


    }

    
}