/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.WristMotor;
import frc.robot.subsystems.WristPID;

public class WristUp extends Command {
  WristPID pid;
  public WristUp() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    pid = new WristPID();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double pidInput = pid.returnPIDInput();
    pid.usePIDOutput(pidInput);
    System.out.println("WORKING");
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    // return !RobotMap.wristMotorHighLimit.get();
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.wristMotor.stopWrist();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.wristMotor.stopWrist();
    end();
  }
}
