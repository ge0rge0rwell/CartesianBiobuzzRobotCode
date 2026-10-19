package org.firstinspires.ftc.teamcode.Subsystems;

import static org.firstinspires.ftc.teamcode.RobotConstants.*;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.bylazar.telemetry.TelemetryManager;
import com.pedropathing.follower.Follower;
import com.pedropathing.math.Pose;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.pedro.Constants;

/**
 * Mecanum drive wrapped around Pedro 3's Follower.
 * Rule: nothing outside this class calls follower.update().
 */
public class Drivetrain extends SubsystemBase {
    private final Follower follower;

    private boolean fieldCentric = true;
    private boolean sloMo = false;
    /** Field heading (radians) the drivers call "forward". Separate from odometry on purpose. */
    private double driverForward = 0.0;

    public Drivetrain(HardwareMap hardwareMap) {
        follower = Constants.create(hardwareMap);
        follower.setPose(Pose.zero());
    }

    @Override
    public void periodic() {
        follower.update();
    }

    public void drive(double forward, double strafeLeft, double turnCcw) {
        forward = deadband(forward);
        strafeLeft = deadband(strafeLeft);
        turnCcw = deadband(turnCcw);

        if (fieldCentric) {
            double h = follower.pose().heading() - driverForward;
            double robotForward = forward * Math.cos(h) + strafeLeft * Math.sin(h);
            double robotStrafe = -forward * Math.sin(h) + strafeLeft * Math.cos(h);
            forward = robotForward;
            strafeLeft = robotStrafe;
        }

        double scale = sloMo ? SLO_MO : 1.0;
        follower.manual(forward * scale, strafeLeft * scale, turnCcw * scale * TURN_COEFFICIENT);
    }

    public void resetDriverForward() {
        driverForward = follower.pose().heading();
    }

    public void setSloMo(boolean on) {
        sloMo = on;
    }

    public void toggleFieldCentric() {
        fieldCentric = !fieldCentric;
    }

    public void telemetry(TelemetryManager t) {
        Pose p = follower.pose();
        t.debug(String.format("pose: x=%.1f y=%.1f h=%.1f deg",
                p.x(), p.y(), Math.toDegrees(p.heading())));
        t.debug("mode: " + (fieldCentric ? "field" : "robot") + (sloMo ? " | SLOW" : ""));
    }

    private static double deadband(double v) {
        return Math.abs(v) < STICK_COUNTER ? 0.0 : v;
    }
}