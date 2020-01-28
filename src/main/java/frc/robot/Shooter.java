package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PWMVictorSPX;

//Import Stuff

public class Shooter {
    PWMVictorSPX vex1 = new PWMVictorSPX(4);
    PWMVictorSPX vex2 = new PWMVictorSPX(5);
    double shootspeed = 0.2;


    public void shoot() {
    
        vex1.set(shootspeed);
        vex2.set(-shootspeed);
    }
    public void stop() {
        vex1.set(0.0);
        vex2.set(0.0);
    }
    public void speedUp() {
        shootspeed = shootspeed + .1;
        DriverStation.reportError("Current Speed is: " + shootspeed, false);
    }
    public void slowDown() {
        shootspeed = shootspeed - .1;
        DriverStation.reportError("Current Speed is: " + shootspeed, false);

        
    }
}