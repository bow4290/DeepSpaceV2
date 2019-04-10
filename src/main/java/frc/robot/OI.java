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
  public XboxController rightJoystick;
  private JoystickButton rightJoystickButton1;
  private JoystickButton rightJoystickButton2;
  private JoystickButton rightJoystickButton3;
  private JoystickButton rightJoystickButton4;
  private JoystickButton rightJoystickButton5;
  private JoystickButton rightJoystickButton6;
  private JoystickButton rightJoystickButton7;
  private JoystickButton rightJoystickButton8;  

  public XboxController leftJoystick;
  private JoystickButton leftJoystickButton1;
  private JoystickButton leftJoystickButton2;
  private JoystickButton leftJoystickButton3;
  private JoystickButton leftJoystickButton4;
  private JoystickButton leftJoystickButton5;
  private JoystickButton leftJoystickButton6;
  private JoystickButton leftJoystickButton7;
  private JoystickButton leftJoystickButton8;
  private JoystickButton leftJoystickButton9;

  public OI() {
    rightJoystick = new XboxController(0);
    rightJoystickButton1 = new JoystickButton(rightJoystick, 1);
    rightJoystickButton2 = new JoystickButton(rightJoystick, 2);
    rightJoystickButton3 = new JoystickButton(rightJoystick, 3);
    rightJoystickButton4 = new JoystickButton(rightJoystick, 4);
    rightJoystickButton5 = new JoystickButton(rightJoystick, 5);
    rightJoystickButton6 = new JoystickButton(rightJoystick, 6);
    rightJoystickButton7 = new JoystickButton(rightJoystick, 7);
    rightJoystickButton8 = new JoystickButton(rightJoystick, 8);

    leftJoystick = new XboxController(1);
    leftJoystickButton1 = new JoystickButton(leftJoystick, 1);
    leftJoystickButton2 = new JoystickButton(leftJoystick, 2);
    leftJoystickButton3 = new JoystickButton(leftJoystick, 3);
    leftJoystickButton4 = new JoystickButton(leftJoystick, 4);
    leftJoystickButton5 = new JoystickButton(leftJoystick, 5);
    leftJoystickButton6 = new JoystickButton(leftJoystick, 6);
    leftJoystickButton7 = new JoystickButton(leftJoystick, 7);
    leftJoystickButton8 = new JoystickButton(leftJoystick, 8);
    leftJoystickButton9 = new JoystickButton(leftJoystick, 9);
      
    
    
    //Joystick Button API Notes:
    // Methods inherited from class edu.wpi.first.wpilibj.buttons.Button
    // cancelWhenPressed, toggleWhenPressed, whenPressed, whenReleased, whileHeld
    // Methods inherited from class edu.wpi.first.wpilibj.buttons.Trigger
    // cancelWhenActive, initSendable, toggleWhenActive, whenActive, whenInactive, whileActive
    
    //========================================================================================
    //==================  Driver Controller  =================================================
    //========================================================================================
    rightJoystickButton1.whileActive(new HatchOpen());
    rightJoystickButton1.whenInactive(new HatchAutoClose());
    rightJoystickButton2.whileHeld(new HatchClose());

    rightJoystickButton3.whileHeld(new ShiftUp());
    rightJoystickButton4.whileHeld(new ShiftDown());
    
    rightJoystickButton5.whileHeld(new PickUpBall());
    rightJoystickButton6.whileHeld(new ThrowBall());

    // leftJoystickButton7.whileHeld(new StopWrist());


    

    
    //========================================================================================
    //==================  Operator Controller  ===============================================
    //========================================================================================

    leftJoystickButton1.whileHeld(new WristDown());
    leftJoystickButton2.whileHeld(new WristUp());

    // leftJoystickButton3.whileHeld(new PickUpBall());
    // leftJoystickButton4.whileHeld(new ThrowBall());

    leftJoystickButton5.whileHeld(new ElevatorDown());
    leftJoystickButton6.whileHeld(new ElevatorUp());

    leftJoystickButton7.whileHeld(new ClimbUp());
    leftJoystickButton8.whileHeld(new ClimbDown());

    // leftJoystickButton9.whileHeld(new StopWrist());

    // wrist up and down 
    // hatch open and close
    // climber up and down 
    // drive with line controller

  }
}
