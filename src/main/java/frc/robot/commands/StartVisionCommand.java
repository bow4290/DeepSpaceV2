/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.awt.Point;
import java.util.ArrayList;

import org.opencv.core.MatOfPoint;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.vision.VisionThread;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import frc.robot.Robot;

public class StartVisionCommand extends Command {
  private VisionThread gripPipeline;
  private double centerX = 0.0;
  // private double tapeDistance = 0.0;
  private final Object imgLock = new Object();
  UsbCamera camera;
  private boolean isFinished = false;
  private boolean isCentered = false;
  private double totalAverage = 0.0;
  private NetworkTable table = NetworkTable.getTable("tables");

  // public DropGearWithCameraCommand() {
  // Use requires() here to declare subsystem dependencies
  // eg. requires(chassis);
  // }

  public StartVisionCommand() {
    // Use requires() here to declare subsystem dependencies
    // require(Robot.);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    isCentered = false;
    isFinished = false;

    camera = CameraServer.getInstance().startAutomaticCapture();
    camera.setResolution(320, 240);

    gripPipeline = new VisionThread(camera, new GripPipeline(), pipeline -> {
      ArrayList<MatOfPoint> blobPoints = pipeline.findContoursOutput();
      synchronized (imgLock) {
        double currentAverage = 0;
        for (MatOfPoint matPoint : blobPoints) {
          double averageX = 0;
          org.opencv.core.Point[] currentPoints = matPoint.toArray();
          for (org.opencv.core.Point point : currentPoints) {
            averageX += point.x;
          }
          averageX = averageX / currentPoints.length;
          currentAverage += averageX;
        }
        totalAverage = currentAverage / blobPoints.size();
      }
      // table.putNumber("Total Average",totalAverage);

      // outputStream.putFrame(mat);
      // if (!pipeline.findContoursOutput().isEmpty()) {
      // if (pipeline.findContoursOutput().size() > 1) {
      // // Rect rectOne = Imgproc.boundingRect(pipeline.findContoursOutput().get(1));
      // // Rect rectTwo = Imgproc.boundingRect(pipeline.findContoursOutput().get(0));
      // synchronized (imgLock) {
      // // double centerRectOne = rectOne.x + (rectOne.width / 2);
      // // double centerRectTwo = rectTwo.x + (rectTwo.width / 2);
      // // tapeDistance = Math.abs(centerRectTwo - centerRectOne);
      // // centerX = (centerRectOne + centerRectTwo) / 2 - 10;
      // }
      // } else {
      // // Rect rectOne = Imgproc.boundingRect(pipeline.findContoursOutput().get(0));
      // synchronized (imgLock) {
      // centerX = rectOne.x + (rectOne.width / 2);
      // }
      // }
      // }
    });
    gripPipeline.start();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() { // double centerX;
    // double tapeDistance;
    synchronized (imgLock) {
      totalAverage = this.totalAverage;
    }

    // double turn = centerX - (320.0 / 2) * -1; // BEFORE COMP REMOVE -1

    table.putNumber("Total Average", totalAverage);
    // SmartDashboard.putNumber("Turn by", turn);
    // SmartDashboard.putNumber("Tape Distance", tapeDistance);

    // BEFORE COMP ADD NEGATIVE BACK
    if (totalAverage < 145) {
      // Robot.driveTrain.turnLeft();
    } else if (totalAverage > 175) {
      // Robot.driveTrain.turnRight();
      // isCentered = true;
    } else {
      isFinished = true;
    }

    // if (isCentered) {
    // if (tapeDistance > 0) {
    // SmartDashboard.putNumber("Tape Distance", tapeDistance);
    //
    // Robot.driveTrain.driveTo(0.3, 0);
    // } else {
    // isFinished = true;
    // }
    // }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return isFinished;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.driveTrain.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
