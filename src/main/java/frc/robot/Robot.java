/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;


public class Robot extends TimedRobot {
  
  PowerDistributionPanel power = new PowerDistributionPanel();
  OI oi = new OI();

  

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
  }

  @Override
  public void testPeriodic() {

    
  }

  @Override
  public void disabledInit() {


  }
}
