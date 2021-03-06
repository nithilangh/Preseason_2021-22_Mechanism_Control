// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.FlyWheel;

public class SpinFlyWheel extends CommandBase {
  /** Creates a new SpinFlyWheel. */
  FlyWheel _flyWheel;

  Joystick _joystick;



  public SpinFlyWheel(FlyWheel flw, Joystick js) {
    // Use addRequirements() here to declare subsystem dependencies.
    _flyWheel = flw;

    _joystick = js;



    addRequirements(_flyWheel);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double speed = _joystick.getRawAxis(Constants.JoystickAxis.YAxis);

    _flyWheel.runFlyWheel(speed);

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
