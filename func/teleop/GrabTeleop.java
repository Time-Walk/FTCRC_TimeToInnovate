package org.firstinspires.ftc.teamcode.func.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.func.classes.RPD;
import org.firstinspires.ftc.teamcode.modules.Grab;
import org.firstinspires.ftc.teamcode.modules.Wheelbase;

public class GrabTeleop {
    Telemetry telemetry;
    LinearOpMode L;
    HardwareMap hwmp;
    Gamepad gamepad1, gamepad2;
    Grab grab;
    public void initFields(Telemetry telemetry, LinearOpMode L, HardwareMap hwmp) {
        this.telemetry = telemetry;
        this.L = L;
        this.hwmp = hwmp;
    }
    public void initGamepad(Gamepad gamepad1, Gamepad gamepad2) {
        this.gamepad1 = gamepad1;
        this.gamepad2 = gamepad2;
    }
    public void init() {
        grab = new Grab();
        grab.initFields(telemetry, L, hwmp);
        grab.init();
    }
    public void grab() {
        grab.setPower(gamepad2.right_trigger);
        grab.setPower(-gamepad2.left_trigger);
    }
}

