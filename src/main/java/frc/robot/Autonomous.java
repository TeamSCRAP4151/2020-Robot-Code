package frc.robot;

import edu.wpi.first.wpilibj.Timer;

//Import Stuff

public class Autonomous {

    Drivetrain driveT = new Drivetrain();
    Shooter shooter = new Shooter();
    Indexer indexer = new Indexer();
    Limelight limelight = new Limelight();

    Timer timer = new Timer();

    public void test() {
        timer.start();
    }

    public void auto() {
        if(timer.getMatchTime() > 14.9) {
        
            driveT.drive(0, .5, 0);
        
        }

    }
}
