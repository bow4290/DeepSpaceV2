/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


import edu.wpi.first.wpilibj.ADXL345_I2C;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  
  private static SpeedController driveTrainLeftSide;
  private static SpeedControllerGroup driveTrainLeft;
  
  private static SpeedController driveTrainRightSide;  
  private static SpeedControllerGroup driveTrainRight;

  public static DifferentialDrive driveTrainBase;
  
  public static Talon wristMotor;
  public static Talon fingerMotor;  
  public static Spark elevatorMotor;
  public static Talon climbMotor;
  
  public static DoubleSolenoid gearShiftSolenoid;
  public static DoubleSolenoid hatchPanelSolenoid;
  public static DoubleSolenoid wristSolenoid;

  public static ADXRS450_Gyro turningGyro;

  public static Encoder driveTrainRightEncoder;
  public static Encoder driveTrainLeftEncoder;
  public static ADXL345_I2C accel;
  public static AnalogInput potInputPosition;
  public static AnalogPotentiometer potentiometer;

  public static void init(){
    driveTrainLeftEncoder = new Encoder(1,2);
    driveTrainRightEncoder = new Encoder(3,4);
    
    driveTrainLeftSide = new Spark(1);
    driveTrainLeft = new SpeedControllerGroup(driveTrainLeftSide);

    driveTrainRightSide = new Spark(0);
    driveTrainRightSide.setInverted(true);
    driveTrainRight = new SpeedControllerGroup(driveTrainRightSide);

    driveTrainBase = new DifferentialDrive(driveTrainLeft, driveTrainRight);
    
    wristMotor = new Talon(2);
    fingerMotor = new Talon(3);
    elevatorMotor = new Spark(4);
    climbMotor = new Talon(5);

    gearShiftSolenoid = new DoubleSolenoid(0, 5, 4);
    hatchPanelSolenoid = new DoubleSolenoid(0, 3, 2);
    wristSolenoid = new DoubleSolenoid(0, 1, 0);
    
    turningGyro = new ADXRS450_Gyro();
    accel = new ADXL345_I2C(I2C.Port.kOnboard, Accelerometer.Range.k4G);

    potInputPosition = new AnalogInput(3);
    potentiometer = new AnalogPotentiometer(potInputPosition);
  }
}
