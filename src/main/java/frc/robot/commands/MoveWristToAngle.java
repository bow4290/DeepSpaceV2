
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


public class MoveWristToAngle extends Command {
  private double wristAngle = 0.0;
  private double currentWristAngle = 0.0;
  private NetworkTable table = NetworkTable.getTable("tables");
  public MoveWristToAngle(double wristAngle) {
    this.wristAngle = wristAngle;
    // this.currentWristAngle = RobotMap.wristEncoder.getRaw();
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    // requires(Robot.wristEncoder);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    table.putNumber("Current Wrist Angle", currentWristAngle);
    table.putNumber("Go To Angle", wristAngle);
     
    if (wristAngle > currentWristAngle){
      Robot.wristMotor.moveWristUp();
    }
    else if (wristAngle == 0){
      Robot.wristMotor.moveWristDown();
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;// wristAngle == currentWristAngle;
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
    end();
  }
}
