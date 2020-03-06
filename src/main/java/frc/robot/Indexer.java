package frc.robot;

import edu.wpi.first.wpilibj.PWMVictorSPX;

public class Indexer {

    PWMVictorSPX indexer = new PWMVictorSPX(RobotMap.IndexVictor);

    public void index(double speed) {

        indexer.set(speed);
    }
}