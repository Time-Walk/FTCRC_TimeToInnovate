package org.firstinspires.ftc.teamcode.modules;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.modules.superclasses.Module;

public class Lift extends Module {
    DcMotor LM, RM;
    CRServo SM2;
    Servo SM0, SM1;
    public double sm0 = 0;
    public double sm1 = 0;
    @Override
    public void init() {
        LM = hwmp.get(DcMotor.class, "LM");
        RM = hwmp.get(DcMotor.class, "RM");
        SM2 = hwmp.get(CRServo.class, "SM2");
        SM0 = hwmp.get(Servo.class, "SM0");
        SM1 = hwmp.get(Servo.class, "SM1");
    }

    public void tele() {
        LM.setPower(gamepad1.left_stick_y);
        RM.setPower(gamepad1.right_stick_y);
        if ( gamepad1.dpad_down ) { sm0 -= .001; }
        if ( gamepad1.dpad_up ) { sm0 += .001; }
        if ( gamepad1.dpad_left ) { sm1 -= .001; }
        if ( gamepad1.dpad_right ) { sm1 += .001; }
        SM0.setPosition(sm0);
        SM1.setPosition(sm1);
        SM2.setPower(gamepad1.right_trigger-gamepad1.left_trigger);
    }
}
