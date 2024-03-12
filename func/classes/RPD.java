package org.firstinspires.ftc.teamcode.func.classes;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.modules.IMU;
import org.firstinspires.ftc.teamcode.func.classes.PD;
import org.firstinspires.ftc.teamcode.modules.Wheelbase;

@Config
public class RPD {
    PD pd;
    IMU imu;
    Wheelbase wb;
    public static double kp;
    public static double kd;
    double ErLast;
    double ERROR;
    public void init() {
        pd = new PD();
        pd.kp = kp;
        pd.kd = kd;
        pd.init();

        imu = new IMU();
        imu.initFields(telemetry, L, hwmp);
        imu.init();

        wb = new Wheelbase();
        wb.initFields(telemetry, L, hwmp);
        wb.init();
        ErLast = 0;
    }
    Telemetry telemetry; LinearOpMode L; HardwareMap hwmp;
    public void initFields(Telemetry telemetry, LinearOpMode L, HardwareMap hwmp) { this.telemetry = telemetry; this.L = L; this.hwmp = hwmp; }
    public void rotate(double degrees) {

        double PD = 0;
        while (ERROR > 1) {
            double P = ERROR * kp;
            double D = kd * (ERROR - ErLast);
            ErLast = ERROR;
            ERROR = degrees - imu.getAngle();
            if (D > P) {
                D = P;
            }
            PD = P + D;
            wb.setMtPower(PD, PD, -PD, -PD);
        }
        wb.setMtZero();
    }
}
