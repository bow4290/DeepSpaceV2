/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.MoveWristToAngle;
import frc.robot.OI;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class ElbowMotor extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MoveWristToAngle(90));
  }

  public void moveElbowUp(){
    RobotMap.elbowMotor.set(Robot.oi.leftJoystick.getX());
  }

  public void moveElbowDown(){
    RobotMap.elbowMotor.set(Robot.oi.leftJoystick.getX());
  }

  public void stopElbow(){
    RobotMap.elbowMotor.set(0.0);
  }



}
