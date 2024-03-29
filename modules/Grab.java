package org.firstinspires.ftc.teamcode.modules;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.modules.superclasses.Module;

public class Grab extends Module {

    DcMotor RZ, LZ;
    public void init() {
        RZ = hwmp.get(DcMotor.class, "RZ");
        LZ = hwmp.get(DcMotor.class, "LZ");
    }
    public void setPower(double pw) { // положительное - загреб, отрицательное - выгреб
        RZ.setPower(pw);
        LZ.setPower(-pw);
    }
    public void tele() {
        setPower(gamepad1.right_trigger-gamepad1.left_trigger);
    }
}
