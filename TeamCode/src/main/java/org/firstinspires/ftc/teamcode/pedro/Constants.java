package org.firstinspires.ftc.teamcode.pedro;

import static org.firstinspires.ftc.teamcode.RobotConstants.Hardware.*;

import com.pedropathing.follower.Follower;
import com.pedropathing.revhub.drivetrains.Mecanum;
import com.pedropathing.revhub.drivetrains.MecanumConfig;
import com.pedropathing.revhub.localizers.PinpointConfig;
import com.pedropathing.revhub.localizers.PinpointLocalizer;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class Constants {
    public static MecanumConfig drivetrainConfig = new MecanumConfig(c -> {
        c.frontLeftName.set(FRONT_LEFT);
        c.frontRightName.set(FRONT_RIGHT);
        c.backLeftName.set(BACK_LEFT);
        c.backRightName.set(BACK_RIGHT);
        c.frontLeftDirection.set(FRONT_LEFT_DIRECTION);
        c.frontRightDirection.set(FRONT_RIGHT_DIRECTION);
        c.backLeftDirection.set(BACK_LEFT_DIRECTION);
        c.backRightDirection.set(BACK_RIGHT_DIRECTION);
    });

    public static PinpointConfig localizerConfig = new PinpointConfig(c -> {
        c.name.set("pinpoint");
        c.podType.set(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);
        c.xPodOffset.set(0.0);
        c.yPodOffset.set(0.0);
        c.xPodDirection.set(GoBildaPinpointDriver.EncoderDirection.FORWARD);
        c.yPodDirection.set(GoBildaPinpointDriver.EncoderDirection.FORWARD);
        c.globalDistanceUnit.set(DistanceUnit.INCH);
        c.offsetUnits.set(DistanceUnit.INCH);
    });

    public static Mecanum drivetrain(HardwareMap h) {
        return new Mecanum(h, drivetrainConfig);
    }

    public static PinpointLocalizer localizer(HardwareMap h) {
        return new PinpointLocalizer(h, localizerConfig);
    }

    public static Follower create(HardwareMap h) {

        return new Follower(localizer(h), drivetrain(h), null);
    }
}