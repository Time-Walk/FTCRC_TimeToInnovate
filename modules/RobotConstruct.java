package org.firstinspires.ftc.teamcode.modules;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.func.classes.RPD;
import org.firstinspires.ftc.teamcode.modules.camera.CameraOut;

@Config
public class RobotConstruct extends Robot {
    CameraOut cameraOut;
    Wheelbase wb;
    Drone sm;
    Neon neon;
    Grab grab;
    IMU imu;

    @Override
    public void init() {
        cameraOut = new CameraOut();
        cameraOut.initFields(telemetry, L, hwmp);
        cameraOut.init();

        wb = new Wheelbase();
        wb.initFields(telemetry, L, hwmp);
        wb.init();

        sm = new Drone();
        sm.initFields(telemetry, L, hwmp);
        sm.init();

        neon = new Neon();
        neon.initFields(telemetry, L, hwmp);
        neon.init();

        grab = new Grab();
        grab.initFields(telemetry, L, hwmp);
        grab.init();

        imu = new IMU();
        imu.initFields(telemetry, L, hwmp);
        imu.init();

    }

    @Override
    public void initFields(Telemetry telemetry, LinearOpMode L, HardwareMap hwmp) {
        this.telemetry = telemetry; this.L = L; this.hwmp = hwmp;
    }
}
