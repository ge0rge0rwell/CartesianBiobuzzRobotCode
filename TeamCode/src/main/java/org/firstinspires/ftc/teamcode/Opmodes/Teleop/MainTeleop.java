package org.firstinspires.ftc.teamcode.Opmodes.Teleop;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.RobotContainer;
import org.firstinspires.ftc.teamcode.Bindings.KeyBinds;

@TeleOp(name = "Main TeleOp", group = "Cartesian")
public class MainTeleop extends CommandOpMode {
    private RobotContainer robot;

    @Override
    public void initialize() {
        robot = new RobotContainer(hardwareMap);
        KeyBinds.bind(new GamepadEx(gamepad1), robot.drivetrain);

        telemetry.addLine("Face robot away from drivers, or press BACK after start.");
        telemetry.update();
    }

    @Override
    public void run() {
        robot.startLoop();
        super.run();
        robot.reportTelemetry(telemetry);
    }
}