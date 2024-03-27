package org.firstinspires.ftc.teamcode.func.classes.superclasses;

public class PID {
    public double kp;
    public double ki;
    public double kd;
    public double Ir, ErLast;
    public double P;
    public double I;
    public double D;
    public void init(double kp, double ki, double kd) {
        Ir = 0;
        ErLast = 0;
        this.kp = kp; this.ki = ki; this.kd = kd;
    }
    public double tick(double Er) {
        P = Er * kp;

        Ir += Er;
        I = Ir * ki;

        D = kd * (Er - ErLast);
        ErLast = Er;
        if ( D > P ) { D = P; }

        return  P + I + D;
    }
}
