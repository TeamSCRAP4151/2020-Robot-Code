package frc.robot;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;
public class Climber {

    VictorSPX climbMotor = new VictorSPX(RobotMap.ClimbVictor);

    public void climb(double speed) {

        climbMotor.set(ControlMode.PercentOutput, speed);
    }
}