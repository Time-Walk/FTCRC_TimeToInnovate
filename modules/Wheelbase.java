package org.firstinspires.ftc.teamcode.modules;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Wheelbase {
    DcMotor RF, RB, LF, LB;
    Telemetry telemetry;
    LinearOpMode L;
    HardwareMap hwmp;
    public void initFields(Telemetry telemetry, LinearOpMode L, HardwareMap hwmp) {
        this.telemetry = telemetry; this.L = L; this.hwmp = hwmp;
    }

    public void init() {
        LF = hwmp.get(DcMotor.class, "LF");
        RF = hwmp.get(DcMotor.class, "RF");
        LB = hwmp.get(DcMotor.class, "LB");
        RB = hwmp.get(DcMotor.class, "RB");

        LF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LB.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RB.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void setMtPower(double lf, double lb, double rf, double rb) {
        LF.setPower(lf);
        LB.setPower(lb);
        RF.setPower(rf);
        RB.setPower(rb);
    }

    public void setMtZero() { setMtPower(0, 0, 0, 0); }
}
