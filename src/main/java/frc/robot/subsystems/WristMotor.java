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
import frc.robot.OI;


/**
 * Add your docs here.
 */
public class WristMotor extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  double maxValue = .5;
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MoveWristToAngle(90));
  }

  public void moveWristUp(){
    RobotMap.wristMotor.set(-.5);
    // if(RobotMap.wristMotorHighLimit.get()){
      //RobotMap.wristMotor.set(maxValue*Math.abs(Robot.oi.leftJoystick.getY()));
    // }
    // else{
      // stopWrist();
    // }
  }

  public void moveWristDown(){
    // if(RobotMap.wristMotorLowLimit.get()){
      RobotMap.wristMotor.set(.2);
      // RobotMap.wristMotor.set(-maxValue*Math.abs(Robot.oi.leftJoystick.getY()));
    // }
    // else{
      // stopWrist();
    // }
  }

  public void stopWrist(){
    RobotMap.wristMotor.set(-0.2);
  }



}
