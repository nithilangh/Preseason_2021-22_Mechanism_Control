// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class FlyWheel extends SubsystemBase {
  /** Creates a new FlyWheel. */
  WPI_TalonSRX _flyWheelTalon;
  WPI_TalonSRX _intakeTalon;
  WPI_TalonSRX _gateTalon;


  public FlyWheel() {
    _flyWheelTalon = new WPI_TalonSRX(Constants.MotorPorts.FlyWheelPort);
    _intakeTalon = new WPI_TalonSRX(Constants.MotorPorts.IntakePort);
    _gateTalon = new WPI_TalonSRX(Constants.MotorPorts.GatePort);

    _flyWheelTalon.configFactoryDefault();
    _intakeTalon.configFactoryDefault();
    _gateTalon.configFactoryDefault();

    _flyWheelTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void runFlyWheel(double drivePower) {
    _flyWheelTalon.set(drivePower);
  }

  public void feedShooter(double feedSpeed) {
    _gateTalon.set(feedSpeed);
  }

  public void intakeBalls(double intakeSpeed) {
    _intakeTalon.set(intakeSpeed);
  }


  // Returns velocity in ticks / 100ms
  public double getFlyWheelVelocity() {
    // returns velocity in meters per second
    double ticksPerSecond = _flyWheelTalon.getSelectedSensorVelocity() * 10;
    double velocity = ticksPerSecond * Constants.Robot.FlyWheelCircumferenceMeters / 4096;
    return velocity;
  }

}
