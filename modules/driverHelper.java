package org.firstinspires.ftc.teamcode.modules;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.func.classes.RPD;
import org.firstinspires.ftc.teamcode.modules.IMU;
import org.firstinspires.ftc.teamcode.func.classes.PD;
import org.firstinspires.ftc.teamcode.modules.Wheelbase;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class driverHelper {
    Telemetry telemetry;
    LinearOpMode L;
    HardwareMap hwmp;
    Gamepad gamepad1;
    RPD rpd;
    public void initFields(Telemetry telemetry, LinearOpMode L, HardwareMap hwmp) {
        this.telemetry = telemetry;
        this.L = L;
        this.hwmp = hwmp;
    }
    public void initGamepad(Gamepad gamepad1) {
        this.gamepad1 = gamepad1;
    }
    public void init() {
        rpd = new RPD();
        rpd.initFields(telemetry, L, hwmp);
        rpd.init();
    }
    public void dh() {
        if (gamepad1.x) {
            rpd.rotate(90);
        } else if (gamepad1.b) {
            rpd.rotate(-90);
        }
    }
}
