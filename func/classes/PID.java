package org.firstinspires.ftc.teamcode.func.classes;

public class PID {
    public double kp;
    public double ki;
    public double kd;
    double Ir, ErLast;
    public void init() {
        Ir = 0;
        ErLast = 0;
    }
    public double tick(double Er) {
        double P = Er * kp;

        Ir += Er;
        double I = Ir * ki;

        double D = kd * (Er - ErLast);
        ErLast = Er;
        if ( D > P ) { D = P; }

        return  P + I + D;
    }
}
