package frc.robot.subsystems.counter;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import org.littletonrobotics.junction.Logger;

public class CounterSubsystem extends SubsystemBase {
  private int counter = 0;
  private int step = 0;

  private int upperBound = 50;
  private int lowerBound = 0;

  public CounterSubsystem() {
    this.step = 1;
  }

  public CounterSubsystem(int step) {
    this.step = step;
  }

  @Override
  public void periodic() {
    Logger.recordOutput("Counter/Value", this.counter);
  }

  public Command incrementCounter() {
    return new RunCommand(
        () -> {
          counter += step;
        });
  }

  public Command decreaseCounter() {
    return new RunCommand(
        () -> {
          counter -= step;
        });
  }

  public Command setCounterToValue(int value) {
    return new InstantCommand(
        () -> {
          counter = value;
        });
  }

  public Trigger isBelowUpperLimit() {
    return new Trigger(() -> this.counter < this.upperBound);
  }

  public Trigger isAboveLowerLimit() {
    return new Trigger(() -> this.counter > this.lowerBound);
  }
}
