package org.firstinspires.ftc.teamcode.Bindings;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.RunCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.Subsystems.Drivetrain;


public final class KeyBinds {
    private KeyBinds() {}

    public static void bind(GamepadEx driver, Drivetrain dt) {
        dt.setDefaultCommand(new RunCommand(
                () -> dt.drive(driver.getLeftY(), -driver.getLeftX(), -driver.getRightX()),
                dt));

        driver.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER)
                .whenPressed(new InstantCommand(() -> dt.setSloMo(true)))
                .whenReleased(new InstantCommand(() -> dt.setSloMo(false)));

        driver.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER)
                .whenPressed(new InstantCommand(dt::toggleFieldCentric));

        driver.getGamepadButton(GamepadKeys.Button.BACK)
                .whenPressed(new InstantCommand(dt::resetDriverForward));
    }
}