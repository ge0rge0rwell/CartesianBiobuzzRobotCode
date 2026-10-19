package org.firstinspires.ftc.teamcode;

import com.bylazar.configurables.annotations.Configurable;
import com.qualcomm.robotcore.hardware.DcMotorSimple.Direction;

@Configurable
public class RobotConstants {

    public static double SLO_MO = 0.35;
    public static double TURN_COEFFICIENT = 0.8;
    public static double STICK_COUNTER = 0.05;

    public static final class Hardware {
        public static final String FRONT_LEFT  = "FrontLeftMotor";
        public static final String BACK_LEFT   = "BackLeftMotor";
        public static final String FRONT_RIGHT = "FrontRightMotor";
        public static final String BACK_RIGHT  = "BackRightMotor";

        public static final Direction FRONT_LEFT_DIRECTION  = Direction.REVERSE;
        public static final Direction BACK_LEFT_DIRECTION   = Direction.REVERSE;
        public static final Direction FRONT_RIGHT_DIRECTION = Direction.FORWARD;
        public static final Direction BACK_RIGHT_DIRECTION  = Direction.FORWARD;

        private Hardware() {}
    }
}