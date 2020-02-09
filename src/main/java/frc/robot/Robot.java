/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.AnalogInput;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
  
  PowerDistributionPanel power = new PowerDistributionPanel();
  OI oi = new OI();

  // distance in inches the robot wants to stay from an object


  // factor to convert sensor values to a distance in inches
  private static final double kValueToInches = 0.125;

  


  
  private static final int kUltrasonicPort = 0;

  private final AnalogInput m_ultrasonic = new AnalogInput(kUltrasonicPort);


  @Override
  public void robotInit() {

    power.clearStickyFaults();
  }

  
  @Override
  public void robotPeriodic() {


  }

  
  @Override
  public void autonomousInit() {
   

  }


  @Override
  public void autonomousPeriodic() {
    
    
  }

  @Override
  public void teleopInit() {
    
    
  }

  @Override
  public void teleopPeriodic() {

    oi.driverInput();
     // sensor returns a value from 0-4095 that is scaled to inches
    SmartDashboard.putNumber("Distance", (m_ultrasonic.getValue() * kValueToInches) ); 
    
  }

  @Override
  public void testPeriodic() {

    
  }

  @Override
  public void disabledInit() {


  }
}
