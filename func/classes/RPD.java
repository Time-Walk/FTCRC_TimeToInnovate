package org.firstinspires.ftc.teamcode.func.classes;

import com.acmerobotics.dashboard.config.Config;

import org.firstinspires.ftc.teamcode.modules.IMU;
import org.firstinspires.ftc.teamcode.func.classes.PD;
import org.firstinspires.ftc.teamcode.modules.Wheelbase;

@Config
public class RPD extends IMU {
    PD pd;
    public static double kp;
    public static double kd;
    double ErLast;
    double ERROR;
    public void init() {
        pd = new PD();
        pd.kp = kp;
        pd.kd = kd;
        pd.init();
        ErLast = 0;

    }
    public void move(double degrees) {

        double PD = 0;
        while (ERROR > 1) {
            double P = ERROR * kp;
            double D = kd * (ERROR - ErLast);
            ErLast = ERROR;
            ERROR = degrees - getAngle();
            if (D > P) {
                D = P;
            }
            PD = P + D;
        }
        LF.setPower(PD);
        LB.setPower(PD);
        RF.setPower(PD);
        RB.setPower(PD);
    }
}
