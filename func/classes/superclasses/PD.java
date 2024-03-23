package org.firstinspires.ftc.teamcode.func.classes.superclasses;

public class PD {
    public double kp;
    public double kd;
    public double ErLast;
    public void init(double kp, double kd) {
        ErLast = 0;
        this.kp = kp; this.kd = kd;
    }
    public double tick(double Er) {
        double P = Er * kp;

        double D = kd * (Er - ErLast);
        ErLast = Er;
        if ( D > P ) { D = P; }

        return  P + D;
    }
}
