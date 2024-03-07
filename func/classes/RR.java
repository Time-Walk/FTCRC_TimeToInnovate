package org.firstinspires.ftc.teamcode.func.classes;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.modules.IMU;
public class RR extends IMU {
    Telemetry telemetry;
    LinearOpMode L;
    HardwareMap hwmp;
    Gamepad gamepad1;

    public void initFields(Telemetry telemetry, LinearOpMode L, HardwareMap hwmp) {
        this.telemetry = telemetry;
        this.L = L;
        this.hwmp = hwmp;
    }

    public void initGamepad(Gamepad gamepad1) {
        this.gamepad1 = gamepad1;
    }

    double kr = 0.2;
    double ERROR;
    double Rele = 0;

    public double move(double degrees) {
        if (gamepad1.x || gamepad1.b) {
            ERROR = degrees - getAngle();
            Rele = Math.signum(ERROR) * kr;
        }
        return Rele;
    }

}
