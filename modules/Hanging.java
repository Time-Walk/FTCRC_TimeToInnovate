package org.firstinspires.ftc.teamcode.modules;


import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.modules.superclasses.Module;

@Config
public class Hanging extends Module {
    public static double HSOpen = 1;
    public static double HSClose = 0;
    DcMotor HR, HL;
    Servo HRS, HLS;
    public void init() {
        HR = hwmp.get(DcMotor.class, "HR");
        HL = hwmp.get(DcMotor.class, "HL");
        HRS = hwmp.get(Servo.class, "HRS");
        HLS = hwmp.get(Servo.class, "HLS");
    }
    public void onp() {
        HR.setPower(1);
        HL.setPower(-1);
    }
    public void onm() {
        HR.setPower(-1);
        HL.setPower(1);
    }
    public void off() {
        HR.setPower(0);
        HL.setPower(0);
    }
    public void tele() {
        if (gamepad2.a) {
            onp();
        }
        else if (gamepad2.x) {
            onm();
        } else if (gamepad2.y) {
            HRS.setPosition(HSOpen);
            HLS.setPosition(HSClose);
        } else if (gamepad2.b) {
            HRS.setPosition(HSClose);
            HLS.setPosition(HSOpen);
        }
        else {
            off();
        }
    }

}