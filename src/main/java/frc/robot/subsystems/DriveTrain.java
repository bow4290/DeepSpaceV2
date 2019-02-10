/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.DriveWithJoysticks;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private double oldValue;
  private static double speedReductionFactor = .999;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new DriveWithJoysticks());
    oldValue = 0.0;
  }

  public void takeJoystickInputs(Joystick joystick){
    RobotMap.driveTrainBase.arcadeDrive(speedBuffer(joystick.getY()), joystick.getX(), true);
  }

  private double speedBuffer(double newValue) {
	  if(Math.abs(newValue)<.5 && Math.abs(oldValue)>.5){
      // System.out.println("New Value: " + newValue + "Old Value: " + oldValue);
      oldValue = Math.abs(oldValue*speedReductionFactor);
      return oldValue;
    }
    else{
      oldValue = Math.abs(newValue);
      return newValue;
    }
  }

  public void driveStraight(){
    RobotMap.driveTrainBase.arcadeDrive(-.6, 0);
  }
  
  public void turnLeft(){
    RobotMap.driveTrainBase.arcadeDrive(0, -0.8);
  }

  public void turnRight(){
    RobotMap.driveTrainBase.arcadeDrive(0, 0.8);
  }

  public void stop(){
    // RobotMap.driveTrainBase.tankDrive(0,0);
  }
}
