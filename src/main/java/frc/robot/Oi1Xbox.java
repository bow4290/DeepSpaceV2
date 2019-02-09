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

public class Oi1Xbox {
  public XboxController mainXboxController;
  private JoystickButton mainXboxControllerButton1;
  private JoystickButton mainXboxControllerButton2;
  private JoystickButton mainXboxControllerButton3;
  private JoystickButton mainXboxControllerButton4;
  private JoystickButton mainXboxControllerButton5;
  private JoystickButton mainXboxControllerButton6;
  private JoystickButton mainXboxControllerButton7;
  private JoystickButton mainXboxControllerButton8;
  private JoystickButton mainXboxControllerButton9;
  private JoystickButton mainXboxControllerButton10;

  
  public Oi1Xbox() {    
    mainXboxController = new XboxController(0);
    mainXboxControllerButton1 = new JoystickButton(mainXboxController, 1);
    mainXboxControllerButton2 = new JoystickButton(mainXboxController, 2);
    mainXboxControllerButton3 = new JoystickButton(mainXboxController, 3);
    mainXboxControllerButton4 = new JoystickButton(mainXboxController, 4);
    mainXboxControllerButton5 = new JoystickButton(mainXboxController, 5);
    mainXboxControllerButton6 = new JoystickButton(mainXboxController, 6);
    mainXboxControllerButton7 = new JoystickButton(mainXboxController, 7);
    mainXboxControllerButton8 = new JoystickButton(mainXboxController, 8);
    mainXboxControllerButton9 = new JoystickButton(mainXboxController, 9);
    mainXboxControllerButton10 = new JoystickButton(mainXboxController, 10);

    mainXboxControllerButton1.whenPressed(new TurnWithGyroCommand(90));
    mainXboxControllerButton2.whenPressed(new StartVisionCommand());
    
    mainXboxControllerButton3.whileHeld(new MoveWristToAngle(1));
    mainXboxControllerButton4.whileHeld(new MoveWristToAngle(0));

    mainXboxControllerButton5.whileHeld(new PickUpBall());
    mainXboxControllerButton6.whileHeld(new ThrowBall());
    
    mainXboxControllerButton7.whileHeld(new ElevatorUp());
    mainXboxControllerButton8.whileHeld(new ElevatorDown());

    mainXboxControllerButton9.whileHeld(new ElbowUp());
    mainXboxControllerButton10.whileHeld(new ElbowDown());
  }
}
