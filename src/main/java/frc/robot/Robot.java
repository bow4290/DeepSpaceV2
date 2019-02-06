/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.StartVisionCommand;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ElbowMotor;
import frc.robot.subsystems.ElevatorMotor;
import frc.robot.subsystems.IntakeOutakeMotor;
// import frc.RobotMap.subsystems.L 
// import sun.nio.ch.Net;
import frc.robot.subsystems.WristMotor;

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
  public static WristMotor wristMotor;
  private NetworkTable nTable;
  public static IntakeOutakeMotor intakeOutakeMotor;
  public static ElevatorMotor elevatorMotor;
  public static DigitalInput lineFollower;
  public static ElbowMotor elbowMotor;

  
  @Override
  public void robotInit() {
    RobotMap.init();
    oi = new OI();
    driveTrain = new DriveTrain();
    wristMotor = new WristMotor();
    intakeOutakeMotor = new IntakeOutakeMotor();
    elevatorMotor = new ElevatorMotor();
    elbowMotor = new ElbowMotor();
    NetworkTable.globalDeleteAll();
    nTable = NetworkTable.getTable("gyroOut");
    RobotMap.wristEncoder.reset();  
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
    boolean lineFollowerValue = RobotMap.lineFollower.get();
    nTable.putBoolean("Line Follower Value", lineFollowerValue);
    RobotMap.driveTrainBase.driveCartesian(oi.rightJoystick.getY(), oi.leftJoystick.getY(), 0.0);   
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
