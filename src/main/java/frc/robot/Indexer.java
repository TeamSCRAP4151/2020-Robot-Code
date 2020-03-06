package frc.robot;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;;

public class Indexer {

    VictorSPX indexerMotor = new VictorSPX(RobotMap.IndexVictor);

    public void index(double speed) {

        indexerMotor.set(ControlMode.PercentOutput, speed);
    }
}