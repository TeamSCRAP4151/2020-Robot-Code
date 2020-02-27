package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PWMVictorSPX;

//Import Stuff

public class Shooter {
    PWMVictorSPX vex1 = new PWMVictorSPX(RobotMap.LeftVictor);
    PWMVictorSPX vex2 = new PWMVictorSPX(RobotMap.RightVictor);
    double shootspeed = 0.4;


    public void shoot() {
    
        vex1.set(shootspeed);
        vex2.set(-shootspeed);
    }
    public void stop() {
        vex1.set(0.0);
        vex2.set(0.0);
    }
    
        
    
}