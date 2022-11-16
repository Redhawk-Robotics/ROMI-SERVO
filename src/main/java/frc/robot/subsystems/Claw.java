// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Claw extends SubsystemBase {
  /** Creates a new Servo. */
  private final Servo claw = new Servo(Constants.Claw);
  private double ClawPos;

  public Claw() {
    reset();
  }

  private void reset() {
    ClawPos = 0.5;

    claw.set(ClawPos);
  }

  public void incrementArm(double upward){
    ClawPos = saturateLimit(ClawPos + upward,0,1);
    claw.set(ClawPos);

  }

  public double get_armPos() {
    return ClawPos;
  }

  public double getArmAngle(){
    return claw.getAngle();
  }
  
  public double saturateLimit(double val, double l_limit, double u_limit) {
    double outval = val;
    if(val > u_limit) {
      outval =  u_limit;
    } else if (val < l_limit) {
      outval = l_limit;
    }
    return outval;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
