
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import frc.robot.*;


public class PickUpBall extends Command {
  public PickUpBall() {
    // requires(Robot.wristEncoder);
    // requires(Robot.intakeOutakeMotor);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
     
      Robot.intakeOutakeMotor.Intake();
    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;// wristAngle == currentWristAngle;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.intakeOutakeMotor.stopFinger();
    }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.intakeOutakeMotor.stopFinger();
    end();
  }
}
