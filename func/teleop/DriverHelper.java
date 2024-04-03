package org.firstinspires.ftc.teamcode.func.teleop;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.modules.superclasses.RobotConstruct;

@Config
public class DriverHelper {
    public static double RelePw = .5;
    RobotConstruct R; Gamepad gamepad1;
    double dhPower[];
    int state = 0; int errorFix = 0;
    double targetAngle = 0;
    public void init(RobotConstruct R, Gamepad gamepad1) {
        this.R = R; this.gamepad1 = gamepad1;
        dhPower = new double[4]; state = 0; errorFix = 0;
    }
    void getErrorFixedInit() {
        if ( targetAngle < -180 ) {
            errorFix = -1;
        }
        else if ( targetAngle > 180 ) {
            errorFix = 1;
        }
    }
    void getErrorFixedTick(double angle) {
        if ( angle > 0 && errorFix == -1) {
            targetAngle += 360;
            errorFix = 0;
        }
        if ( angle < 0 && errorFix == 1) {
            targetAngle -= 360;
            errorFix = 0;
        }
    }
    public double[] tele() {
        if ( gamepad1.dpad_left && state == 0 ) {
            state = -1;
            targetAngle = R.imu.getAngle() - 90;
            getErrorFixedInit();
        }
        if ( gamepad1.dpad_right && state == 0 ) {
            state = 1;
            targetAngle = R.imu.getAngle() + 90;
            getErrorFixedInit();
        }
        if ( state == 1 || state == -1 ) {
            double angle = R.imu.getAngle();
            getErrorFixedTick(angle);
            double Er = targetAngle - angle;
            double Rele = RelePw * Math.signum(Er);
            dhPower[0] = Rele; dhPower[1] = Rele; dhPower[2] = Rele; dhPower[3] = Rele;
            if ( ( state == 1 && Er < 0 ) || ( state == -1 && Er > 0 ) ) { state = 0; }
        }
        else { dhPower[0] = 0; dhPower[1] = 0; dhPower[2] = 0; dhPower[3] = 0; }
        return dhPower;
    }
}
