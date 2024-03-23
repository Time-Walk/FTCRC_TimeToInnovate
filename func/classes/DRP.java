package org.firstinspires.ftc.teamcode.func.classes;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.modules.IMU;
import org.firstinspires.ftc.teamcode.modules.Wheelbase;
import org.firstinspires.ftc.teamcode.modules.superclasses.RobotConstruct;
@Config
public class DRP {
    Telemetry telemetry;
    LinearOpMode L;
    HardwareMap hwmp;
    RobotConstruct R;
    public static double kp;
    public static double ka;
    public static double meh;
    public void init(RobotConstruct R) {
        this.R = R;
    }
    public void go(double tick) {
        boolean wuh =  true;
        R.imu.init();
        double sa = R.imu.getAngle();
        R.wb.resetEncoders();
        while(Math.abs(tick - R.wb.LF.getCurrentPosition()) > meh) {
            double LErr = tick - R.wb.LF.getCurrentPosition();
            double RErr = tick - R.wb.RF.getCurrentPosition();
        }


    }

}
