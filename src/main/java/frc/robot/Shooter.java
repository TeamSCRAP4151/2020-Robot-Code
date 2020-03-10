package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shooter {
    VictorSPX leftVictor = new VictorSPX(RobotMap.LeftVictor);
    VictorSPX rightVictor = new VictorSPX(RobotMap.RightVictor);
    
    double shootspeed = 0.4;

    public void shoot() {
        rightVictor.setInverted(false);

        leftVictor.set(ControlMode.PercentOutput, shootspeed);
        rightVictor.set(ControlMode.PercentOutput, -shootspeed);
       
        SmartDashboard.putBoolean("Shooter Status", true);
    }
    public void stop() {
        leftVictor.set(ControlMode.PercentOutput, 0.0);
        rightVictor.set(ControlMode.PercentOutput, 0.0);
        
        SmartDashboard.putBoolean("Shooter Status", false);
    }
    
        
    
}