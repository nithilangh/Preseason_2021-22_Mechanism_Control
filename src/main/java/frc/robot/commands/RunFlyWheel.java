// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.FlyWheel;

public class RunFlyWheel extends CommandBase {
  /** Creates a new RunFlyWheel. */

  FlyWheel _flyWheel;
  Joystick _joystick;

  public RunFlyWheel(FlyWheel flw, Joystick js) {
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
    double _flyWheelSpeed = _joystick.getRawAxis(Constants.JoystickAxis.YAxis);

    _flyWheel.runFlyWheel(_flyWheelSpeed);

    _flyWheel.intakeBalls(0.8);

    if(_joystick.getRawButton(1) == true) {
      _flyWheel.feedShooter(0.3);
    }
    else {
      _flyWheel.feedShooter(0.0);
    }

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
