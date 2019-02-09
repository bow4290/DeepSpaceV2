/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;

public class OI {
  public Joystick rightJoystick;
  private JoystickButton rightJoystickButton1;
  private JoystickButton rightJoystickButton2;
  private JoystickButton rightJoystickButton3;
  private JoystickButton rightJoystickButton4;
  private JoystickButton rightJoystickButton5;
  private JoystickButton rightJoystickButton6;
  private JoystickButton rightJoystickButton7;
  private JoystickButton rightJoystickButton8;  

  // public Joystick leftJoystick;
  // private JoystickButton leftJoystickButton1;
  // private JoystickButton leftJoystickButton2;
  // private JoystickButton leftJoystickButton3;
  // private JoystickButton leftJoystickButton4;
  // private JoystickButton leftJoystickButton5;
  // private JoystickButton leftJoystickButton6;
  // private JoystickButton leftJoystickButton7;
  // private JoystickButton leftJoystickButton8;

  // public XboxController mainXboxController;
  // private JoystickButton mainXboxControllerButton1;
  // private JoystickButton mainXboxControllerButton2;
  // private JoystickButton mainXboxControllerButton3;
  // private JoystickButton mainXboxControllerButton4;
  // private JoystickButton mainXboxControllerButton5;
  // private JoystickButton mainXboxControllerButton6;
  // private JoystickButton mainXboxControllerButton7;
  // private JoystickButton mainXboxControllerButton8;
  // private JoystickButton mainXboxControllerButton9;

  // public XboxController secondaryXboxController;
  // private JoystickButton secondaryXboxControllerButton1;
  // private JoystickButton secondaryXboxControllerButton2;
  // private JoystickButton secondaryXboxControllerButton3;
  // private JoystickButton secondaryXboxControllerButton4;
  // private JoystickButton secondaryXboxControllerButton5;
  // private JoystickButton secondaryXboxControllerButton6;
  // private JoystickButton secondaryXboxControllerButton7;
  // private JoystickButton secondaryXboxControllerButton8;
  // private JoystickButton secondaryXboxControllerButton9;

  public OI() {
    rightJoystick = new Joystick(0);
    rightJoystickButton1 = new JoystickButton(rightJoystick, 1);
    rightJoystickButton2 = new JoystickButton(rightJoystick, 2);
    rightJoystickButton3 = new JoystickButton(rightJoystick, 3);
    rightJoystickButton4 = new JoystickButton(rightJoystick, 4);
    rightJoystickButton5 = new JoystickButton(rightJoystick, 5);
    rightJoystickButton6 = new JoystickButton(rightJoystick, 6);
    rightJoystickButton7 = new JoystickButton(rightJoystick, 7);
    rightJoystickButton8 = new JoystickButton(rightJoystick, 8);

    // leftJoystick = new Joystick(1);
    // leftJoystickButton1 = new JoystickButton(leftJoystick, 0);
    // leftJoystickButton2 = new JoystickButton(leftJoystick, 1);
    // leftJoystickButton3 = new JoystickButton(leftJoystick, 2);
    // leftJoystickButton4 = new JoystickButton(leftJoystick, 3);
    // leftJoystickButton5 = new JoystickButton(leftJoystick, 4);
    // leftJoystickButton6 = new JoystickButton(leftJoystick, 5);
    // leftJoystickButton7 = new JoystickButton(leftJoystick, 6);
    // leftJoystickButton8 = new JoystickButton(leftJoystick, 7);    
    
    // mainXboxController = new XboxController(0);
    // mainXboxControllerButton1 = new JoystickButton(mainXboxController, 1);
    // mainXboxControllerButton2 = new JoystickButton(mainXboxController, 2);
    // mainXboxControllerButton3 = new JoystickButton(mainXboxController, 3);
    // mainXboxControllerButton4 = new JoystickButton(mainXboxController, 4);
    // mainXboxControllerButton5 = new JoystickButton(mainXboxController, 5);
    // mainXboxControllerButton6 = new JoystickButton(mainXboxController, 6);
    // mainXboxControllerButton7 = new JoystickButton(mainXboxController, 7);
    // mainXboxControllerButton8 = new JoystickButton(mainXboxController, 8);
    // mainXboxControllerButton9 = new JoystickButton(mainXboxController, 9);

    // secondaryXboxController = new XboxController(0);
    // secondaryXboxControllerButton1 = new JoystickButton(secondaryXboxController, 0);
    // secondaryXboxControllerButton2 = new JoystickButton(secondaryXboxController, 1);
    // secondaryXboxControllerButton3 = new JoystickButton(secondaryXboxController, 2);
    // secondaryXboxControllerButton4 = new JoystickButton(secondaryXboxController, 3);
    // secondaryXboxControllerButton5 = new JoystickButton(secondaryXboxController, 4);
    // secondaryXboxControllerButton6 = new JoystickButton(secondaryXboxController, 5);
    // secondaryXboxControllerButton7 = new JoystickButton(secondaryXboxController, 6);
    // secondaryXboxControllerButton8 = new JoystickButton(secondaryXboxController, 7);
    // secondaryXboxControllerButton9 = new JoystickButton(secondaryXboxController, 8);

    //Joystick Button API Notes:
    // Methods inherited from class edu.wpi.first.wpilibj.buttons.Button
    // cancelWhenPressed, toggleWhenPressed, whenPressed, whenReleased, whileHeld
    // Methods inherited from class edu.wpi.first.wpilibj.buttons.Trigger
    // cancelWhenActive, initSendable, toggleWhenActive, whenActive, whenInactive, whileActive


    // rightJoystickButton1.whenPressed(new TurnWithGyroCommand(90));
    // rightJoystickButton1.whenPressed(new StartVisionCommand());
    
    // rightJoystickButton1.whileHeld(new MoveWristToAngle(1));
    rightJoystickButton2.whileHeld(new MoveWristToAngle(0));

    rightJoystickButton7.whileHeld(new PickUpBall());
    rightJoystickButton8.whileHeld(new ThrowBall());
    
    rightJoystickButton5.whileHeld(new ElevatorUp());
    rightJoystickButton6.whileHeld(new ElevatorDown());

    rightJoystickButton3.whileHeld(new ElbowUp());
    rightJoystickButton4.whileHeld(new ElbowDown());

    rightJoystickButton1.whileHeld(new DriveWithLineFollowers());
    rightJoystickButton1.whenReleased(new DriveWithJoysticks());
    



    // mainXboxControllerButton1.whenPressed(new TurnWithGyroCommand(90));
    // mainXboxControllerButton2.whenPressed(new StartVisionCommand());
    
    // mainXboxControllerButton3.whileHeld(new MoveWristToAngle(1));
    // mainXboxControllerButton4.whileHeld(new MoveWristToAngle(0));

    // mainXboxControllerButton5.whileHeld(new PickUpBall());
    // mainXboxControllerButton6.whileHeld(new ThrowBall());
    
    // mainXboxControllerButton7.whileHeld(new ElevatorUp());
    // mainXboxControllerButton8.whileHeld(new ElevatorDown());

    // mainXboxControllerButton1.whileHeld(new ElbowUp());
    // mainXboxControllerButton2.whileHeld(new ElbowDown());



  }
}
