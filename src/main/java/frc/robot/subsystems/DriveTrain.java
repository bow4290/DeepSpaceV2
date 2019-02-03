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

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new DriveWithJoysticks());
  }

  public void takeJoystickInputs(XboxController xboxController){
    RobotMap.driveTrainBase.arcadeDrive(xboxController.getY(), xboxController.getX());;
  }

  public void turnLeft(){
    // RobotMap.driveTrainBase.arcadeDrive(0, -0.8);
  }

  public void turnRight(){
    // RobotMap.driveTrainBase.arcadeDrive(0, 0.8);
  }

  public void stop(){
    // RobotMap.driveTrainBase.tankDrive(0,0);
  }
}
