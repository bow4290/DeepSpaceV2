/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import static org.junit.Assume.assumeNoException;

import edu.wpi.first.wpilibj.ADXL345_I2C;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.interfaces.Accelerometer.Range;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class experimentalAccelerometer extends Command {
  Accelerometer accel;
  double accelerometerX;
  double accelerometerY;
  double accelerometerZ;

  private NetworkTable table = NetworkTable.getTable("tables");

  public experimentalAccelerometer() {
    accel = new ADXL345_I2C(I2C.Port.kOnboard, Accelerometer.Range.k4G);
  }

  public void experimentalAccelerometer() {
  }

  private boolean isEnabled() {
    return false;
  }

  private boolean isOperatorControl() {
    return false;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double accelerationX = accel.getX();
    double accelerationY = accel.getY();
    double accelerationZ = accel.getZ();

    table.putNumber("accelerationX", accelerationX);
    table.putNumber("accelerationY", accelerationY);
    table.putNumber("accelerationZ", accelerationZ);

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
