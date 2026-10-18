package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class RobotConstants {
    public static final class HardwareMappings {
        public static final String FRONT_LEFT = "FrontLeftMotor";
        public static final String BACK_LEFT = "BackLeftMotor";
        public static final String FRONT_RIGHT = "FrontRightMotor";
        public static final String BACK_RIGHT = "BackRightMotor";
        public static DcMotorSimple.Direction LeftFrontDirection = DcMotorSimple.Direction.REVERSE;

        public static DcMotorSimple.Direction RightFrontDirection = DcMotorSimple.Direction.FORWARD;

        public static DcMotorSimple.Direction LeftBackDirection = DcMotorSimple.Direction.REVERSE;

        public static DcMotorSimple.Direction RightBackDirection = DcMotorSimple.Direction.FORWARD;
        public static String ImuName = "imu";



    }
}
