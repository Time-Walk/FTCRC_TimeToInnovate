package org.firstinspires.ftc.teamcode.modules;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.modules.superclasses.Module;

public class Wheelbase extends Module {
    public DcMotor RF, RB, LF, LB;

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
    public void resetEncoders() {
        LB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        LF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void setMtZero() { setMtPower(0, 0, 0, 0); }

    public void tele() {
        double rf = gamepad1.left_stick_y + gamepad1.left_stick_x + (gamepad1.right_stick_x * 0.6);
        double rb = gamepad1.left_stick_y - gamepad1.left_stick_x + (gamepad1.right_stick_x * 0.6);
        double lf = -gamepad1.left_stick_y + gamepad1.left_stick_x + (gamepad1.right_stick_x * 0.6);
        double lb = -gamepad1.left_stick_y - gamepad1.left_stick_x + (gamepad1.right_stick_x * 0.6);
        setMtPower(lf, lb, rf, rb);
    }
}
