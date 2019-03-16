/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.DriveWithJoysticks;
import frc.robot.commands.MoveWristToAngle;
import frc.robot.commands.WristWithJoysticks;
import frc.robot.OI;


/**
 * Add your docs here.
 */
public class WristMotor extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  double maxValue = .5;
  private double oldSpeed = 0;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new WristWithJoysticks());
  }

  public void moveWristUp(){
    RobotMap.wristMotor.set(-.8);
    // if(RobotMap.wristMotorHighLimit.get()){
      //RobotMap.wristMotor.set(maxValue*Math.abs(Robot.oi.leftJoystick.getY()));
    // }
    // else{
      // stopWrist();
    // }
  }

  public void moveWristDown(){
    // if(RobotMap.wristMotorLowLimit.get()){
      RobotMap.wristMotor.set(1);
      // RobotMap.wristMotor.set(-maxValue*Math.abs(Robot.oi.leftJoystick.getY()));
    // }
    // else{
      // stopWrist();
    // }
  }
  

  public void stopWrist(){
    RobotMap.wristMotor.set(-0.35);
  }

  public void TakeJoystickInput(XboxController leftJoystick) {
    RobotMap.wristMotor.set(speedBuffer(leftJoystick.getY(), .04));
  }

  public double speedBuffer(double joy, double perc) {
    double oldSpeedMagnitude = Math.abs(oldSpeed);
    double addSpeed = oldSpeedMagnitude * perc;
    double directionForwardReverse = Math.signum(joy);
    double newSpeedMagnitude = Math.abs(joy);
    double speedDelta = Math.abs(joy-oldSpeed);
    double directionSpeedDelta = Math.signum(joy-oldSpeed);

		if (speedDelta < addSpeed + 0.01) {
			oldSpeed = joy;
    }
    else if (oldSpeedMagnitude < perc * 10 && newSpeedMagnitude > 0.1) {
			oldSpeed = perc * 10 * directionForwardReverse;
			oldSpeed += 0.01 * speedDelta;
    } 
    else {
			oldSpeed += addSpeed * directionSpeedDelta;
		}
		return oldSpeed;
	}



}
