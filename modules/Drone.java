package org.firstinspires.ftc.teamcode.modules;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.modules.superclasses.Module;

@Config
public class Drone extends Module {
    Servo SM, SMA;
    public static double SMFLY = 0.2;
    public static double SMIDLE = 0.7;
    public static double SMAFLY = 0.2;
    public static double SMAIDLE = 0.7;
    @Override
    public void init() {
        SM = hwmp.get(Servo.class, "SM");
        SMA = hwmp.get(Servo.class, "SMA");
    }
    public void fly() {
        SMA.setPosition(SMAFLY);
        delay(1000);
        SM.setPosition(SMFLY);
        delay(2000);
        SMA.setPosition(SMAIDLE);
    }
    public void close() {
        SM.setPosition(SMIDLE);
    }
    public void tele() {
        if ( gamepad2.dpad_up ) { fly(); telemetry.addData("123", 123); telemetry.update();}
        else if (gamepad2.dpad_down) {close();}
    }
}
