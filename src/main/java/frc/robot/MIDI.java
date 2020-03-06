package frc.robot;

import com.ctre.phoenix.music.Orchestra;

import java.util.Collection;

import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class MIDI {

    TalonFX frontLeftWheel = new TalonFX(RobotMap.FrontLeftFalcon);
    TalonFX backLeftWheel = new TalonFX(RobotMap.BackLeftFalcon);
    TalonFX frontRightWheel = new TalonFX(RobotMap.FrontRightFalcon);
    TalonFX backRightWheel = new TalonFX(RobotMap.BackRightFalcon);

    TalonFX[] instruments = {frontLeftWheel, frontRightWheel, backLeftWheel, backRightWheel};
    Orchestra orchestra = new Orchestra();

    
}