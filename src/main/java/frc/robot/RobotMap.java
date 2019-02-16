/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.subsystems.ElbowMotor;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  
  public static DifferentialDrive driveTrainBase;
  public static DoubleSolenoid gearShiftSolenoid;
  public static DoubleSolenoid hatchPanelSolenoid;


  private static SpeedController driveTrainMotorRightFront; 
  private static SpeedController driveTrainMotorRightBack;
  private static SpeedControllerGroup driveTrainRight;

  private static SpeedController driveTrainMotorLeftFront;
  private static SpeedController driveTrainMotorLeftBack;
  private static SpeedControllerGroup driveTrainLeft;
  
  public static Encoder wristEncoder;
  public static Encoder elbowEncoder;

  // public static Jaguar elbow;
  public static Jaguar wristMotor;
  public static DigitalInput wristMotorHighLimit;
  public static DigitalInput wristMotorLowLimit;

  public static Talon fingerMotor;
  
  public static VictorSP elevatorMotor;

  public static Talon elbowMotor;
  public static DigitalInput elbowMotorHighLimit;
  public static DigitalInput elbowMotorLowLimit;
  
  public static AnalogInput lineFollowerLeft;
  public static AnalogInput lineFollowerCenter;
  public static AnalogInput lineFollowerRight;

  
  

  public static void init(){
    driveTrainMotorRightFront = new Spark(0);    
    driveTrainMotorRightBack = new Spark(1);
    driveTrainRight = new SpeedControllerGroup(driveTrainMotorRightFront, driveTrainMotorRightBack);

    driveTrainMotorLeftFront = new Spark(2);
    driveTrainMotorLeftBack = new Spark(3);
    driveTrainLeft = new SpeedControllerGroup(driveTrainMotorLeftFront, driveTrainMotorLeftBack);

    gearShiftSolenoid = new DoubleSolenoid(4, 5);
    hatchPanelSolenoid = new DoubleSolenoid(6, 7);
    
    driveTrainBase = new DifferentialDrive(driveTrainLeft, driveTrainRight);
    
    elbowMotor = new Talon(6);
    elbowMotorHighLimit = new DigitalInput(0);
    elbowMotorLowLimit = new DigitalInput(1);

    wristMotor = new Jaguar(5);
    wristMotorHighLimit = new DigitalInput(2);
    wristMotorLowLimit = new DigitalInput(3);

    fingerMotor = new Talon(7);
    elevatorMotor = new VictorSP(4);

    // wristEncoder = new Encoder(2,3);
    // wristEncoder.reset();

    lineFollowerRight = new AnalogInput(0);
    lineFollowerCenter = new AnalogInput(1);
    lineFollowerLeft = new AnalogInput(2);
  }
}
