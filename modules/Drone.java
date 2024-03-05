package org.firstinspires.ftc.teamcode.modules;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Config
public class Drone {
    Telemetry telemetry;
    LinearOpMode L;
    HardwareMap hwmp;
    Servo SM;
    public static double SMFLY = 0.2;
    public static double SMIDLE = 0.7;
    public void initFields(Telemetry telemetry, LinearOpMode L, HardwareMap hwmp) {
        this.telemetry = telemetry; this.L = L; this.hwmp = hwmp;
    }
    public void init() {
        SM = hwmp.get(Servo.class, "SM");
    }
    public void fly() {
        SM.setPosition(SMFLY);
    }
    public void close() {
        SM.setPosition(SMIDLE);
    }
}
