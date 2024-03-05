package org.firstinspires.ftc.teamcode.func.classes;

public class PD {
    public double kp;
    public double kd;
    double ErLast;
    public void init() {
        ErLast = 0;
    }
    public double tick(double Er) {
        double P = Er * kp;

        double D = kd * (Er - ErLast);
        ErLast = Er;
        if ( D > P ) { D = P; }

        return  P + D;
    }
}
