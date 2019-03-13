/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;


public class WristPID extends PIDSubsystem { // This system extends PIDSubsystem
	public WristPID() {
		super("Wrist", 2.0, 0.0, 0.0);// The constructor passes a name for the subsystem and the P, I and D constants that are used when computing the motor output
		setAbsoluteTolerance(0.05);
		getPIDController().setContinuous(false);
	}
	
    public void initDefaultCommand() {
    }

    public double returnPIDInput() {
      var PotOutput = RobotMap.potInputPosition.getAverageVoltage(); // returns the sensor value that is providing the feedback for the system
      SmartDashboard.putNumber("Pot Output", PotOutput);
      return PotOutput;
    }

    public void usePIDOutput(double output) {
      SmartDashboard.putNumber("Pot Input", output);
    	RobotMap.wristMotor.pidWrite(output); // this is where the computed output value fromthe PIDController is applied to the motor
    }
}