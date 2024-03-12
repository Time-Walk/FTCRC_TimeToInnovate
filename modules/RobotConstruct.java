package org.firstinspires.ftc.teamcode.modules;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.func.classes.RPD;
import org.firstinspires.ftc.teamcode.func.classes.RR;
import org.firstinspires.ftc.teamcode.func.teleop.GrabTeleop;
import org.firstinspires.ftc.teamcode.func.teleop.WheelBaseDrive;
import org.firstinspires.ftc.teamcode.func.teleop.driverHelper;
import org.firstinspires.ftc.teamcode.modules.camera.CameraOut;

@Config
public class RobotConstruct extends Robot {
    public CameraOut cameraOut;
    public Wheelbase wb;
    public Drone sm;
    public Neon neon;
    public Grab grab;
    public IMU imu;
    public RPD rpd;
    public RR rr;
    public driverHelper dh;
    public WheelBaseDrive wbd;
    public GrabTeleop grabtele;

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

        rr = new RR();
        rr.initFields(telemetry, L, hwmp);
        rr.init();

        rpd = new RPD();
        rpd.initFields(telemetry, L, hwmp);
        rpd.init();

        dh = new driverHelper();
        dh.initFields(telemetry, L, hwmp);
        dh.init();

        wbd = new WheelBaseDrive();
        wbd.initFields(telemetry, L, hwmp);
        wbd.init();

        grabtele = new GrabTeleop();
        grabtele.initFields(telemetry, L, hwmp);
        grabtele.init();
    }

    @Override
    public void initFields(Telemetry telemetry, LinearOpMode L, HardwareMap hwmp) {
        this.telemetry = telemetry; this.L = L; this.hwmp = hwmp;
    }
}
