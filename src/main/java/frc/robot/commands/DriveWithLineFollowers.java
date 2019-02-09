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
import frc.robot.subsystems.DriveTrain;

public class DriveWithLineFollowers extends Command {
  
  private DriveTrain driveTrain;

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    driveTrain = new DriveTrain();
    requires(driveTrain);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    String line = "";
    double lineFollowerLeftValue = RobotMap.lineFollowerLeft.getVoltage();
    double lineFollowerCenterValue = RobotMap.lineFollowerCenter.getVoltage();
    double lineFollowerRightValue = RobotMap.lineFollowerRight.getVoltage();

    line += lineFollowerLeftValue > 1 ? 1 : 0;
    line += lineFollowerCenterValue > 1 ? 1 : 0;
    line += lineFollowerRightValue > 1 ? 1 : 0;
    
    switch(line){
      case "100":
        driveTrain.turnRight();
        break;
      case "110":
        driveTrain.turnRight();
        break;
      case "111":
        driveTrain.stop();
        break;
      case "101":
        driveTrain.stop();
        break;
      case "010":
        driveTrain.driveStraight();
        break;
      case "011":
        driveTrain.turnLeft();
        break;
      case "001":
        driveTrain.turnLeft();
        break;
      case "000":
        driveTrain.driveStraight();
        break;
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
