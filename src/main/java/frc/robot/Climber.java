package frc.robot;

import edu.wpi.first.wpilibj.PWMVictorSPX;

public class Climber {

    PWMVictorSPX climbMotor = new PWMVictorSPX(RobotMap.ClimbVictor);

    public void climb() {

        climbMotor.set(1);
    }
}