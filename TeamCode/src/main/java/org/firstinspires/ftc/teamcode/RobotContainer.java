package org.firstinspires.ftc.teamcode;

import com.bylazar.telemetry.PanelsTelemetry;
import com.bylazar.telemetry.TelemetryManager;
import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Subsystems.Drivetrain;

import java.util.List;


public class RobotContainer {
    public final Drivetrain drivetrain;

    private final List<LynxModule> hubs;
    private final TelemetryManager panels;
    private final ElapsedTime loopTimer = new ElapsedTime();

    public RobotContainer(HardwareMap hardwareMap) {
        hubs = hardwareMap.getAll(LynxModule.class);
        for (LynxModule hub : hubs) {
            hub.setBulkCachingMode(LynxModule.BulkCachingMode.MANUAL);
        }

        drivetrain = new Drivetrain(hardwareMap);
        panels = PanelsTelemetry.INSTANCE.getTelemetry();
    }

    public void startLoop() {
        for (LynxModule hub : hubs) {
            hub.clearBulkCache();
        }
    }

    public void reportTelemetry(Telemetry dsTelemetry) {
        panels.debug(String.format("loop: %.1f ms", loopTimer.milliseconds()));
        loopTimer.reset();
        drivetrain.telemetry(panels);
        panels.update(dsTelemetry);
    }
}