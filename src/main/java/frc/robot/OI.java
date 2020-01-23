package frc.robot;


import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.XboxController;

public final class OI {

    Drivetrain driveT = new Drivetrain();
    XboxController xbox = new XboxController(0);
    Shooter pewpew = new Shooter();
    AHRS ahrs;

    public OI() {

        try {

            ahrs = new AHRS(SPI.Port.kMXP);

        } catch (RuntimeException e) {

            DriverStation.reportError("Error instantiating with drive system:  " + e.getMessage(), true);
        }
    }

    public void driverInput() {

        driveT.brake(xbox.getTriggerAxis(Hand.kRight));

        if (xbox.getAButton()) {
            pewpew.shoot();
        }
        else {
            pewpew.stop();
        }

        try {

            driveT.drive(xbox.getX(Hand.kLeft), -xbox.getY(Hand.kLeft), xbox.getX(Hand.kRight), ahrs.getAngle());

        } catch (RuntimeException e) {

            DriverStation.reportError("Error instantiating with drive system:  " + e.getMessage(), true);
        }
        

    }

    
}