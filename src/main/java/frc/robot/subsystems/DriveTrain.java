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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.DriveWithJoysticks;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem { 
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public void initDefaultCommand() {
    setDefaultCommand(new DriveWithJoysticks());
      // Set the default command for a subsystem here.
      //setDefaultCommand(new MySpecialCommand());
  }

  public void takeJoystickInputs(Joystick xBoxController) {

    RobotMap.driveTrain.arcadeDrive(speedBuffer(xBoxController.getY(Hand.kLeft), 0.04), -xBoxController.getX(Hand.kRight) * 0.9);
   //RobotMap.driveTrain.arcadeDrive(0,0);
  }

  private boolean isSlow = false;

  public void switchIsSlow()
  {
    isSlow = !isSlow;
  }

    private double oldSpeed = 0.0;

    public double speedBuffer(double joy, double perc) {
    double addSpeed = Math.abs(oldSpeed) * perc;
  if (Math.abs(joy - oldSpeed) < addSpeed + 0.01) {
    oldSpeed = joy;
  } else if (Math.abs(oldSpeed) < perc * 10 && Math.abs(joy) > 0.1) {
    oldSpeed = perc * 10 * Math.signum(joy);
  } else {
    oldSpeed += addSpeed * Math.signum(joy - oldSpeed);
  }
    double speedMultiplier = isSlow ? 0.8 : 1.0;
    return oldSpeed;
  }

  private double speedBuffer(double joy)
  {
    if (joy >= 0.5) 
    return 0.5;
    return 0.5;

  }

  public void turnRight()
  {
    RobotMap.driveTrain.arcadeDrive(0, 0.6);
  }

  public void turnLeft()
  {
    RobotMap.driveTrain.arcadeDrive(0, -0.6);
  }

  public void stop()
  {
  RobotMap.driveTrain.arcadeDrive(0, 0);
  }

  // public void driveForward()
  // {
  //   double angle = RobotMap.turningGyro.getAngle();


  //   if(angle > 2.0)
  //   {
  //     RobotMap.driveTrain.tankDrive(0.6, 0.7);
  //   }
  //   else if(angle < -2.0)
  //   {
  //     RobotMap.driveTrain.tankDrive(0.7, 0.6);
  //   }
  //   else
  //   {
  //     RobotMap.driveTrain.tankDrive(-0.6, -0.6);
  //   }

  // }

  public void driveBackward() {
    RobotMap.driveTrain.arcadeDrive(-0.6, 0);
  }

  public void testDriveForward() {
    RobotMap.driveTrain.arcadeDrive(-0.6, 0);
  }
}
