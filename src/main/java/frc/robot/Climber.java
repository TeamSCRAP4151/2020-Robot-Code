package frc.robot;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;
public class Climber {

    VictorSPX climbMotor = new VictorSPX(RobotMap.ClimbVictor);

    public void climb() {

        climbMotor.set(ControlMode.PercentOutput, 1);
    }
}