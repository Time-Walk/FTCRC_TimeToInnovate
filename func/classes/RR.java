package org.firstinspires.ftc.teamcode.func.classes;

import android.telephony.CellSignalStrengthWcdma;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.modules.IMU;
import org.firstinspires.ftc.teamcode.modules.Wheelbase;

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
    Wheelbase wb;
    double kr = 0.2;
    double ERROR;
    double R = 0;

    public void init() {
        wb = new Wheelbase();
        wb.initFields(telemetry, L, hwmp);
        wb.init();
    }

    public void rotate(double degrees) {
        if (gamepad1.x || gamepad1.b) {
            ERROR = degrees - getAngle();
            R = Math.signum(ERROR) * kr;
        }
        while (ERROR>1) {
            wb.setMtPower(R, R, -R, -R);
        } wb.setMtZero();
    }

}
