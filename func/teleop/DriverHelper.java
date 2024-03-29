package org.firstinspires.ftc.teamcode.func.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.func.classes.RR;

public class DriverHelper {
    Telemetry telemetry;
    LinearOpMode L;
    HardwareMap hwmp;
    Gamepad gamepad1 ;
    RR rr;
    public void initFields(Telemetry telemetry, LinearOpMode L, HardwareMap hwmp) {
        this.telemetry = telemetry;
        this.L = L;
        this.hwmp = hwmp;
    }
    public void initGamepad(Gamepad gamepad1) {
        this.gamepad1 = gamepad1;
    }
    public void init() {
        rr = new RR();
        rr.initFields(telemetry, L, hwmp);
        rr.init();
    }
    public void dh() {
        if (gamepad1.x) {
            rr.rotate(90);
        } else if (gamepad1.b) {
            rr.rotate(-90);
        }
    }
}
