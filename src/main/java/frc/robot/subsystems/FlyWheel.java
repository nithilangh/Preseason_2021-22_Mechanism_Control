// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class FlyWheel extends SubsystemBase {
  /** Creates a new FlyWheel. */
  WPI_TalonSRX _flyWheelTalon;


  public FlyWheel() {
    _flyWheelTalon = new WPI_TalonSRX(Constants.MotorPorts.FlyWheelPort);

    _flyWheelTalon.configFactoryDefault();

    _flyWheelTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void RunFlyWheel(double _drivePower) {
    _flyWheelTalon.set(_drivePower);
  }

  // Returns velocity in ticks / 100ms
  public double getFlyWheelVelocity() {
    return _flyWheelTalon.getSelectedSensorVelocity();
  }

}
