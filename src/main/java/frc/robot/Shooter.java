package frc.robot;

import edu.wpi.first.wpilibj.PWMVictorSPX;

//Import Stuff

public class Shooter {
    PWMVictorSPX vex1 = new PWMVictorSPX(4);
    PWMVictorSPX vex2 = new PWMVictorSPX(5);

    public void shoot() {

        double shootspeed = 0.4;
        vex1.set(shootspeed);
        vex2.set(-shootspeed);
    }
    public void stop() {
        vex1.set(0.0);
        vex2.set(0.0);
    }
}