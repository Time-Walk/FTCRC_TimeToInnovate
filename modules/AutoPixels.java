package org.firstinspires.ftc.teamcode.modules;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.modules.superclasses.Module;

@Config
public class AutoPixels extends Module {
    Servo YP, PP;
    public static double YPIDLE = .9;
    public static double YPSTAND = .15;
    public static double PPIDLE = .3;
    public static double PPOPEN = .8;
    public void init() {
        YP = hwmp.get(Servo.class, "YP");
        PP = hwmp.get(Servo.class, "PP");
    }

    public void YPStand() {YP.setPosition(YPSTAND);}
    public void YPClose() {YP.setPosition(YPIDLE);}
    public void PPOpen() {PP.setPosition(PPOPEN);}
    public void PPClose() {PP.setPosition(PPIDLE);}

    public void autoYellowStand() {
        int waitFor = 50;
        int times = 70;
        double perTime = (YPIDLE - YPSTAND) / times;
        for ( int i=0; i < times; i++ ) {
            YP.setPosition(YPIDLE-(i*perTime));
            delay(waitFor);
        }
        delay(1000);
        YP.setPosition(YPIDLE);
    }

    public void tele() {
        if ( gamepad1.a ) {
            PPOpen();
        }
        if ( gamepad1.b ) {
            PPClose();
        }
    }

}
