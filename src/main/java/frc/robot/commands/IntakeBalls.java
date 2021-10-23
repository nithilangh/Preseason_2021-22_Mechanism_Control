// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FlyWheel;

public class IntakeBalls extends CommandBase {
  /** Creates a new IntakeBalls. */

  FlyWheel _flyWheel;

  public IntakeBalls(FlyWheel flw) {
    // Use addRequirements() here to declare subsystem dependencies.
    _flyWheel = flw;
    addRequirements(_flyWheel);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    _flyWheel.intakeBalls(0.5);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
