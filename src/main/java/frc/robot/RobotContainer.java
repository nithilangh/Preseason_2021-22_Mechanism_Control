// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants.JoystickAxis;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.FeedShooter;
import frc.robot.commands.IntakeBalls;
import frc.robot.commands.RunFlyWheel;
import frc.robot.commands.SpinFlyWheel;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.FlyWheel;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  private final FlyWheel _flyWheel;

  private final Joystick _joystick;

  private final SpinFlyWheel _spinFlyWheel;

  private final IntakeBalls _intakeBalls;

  private final FeedShooter _feedShooter;

  private final RunFlyWheel _runFlyWheel;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    _flyWheel = new FlyWheel();

    _joystick = new Joystick(Constants.USBOrder.ZERO);

    _spinFlyWheel = new SpinFlyWheel(_flyWheel, _joystick);

    _intakeBalls = new IntakeBalls(_flyWheel);

    _feedShooter = new FeedShooter(_flyWheel);

    _runFlyWheel = new RunFlyWheel(_flyWheel, _joystick);

    _flyWheel.setDefaultCommand(_runFlyWheel);


    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
