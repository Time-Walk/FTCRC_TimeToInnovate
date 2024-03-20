package org.firstinspires.ftc.teamcode.modules;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.modules.superclasses.Module;

@Config
public class Drone extends Module {
    Servo SM;
    public static double SMFLY = 0.2;
    public static double SMIDLE = 0.7;
    @Override
    public void init() {
        SM = hwmp.get(Servo.class, "SM");
    }
    public void fly() {
        SM.setPosition(SMFLY);
    }
    public void close() {
        SM.setPosition(SMIDLE);
    }
    public void tele() {
        if ( gamepad2.dpad_up ) { fly(); }
    }
}
