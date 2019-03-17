/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode.PixelFormat;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.ADXL345_I2C;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.DriveWithJoysticks;
import frc.robot.commands.WristUp;
import frc.robot.subsystems.ClimbMotor;
import frc.robot.subsystems.DriveTrain;
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
  public static DriveTrain driveTrain;
  public static WristMotor wristMotor;
  public static OI oi;
  public static IntakeOutakeMotor intakeOutakeMotor;
  public static ElevatorMotor elevatorMotor;
  public static ClimbMotor climbMotor;
  public static DigitalInput lineFollower;
  
  
  @Override
  public void robotInit() {
    RobotMap.init();   
    driveTrain = new DriveTrain();
    wristMotor = new WristMotor();
    intakeOutakeMotor = new IntakeOutakeMotor();
    elevatorMotor = new ElevatorMotor();
    climbMotor = new ClimbMotor();
    oi = new OI();
    UsbCamera camera1 = CameraServer.getInstance().startAutomaticCapture(0);
    camera1.setVideoMode(PixelFormat.kMJPEG, 200, 150, 30);
  }

  
  @Override
  public void robotPeriodic() {
  }

  @Override
  public void teleopInit() {    
  }
  
  @Override
  public void teleopPeriodic() { 
    Scheduler.getInstance().run();
    
    double gyroAngle = RobotMap.turningGyro.getAngle();
    SmartDashboard.putNumber("Gyro Angle", gyroAngle);
    
    double potPosition = RobotMap.potInputPosition.getVoltage();
    SmartDashboard.putNumber("Pot Position", potPosition);

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
  }
}
