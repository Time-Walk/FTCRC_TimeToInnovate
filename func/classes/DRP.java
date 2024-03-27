package org.firstinspires.ftc.teamcode.func.classes;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.func.classes.superclasses.PD;
import org.firstinspires.ftc.teamcode.modules.IMU;
import org.firstinspires.ftc.teamcode.modules.Wheelbase;
import org.firstinspires.ftc.teamcode.modules.superclasses.RobotConstruct;
@Config
public class DRP {
    Telemetry telemetry;
    LinearOpMode L;
    HardwareMap hwmp;
    RobotConstruct R;
    PD pdX, pdY, pdRot;
    public static double kpXY;
    public static double kdXY;
    public static double kpRot;
    public static double kdRot;
    public static double krAccel;
    public static double kpAccel;
    public static double minTargetErDist = 5;
    public static double minErSpeed = 10;
    public static double maxRotationDelta = 1;
    public void init(RobotConstruct R) {
        this.R = R;
        pdX = new PD();
        pdY = new PD();
        pdRot = new PD();
        pdX.init(kpXY, kdXY);
        pdY.init(kpXY, kdXY);
        pdRot.init(kpRot, kdRot);
        telemetry = FtcDashboard.getInstance().getTelemetry();
    }
    public void go(double targetX, double targetY) {
        R.imu.init();
        R.wb.resetEncoders();
        boolean condSumm = false;
        boolean condX = false;
        boolean condY = false;
        while ( !condSumm ) {

            double Ux = 0;
            double Uy = 0;

            if ( !condX ) {
                double XEr = targetX - R.wb.LF.getCurrentPosition();
                if ( XEr > targetX / 2) {
                    double Rele = krAccel * Math.signum(XEr);
                    double P = kpAccel * Math.abs(targetX - XEr) * Math.signum(targetX);
                    Ux = Rele + P;
                }
                else {
                    Ux = pdX.tick(XEr);
                }
                if ( Math.abs( targetX - XEr ) < minTargetErDist && Math.abs(XEr - pdX.ErLast) < minErSpeed ) {
                    condX = true;
                }
            }

            if ( !condY ) {
                double YEr = targetY - R.wb.RF.getCurrentPosition();
                if ( YEr > targetY / 2) {
                    double Rele = krAccel * Math.signum(YEr);
                    double P = kpAccel * Math.abs(targetY - YEr) * Math.signum(targetY);
                    Uy = Rele + P;
                }
                else {
                    Uy = pdY.tick(YEr);
                }
                if ( Math.abs( targetY - YEr ) < minTargetErDist && Math.abs(YEr - pdY.ErLast) < minErSpeed ) {
                    condY = true;
                }
            }

            double ErRot = -R.imu.getAngle();
            double URot = pdRot.tick(ErRot);

            condSumm = condX && condY && ( Math.abs(ErRot) < maxRotationDelta );

            R.wb.setMtPower(Ux + URot, Uy+URot, -Uy+URot, -Ux+URot);

            telemetry.addData("Ux", Ux);
            telemetry.addData("Uy", Uy);
            telemetry.addData("Urot", URot);
            telemetry.addData("lf", R.wb.LF.getPower());
            telemetry.addData("lb", R.wb.LB.getPower());
            telemetry.addData("rf", R.wb.RF.getPower());
            telemetry.addData("rb", R.wb.RB.getPower());
            telemetry.update();
        }

    }

}
