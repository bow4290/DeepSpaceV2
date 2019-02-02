/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.StartVisionCommand;
import frc.robot.subsystems.DriveTrain;
// import sun.nio.ch.Net;
import frc.robot.subsystems.WristEncoder;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static OI oi;
  public static DriveTrain driveTrain;
  public static WristEncoder wristEncoder;
  private NetworkTable nTable;

  
  @Override
  public void robotInit() {
    RobotMap.init();
    oi = new OI();
    driveTrain = new DriveTrain();
    wristEncoder = new WristEncoder();
    nTable = NetworkTable.getTable("gyroOut");
  }

  
  @Override
  public void robotPeriodic() {
  }

  @Override
  public void teleopInit() {    
  // new StartVisionCommand().start();
  }
  
  @Override
  public void teleopPeriodic() { 
    Scheduler.getInstance().run();
    double gyroAngle = RobotMap.turningGyro.getAngle();
    nTable.putNumber("Current Gyro Value", gyroAngle);
    //RobotMap.driveTrainBase.tankDrive(oi.leftJoystick.getY(), oi.rightJoystick.getY());   
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {   
    Scheduler.getInstance().run(); 
  }
  
  @Override
  public void autonomousInit() {
    RobotMap.wristEncoder.reset();  
  }
  
  @Override
  public void autonomousPeriodic() {  
    Scheduler.getInstance().run(); 
  }
  
  @Override
  public void testPeriodic() {
    Scheduler.getInstance().run(); 
    //LiveWindow.run();
  }
}
