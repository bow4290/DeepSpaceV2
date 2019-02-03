/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


import edu.wpi.first.wpilibj.ADXRS450_Gyro;
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
import frc.robot.subsystems.ElbowMotor;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  
  public static DifferentialDrive driveTrainBase;
  private static DoubleSolenoid gearShiftSolenoid;

  private static SpeedController driveTrainMotorRightFront; 
  private static SpeedController driveTrainMotorRightBack;
  private static SpeedControllerGroup driveTrainRight;

  private static SpeedController driveTrainMotorLeftFront;
  private static SpeedController driveTrainMotorLeftBack;
  private static SpeedControllerGroup driveTrainLeft;

  private static SpeedController elevator;
  private static SpeedController elbow;
  private static SpeedController wrist;
  private static SpeedController finger;
  
  public static ADXRS450_Gyro turningGyro;
  public static Encoder wristEncoder;
  public static Encoder elbowEncoder;

  // public static Jaguar elbow;
  public static Talon wristMotor;
  public static Talon fingerMotor;
  public static VictorSP elevatorMotor;
  public static Jaguar elbowMotor;

  public static DigitalInput lineFollower;  

  public static void init(){
    driveTrainMotorRightFront = new Spark(8);
    driveTrainMotorRightBack = new Spark(9);
    driveTrainRight = new SpeedControllerGroup(driveTrainMotorRightFront, driveTrainMotorRightBack);

    driveTrainMotorLeftFront = new Spark(6);
    driveTrainMotorLeftBack = new Spark(7);
    driveTrainLeft = new SpeedControllerGroup(driveTrainMotorLeftFront, driveTrainMotorLeftBack);

    // gearShiftSolenoid = new DoubleSolenoid(0, 1);
    driveTrainBase = new DifferentialDrive(driveTrainLeft, driveTrainRight);
    //  driveTrainBase = new DifferentialDrive(driveTrainRight, driveTrainLeft);
    // elevator = new Spark(4);
    elbowMotor = new Jaguar(5);
    wristMotor = new Talon(4);
    fingerMotor = new Talon(3);
    elevatorMotor = new VictorSP(2);

    wristEncoder = new Encoder(1, 2);

    lineFollower = new DigitalInput(3);

    turningGyro = new ADXRS450_Gyro();
    turningGyro.reset();
  }
}
