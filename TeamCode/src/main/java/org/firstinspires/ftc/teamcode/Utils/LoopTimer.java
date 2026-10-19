package org.firstinspires.ftc.teamcode.Utils;

import com.qualcomm.robotcore.util.ElapsedTime;
public class LoopTimer {
    private final ElapsedTime timer = new ElapsedTime();

    public double turMs() {
        double ms = timer.milliseconds();
        timer.reset();
        return ms;
    }
}