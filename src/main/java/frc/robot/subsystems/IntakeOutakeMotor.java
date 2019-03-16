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
import frc.robot.RobotMap;
import frc.robot.commands.DriveWithJoysticks;
import frc.robot.commands.MoveWristToAngle;

/**
 * Add your docs here.
 */
public class IntakeOutakeMotor extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MoveWristToAngle(90));
  }

  public void Intake(){
    RobotMap.fingerMotor.set(.4);
  }

  public void Outake(){
    RobotMap.fingerMotor.set(-1);
  }

  public void stopFinger(){
    RobotMap.fingerMotor.set(0.0);
  }



}
