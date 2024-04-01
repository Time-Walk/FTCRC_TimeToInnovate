package org.firstinspires.ftc.teamcode.modules;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.modules.superclasses.Module;

@Config
public class Drone extends Module {
    public Servo SM, SMA;
    public static double SMFLY = 0.2;
    public static double SMIDLE = 0.375;
    public static double SMAFLY = 0.6;
    public static double SMAIDLE = 0.4;
    public static double SMAPRE = .46;
    @Override
    public void init() {
        SM = hwmp.get(Servo.class, "SM");
        SMA = hwmp.get(Servo.class, "SMA");
    }
    public void fly() {
        int waitFor = 100;
        int times = 70;
        double perTime = (SMAIDLE - SMAFLY) / times;
        for (int i=0;i<times;i++) {
            SMA.setPosition(SMAIDLE-(perTime*i));
        }
        delay(1000);
        SM.setPosition(SMFLY);
        delay(2000);
        for (int i = 0;i<times;i++) {
            SMA.setPosition(SMAFLY-(perTime*i));
        }
        SMA.setPosition(SMAIDLE);
    }
    public void close() {
        SM.setPosition(SMIDLE);
    }
    public void tele() {
        if ( gamepad1.dpad_up ) { fly(); telemetry.addData("123", 123); telemetry.update();}
    }
}
