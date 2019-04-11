/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.Robot;
import frc.robot.commands.*;


/**
 * Add your docs here.
 */
public class Solenoid extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new HatchAutoClose());
  }

  public void shiftHigh() {
      RobotMap.gearShiftSolenoid.set(Value.kForward);
  }

  public void shiftLow() {
    RobotMap.gearShiftSolenoid.set(Value.kReverse);
  }
  public void hatchOpen() {
    RobotMap.hatchPanelSolenoid.set(Value.kForward);
  }
  public void hatchClosed() {
    RobotMap.hatchPanelSolenoid.set(Value.kReverse);
  }
  public void elbowUp() {
    RobotMap.wristSolenoid.set(Value.kForward);
  }
  public void elbowdown() {
    RobotMap.wristSolenoid.set(Value.kReverse);
  }
}
