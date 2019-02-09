/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;

public class Oi1Joystick {
  public Joystick rightJoystick;
  private JoystickButton rightJoystickButton1;
  private JoystickButton rightJoystickButton2;
  private JoystickButton rightJoystickButton3;
  private JoystickButton rightJoystickButton4;
  private JoystickButton rightJoystickButton5;
  private JoystickButton rightJoystickButton6;
  private JoystickButton rightJoystickButton7;
  private JoystickButton rightJoystickButton8;  


  public Oi1Joystick() {
    rightJoystick = new Joystick(0);
    rightJoystickButton1 = new JoystickButton(rightJoystick, 1);
    rightJoystickButton2 = new JoystickButton(rightJoystick, 2);
    rightJoystickButton3 = new JoystickButton(rightJoystick, 3);
    rightJoystickButton4 = new JoystickButton(rightJoystick, 4);
    rightJoystickButton5 = new JoystickButton(rightJoystick, 5);
    rightJoystickButton6 = new JoystickButton(rightJoystick, 6);
    rightJoystickButton7 = new JoystickButton(rightJoystick, 7);
    rightJoystickButton8 = new JoystickButton(rightJoystick, 8);

    // Joystick Button API Notes:
    // Methods inherited from class edu.wpi.first.wpilibj.buttons.Button
    // cancelWhenPressed, toggleWhenPressed, whenPressed, whenReleased, whileHeld
    // Methods inherited from class edu.wpi.first.wpilibj.buttons.Trigger
    // cancelWhenActive, initSendable, toggleWhenActive, whenActive, whenInactive, whileActive

    rightJoystickButton1.whenPressed(new TurnWithGyroCommand(90));
    rightJoystickButton1.whenPressed(new StartVisionCommand());
    
    rightJoystickButton1.whileHeld(new MoveWristToAngle(1));
    rightJoystickButton2.whileHeld(new MoveWristToAngle(0));

    rightJoystickButton7.whileHeld(new PickUpBall());
    rightJoystickButton8.whileHeld(new ThrowBall());
    
    rightJoystickButton5.whileHeld(new ElevatorUp());
    rightJoystickButton6.whileHeld(new ElevatorDown());

    rightJoystickButton3.whileHeld(new ElbowUp());
    rightJoystickButton4.whileHeld(new ElbowDown());
  }
}
