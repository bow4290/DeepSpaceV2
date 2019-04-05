/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import org.opencv.core.Mat;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
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
  private double oldSpeedX = 0.0;
  private double oldSpeedY = 0.0;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new DriveWithJoysticks());
  }

  public void takeJoystickInputs(XboxController rightJoystick){
    RobotMap.driveTrainBase.arcadeDrive(speedBuffer(rightJoystick.getY(), 0.04), -(speedCurve(rightJoystick.getX(), 0.04)), false);
    // RobotMap.driveTrainBase.arcadeDrive(joystick.getY(), joystick.getX());
  }

  public double speedCurve(double joy, double accel){
    double deadband = .1;
    double linearSpeed = .65;
    double outputSpeed = .65;
    double oldSpeedMagnitude = Math.abs(oldSpeedX);
    double addSpeed = oldSpeedMagnitude * accel;
    double directionForwardReverse = Math.signum(joy);
    double newSpeedMagnitude = Math.abs(joy);
    double speedDelta = Math.abs(joy-oldSpeedX);
    double directionSpeedDelta = Math.signum(joy-oldSpeedX);

    if (Math.abs(joy) <= deadband){
      oldSpeedX = 0;
    }
    

    else if (Math.abs(joy)>deadband && Math.abs(joy)<linearSpeed){

      if (speedDelta < addSpeed + 0.01) {
			  oldSpeedX = joy;
      }
      else if (oldSpeedMagnitude < accel * 10 && newSpeedMagnitude > 0.1) {
			  oldSpeedX = accel * 10 * directionForwardReverse;
			  oldSpeedX += 0.01 * speedDelta;
      } 
			else{
        oldSpeedX += addSpeed;
      }
      return oldSpeedX * directionSpeedDelta;
    }

    else if (Math.abs(joy)>= linearSpeed){
      double deltaX = 1-linearSpeed;
      double deltaY = 1-outputSpeed;
      double slope = (deltaY/deltaX);
      oldSpeedX = joy*slope;
    }

    return oldSpeedX;
  }



   public double speedBuffer(double joy, double perc) {
    double oldSpeedMagnitude = Math.abs(oldSpeedY);
    double addSpeed = oldSpeedMagnitude * perc;
    double directionForwardReverse = Math.signum(joy);
    double newSpeedMagnitude = Math.abs(joy);
    double speedDelta = Math.abs(joy-oldSpeedY);
    double directionSpeedDelta = Math.signum(joy-oldSpeedY);

		if (speedDelta < addSpeed + 0.01) {
			oldSpeedY = joy;
    }
    else if (oldSpeedMagnitude < perc * 10 && newSpeedMagnitude > 0.1) {
			oldSpeedY = perc * 10 * directionForwardReverse;
			oldSpeedY += 0.01 * speedDelta;
    } else {
      oldSpeedY += addSpeed;
    }
		return oldSpeedY * directionSpeedDelta;
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
     RobotMap.driveTrainBase.tankDrive(0,0);
  }
}
